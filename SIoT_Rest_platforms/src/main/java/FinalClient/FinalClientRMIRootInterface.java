/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalClient;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author silvia
 */
public interface FinalClientRMIRootInterface extends Remote {
    
    public String helloWorld() throws RemoteException;
    
    public String requestDataWithTrx(String txHash, String SVER_ID, String SVE_ID) throws RemoteException;
    
}
