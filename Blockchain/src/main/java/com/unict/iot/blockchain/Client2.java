/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unict.iot.blockchain;

import java.util.List;
import java.util.Scanner;
import org.bitcoinj.core.Address;

/**
 *
 * @author silvia
 */
public class Client2 {
    public static void main(String args[]) {
        TransactionClient c = new TransactionClient("./wallets", "receiver-wallet");
        System.out.println("Hello! I'm the receiver.");
        // OK così posso usare solo questo indirizzo
        Address address = new Address(c.getParams(), "mjLogQRYRDuUFsDjctzamVqQLE2iknst9X");
        c.getWallet().addWatchedAddress(address);
        List<Address> list = c.getWallet().getWatchedAddresses();
        System.out.println("I have " + list.size() + " addresses:");
        list.forEach((a) -> {
            System.out.println(a.toString());
        });
        System.out.println("My current balance (does not include unconfirmed "
                + "unspent outputs): " + c.getWallet().getBalance().toFriendlyString());
        Scanner s = new Scanner(System.in);
        s.nextLine();
        
    }
}
