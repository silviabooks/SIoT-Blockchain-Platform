/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package festival;

import Settings.Setup;
import com.google.gson.Gson;
import com.mysql.jdbc.StringUtils;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

/**
 *
 * @author Salvo
 */
public class FestivalResources {

    public FestivalResources() {
    }

    public ArrayList<String> getResources() throws IOException, SQLException {
        Connector connector = new Connector();
        String res;
        String res1;
        String feed;
        ArrayList<String> feeds = new ArrayList<>();
        Gson gson = new Gson();
        res = connector.connection("https://api.festival-project.eu/festival/eaas/experimentation/aggregators");
        AggregatorParser[] ac = gson.fromJson(res, AggregatorParser[].class);
        // System.out.println("aggregators->" + res+"\n------------------------------");
        System.out.println("aggregators size->" + ac.length + "\n------------------------------");

        TestBedsContainer tbc = null;
        TestBedsContainer tbc1 = null;
        feed f = null;
        for (int i = 0; i < ac.length; i++) {
            res = connector.connection("https://api.festival-project.eu/festival/eaas/experimentation/aggregators/" + ac[i].getAggregatorID() + "/testbeds");
            // System.out.println("aggregators->" + res);
            tbc = gson.fromJson(res, TestBedsContainer.class);

            for (int j = 0; j < tbc.getTestbeds().size(); j++) {

                res1 = connector.connection("https://api.festival-project.eu/festival/eaas/experimentation/aggregators/"
                        + ac[i].getAggregatorID() + "/testbeds/" + tbc.getTestbeds().get(j).getId() + "/resources?rows=2");
                //System.out.println("resources->" + res1);
                tbc1 = gson.fromJson(res1, TestBedsContainer.class);
                // System.out.println("Resources size->"+tbc1.getResources().get(j).getDescription())   ;

                for (int k = 0; k < tbc1.getResources().size(); k++) {

                    feed = connector.connection("https://api.festival-project.eu/festival/eaas/experimentation/aggregators/"
                            + ac[i].getAggregatorID() + "/testbeds/" + tbc.getTestbeds().get(j).getId() + "/resources/" + tbc1.getResources().get(k).getId());

                    String path = "https://api.festival-project.eu/festival/eaas/experimentation/aggregators/"
                            + ac[i].getAggregatorID() + "/testbeds/" + tbc.getTestbeds().get(j).getId() + "/resources/" + tbc1.getResources().get(k).getId();
                    // tbc.getResources().get(k).
                    String coord = "";
                    Random r = new Random();
                    try {
                        coord = feed.toString().split("coordinates")[1].split("locationDescription")[0].split(":")[1].split("]")[0].replaceAll("\\s+", "").replaceAll("\\[", "");
                        if (coord.compareTo("") == 0) {
                            Double lat = (r.nextDouble() * -180.0) + 90.0;
                            Double longi = (r.nextDouble() * -360.0) + 180.0;
                            coord = lat.toString() + "," + longi.toString();
                        }
                        System.out.println("feed->" + feed);

                        f = gson.fromJson(feed, feed.class);

                        // System.out.println("feed->" + f.getDescription());
                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/social_iot_platform?" + "user=ing&password=salvo1993");
                        String description = f.getTitle().replaceAll("'", "`");
                        String name = f.getId().replaceAll("'", "`");

                        PreparedStatement pst = conn.prepareStatement("INSERT INTO sver (channel,uid, areas,ip,meta,server) VALUES ('" + f.getAggregatorID() + "','" + this.generateID() + "','" + coord + "','" + path + "','" + description + "','" + Setup.ID_SERVER + "')");
                        pst.execute();

                        conn.close();
                    } catch (Exception ex) {
                    }
                    // tbc1 = gson.fromJson(res1, TestBedsContainer.class);  
                    // System.out.println("Resources size->"+tbc1.getResources().size())   ;
                    /// feeds.add(feed);
                }

            }

        }

        //AggregatorParser[] ac1 = gson.fromJson(res, AggregatorParser[].class);       
        //   System.out.println("tesbeds->" + ac1[0].getAggregatorID());
        //   System.out.println(response.toString());//from response
        return feeds;
    }

    private String generateID() {
        UUID id = UUID.randomUUID();
        return id.toString().replaceAll("-", "");
    }
}
