/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resourcesupdater;

import Settings.Setup;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.UUID;
import thingspeak.PublicChannel;
import thingspeak.PublicChannelCollection;
import thingspeak.ThingSpeakException;

/**
 *
 * @author Salvo
 */
public class ThingSpeakUpdater {

    public ThingSpeakUpdater() {
    }

    public void updateThingsSpeack_SVE_DB() throws UnirestException,
            ThingSpeakException, ClassNotFoundException, SQLException {

        PublicChannelCollection p = new PublicChannelCollection();
        Iterator<PublicChannel> i = p.iterator();

        /*Channel channel = new Channel(418835);
        Feed statusFeed = channel.getStatusFeed();
        Feed channelFeed = channel.getChannelFeed();
        Feed fieldFeed = channel.getFieldFeed(1);*/
        //  System.out.println(channel.getChannelJsonFeed());
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/social_iot_platform?" + "user=ing&password=salvo1993");

        while (i.hasNext()) {

            PublicChannel pc = new PublicChannel();
            pc = i.next();

            Class.forName("com.mysql.jdbc.Driver");  // MySQL database connection

            String description = pc.getDescription().replaceAll("'", "`");
            String name = pc.getName().replaceAll("'", "`");
            System.out.println(pc.getId() + "/" + description + "/" + name);
            String areas = pc.getLatitude() + "," + pc.getLongitude();
            String price = "1000";
            String walletAddress = "mjLogQRYRDuUFsDjctzamVqQLE2iknst9X";
            int server = 0;
            String address = "https://thingspeak.com/channels/" + pc.getId();
            PreparedStatement pst = conn.prepareStatement("INSERT INTO sver "
                    + "(channel,uid,areas,ip,meta,server,price,walletAddress) VALUES ('"
                    + pc.getId() + "','" + this.generateID() + "','" + areas
                    + "','" + address + "','" + name + "','" + Setup.ID_SERVER
                    + "','" + price + "','" + walletAddress + "')");
            pst.execute();

        }
        conn.close();
    }

    private String generateID() {
        UUID id = UUID.randomUUID();
        return id.toString().replaceAll("-", "");
    }
}
