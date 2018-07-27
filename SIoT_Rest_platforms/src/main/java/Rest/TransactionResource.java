/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import com.unict.iot.blockchain.TrxManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author silvia
 */
@Path("Transaction")
public class TransactionResource {

    private TrxManager trxManager;

    @Context
    private UriInfo context;

    public TransactionResource() {

    }

    @GET
    @Path("{trxHash}")
    @Produces(MediaType.APPLICATION_JSON)
    public String visualizeData(@PathParam("trxHash") String trxHash) {
        // cercare la trx nel DB e ritornare i dati se presenti
        trxManager = new TrxManager();
        String result;
        if (trxManager.isUnconfirmed(trxHash)) {
            result = "Waiting for transaction validation...";
        } else {
            // vai a cercare i dati nella tabella delle trx validate
            result = trxManager.getCompletedTrx(trxHash);
        }
        trxManager.closeConnection();
        return result;
    }
}
