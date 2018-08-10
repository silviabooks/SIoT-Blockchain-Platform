/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unict.iot.blockchain;

import Settings.Setup;
import static Systems.GridsSystems.ww;
import com.google.gson.Gson;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;
import thingspeak.Channel;
import thingspeak.Entry;
import thingspeak.Feed;
import thingspeak.FeedParameters;
import thingspeak.ThingSpeakException;

/**
 * Some methods to access the trx database
 *
 * @author silvia
 */
public class TrxManager {

    private static Connection connection;

    public TrxManager() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://"
                    + Setup.IP_SERVER + ":3306/social_iot_platform_transaction?"
                    + "user=ing2&password=silvia1994");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(TrxManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateUnconfirmedTrx(String trxHash, String SVER_ID, String SVE_ID) {
        try {
            //System.out.println("updateunconfirmedtrx");
            PreparedStatement pst = connection.prepareStatement("UPDATE "
                    + "`unconfirmed` SET `SVER_ID`='" + SVER_ID
                    + "',`SVE_ID`='" + SVE_ID + "' WHERE `TrxHash`='"
                    + trxHash + "'");
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(TrxManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public HashSet<String> loadUnconfirmedTrxs() {
        HashSet<String> set = new HashSet<>();
        System.out.println("Restoring unconfirmed transactions...");
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM `unconfirmed`");
            while (rs.next()) {
                set.add(rs.getString("TrxHash"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TrxManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return set;
    }

    public void addUnconfirmedTrx(String trxHash, String SVER_ID, String SVE_ID) {
        try {
            PreparedStatement pst = connection.prepareStatement(
                    "INSERT INTO `unconfirmed` (TrxHash) "
                    + "VALUES ('" + trxHash + "')");
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(TrxManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void confirmTrxAndReadData(String trxHash) {
        try {
            String content = null;
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM `unconfirmed` "
                    + "WHERE `TrxHash`='" + trxHash + "'");
            if (rs.next()) {
                try {
                    String sverId = rs.getString("SVER_ID");
                    String sveId = rs.getString("SVE_ID");
                    // HTTP request to get the SVE information
                    String url = "http://localhost:8080/Sim/SIoT/Server/" + sverId + "/" + sveId;
                    URL obj = new URL(url);
                    HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
                    conn.setRequestMethod("GET");
                    StringBuilder response;
                    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    String inputLine;
                    response = new StringBuilder();
                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    JSONObject myResponse = new JSONObject(response.toString());

                    final String walletAddress = myResponse.getString("walletAddress");
                    final String price = myResponse.getString("price");
                    System.out.println(" *** SENDING COMMISSION for " + trxHash);
                    // Create a thread - I'm sending bitcoins to the channel owner
                    // It's "fire and forget", I don't need the hash of this trx or whatever
                    Thread thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            ww.getTc().makeTransaction(walletAddress, price);
                        }
                    });
                    thread.start();
                    
                    //TODO: restituire la readAPIkey! E fare il DB con le chiavi
//                    Statement keyStmt = connection.createStatement();
//                    ResultSet res = keyStmt.executeQuery("SELECT readAPIkey FROM `readAPIkeys` "
//                            + "WHERE SVER_ID='" + sverId + "' AND SVE_ID='" + sveId + "'");
//                    if (res.next()) 
//                        content = res.getString("readAPIkey");
//                    else {
//                        content = "ReadAPIKey not found. The channel is public!";
                    content = "ReadAPIKey finta";
                        // Get the channel ID
    //                    String chanID = myResponse.getString("meta")
    //                            .replace("https://thingspeak.com/channels/", "");
    //                    // Read from ThingSpeak (10 results by default)
    //                    // Questo non servirà più visto che restituisco la readKey...
    //                    Channel channel = new Channel(Integer.parseInt(chanID));
    //                    FeedParameters par = new FeedParameters();
    //                    par.results(10);
    //                    Feed feed = channel.getChannelFeed(par);
    //                    ArrayList<Entry> lista = feed.getEntryList();
    //                    Gson gson = new Gson();
    //                    content = gson.toJson(lista);
                    System.out.println(content);
                    //}
                    
                } catch (ProtocolException | MalformedURLException ex) {
                    Logger.getLogger(TrxManager.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                System.out.println("error");
            }
            PreparedStatement pst = connection.prepareStatement(
                    "DELETE FROM `unconfirmed` WHERE `TrxHash`='" + trxHash + "'");
            pst.execute();
            //TODO sostituire con la funzione addCompletedTrx(trxHash, content)
            PreparedStatement pst2 = connection.prepareStatement(
                    "INSERT INTO `completed` (TrxHash, Content) "
                    + "VALUES ('" + trxHash + "', '" + content + "')");
            pst2.execute();

        } catch (SQLException | IOException ex) {
            Logger.getLogger(TrxManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean isUnconfirmed(String trxHash) {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM `unconfirmed` "
                    + "WHERE `TrxHash`='" + trxHash + "'");
            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(TrxManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public void addCompletedTrx(String trxHash, String data) {
        try {
            PreparedStatement pst = connection.prepareStatement(
                    "INSERT INTO `completed` (TrxHash, Content) "
                    + "VALUES ('" + trxHash + "', '" + data + "')");
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(TrxManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getCompletedTrx(String trxHash) {
        String result = null;
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM `completed` "
                    + "WHERE `TrxHash`='" + trxHash + "'");
            if (rs.next()) {
                result = rs.getString("Content");
                
            } else {
                result = "error";
            }
        } catch (SQLException ex) {
            Logger.getLogger(TrxManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(TrxManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
