/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Systems;

import com.unict.iot.blockchain.SIoTBitcoinClient;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashMap;

/**
 *
 * @author Salvo
 */
public interface RMIRootInterface extends Remote {

    public void RegisterServer_address(String address, String id) throws RemoteException;

    public HashMap<String, String> getAddressServerList() throws RemoteException;

    public boolean CreateWallet() throws RemoteException;

    public SIoTBitcoinClient getTransactionClient() throws RemoteException;

    public String getWalletBalance() throws RemoteException;
            
    public String makeTransaction(String destAddress, String amount) throws RemoteException;
    
}
