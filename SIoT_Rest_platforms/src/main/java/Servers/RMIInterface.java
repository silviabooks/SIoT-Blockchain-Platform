/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servers;

import Entities.ClientInterface;
import Servers.SVER.FriendTableEntry;
import Servers.SVER.Sve;
import Servers.RelBrowser;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author Salvo
 */
public interface RMIInterface extends Remote {

    public RelBrowser getRelBrowser() throws RemoteException;

    public HashSet<HashMap> getGRIDS_MS() throws RemoteException;

    public void addMap_GRIDS(HashMap map) throws RemoteException;

    public HashMap<ClientInterface, Sve> getGRIDS_RS() throws RemoteException;

    public void updateGRIDS_RS(ClientInterface c, Sve sve) throws RemoteException;

    public void fillGRIDS_RS() throws RemoteException;
}
