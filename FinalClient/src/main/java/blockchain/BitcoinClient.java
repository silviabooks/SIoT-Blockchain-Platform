/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockchain;

import static com.google.common.base.Preconditions.checkNotNull;
import java.io.File;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bitcoinj.core.Address;
import org.bitcoinj.core.Coin;
import org.bitcoinj.core.InsufficientMoneyException;
import org.bitcoinj.core.NetworkParameters;
import org.bitcoinj.core.Transaction;
import org.bitcoinj.kits.WalletAppKit;
import org.bitcoinj.params.TestNet3Params;
import org.bitcoinj.wallet.SendRequest;
import org.bitcoinj.wallet.Wallet;
import org.bitcoinj.wallet.listeners.WalletCoinsReceivedEventListener;
import org.bitcoinj.wallet.listeners.WalletCoinsSentEventListener;

/**
 *
 * @author silvia
 */
public class BitcoinClient {

    private final String walletPath;
    private final String walletName;

    private final WalletAppKit kit;
    private final NetworkParameters params;

    public BitcoinClient(String walletPath, String walletName) {
        // create wallet kit
        this.params = TestNet3Params.get();
        this.walletName = walletName;
        this.walletPath = walletPath;
        this.kit = new WalletAppKit(params, new File(walletPath), walletName);
        this.kit.setAutoSave(Boolean.valueOf("True"));
        this.kit.startAsync();
        this.kit.awaitRunning();

        // Adding listeners for receiving and sending coins
        this.kit.wallet().addCoinsReceivedEventListener(new WalletCoinsReceivedEventListener() {
            @Override
            public void onCoinsReceived(Wallet wallet, Transaction t,
                    Coin prevBalance, Coin newBalance) {
                System.out.println(" *** I received coins: " + t.getHashAsString());
                System.out.println("Previous Balance: " + prevBalance.toFriendlyString());
                System.out.println("New Balance: " + newBalance.toFriendlyString());
            }
        });

        this.kit.wallet().addCoinsSentEventListener(new WalletCoinsSentEventListener() {
            @Override
            public void onCoinsSent(Wallet wallet, Transaction t,
                    Coin prevBalance, Coin newBalance) {
                System.out.println(" *** Coins sent! " + t.getHashAsString());
            }
        });
    }

    public String getWalletPath() {
        return walletPath;
    }

    public String getWalletName() {
        return walletName;
    }

    public Wallet getWallet() {
        return this.kit.wallet();
    }

    public WalletAppKit getKit() {
        return this.kit;
    }

    public NetworkParameters getParams() {
        return this.params;
    }

    // TODO: modificare e aggiungere altre robe
    public String makeTransaction(String destAddress, String amount) {
        String txString = null;
        System.out.println("Sending " + amount + " satoshis to " + destAddress);
        Address address = Address.fromBase58(this.params, destAddress);
        try {
            SendRequest sendRequest = SendRequest.to(address,
                    Coin.valueOf(Long.parseLong(amount)));
            sendRequest.feePerKb = Transaction.REFERENCE_DEFAULT_MIN_TX_FEE;
            Wallet.SendResult sendResult = this.getWallet().sendCoins(
                    this.getKit().peerGroup(), sendRequest);
            checkNotNull(sendResult); // Never try to send more coins than we have!
            Transaction result = sendResult.broadcastComplete.get();
            txString = "COINS SENT. transaction hash: "
                    + result.getHashAsString();
            System.out.println(txString);

        } catch (InsufficientMoneyException e) {
            txString = "Not enough coins in your wallet. Missing "
                    + e.missing.getValue() + " satoshis (including fees)";
            System.out.println(txString);

        } catch (InterruptedException | ExecutionException ex) {
            Logger.getLogger(BitcoinClient.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return txString;

    }

}
