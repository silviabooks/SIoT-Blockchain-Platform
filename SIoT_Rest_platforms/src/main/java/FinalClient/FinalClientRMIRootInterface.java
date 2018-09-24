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
    
    public String requestDataWithTrx(String txHash, String SVER_ID, String SVE_ID) throws RemoteException;
    
    public String rechargeCredit(String trxHash, int userID, int amount) throws RemoteException;
    
    public int getCredit(int userID) throws RemoteException;
    
    public String requestDatawithCredit(String SVER_ID, String SVE_ID, int userID) throws RemoteException;
}
