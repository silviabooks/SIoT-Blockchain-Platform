/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servers;

import Entities.ClientInterface;
import Servers.SVER.FriendTableEntry;
import Servers.SVER.Sve;
import Settings.Setup;
import Systems.CustomSimulation;
import Systems.RMIRootInterface;
import java.io.FileNotFoundException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Salvo
 */
public class RelFactory {

    private Sve SVE;
    private static RMIInterface look_up;
    private static RMIRootInterface root_look_up;
    HashMap<String, String> ServerList;
    Random rand = new Random(1);

    public RelFactory() {

    }
    String[] type_of_rel = new String[]{"OOR", "SOR", "CLOR", "CWOR"};

    public void areas_count(ClientInterface e,
            List<ClientInterface> secondList,
            List<FriendTableEntry> FriendTableBuffer,
            Map<Integer, Double> probabilities) throws NotBoundException, MalformedURLException, RemoteException {

        for (ClientInterface h2 : secondList) {
            final int R = 6371; // Radius of the earth7
            String geo1[] = e.getAreas().split(",");
            String geo2[] = h2.getAreas().split(",");
            
            double latDistance = Math.toRadians(Double.parseDouble(geo2[0]) - Double.parseDouble(geo1[0]));
            double lonDistance = Math.toRadians(Double.parseDouble(geo1[1]) - Double.parseDouble(geo1[1]));
            double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                    + Math.cos(Math.toRadians(Double.parseDouble(geo1[0]))) * Math.cos(Math.toRadians(Double.parseDouble(geo2[0])))
                    * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
            double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
            double distance = R * c; // km

            int count = 0;

            for (int d : probabilities.keySet()) {
                if (distance <= d) {
                    count = d;
                    break;
                } else {
                    // count = d;
                }

            }

            try {

                getProb(FriendTableBuffer, probabilities.get(count), h2, e.getServer());
            } catch (UnknownHostException ex) {
                Logger.getLogger(RelFactory.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    public void CreateRealationship_logic(Map<Integer, Double> probabilities, List<ClientInterface> ListaClient) throws FileNotFoundException, UnknownHostException, RemoteException, NotBoundException, MalformedURLException {
        System.out.println("Relationship creation");
        HashMap<String, String> ServerList = new HashMap<String, String>();
        root_look_up = (RMIRootInterface) Naming.lookup("//" + Setup.GATEWAY + "/root");
        ServerList = root_look_up.getAddressServerList();

        for (ClientInterface h1 : ListaClient) {
            try {
                if (h1.getServer() == Setup.ID_SERVER) {
                    this.SVE = new Sve();
                    List<FriendTableEntry> FriendTableBuffer = new LinkedList<>();

                    //smartphones-smartphones
                    this.areas_count(h1, ListaClient, FriendTableBuffer, probabilities);

                    this.SVE.setSVER(FriendTableBuffer);

                    look_up = (RMIInterface) Naming.lookup("//" + Setup.IP_SERVER + "/server" + h1.getServer());

                    look_up.updateGRIDS_RS(h1, SVE);
                }
            } catch (NotBoundException ex) {
                Logger.getLogger(CustomSimulation.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MalformedURLException ex) {
                Logger.getLogger(CustomSimulation.class.getName()).log(Level.SEVERE, null, ex);
            } catch (RemoteException ex) {
                Logger.getLogger(CustomSimulation.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        System.out.println("Relationship CREATED!");
        look_up.fillGRIDS_RS(); ////////////////////////////////////messo qui per evitae rallentamenti dovrebbe andrae dentro udateGRidsRS
        System.out.println("READY!");
        return;
    }

    private void getProb(List<FriendTableEntry> FriendTableBuffer,
            double p,
            ClientInterface c,
            int u) throws UnknownHostException, NotBoundException, MalformedURLException, RemoteException {
        root_look_up = (RMIRootInterface) Naming.lookup("//" + Setup.GATEWAY + "/root");
        ServerList = root_look_up.getAddressServerList();
        FriendTableEntry tableEntry = null;
        if (p == 1) {
            try {
                look_up = (RMIInterface) Naming.lookup("//" + this.ServerList.get("" + u) + "/server" + u);
                tableEntry = new FriendTableEntry(this.type_of_rel[rand.nextInt(3)],
                        new InetSocketAddress(InetAddress.getLocalHost(), 200).toString(),
                        ServerList.get("" + c.getServer()),//MS locator
                        c);
                FriendTableBuffer.add(tableEntry);

            } catch (NotBoundException ex) {
                Logger.getLogger(CustomSimulation.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MalformedURLException ex) {
                Logger.getLogger(CustomSimulation.class.getName()).log(Level.SEVERE, null, ex);
            } catch (RemoteException ex) {
                Logger.getLogger(CustomSimulation.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {

            Float tmp = rand.nextFloat();

            if (tmp <= p) {
                try {
                    // System.out.println("-------->"+"//"+this.ServerList.get(""+u)+"/server" + u);
                    look_up = (RMIInterface) Naming.lookup("//" + this.ServerList.get("" + u) + "/server" + u);
                    tableEntry = new FriendTableEntry(this.type_of_rel[rand.nextInt(3)],
                            new InetSocketAddress(InetAddress.getLocalHost(), 200).toString(), //da cambiareeeee
                            ServerList.get("" + c.getServer()),
                            c);
                    FriendTableBuffer.add(tableEntry);

                } catch (NotBoundException ex) {
                    Logger.getLogger(CustomSimulation.class.getName()).log(Level.SEVERE, null, ex);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(CustomSimulation.class.getName()).log(Level.SEVERE, null, ex);
                } catch (RemoteException ex) {
                    Logger.getLogger(CustomSimulation.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}
