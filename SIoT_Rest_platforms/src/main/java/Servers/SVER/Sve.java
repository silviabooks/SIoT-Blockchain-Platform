/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servers.SVER;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Salvo
 */
public class Sve implements Serializable {

    public Sve() {
    }
    
    private List<FriendTableEntry> SVE;

    public List<FriendTableEntry> getSVER() {
        return SVE;
    }

    public void setSVER(List<FriendTableEntry> SVER) {
        this.SVE = SVER;
    }
    
}
