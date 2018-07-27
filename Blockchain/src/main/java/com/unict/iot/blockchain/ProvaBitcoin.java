/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unict.iot.blockchain;

import static com.google.common.base.Preconditions.checkNotNull;
import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bitcoinj.core.Address;
import org.bitcoinj.core.Coin;
import org.bitcoinj.core.ECKey;
import org.bitcoinj.core.NetworkParameters;
import org.bitcoinj.core.Transaction;
import org.bitcoinj.core.TransactionConfidence;
import org.bitcoinj.core.InsufficientMoneyException;
import org.bitcoinj.core.listeners.TransactionConfidenceEventListener;
import org.bitcoinj.kits.WalletAppKit;
import org.bitcoinj.params.TestNet3Params;
import org.bitcoinj.wallet.Wallet;
import org.bitcoinj.wallet.listeners.KeyChainEventListener;
import org.bitcoinj.wallet.listeners.ScriptsChangeEventListener;
import org.bitcoinj.wallet.listeners.WalletCoinsReceivedEventListener;
import org.bitcoinj.wallet.listeners.WalletCoinsSentEventListener;
import org.bitcoinj.script.Script;
import org.bitcoinj.wallet.SendRequest;


/**
 *
 * @author silvia
 */
public class ProvaBitcoin {
    public static void main(String args[]) {
        
        NetworkParameters params = TestNet3Params.get();
        WalletAppKit myKit = new WalletAppKit(params, new File("."), "my-wallet-example");
        myKit.setAutoSave(Boolean.valueOf("True"));
        myKit.startAsync();
        myKit.awaitRunning();
        
        System.out.println("Ciao, il mio indirizzo è: " + myKit.wallet().currentReceiveAddress());
        System.out.println("Ho questi coin: " + myKit.wallet().getBalance().toFriendlyString());
        
        myKit.wallet().addCoinsReceivedEventListener(
                new WalletCoinsReceivedEventListener() {
            @Override
            public void onCoinsReceived(Wallet wallet, Transaction t, 
                    Coin prevBalance, Coin newBalance) {
                /*
                Ovviamente questo metodo viene chiamato anche quando invio
                soldi, visto che vengono creati due output, uno per il dest
                address, e uno per me stesso. Quest'ultimo avrà l'amount negativo
                */
                System.out.println(" *** Ho ricevuto soldi! Da: " + t.getHashAsString());
                System.out.println("Quanti? " + t.getValue(wallet));
                System.out.println("PrevBalance: " + prevBalance.toFriendlyString());
                System.out.println("NewBalance: " + newBalance.toFriendlyString());
            }
        });
        
        myKit.wallet().addCoinsSentEventListener(new WalletCoinsSentEventListener() {
            @Override
            public void onCoinsSent(Wallet wallet, Transaction t, 
                    Coin prevBalance, Coin newBalance) {
                System.out.println("Coin inviati!");
            }
        });
        
        myKit.wallet().addKeyChainEventListener(new KeyChainEventListener() {
            @Override
            public void onKeysAdded(List<ECKey> keys) {
                System.out.println("new key added");
            }
        });

        myKit.wallet().addScriptsChangeEventListener(new ScriptsChangeEventListener() {
            @Override
            public void onScriptsChanged(Wallet wallet, List<Script> scripts, boolean isAddingScripts) {
                System.out.println("new script added");
            }
        });
        
        myKit.wallet().addTransactionConfidenceEventListener(new TransactionConfidenceEventListener() {
            @Override
            public void onTransactionConfidenceChanged(Wallet wallet, Transaction tx) {
                System.out.println(" *** confidence changed: " + tx.getHashAsString());
                TransactionConfidence confidence = tx.getConfidence();
                System.out.println("new confidence: " + confidence.getDepthInBlocks());
            }
        });
        
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ProvaBitcoin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // TODO send money to 2N8hwP1WmJrFF5QWABn38y63uYLhnJYJYTF
        
        Address faucetAddr = Address.fromBase58(params, 
                "2N8hwP1WmJrFF5QWABn38y63uYLhnJYJYTF");
        // long satoshis = 2997750;
        // Coin value = Coin.valueOf(satoshis);
        System.out.println("Sto per mandare tutti i bitcoin che ho al faucet...");
        try {
            SendRequest sendRequest = SendRequest.emptyWallet(faucetAddr);
            Wallet.SendResult sendResult = myKit.wallet().sendCoins(sendRequest);
            checkNotNull(sendResult);  // We should never try to send more coins than we have!
            //Wallet.SendResult result = myKit.wallet().sendCoins(myKit.peerGroup(), faucetAddr, value);
            System.out.println("coins sent. transaction hash: " + sendResult.tx.getHashAsString());
        } catch (InsufficientMoneyException e) {
            System.out.println("Not enough coins in your wallet. Missing " 
                    + e.missing.getValue() + " satoshis are missing (including fees)");
        }
        try {
            Thread.sleep(20000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ProvaBitcoin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        myKit.stopAsync();
        myKit.awaitTerminated();
    }
    
}
