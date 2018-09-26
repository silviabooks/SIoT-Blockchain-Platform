/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unict.iot.blockchain;

import Settings.Setup;
import static Systems.GridsSystems.ww;
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
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;

/**
 * Methods to access the trx database
 *
 * @author silvia
 */
public class TrxManager {

    private static Connection connection;

    /**
     * Creates the connection to the database with JDBC
     */
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

    /**
     * Adds the record in the "creditCharges" table (the trx is not confirmed yet)
     * @param trxHash
     * @param userID
     * @param amount 
     */
    public void addChargeRecord(String trxHash, int userID, int amount) {
        try {
            PreparedStatement pst = connection.prepareStatement(
                    "INSERT INTO `creditCharges` (trxHash, userID, credit, isConfirmed) "
                    + "VALUES ('" + trxHash + "', " + userID + ", "
                    + amount + ", 0)");
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(TrxManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Set 'isConfirmed' to 1 in row with trxHash of table "creditCharges"
     * and delete row from table 'unconfirmed'
     * @param trxHash 
     */
    public void confirmCharge(String trxHash) {
        try {
            PreparedStatement pst = connection.prepareStatement("UPDATE "
                    + "`creditCharges` SET `isConfirmed`=1"
                    + " WHERE `trxHash`='" + trxHash + "'");
            pst.execute();
            pst = connection.prepareStatement("DELETE FROM `unconfirmed` "
                    + "WHERE `TrxHash`='" + trxHash + "'");
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(TrxManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * 
     * @param SVER_ID
     * @param SVE_ID
     * @param userID
     * @return 
     */
    public String getDataWithCredit(String SVER_ID, String SVE_ID,
            int userID) {
        String res = "";
        try {
            String url = "http://localhost:8080/Sim/SIoT/Server/" + SVER_ID + "/" + SVE_ID;
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
            // Check if credit is available with subtractCredit...
            boolean sub = subtractCredit(userID, (Integer.parseInt(price)));
            if (!sub) {
                res = "You don't have enough credit to perform the request!";
            } else {
                // ...if so, start thread. If not, return error string
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(" *** SENDING COMMISSION to " + walletAddress);
                        ww.getTc().makeTransaction(walletAddress, price);
                    }
                });
                //thread.start();
                Statement keyStmt = connection.createStatement();
                ResultSet resSet = keyStmt.executeQuery("SELECT readAPIkey FROM `readAPIkeys` "
                        + "WHERE SVER_ID='" + SVER_ID + "' AND SVE_ID='" + SVE_ID + "'");
                if (resSet.next()) {
                    res = resSet.getString("readAPIkey");
                } else {
                    res = "ReadAPIKey not found. The channel could be public";
                }
            }
        } catch (MalformedURLException | ProtocolException | SQLException ex) {
            Logger.getLogger(TrxManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TrxManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    public int getCredit(int userID) {
        int credit = 0;
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT SUM(credit) FROM "
                    + "`creditCharges` WHERE `userID`="
                    + userID + " AND `isConfirmed`=1 GROUP BY `userID`");
            while (rs.next()) {
                credit += rs.getInt("SUM(credit)");
            }
            System.out.println("Credit of user " + userID + ": " + credit);
        } catch (SQLException ex) {
            Logger.getLogger(TrxManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return credit;
    }

    private boolean subtractCredit(int userID, int amount) {
        boolean outcome = false;
        try {
            int initialCredit = getCredit(userID);
            if (initialCredit < amount) {
                outcome = false; // not enough credit
            } else if (initialCredit == amount) {
                // delete the records because the credit is now zero
                PreparedStatement pst = connection.prepareStatement(
                        "DELETE FROM `creditCharges` WHERE `userID`=" + userID
                        + " AND `isConfirmed`=1");
                pst.execute();
                outcome = true;
            } else { // subtract credit mindfully
                int credit = 0;
                String sql = "SELECT `credit` FROM `creditCharges` WHERE `userID`=" + userID
                        + " AND `isConfirmed`=1 ORDER BY `credit` DESC LIMIT 1";
                Statement keyStmt = connection.createStatement();
                ResultSet res = keyStmt.executeQuery(sql);
                if (res.next()) {
                    credit = Integer.valueOf(res.getString("credit"));
                } else {
                    outcome = false;
                }
                int newVal = credit - amount;
                // subtract credit only from one entry of the table
                sql = "UPDATE `creditCharges` SET `credit`=" + newVal
                        + " WHERE `userID`=" + userID
                        + " AND `isConfirmed`=1 AND `credit`=" + credit
                        + " LIMIT 1";
                PreparedStatement pst = connection.prepareStatement(sql);
                pst.execute();
                outcome = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TrxManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return outcome;
    }

    public void updateUnconfirmedTrx(String trxHash, String SVER_ID, String SVE_ID) {
        try {
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

    public void confirmTrxAndReadData(final String trxHash) {
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
                    // Create a thread - I'm sending bitcoins to the channel owner
                    // It's "fire and forget", I don't need the hash of this trx or whatever
                    Thread thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println(" *** SENDING COMMISSION for " + trxHash);
                            ww.getTc().makeTransaction(walletAddress, price);
                        }
                    });
                    //thread.start();
                    Statement keyStmt = connection.createStatement();
                    ResultSet res = keyStmt.executeQuery("SELECT readAPIkey FROM `readAPIkeys` "
                            + "WHERE SVER_ID='" + sverId + "' AND SVE_ID='" + sveId + "'");
                    if (res.next()) {
                        content = res.getString("readAPIkey");
                    } else {
                        content = "ReadAPIKey not found. The channel could be public";
                    }

                } catch (ProtocolException | MalformedURLException ex) {
                    Logger.getLogger(TrxManager.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                System.out.println("error");
            }
            PreparedStatement pst = connection.prepareStatement(
                    "DELETE FROM `unconfirmed` WHERE `TrxHash`='" + trxHash + "'");
            pst.execute();
            addCompletedTrx(trxHash, content);

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
