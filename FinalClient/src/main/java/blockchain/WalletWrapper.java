/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockchain;

import static com.google.common.base.Preconditions.checkNotNull;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bitcoinj.core.Address;
import org.bitcoinj.core.Coin;
import org.bitcoinj.core.InsufficientMoneyException;
import org.bitcoinj.core.Transaction;
import org.bitcoinj.wallet.SendRequest;
import org.bitcoinj.wallet.Wallet.SendResult;

/**
 *
 * @author silvia
 */
public class WalletWrapper {

    private BitcoinClient tc;
    
    public WalletWrapper() {        
    }

    public BitcoinClient getTc() {
        return tc;
    }

    public void setTc(BitcoinClient tc) {
        this.tc = tc;
    }

    public void createWallet() {
        BitcoinClient tc1
                = new BitcoinClient(".", "final-app-wallet");
        final Address address = new Address(tc1.getParams(), Setup.Setup.WATCHED_ADDR);
        tc1.getWallet().addWatchedAddress(address);
        System.out.println("Balance: " + tc1.getWallet().getBalance().toFriendlyString());
        System.out.println("Rcv addr: " + Setup.Setup.WATCHED_ADDR);
        this.setTc(tc1);
    }
    
    public String sendBitcoin(String amount, String destAddress) {
        String trxString = null;
        System.out.println("Sending " + amount + " satoshis to " + destAddress);
        Address address = Address.fromBase58(tc.getParams(), destAddress);
        try {
            SendRequest sendRequest = SendRequest.to(address, 
                    Coin.valueOf(Long.parseLong(amount)));
            sendRequest.feePerKb = Transaction.REFERENCE_DEFAULT_MIN_TX_FEE;
            SendResult sendResult = tc.getWallet()
                    .sendCoins(tc.getKit().peerGroup(), sendRequest);
            checkNotNull(sendResult); // Never try to send more coins than we have
            Transaction result = sendResult.broadcastComplete.get(); 
            trxString = result.getHashAsString();
            System.out.println(trxString);
            
        } catch (InsufficientMoneyException e) {
            trxString = "Not enough coins in your wallet. Missing " 
                    + e.missing.getValue() + " satoshis (including fees)";
            System.out.println(trxString);
            
        } catch (InterruptedException | ExecutionException ex) {
            Logger.getLogger(WalletWrapper.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return trxString;
    }
}
