/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servers;

import Entities.Client;
import Servers.SVER.Sve;
import Entities.ClientInterface;
import Servers.SVER.FriendTableEntry;
import Settings.Setup;
import Systems.RMIRootInterface;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Salvo
 */
public class GridsRS {

    private HashMap<ClientInterface, Sve> GRIDS_RS; //KEY = ID OF THE NODE, VALUE = THE LIST OF FRIENDS
    private Sve SVE;
    private static RMIRootInterface root_look_up;
    HashMap<String, String> ServerList = new HashMap<String, String>();

    public GridsRS() {
        this.GRIDS_RS = new HashMap<ClientInterface, Sve>();
    }

    public HashMap<ClientInterface, Sve> getGRIDS_RS() throws ClassNotFoundException,
            SQLException, UnknownHostException {
        return GRIDS_RS;
    }

    public void UpdateGRIDS_RS(ClientInterface c, Sve sve) throws SQLException,
            ClassNotFoundException, NotBoundException, MalformedURLException, RemoteException {
        root_look_up = (RMIRootInterface) Naming.lookup("//" + Setup.GATEWAY + "/root");
        ServerList = root_look_up.getAddressServerList();
        Connection conn = DriverManager.getConnection("jdbc:mysql://"
                + Setup.IP_SERVER + ":3306/social_iot_platform_sve?"
                        + "user=ing&password=salvo1993");
        Class.forName("com.mysql.jdbc.Driver");  // MySQL database connection
        Statement stmt = conn.createStatement();
        String sql = "CREATE TABLE IF NOT EXISTS" + " SVE_" + c.getUID()
                + "(id_friend  VARCHAR(255) not NULL, "
                + " REL VARCHAR(255), "
                + " MS_LOCATOR VARCHAR(255), "
                + " SVE_LOCATOR VARCHAR(255), "
                + " SERVER VARCHAR(255), "
                + " PRIMARY KEY ( id_friend ))";
        stmt.executeUpdate(sql);

        /* String sql1 = "CREATE TABLE IF NOT EXISTS" + " SVE_" + c.getUID()
                + "(id_friend  VARCHAR(255) not NULL, "
                + " REL VARCHAR(255), "
                + " MS_LOCATOR VARCHAR(255), "
                + " SVE_LOCATOR VARCHAR(255), "
                + " PRIMARY KEY ( id_friend ))";
       
        stmt.executeUpdate(sql1);*/
        Statement stmt1 = conn.createStatement();

        for (FriendTableEntry f : sve.getSVER()) {
            String sql2 = "SELECT * FROM SVE_" + c.getUID() 
                    + " WHERE id_friend = '" + f.getClient_instance().getUID() + "'";
            // System.out.println(sql2);
            ResultSet rs = stmt.executeQuery(sql2);
            if (rs.next()) {
                PreparedStatement pst = conn.prepareStatement("UPDATE SVE_" 
                        + c.getUID() + " SET REL = '" + f.getRelationship_Type() 
                        + "',MS_LOCATOR = '" + f.getGRIDS_MS_Locator().toString() 
                        + "',SVE_LOCATOR='" + f.getSVE_locator() 
                        + "' WHERE id_friend ='" + f.getClient_instance().getUID() + "'");
                pst.execute();
            } else {
                PreparedStatement pst = conn.prepareStatement("INSERT INTO SVE_" 
                        + c.getUID() + " (id_friend, REL,MS_LOCATOR,SVE_LOCATOR, SERVER) VALUES ('" 
                        + f.getClient_instance().getUID() + "','" + f.getRelationship_Type() + "','" 
                        + f.getGRIDS_MS_Locator().toString() + "','" + f.getSVE_locator() + "','" 
                        + f.getClient_instance().getServer() + "')");
                pst.execute();

            }

        }

        //this.GRIDS_RS.put(c, sve); //da rimuovere=> conv in DB
        //this.fillGRIDS_RS();
        conn.close();

    }

    public void fillGRIDS_RS() throws ClassNotFoundException,
            SQLException, NotBoundException, MalformedURLException, RemoteException {

        HashMap<String, String> ServerList = new HashMap<String, String>();
        root_look_up = (RMIRootInterface) Naming.lookup("//" + Setup.GATEWAY + "/root");
        ServerList = root_look_up.getAddressServerList();
        HashMap<ClientInterface, Sve> GRIDS_RS1;
        GRIDS_RS1 = new HashMap<ClientInterface, Sve>();
        ClientInterface c;
        ClientInterface c1;
        // List<ClientInterface> bufferList;
        List<FriendTableEntry> FriendTableBuffer = null;
        Class.forName("com.mysql.jdbc.Driver");  // MySQL database connection
        Connection conn = DriverManager.getConnection("jdbc:mysql://" 
                + Setup.IP_SVER + ":3306/social_iot_platform_sve?" 
                        + "user=ing&password=salvo1993");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT table_name FROM information_schema.tables "
                + "WHERE table_schema = 'social_iot_platform_sve'");

        while (rs.next()) {
            Statement stmt2 = conn.createStatement();
            String cmd = "SELECT * FROM " + rs.getString(1);
            ResultSet rs2 = stmt2.executeQuery(cmd);
            FriendTableBuffer = new LinkedList<>();
            while (rs2.next()) {

                if (rs2.getString("id_friend").compareTo(rs.getString(1).split("_")[1]) != 0) {
                    /////////////////
                    Connection conn1 = DriverManager.getConnection("jdbc:mysql://" 
                            + ServerList.get(rs2.getString("server")) 
                            + ":3306/social_iot_platform?" + "user=ing&password=salvo1993");
                    Statement stmt3 = conn1.createStatement();
                    String cmd2 = "SELECT * FROM sver where uid = '" 
                            + rs2.getString("id_friend") + "'";
                    ResultSet rs3 = stmt3.executeQuery(cmd2);
                    while (rs3.next()) {
                        c = new Client(rs2.getString("id_friend"), 
                                rs3.getString("areas"), rs3.getString("ip"), 
                                rs3.getString("meta"), Integer.parseInt(rs3.getString("server")),
                                rs3.getString("price"), rs3.getString("walletAddress"));

                        FriendTableEntry f = new FriendTableEntry(rs2.getString("REL"), 
                                rs2.getString("SVE_LOCATOR"), rs2.getString("MS_LOCATOR"), c);

                        FriendTableBuffer.add(f);
                    }
                    conn1.close();
                }
            }
            SVE = new Sve();
            SVE.setSVER(FriendTableBuffer);

            Connection conn2 = DriverManager.getConnection("jdbc:mysql://" 
                    + Setup.IP_SVER + ":3306/social_iot_platform?" + "user=ing&password=salvo1993");
            Statement stmt4 = conn2.createStatement();
            String cmd2 = "SELECT * FROM sver where uid = '" + rs.getString(1).split("_")[1] + "'";

            ResultSet rs4 = stmt4.executeQuery(cmd2);
            while (rs4.next()) {
                c1 = new Client(rs.getString(1).split("_")[1], 
                        rs4.getString("areas"), rs4.getString("ip"), 
                        rs4.getString("meta"), 0, rs4.getString("price"), 
                        rs4.getString("walletAddress"));
                GRIDS_RS1.put(c1, SVE);
            }
            conn2.close();
        }
        conn.close();

        this.GRIDS_RS = GRIDS_RS1;

    }

}
