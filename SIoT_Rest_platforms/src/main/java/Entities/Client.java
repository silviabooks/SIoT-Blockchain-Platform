/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Salvo
 */
public class Client implements ClientInterface, Serializable {

    private String UID;
    public String areas;
    private String ip;
    private String meta;
    private int server;
    private String price;
    private String walletAddress;

    public Client(String UID, String areas, String meta, String ip, int server,
            String price, String walletAddress) {
        this.UID = UID;
        this.areas = areas;
        this.meta = meta;
        this.ip = ip;
        this.server = server;
        this.price = price;
        this.walletAddress = walletAddress;
    }

    @Override
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setMETA(String META) {
        this.meta = META;
    }

    @Override
    public String getAreas() {
        return areas;
    }

    @Override
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String getWalletAddress() {
        return walletAddress;
    }

    public void setWalletAddress(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    @Override
    public String toString() {

        return "Client{" + "UID=" + UID + ", areas=" + areas + ", ip=" + ip
                + ", meta=" + meta + ", server=" + server + ", price=" + price
                + ", walletAddress=" + walletAddress + "}";
    }

    @Override
    public String getUID() {
        return UID;
    }

    @Override
    public String getMETA() {
        return meta;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.UID);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Client other = (Client) obj;
        if (!Objects.equals(this.UID, other.UID)) {
            return false;
        }
        return true;
    }

    @Override
    public int getServer() {
        return server;
    }

    @Override
    public void setServer(int server) {
        this.server = server;
    }

    @Override
    public void setAreas() {
        throw new UnsupportedOperationException("Not supported yet.");
        //To change body of generated methods, choose Tools | Templates.
    }

}
