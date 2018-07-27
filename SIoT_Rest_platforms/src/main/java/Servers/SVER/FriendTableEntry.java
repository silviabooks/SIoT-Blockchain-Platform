/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servers.SVER;
import Entities.ClientInterface;
import java.io.Serializable;
import java.net.InetAddress;
import java.lang.String;
import java.util.Objects;

/**
 *
 * @author Salvo
 */
public class FriendTableEntry implements Comparable, Serializable{
    private String Relationship_Type;
    private String SVE_locator;
    private String GRIDS_MS_Locator;
    private ClientInterface Client_instance;
    
    public FriendTableEntry(String Relationship_Type, String SVE_locator, String GRIDS_MS_Locator, ClientInterface Client_instance) {
        this.Client_instance = Client_instance;
        this.Relationship_Type = Relationship_Type;
        this.SVE_locator = SVE_locator;     
        this.GRIDS_MS_Locator = GRIDS_MS_Locator;
    }

    public ClientInterface getClient_instance() {
        return Client_instance;
    }

    public void setClient_instance(ClientInterface Client_instance) {
        this.Client_instance = Client_instance;
    }


    public String getRelationship_Type() {
        return Relationship_Type;
    }

    public void setRelationship_Type(String Relationship_Type) {
        this.Relationship_Type = Relationship_Type;
    }

    public String getSVE_locator() {
        return SVE_locator;
    }

    public void setSVE_locator(String SVE_locator) {
        this.SVE_locator = SVE_locator;
    }

    public String getGRIDS_MS_Locator() {
        return GRIDS_MS_Locator;
    }

    public void setGRIDS_MS_Locator(String GRIDS_MS_Locator) {
        this.GRIDS_MS_Locator = GRIDS_MS_Locator;
    }

    @Override
    public String toString() {
        return "FriendTable{" + "Friend_SVE_UID=" + this.Client_instance.getUID()
                + ", Metadata=" + this.Client_instance.getMETA() + ", Relationship_Type=" 
                + Relationship_Type + ", SVE_locator=" + SVE_locator 
                + ", GRIDS_MS_Locator=" + GRIDS_MS_Locator + '}';
    }  

    @Override
    public int compareTo(Object o) {
        //String comp=this.getSVE_locator();
      int build = this.getClient_instance().getServer();
      //  return build.toString.compareTo(((FriendTableEntry)o).getClient_instance().getBuilding());
       return Integer.compare(build, ((FriendTableEntry)o).getClient_instance().getServer()) ;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.Client_instance);
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
        final FriendTableEntry other = (FriendTableEntry) obj;
        if (!Objects.equals(this.Client_instance, other.Client_instance)) {
            return false;
        }
        return true;
    }
    
}
