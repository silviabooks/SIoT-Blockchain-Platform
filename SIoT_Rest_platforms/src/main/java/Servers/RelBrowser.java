/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servers;

import Entities.ClientInterface;
import NetGraph.Node;
import Servers.SVER.FriendTableEntry;
import Settings.Setup;
import Statistics.Statistics;
import Statistics.StatisticsInterface;
import Systems.RMIRootInterface;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * @author Salvo
 */
public class RelBrowser implements Serializable {

    StatisticsInterface SI = new Statistics();
    int numNodes = 0;
    private static RMIInterface look_up;
    private static RMIRootInterface root_look_up;
    
    
    public RelBrowser() {
    }

    private void printResults(int ext_hop, int int_hop,
            String UID, String ft) {
        System.out.println("NMS ADDRESS FOUND :" + UID + "->"
                + ft);
        System.out.println("NUMBER OF EXT_HOP DONE: " + ext_hop);
        System.out.println("NUMBER OF INT_HOP DONE: " + int_hop);
    }

    public String search_entity(
            ClientInterface mynode,
            String id_to_find,
            String metadata,
            Float intra_server_latency,
            Float inter_server_latency
           ) throws NotBoundException, MalformedURLException, RemoteException {
   
        
        HashMap<String,String> ServerList = new  HashMap<String,String>();
        root_look_up = (RMIRootInterface) Naming.lookup("//"+Setup.GATEWAY+"/root");
        ServerList = root_look_up.getAddressServerList();

        StatisticsInterface SI = new Statistics();
        HashSet<String> added = new HashSet<>();
        ClientInterface rootNode = mynode;

        int ext_hop = 0;
        int int_hop = 0;
        //Select the server
        int k = 0;
        int j = 0;
        PriorityQueue<Node> queue = new PriorityQueue<>();
        ArrayList<Node> explored = new ArrayList<>();

        // System.out.println("---------->" + rootNode.getUID());
        System.out.println("\n\n******************* "
                + rootNode.getUID() + " looks for " + id_to_find + " ******************\n");
        System.out.println("First Server selected: Server" + rootNode.getServer());
        System.out.println("Id to find:" + id_to_find);
        System.out.println("META:" + metadata);

        look_up = (RMIInterface) Naming.lookup("//"+ServerList.get(""+rootNode.getServer())+"/server" + rootNode.getServer());

        if (look_up.getGRIDS_RS().containsKey(mynode)) {   //verifico: potrebbe accadere che il nodo non esiste più

            for (FriendTableEntry ft : look_up.getGRIDS_RS().get(mynode).getSVER()) {

                ClientInterface n_ = ft.getClient_instance();

                if (n_.getUID().equals(id_to_find)) {
                    int_hop = 1;
                    if(rootNode.getServer()!=n_.getServer()){
                    ext_hop=1;
                    }
                    printResults(ext_hop, int_hop, n_.getUID(), ft.getGRIDS_MS_Locator());
                    SI.write_stat_Custom_search(n_.getServer(), this.numNodes,
                            ext_hop, int_hop, (int_hop) + (ext_hop * inter_server_latency));
                    return ft.getGRIDS_MS_Locator();
                }  
                /*if (n_.getMETA().equals("SmartPhone")) {
                    Node node = new Node();
                    // System.out.println("aggiungo lo smartfone del disposiivo");
                    node.setFTEntry(ft);
                    node.setFather(rootNode.getUID());
                    node.setFatherPort(0);
                    node.setLevel(1);
                    node.setClient(n_);
                    queue.add(node);
                }*/
                // decommenta se la ricerca non deve passare sempre da smartphone*/
                else {

                    Node node = new Node();
                    // System.out.println("aggiungo lo smartfone del disposiivo");
                    node.setFTEntry(ft);
                    node.setFather(mynode.getUID());
                    node.setFatherPort(0);
                    node.setLevel(1);
                    node.setClient(n_);
                    queue.add(node);
                    added.add(node.getClient().getUID());
                }
            } //FT entry of the root Node

            
         
            
            while (!queue.isEmpty()) {
             
                Node current = queue.remove(); //ci saranno solo smartphone e amici diretti delo smartphone
              
                 
                
                
                
                

                if (!explored.isEmpty()) {
                    if (!current.getFather().equals(explored.get(explored.size() - 1).getFather())) { //quando cambia il padre-> tenere conto del padre

                        if (current.getClient().getServer() == explored.get(explored.size() - 1).getClient().getServer()) {
                            int_hop = int_hop + 1;
                           // System.out.println("int->" + explored.get(explored.size() - 1).getFather());
                        } else {
                            ext_hop = ext_hop + 1;
                           // System.out.println("ext->" + explored.get(explored.size() - 1).getFather());
                        }
                    }
                }else{
                   
                    if (current.getClient().getServer() == rootNode.getServer()) {
                        int_hop = int_hop + 1;//settare a due se si considere l'hopper raggiungere i prorprio sve1 per raggiungere la dest ed uno per raggiungere il prorio sve
                        // System.out.println("sono qui" +current.getClient().getUID() +  rootNode.getUID());
                    } else {
                        ext_hop = ext_hop + 1;
                           
                    }
                }

                if (current.getClient().getUID().equals(id_to_find)) {
                     
                    if (current.getClient().getServer() == explored.get(explored.size() - 1).getClient().getServer()) {
                            int_hop = int_hop + 1; 
                           // System.out.println("int->" + explored.get(explored.size() - 1).getFather());
                        } else {
                            ext_hop = ext_hop + 1;
                           // System.out.println("ext->" + explored.get(explored.size() - 1).getFather());
                        }
                     
                      
                    printResults(ext_hop, int_hop, current.getClient().getUID(),
                            current.getFTentry().getGRIDS_MS_Locator());
                    SI.write_stat_Custom_search(current.getClient().getServer(), this.numNodes,
                            ext_hop, int_hop, (int_hop) + (ext_hop * inter_server_latency));
                    return current.getFTentry().getGRIDS_MS_Locator();

                     //  } else if (!explored.contains(current) && current.getClient().getMETA().compareTo("SmartPhone") == 0) {
               } else if (!explored.contains(current)) {
                    look_up = (RMIInterface) Naming.lookup("//"+ServerList.get(""+current.getClient().getServer())+"/server" + current.getClient().getServer());
                    for (FriendTableEntry ft : look_up.getGRIDS_RS().get(current.getClient()).getSVER()) {
                        if (ft.getClient_instance().getUID().equals(id_to_find)) {
                             
                        
                        if (current.getClient().getServer() == ft.getClient_instance().getServer()) {
                            int_hop = int_hop + 1;
                           // System.out.println("int->" + explored.get(explored.size() - 1).getFather());
                        } else {
                            ext_hop = ext_hop + 1;
//                            System.out.println("ext->" + explored.get(explored.size() - 1).getFather());
                        }
                           
                           
                            printResults(ext_hop, int_hop,
                                    ft.getClient_instance().getUID(),
                                    ft.getGRIDS_MS_Locator());
                            SI.write_stat_Custom_search(current.getClient().getServer(), this.numNodes,
                                    ext_hop, int_hop, (int_hop) + (ext_hop * inter_server_latency));
                            return ft.getGRIDS_MS_Locator();
                        }

                        Node node = new Node();
                        node.setFTEntry(ft);
                        node.setFather(current.getClient().getUID());
                        node.setFatherPort(0);
                        node.setLevel(1);
                        node.setClient(ft.getClient_instance());
                         //  if (!explored.contains(node) && node.getClient().getMETA().equals("SmartPhone")) {
                        if (!explored.contains(node)&&!added.contains(node.getClient().getUID())) {
                            queue.add(node);
                            added.add(node.getClient().getUID());
                        } else {

                            //add to queue devices that are not SmartPhone. 
                            //This can be help the research if two or more subGraph are not directly connected
                        }

                    }
                }

                explored.add(current);
               
            }

        }

        return null;
    }

}
