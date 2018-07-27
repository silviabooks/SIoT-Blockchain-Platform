/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Systems;

import Servers.Server;
import Entities.Client;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Salvo
 */
public class Configurator {
    ArrayList<Server> servers;
    public List<Client> entities;

  
    
    
    public ArrayList<Server> getServers() {
        return servers;
    }

    public List<Client> getListaClient() {
        return entities;
    }

    @Override
    public String toString() {
        return "Configurator{" + "servers=" + servers + ", entities=" + entities + '}';
    }

}
