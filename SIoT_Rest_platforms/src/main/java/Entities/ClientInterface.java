/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 *
 * @author Salvo
 */
public interface ClientInterface {

    public String getUID();

    String getMETA();

    public String getAreas();

    public int getServer();

    public void setServer(int server);

    public void setAreas();

    public String getIp();
    
    public String getPrice();
    
    public String getWalletAddress();
}
