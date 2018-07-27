/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NetGraph;

import Entities.Client;
import Entities.ClientInterface;
import Servers.RMIInterface;
import Servers.SVER.FriendTableEntry;
import Settings.Setup;
import Statistics.Statistics;
import Statistics.StatisticsInterface;
import Systems.RMIRootInterface;
import java.awt.Dimension;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import org.graphstream.algorithm.BetweennessCentrality;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import org.graphstream.ui.view.Viewer;
import org.graphstream.ui.view.ViewerListener;
import org.graphstream.ui.view.ViewerPipe;

/**
 *
 * @author Salvo
 */
public class NetGraph implements ViewerListener, Runnable {

    List<ClientInterface> ListaClient;

    JLabel ID;
    JLabel meta;
    JLabel building;
    JLabel floor;
    JLabel office;
    JFrame myJFrame;
    JTextField id_to_search;
    NodeInfo infopanel;
    boolean compute_betweenness;
    private static RMIInterface look_up;
    private static RMIRootInterface root_look_up;
    Graph graph;

    public NetGraph(boolean compute_betweenness, List<ClientInterface> ListaClient) throws RemoteException, NotBoundException, MalformedURLException {
        //root_look_up = (RMIRootInterface) Naming.lookup("//localhost/root");

        //this.ListaClient = root_look_up.getListaClient();
        //da modificare-> get lista server-> get lista cient, sommo e grafico
        this.ListaClient = ListaClient;
        this.compute_betweenness = compute_betweenness;
        graph = new MultiGraph("SIoT Graph");
    }

    protected boolean loop = true;

    public Graph getGraph() {
        return graph;
    }

