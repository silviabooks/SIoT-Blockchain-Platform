/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unict.iot.blockchain;

import java.util.Scanner;

/**
 *
 * @author silvia
 */
public class SenderExample {
    public static void main(String args[]) {
        TransactionClient c = new TransactionClient("/home/silvia/Scrivania/porcod", "ciao");
        System.out.println("Hello! I'm the sender. My current address is: ");
        System.out.println(c.getWallet().currentReceiveAddress());
        System.out.println("My current balance (does not include unconfirmed "
                + "unspent outputs): " + c.getWallet().getBalance().toFriendlyString());
        Scanner s = new Scanner(System.in);
        s.nextLine();
    }
}
