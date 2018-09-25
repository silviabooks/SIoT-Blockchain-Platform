/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Systems;

import com.unict.iot.blockchain.SIoTBitcoinClient;
import com.unict.iot.blockchain.TrxManager;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bitcoinj.core.Address;
import org.bitcoinj.core.NetworkParameters;
import org.bitcoinj.core.Transaction;
import org.bitcoinj.core.TransactionConfidence;
import org.bitcoinj.core.TransactionOutput;
import org.bitcoinj.core.listeners.TransactionConfidenceEventListener;
import org.bitcoinj.wallet.Wallet;

/**
 *
 * @author silvia
 */
public class WalletWrapper {

    private static SIoTBitcoinClient tc;
    public static HashSet<String> unconfirmedTrxs;

    public WalletWrapper() {
        TrxManager trxm = new TrxManager();
        unconfirmedTrxs = trxm.loadUnconfirmedTrxs();
        trxm.closeConnection();
    }

    public SIoTBitcoinClient getTc() {
        return tc;
    }

    public void setTc(SIoTBitcoinClient tc1) {
        tc = tc1;
    }

    public void createWallet() {
        final SIoTBitcoinClient tc1
                = new SIoTBitcoinClient("/home/silvia/tesi/Blockchain/wallets", "sender-wallet");
        System.out.println("Balance: " + tc1.getWallet().getBalance().toFriendlyString());
        final NetworkParameters netPars = tc1.getParams();
        // Add watched addresses
        final Address address = new Address(tc1.getParams(), "n2dVfxCAtYHxAu8R9t8Vmy6KWZviv3bs47");
        final Address chargeAddress = new Address(tc1.getParams(), "mjvRjidP7u7bqBQA9CsZFUJxB1si9nqaAF");
        tc1.getWallet().addWatchedAddress(address);
        tc1.getWallet().addWatchedAddress(chargeAddress);
        System.out.println("My address is: n2dVfxCAtYHxAu8R9t8Vmy6KWZviv3bs47");
        System.out.println("My address for CHARGES is: mjvRjidP7u7bqBQA9CsZFUJxB1si9nqaAF");
        // Confidence Event Listener
        tc1.getWallet().addTransactionConfidenceEventListener(
                new TransactionConfidenceEventListener() {
            @Override
            public void onTransactionConfidenceChanged(Wallet wallet, Transaction tx) {
                boolean isRcvAddress = false;
                boolean isChargeAddress = false;
                // Get the destination wallet address
                for (TransactionOutput tout : tx.getOutputs()) {
                    String toAddress = tout.getScriptPubKey()
                            .getToAddress(netPars).toString();
                    // Verify if toAddress is the normal address or the charge one
                    if (toAddress.equals(address.toString())) {
                        isRcvAddress = true;
                    }
                    if (toAddress.equals(chargeAddress.toString())) {
                        isChargeAddress = true;
                    }
                }

                // Differentiate actions: CREDIT CHARGE TRANSACTION
                if (isChargeAddress) {
                    // Confirmation control
                    TransactionConfidence confidence = tx.getConfidence();
                    int depth = confidence.getDepthInBlocks();
                    String trxString = tx.getHashAsString();
                    if (depth == 0) { // The trx isn't in the Blockchain yet
                        // Verify if the hash is present
                        if (unconfirmedTrxs.add(trxString)) {
                            // if it wasn't there, add it in the set and in the DB
                            TrxManager trxm = new TrxManager();
                            System.out.println("metto charge");
                            trxm.addUnconfirmedTrx(trxString, "charge", "charge");
                            trxm.closeConnection();
                        }
                        // if it was there, nothing to do
                    } else { // The trx has been inserted in the Blockchain
                        // if it isn't in the set, do nothing
                        // otherwise, delete it from the set and from the DB
                        if (unconfirmedTrxs.contains(trxString)) {
                            System.out.println("*********** Charge " + trxString
                                    + " confirmed! *********");
                            TrxManager trxm = new TrxManager();
                            trxm.confirmCharge(trxString);
                            trxm.closeConnection();
                            unconfirmedTrxs.remove(trxString);
                        }
                    }
                }

                // NORMAL TRANSACTION
                if (isRcvAddress) {
                    boolean valoreFantomatico = tx.getValueSentFromMe(wallet)
                            .compareTo(tx.getValueSentToMe(wallet)) < 0;
                    // if > 0, the money are spent
                    // if < 0, the money are received
                    if (tx.getValueSentFromMe(wallet).isZero() || valoreFantomatico) {
                        TransactionConfidence confidence = tx.getConfidence();
                        // Confirmation control
                        int depth = confidence.getDepthInBlocks();
                        String trxString = tx.getHashAsString();

                        if (depth == 0) { // The trx isn't in the Blockchain yet
                            // Verify if the hash is present
                            if (unconfirmedTrxs.add(trxString)) {
                                // if it wasn't there, add it in the set and in the DB
                                TrxManager trxm = new TrxManager();
                                trxm.addUnconfirmedTrx(trxString, "", "");
                                trxm.closeConnection();
                            }
                            // if it was there, nothing to do
                        } else { // The trx has been inserted in the Blockchain
                            // if it isn't in the set, do nothing
                            // otherwise, delete it from the set and from the DB
                            if (unconfirmedTrxs.contains(trxString)) {
                                System.out.println("*** Transaction " + trxString
                                        + " confirmed! *********");
                                TrxManager trxm = new TrxManager();
                                trxm.confirmTrxAndReadData(trxString);
                                
                                // TIMESTAMP
                                writeOnFile(trxString, System.currentTimeMillis(), "parte2.csv");
                                
                                trxm.closeConnection();
                                unconfirmedTrxs.remove(trxString);
                            }
                        }
                    }
                }
            }
        });
        this.setTc(tc1);
    }
    
    private void writeOnFile(String trx, long value, String fileDesc) {
        FileWriter out = null;
        try {
            out = new FileWriter(fileDesc, true);
            out.write(trx + "," + value + "\n");
        } catch (IOException ex) {
            Logger.getLogger(WalletWrapper.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                out.close();
            } catch (IOException ex) {
                Logger.getLogger(WalletWrapper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