    public void create() throws NotBoundException, MalformedURLException, RemoteException, ClassNotFoundException, SQLException {
        Iterator<org.graphstream.graph.Node> it = graph.getNodeIterator();
         HashMap<String,String> ServerList = new  HashMap<String,String>();
        root_look_up = (RMIRootInterface) Naming.lookup("//"+Setup.GATEWAY+"/root");
        ServerList = root_look_up.getAddressServerList();

        for (ClientInterface c : this.ListaClient) {
            
               // System.out.println("0");

                graph.addNode(c.getUID()).setAttribute("ID", c.getUID());
                graph.getNode(c.getUID()).setAttribute("meta", c.getMETA());
                graph.getNode(c.getUID()).setAttribute("area", c.getAreas());
                graph.getNode(c.getUID()).setAttribute("server", "Server: " + c.getServer());
if(c.getServer()==Setup.ID_SERVER){
                graph.getNode(c.getUID()).addAttribute("ui.class", "simple");
}else{
       graph.getNode(c.getUID()).addAttribute("ui.class", "different");
}
//graph.getNode(c.getUID()).addAttribute("ui.style", "fill-color: rgb("+c.getAreas()[0]*10+","+c.getAreas()[0]*30+","+c.getAreas()[0]*25+");");

            
        }

        String a = null;
        for (ClientInterface c : this.ListaClient) {

            try {
                //System.out.println("--------->"+"//"+ServerList.get(""+c.getServer())+"/server" + c.getServer());
                if(c.getServer()==Setup.ID_SERVER){
                look_up = (RMIInterface) Naming.lookup("//"+ServerList.get(""+c.getServer())+"/server" + c.getServer()); //localhost will be dyn

                // if (this.GRIDS_SYSTEMS.getServerList().get(c.getAreas()[0]).getGRIDS_RS().containsKey(c)) {
                if (look_up.getGRIDS_RS().containsKey(c)) {

                    // if (c.getMETA().equals("SmartPhone") && this.GRIDS_SYSTEMS.getServerList().get(c.getAreas()[0]).getGRIDS_RS().containsKey(c)) {
                    for (FriendTableEntry f : look_up.getGRIDS_RS().get(c).getSVER()) {

                            
                            try {
                                graph.addEdge(c.getUID() + f.getClient_instance().getUID(), c.getUID(), f.getClient_instance().getUID(), true);
                            } catch (Exception ex) {
                            
                            //others nodes inside}
                        }

                    }
                }
                }else{
                
                
                
                /////TO DO                
                   Connection conn1 = DriverManager.getConnection("jdbc:mysql://"+ServerList.get(""+c.getServer())+":3306/social_iot_platform_sve?" + "user=ing&password=salvo1993");
       
                    Statement stmt3 = conn1.createStatement();
                    String cmd2 = "SELECT * FROM " +"SVE_"+c.getUID();
                     System.out.println(cmd2);
                    ResultSet rs3 = stmt3.executeQuery(cmd2);
                    while(rs3.next()){
                    //c = new Client(rs2.getString("id_friend"), rs3.getString("areas"), rs3.getString("ip"), rs3.getString("meta"), Integer.parseInt(rs3.getString("server")));
                    
                 try {
                                graph.addEdge(c.getUID() + rs3.getString("id_friend"), c.getUID(), rs3.getString("id_friend"), true);
                            } catch (Exception ex) {
                            
                            //others nodes inside}
                        }

                  
                    }
                    conn1.close();
                
                
                }
            } catch (NotBoundException ex) {
                Logger.getLogger(NetGraph.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MalformedURLException ex) {
                Logger.getLogger(NetGraph.class.getName()).log(Level.SEVERE, null, ex);
            } catch (RemoteException ex) {
                Logger.getLogger(NetGraph.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        System.setProperty("org.graphstream.ui.renderer",
                "org.graphstream.ui.j2dviewer.J2DGraphRenderer");
        graph.addAttribute("ui.quality");
        graph.addAttribute("ui.antialias");
        graph.addAttribute("ui.stylesheet", "url(" + getClass().getResource("/style.css") + ")");
        Viewer viewer = graph.display();
        this.setupPanel();
        if (this.compute_betweenness) {
            this.Betweenness(); //betweenness

        }
        viewer.setCloseFramePolicy(Viewer.CloseFramePolicy.HIDE_ONLY);

        ViewerPipe fromViewer = viewer.newViewerPipe();
        fromViewer.addViewerListener(this);
        fromViewer.addSink(graph);

        while (it.hasNext()) {
            org.graphstream.graph.Node n = it.next();
            //System.out.println(n);
        }

        while (loop) {
            try {
                fromViewer.pump();
            } catch (Exception e) {
            }
        }

    }

    public void Betweenness() {
        BetweennessCentrality bcb = new BetweennessCentrality();
        bcb.init(graph);
        System.out.println(graph.getNodeCount());
        bcb.compute();
        for (ClientInterface c : this.ListaClient) {
            System.out.println("UID:" + c.getUID() + "Meta:" + c.getMETA() + "Score: " + graph.getNode(c.getUID()).getAttribute("Cb"));
            StatisticsInterface stat = new Statistics();
            stat.betweenness(c.getUID(), c.getMETA(), Float.parseFloat(graph.getNode(c.getUID()).getAttribute("Cb").toString()));

        }
    }

    public void setupPanel() throws NotBoundException, MalformedURLException, RemoteException {

        myJFrame = new JFrame();
        myJFrame.setPreferredSize(new Dimension(700, 360));
        myJFrame.setMaximumSize(new Dimension(800, 360));
        myJFrame.setMinimumSize(new Dimension(700, 360));
        infopanel = new NodeInfo(this.ListaClient, graph);
        infopanel.setVisible(true);
        myJFrame.add(infopanel);

    }

    @Override
    public void viewClosed(String viewName) {
        loop = false;
    }

    @Override
    public void buttonPushed(String id) {
        try {
            // System.out.println("Button pushed on node " + id);
            // graph.getNode(id).setAttribute("ui.label", "ID:" + graph.getNode(id).getAttribute("ID").toString());
            HashMap<String,String> ServerList = new  HashMap<String,String>();
            root_look_up = (RMIRootInterface) Naming.lookup("//"+Setup.GATEWAY+"/root");
            ServerList = root_look_up.getAddressServerList();
            
            infopanel.getID().setText(graph.getNode(id).getAttribute("ID").toString());
            infopanel.getMeta().setText(graph.getNode(id).getAttribute("meta").toString());
            infopanel.getServer().setText(graph.getNode(id).getAttribute("server").toString());
            String areas = null;
            DefaultListModel listModel = new DefaultListModel();
            for (ClientInterface c : this.ListaClient) {
                if (c.getUID().equals(id) && c.getServer() == Setup.ID_SERVER) {
                    
                    try {
                        look_up = (RMIInterface) Naming.lookup("//localhost/server" + c.getServer());
                        
                        //   for (FriendTableEntry f : this.GRIDS_SYSTEMS.getServerList().get(c.getAreas()[0]).getGRIDS_RS().get(c).getSVER()) {
                        for (FriendTableEntry f : look_up.getGRIDS_RS().get(c).getSVER()) {
                            
                            listModel.addElement(f.getClient_instance().getUID() + " ( " + f.getRelationship_Type() + " )");
                        }
                        
                        infopanel.getFriends().setModel(listModel);
                        areas = "AREAS: " + c.getAreas();
                        
                        break;
                    } catch (NotBoundException ex) {
                        Logger.getLogger(NetGraph.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (MalformedURLException ex) {
                        Logger.getLogger(NetGraph.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (RemoteException ex) {
                        Logger.getLogger(NetGraph.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{
                    try {
                        //if it is on a different serve, I must surf on it!
                        
                        Connection conn1 = DriverManager.getConnection("jdbc:mysql://"+ServerList.get(""+c.getServer())+":3306/social_iot_platform_sve?" + "user=ing&password=salvo1993");
                        
                        Statement stmt3 = conn1.createStatement();
                        String cmd2 = "SELECT * FROM " +"SVE_"+c.getUID();
                        System.out.println(cmd2);
                        ResultSet rs3 = stmt3.executeQuery(cmd2);
                        while(rs3.next()){
                            //c = new Client(rs2.getString("id_friend"), rs3.getString("areas"), rs3.getString("ip"), rs3.getString("meta"), Integer.parseInt(rs3.getString("server")));
                            
                            try {
                                  listModel.addElement(rs3.getString("id_friend") + " ( " + rs3.getString("REL")+")");
                               
                            } catch (Exception ex) {
                                
                                //others nodes inside}
                            }
                            
                            
                        }
                        infopanel.getFriends().setModel(listModel);
                        areas = "AREAS: " + c.getAreas();
                        conn1.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(NetGraph.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    
                    
                    
                }

            }
            infopanel.getAreas().setText(areas);
            infopanel.setVisible(true);
            myJFrame.setVisible(true);
        } catch (NotBoundException ex) {
            Logger.getLogger(NetGraph.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(NetGraph.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(NetGraph.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void buttonReleased(String id) {
        // System.out.println("Button rel on node " + id);
        // graph.getNode(id).setAttribute("ui.label", "");
    }

    @Override
    public void run() {
        try {
            System.out.println("CREATION OF THE GRAPH");
            this.create();
        } catch (NotBoundException ex) {
            Logger.getLogger(NetGraph.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(NetGraph.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(NetGraph.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NetGraph.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(NetGraph.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
