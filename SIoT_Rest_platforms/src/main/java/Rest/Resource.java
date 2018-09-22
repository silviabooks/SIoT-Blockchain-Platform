/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import Entities.Client;
import Entities.ClientInterface;
import Servers.RMIInterface;
import Servers.SVER.FriendTableEntry;
import Settings.Setup;
import Systems.RMIRootInterface;
import Tools.Wrapper;
import com.google.gson.Gson;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * REST Web Service
 *
 * @author Salvo
 */
@Path("Server")
public class Resource {

    private static RMIInterface look_up;
    private static RMIRootInterface root_look_up;
    @Context
    private UriInfo context;

    public Resource() {

    }

    /**
     * Retrieves representation of an instance of Rest.Resource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{id}/SVER")
    @Produces(MediaType.APPLICATION_JSON)
    public String getHtml(@PathParam("id") String id) {
        try {
            //TODO return proper representation object
            look_up = (RMIInterface) Naming.lookup("//localhost/server" + id);
            Gson gson = new Gson();
            // {id}/SVER/{uid}
            return "" + gson.toJson(look_up.getGRIDS_RS()).toString();
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(Resource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "error";
    }

//******************************
    @GET
    @Path("{id}/Entities")
    @Produces(MediaType.APPLICATION_JSON)
    public String getEntities(@PathParam("id") String id) {
        try {
            //TODO return proper representation object
            look_up = (RMIInterface) Naming.lookup("//localhost/server" + id);
            //System.out.println(look_up.getGRIDS_RS().size());
            Gson gson = new Gson();
            return "" + gson.toJson(look_up.getGRIDS_MS().toString());
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(Resource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "error";
    }

    //**************************
    /**
     * Should be deleted 
     * Example:
     * http://localhost:8080/Sim/SIoT/Server/0/SVER/32
     *
     * @param id
     * @param uid
     * @return
     */
    @GET
    @Path("{id}/SVER/{uid}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getFriends(@PathParam("id") String id, @PathParam("uid") String uid) {
        try {
            //TODO return proper representation object
            look_up = (RMIInterface) Naming.lookup("//localhost/server" + id);
            //System.out.println(look_up.getGRIDS_RS().size());
            Gson gson = new Gson();
            for (ClientInterface c : look_up.getGRIDS_RS().keySet()) {
                if (c.getUID().equals(uid)) {
                    return "" + gson.toJson(look_up.getGRIDS_RS().get(c)).toString();
                }
            }

            return "No friends";
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(Resource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "error";
    }

    /**
     * Returns the list of Clients
     *
     * @param id
     * @return
     * @throws NotBoundException
     * @throws MalformedURLException
     * @throws RemoteException
     */
    @GET
    @Path("{id}/Clients")
    @Produces(MediaType.APPLICATION_JSON)
    public String getClients(@PathParam("id") String id) throws NotBoundException,
            MalformedURLException, RemoteException {
        String reqOutput;
        try {
            look_up = (RMIInterface) Naming.lookup("//localhost/server" + id);
            Gson gson = new Gson();
            ArrayList<Client> list = new ArrayList<>();
            for (ClientInterface c : look_up.getGRIDS_RS().keySet()) {
                //System.out.println(c.toString());
                list.add((Client) c);
            }
            reqOutput = gson.toJson(list);
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(Resource.class.getName()).log(Level.SEVERE, null, ex);
            reqOutput = "error";

        }
        return reqOutput;
    }

    /**
     * Request that performs the transaction to get the client friends
     *
     * @param id server ID
     * @param uid client ID
     * @param destAddress wallet destination address for the transaction
     * @param amount amount for the transaction
     * @return
     * @throws NotBoundException
     * @throws MalformedURLException
     * @throws RemoteException
     */
    @GET
    @Path("{id}/SVER/{uid}/Transaction/{amount}/{address}")
    @Produces(MediaType.APPLICATION_JSON)
    public String makeTransaction(@PathParam("id") String id,
            @PathParam("uid") String uid,
            @PathParam("address") String destAddress,
            @PathParam("amount") String amount) throws NotBoundException,
            MalformedURLException, RemoteException {

        String reqOutput = null;

        root_look_up = (RMIRootInterface) Naming.lookup("//" + Setup.GATEWAY + "/root");
        
        String txResult = root_look_up.makeTransaction(destAddress, amount);
        
        System.out.println(txResult);

        if (txResult.contains("COINS SENT")) {
            try {
                //TODO return proper representation object
                look_up = (RMIInterface) Naming.lookup("//localhost/server" + id);
                Gson gson = new Gson();
                reqOutput = "No friends";
                for (ClientInterface c : look_up.getGRIDS_RS().keySet()) {
                    if (c.getUID().equals(uid)) {
                        reqOutput = "" + gson.toJson(look_up.getGRIDS_RS().get(c)).toString();
                    }
                }

            } catch (NotBoundException | MalformedURLException | RemoteException ex) {
                Logger.getLogger(Resource.class.getName()).log(Level.SEVERE, null, ex);
                reqOutput = "error";
            }

        } else {
            reqOutput = txResult;
        }
        return reqOutput;
    }

    @GET
    @Path("{id}/{uid}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getSingleSVE(@PathParam("id") String id, @PathParam("uid") String uid) {
        String result = "SVE not found.";
        try {
            look_up = (RMIInterface) Naming.lookup("//localhost/server" + id);
            Gson gson = new Gson();
            for (ClientInterface c : look_up.getGRIDS_RS().keySet()) {
                if (c.getUID().equals(uid)) {
                    result = gson.toJson(c);
                }
            }
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(Resource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    //***************************
    /**
     *
     * @param list
     * @throws UnknownHostException
     * @throws MalformedURLException
     * @throws RemoteException
     * @throws NotBoundException
     */
    @POST
    @Consumes({"application/json"})
    @Path("/List")
    public void addNode(String list) throws UnknownHostException,
            MalformedURLException, RemoteException, NotBoundException {
        System.out.println("List = " + list);
        /* GRIDS_MS_InterfaceManager GM = new GRIDS_MS_InterfaceManager();
        GM.addEntity(list);*/
    }

    /**
     *
     * @param rq
     * @return
     * @throws UnknownHostException
     * @throws MalformedURLException
     * @throws RemoteException
     * @throws NotBoundException
     */
    @POST
    @Consumes({"application/json"})
    @Path("/IpList")
    public Response IpList(String rq) throws UnknownHostException,
            MalformedURLException, RemoteException, NotBoundException {
        Gson gson = new Gson();

        Wrapper wrapp = gson.fromJson(rq, Wrapper.class);

        ArrayList<String> ipList = new ArrayList();

        look_up = (RMIInterface) Naming.lookup("//localhost/server" + wrapp.getArea());
        String ipRoot = null;

        for (ClientInterface c : look_up.getGRIDS_RS().keySet()) {
            ipRoot = c.getIp();
            System.out.println("--------------------->" + c.getUID() + "/////" + wrapp.getId());
            if (c.getUID().equals(wrapp.getId())) {
                for (FriendTableEntry fte : look_up.getGRIDS_RS().get(c).getSVER()) {
                    if (fte.getRelationship_Type().equals(wrapp.getRel())) {
                        ipList.add(fte.getClient_instance().getIp());
                    }
                }
                break;

            }
        }
        ipList.add(0, ipRoot);
        System.out.println("rq = " + ipList);

        return Response.status(200).entity(ipList.toString()).build();

    }

    //******** PYTHON TEST ******
    @GET
    @Path("test")
    @Produces(MediaType.APPLICATION_JSON)
    public String Test(@PathParam("id") String id
    ) {

        Gson gson = new Gson();
        gson = new Gson();
        ArrayList<String> l = new ArrayList();
        l.add("10.0.0.2");
        l.add("10.0.0.3");
        l.add("10.0.0.4");
        return "" + gson.toJson(l.toString());

    }

}
