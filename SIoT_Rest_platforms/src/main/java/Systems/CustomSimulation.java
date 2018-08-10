/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Systems;

import FinalClient.FinalClientRMIRootInterface;
import Servers.SVER.Sve;
import Servers.Server;
import Entities.ClientInterface;
import Entities.Client;
import FinalClient.FinalClient;
import Servers.RMIInterface;
import Settings.Setup;
import com.google.gson.Gson;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Salvo
 */
public class CustomSimulation {

    GridsSystems GRIDS_SYSTEMS;
    ArrayList<Server> servers;
    List<Client> entities;
    List<ClientInterface> ListaClient;
    List<ClientInterface> ListaClientProb;
    private Sve SVE;
    Random rand = new Random(1);
    int entitiesProb = 0;
    private static RMIRootInterface root_look_up;
    private static RMIInterface look_up;
    private Float InterServerLatency;
    public boolean compute_betweenness;
    public boolean relationship_ini_ignore;
    private FinalClient c;

    public void initNetwork(Float InterServerLatency,
            boolean compute_betweenness,
            boolean relationship_ini_ignore) throws FileNotFoundException, IOException, NotBoundException {

        this.InterServerLatency = InterServerLatency;
        this.compute_betweenness = compute_betweenness;
        this.relationship_ini_ignore = relationship_ini_ignore;

        GRIDS_SYSTEMS = new GridsSystems();
        Naming.rebind("//" + Setup.GATEWAY + "/root", GRIDS_SYSTEMS);

        System.out.println("Gateway RMI configuration...");
        root_look_up = (RMIRootInterface) Naming.lookup("//" + Setup.GATEWAY + "/root");

        Server s = new Server(Setup.IP_SERVER, Setup.ID_SERVER);
        System.out.println("Server RMI configuration...");
        Naming.rebind("//" + Setup.IP_SERVER + "/server" + s.getId(), s);

        root_look_up.RegisterServer_address("" + Setup.ID_SERVER, Setup.IP_SERVER);

        /**
         * *** Wallet Creation ***
         */
        if (root_look_up.CreateWallet()) {
            System.out.println("Wallet Created!");
            System.out.println(root_look_up.getWalletBalance());
        } else {
            System.out.println("Wallet NOT Created!");
        }
        /**
         * *** RMI on second port for finalClient ***
         */
        this.c = new FinalClient();
        System.out.println("RMI for final client...");
        try {
            FinalClientRMIRootInterface stub
                    = (FinalClientRMIRootInterface) UnicastRemoteObject.exportObject(this.c, 0);
            Registry registry = LocateRegistry.getRegistry(Setup.IP_SERVER, 4849);
            registry.rebind("FinalClientRMIRoot", stub);
        } catch (RemoteException ex) {
            Logger.getLogger(CustomSimulation.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("RMI bound to " + Setup.IP_SERVER + ":4849");

    }

}
