/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Systems;

import com.unict.iot.blockchain.SIoTBitcoinClient;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

/**
 *
 * @author Salvo
 */
public class GridsSystems extends UnicastRemoteObject implements RMIRootInterface {

    WalletWrapper ww;

    HashMap<String, String> servers_address;

    public GridsSystems() throws RemoteException {
        super();
        ww = new WalletWrapper();
        servers_address = new HashMap<>();

    }

    @Override
    public void RegisterServer_address(String address, String id) {
        this.servers_address.put(address, id);
        System.out.println("SERVER REGISTERED: " + "//" + address + "/server" + id + "\n");

    }

    @Override
    public HashMap<String, String> getAddressServerList() {
        //System.out.println(this.servers_address.toString());
        return this.servers_address;
    }

    @Override
    public boolean CreateWallet() {
        this.ww = new WalletWrapper();
        try {
            ww.createWallet();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public SIoTBitcoinClient getTransactionClient() {
        return this.ww.getTc();
    }

    @Override
    public String makeTransaction(String destAddress, String amount) {
        return this.getTransactionClient().makeTransaction(destAddress, amount);
        
    }

    @Override
    public String getWalletBalance() {
        return this.getTransactionClient().getWallet().getBalance().toFriendlyString();
    }
    
    // Aggiungere metodi qui..
    
}
