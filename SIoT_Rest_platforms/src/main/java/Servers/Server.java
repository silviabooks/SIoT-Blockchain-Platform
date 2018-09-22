/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servers;

import Servers.SVER.Sve;
import Entities.ClientInterface;
import Servers.SVER.FriendTableEntry;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.UnknownHostException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Salvo
 */
public class Server extends UnicastRemoteObject implements RMIInterface, Serializable{
    
    private int id;
    private ServerSocket ss;
    private String ip;
    private HashSet<HashMap> GRIDS_MS; //EACH HASMAP IS THE ENTRY OF THE MS TABLE
    private GridsRS GRIDS_RS;
    private List<Server> servers; 
    private RelBrowser RelBrowser;
    
    
    public Server(String ip, int id) throws RemoteException {  //loc rappresenta il valore di localizzazione spaziale
        
        this.ip = ip;
        this.id = id;
        GRIDS_MS = new HashSet<>();
        GRIDS_RS = new GridsRS();
       
        RelBrowser = new RelBrowser();
        System.out.println("Server listening at: //"+this.getIp()+"/server" +this.id);
        
    }
    
    public Server(Server s) throws RemoteException{
        this.ip = s.getIp();
        this.id = s.getId();
        GRIDS_MS = new HashSet<>();
        GRIDS_RS = new GridsRS();
       
        RelBrowser = new RelBrowser();
        System.out.println("Server listening at: //"+this.getIp()+"/server" +this.id);
        /*try {
            ss = new ServerSocket(this.port_);
            
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }
    
    @Override
    public RelBrowser getRelBrowser() {
        return RelBrowser;
    }  
    
    public void initGRIDS_MS() {
        GRIDS_MS = new HashSet<>();
    }

    public void initGRIDS_RS() {
        GRIDS_RS = new GridsRS();
    }
    
@Override
    public HashMap<ClientInterface, Sve> getGRIDS_RS() {
        try {
            return GRIDS_RS.getGRIDS_RS();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
   /* @Override
    public void setGRIDS_RS(HashMap<ClientInterface, Sve> GRIDS_RS1) {
        this.GRIDS_RS.setGRIDS_RS(GRIDS_RS1);
    }*/
@Override
    public void updateGRIDS_RS(ClientInterface c, Sve sve) throws RemoteException {
        try {
            this.GRIDS_RS.UpdateGRIDS_RS(c, sve);
        } catch (SQLException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
	
	   @Override
    public void fillGRIDS_RS() throws RemoteException {
        try {
            this.GRIDS_RS.fillGRIDS_RS();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        }
    
     
    public void updateSVER_GRIDS_RS(FriendTableEntry f,ClientInterface c) 
            throws ClassNotFoundException, SQLException, UnknownHostException {
        this.GRIDS_RS.getGRIDS_RS().get(c).getSVER().add(f);
    }
    
    
    public HashSet<HashMap> getGRIDS_MS() {
        return GRIDS_MS;
    }
    
    public void addMap_GRIDS(HashMap map){
        this.GRIDS_MS.add(map);
    }
    
    
    
 
    
    
  
 /*
    public ServerSocket getServerSocket(){
        return ss;
    }
   
    @Override
 public String getServerSocketAddr(){
   System.out.println("->>>>>>>"+ss.getInetAddress().toString());
 return ss.getInetAddress().toString();
 
 }
 */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
 

    
}
