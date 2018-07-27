/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package festival;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author Salvo
 */
public class Connector {
    public String connection(String urly) throws MalformedURLException, IOException {

        URL obj = new URL(urly);
       
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
         
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("x-auth-token", "NhUF35qesagalwBkNbMGnmE9XdsmSD");
        con.setDoOutput(true);
        int responseCode = con.getResponseCode();
        System.out.println("Response Code : " + responseCode);

        BufferedReader iny = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String output;
        StringBuffer response = new StringBuffer();

        while ((output = iny.readLine()) != null) {
            response.append(output);
        }
        iny.close();

        return response.toString();

    }
}
