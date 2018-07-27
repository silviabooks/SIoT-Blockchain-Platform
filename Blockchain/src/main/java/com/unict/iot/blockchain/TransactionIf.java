/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unict.iot.blockchain;
import org.bitcoinj.core.NetworkParameters;
import org.bitcoinj.core.Transaction;
import org.bitcoinj.kits.WalletAppKit;
import org.bitcoinj.wallet.Wallet;

/**
 *
 * @author silvia
 */
public interface TransactionIf {
    
    public Transaction makeTransaction(String src, String dest);
    
    public String getWalletPath();

    public String getWalletName();
    
    public Wallet getWallet();

    public WalletAppKit getKit();

    public NetworkParameters getParams();
    
}
