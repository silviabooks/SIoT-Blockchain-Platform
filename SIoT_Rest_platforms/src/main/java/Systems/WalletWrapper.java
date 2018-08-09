/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Systems;

import com.unict.iot.blockchain.SIoTBitcoinClient;
import com.unict.iot.blockchain.TrxManager;
import java.util.HashSet;
import org.bitcoinj.core.Address;
import org.bitcoinj.core.Transaction;
import org.bitcoinj.core.TransactionConfidence;
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
        SIoTBitcoinClient tc1
                = new SIoTBitcoinClient("/home/silvia/tesi/Blockchain/wallets", "sender-wallet");
        System.out.println("Balance: " + tc1.getWallet().getBalance().toFriendlyString());
        // Watched address
        Address address = new Address(tc1.getParams(), "n2dVfxCAtYHxAu8R9t8Vmy6KWZviv3bs47");
        tc1.getWallet().addWatchedAddress(address);
        System.err.println("My address is: n2dVfxCAtYHxAu8R9t8Vmy6KWZviv3bs47");
        // Listener
        tc1.getWallet().addTransactionConfidenceEventListener(
                new TransactionConfidenceEventListener() {
            @Override
            public void onTransactionConfidenceChanged(Wallet wallet, Transaction tx) {
                boolean valoreFantomatico = tx.getValueSentFromMe(wallet)
                        .compareTo(tx.getValueSentToMe(wallet)) < 0;
                // se è > 0, allora li ho sborsati
                // se è < 0, allora li ho ricevuti
                if (tx.getValueSentFromMe(wallet).isZero() || valoreFantomatico) {
                    TransactionConfidence confidence = tx.getConfidence();
                    // Confirmation control
                    int depth = confidence.getDepthInBlocks();
                    String trxString = tx.getHashAsString();

                    if (depth == 0) { // La trx non è ancora nella Blockchain
                        // Verifico se l'hash è presente
                        if (unconfirmedTrxs.add(trxString)) {
                            // se non c'era, l'aggiungo sia nel set che nel DB
                            System.out.println("Unconfirmed trx: " + trxString);
                            TrxManager trxm = new TrxManager();
                            trxm.addUnconfirmedTrx(trxString, "", "");
                            trxm.closeConnection();
                        }
                        // se c'era, non faccio niente
                    } else { // La trx è stata inserita nella Blockchain
                        // se non c'è nel set, non faccio niente
                        // se c'è, la levo sia dal set che dal DB
                        if (unconfirmedTrxs.contains(trxString)) {
                            System.out.println("*** Transaction " + trxString
                                    + " confirmed! *********");
                            TrxManager trxm = new TrxManager();
                            trxm.confirmTrxAndReadData(trxString);
                            trxm.closeConnection();
                            unconfirmedTrxs.remove(trxString);
                        }
                    }
                }
            }
        });
        this.setTc(tc1);
    }
}
