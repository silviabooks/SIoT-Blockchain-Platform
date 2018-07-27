/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NetGraph;

import Entities.ClientInterface;
import Servers.SVER.FriendTableEntry;
import java.util.Comparator;
import java.util.Objects;

/**
 *
 * @author Salvo
 */
public class Node implements Comparable{
    
    private String father;
    private int level;
    private FriendTableEntry FTEntry;
    private int port;
    private ClientInterface client;

    public Node() {
    }

    public ClientInterface getClient() {
        return client;
    }

    public void setClient(ClientInterface client) {
        this.client = client;
    }
    public int getFatherPort() {
        return port;
    }

    public void setFatherPort(int port) {
        this.port = port;
      
    }
    
    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public FriendTableEntry getFTentry() {
        return FTEntry;
    }

    public void setFTEntry(FriendTableEntry FT) {
        this.FTEntry = FT;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.client);
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
        final Node other = (Node) obj;
        if (!Objects.equals(this.client.getUID(), other.client.getUID())) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Object o) {
        return Integer.compare(this.getClient().getServer(),((Node)o).getClient().getServer());
    }

    

    

    
    
    
}
