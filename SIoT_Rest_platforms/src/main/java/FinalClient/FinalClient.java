/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalClient;

import static Systems.WalletWrapper.unconfirmedTrxs;
import com.unict.iot.blockchain.TrxManager;
import java.rmi.RemoteException;

/**
 *
 * @author silvia
 */
public class FinalClient implements FinalClientRMIRootInterface {

    private TrxManager trxm;

    @Override
    public String requestDataWithTrx(String trxHash, String SVER_ID, String SVE_ID) {
        /**
         * prima di ogni cosa assumo che la trx sia non validata, quindi la
         * inserisco nel set e nel DB, ma nel DB devo inserire anche SVER_ID e
         * SVE_ID, se no quando la trx sarà validata, non so che dati prendere!
         */
        trxm = new TrxManager();
        if (unconfirmedTrxs.add(trxHash)) {
            // se non c'era, vuol dire che il listener non l'ha ancora 
            // aggiunto, quindi aggiungo tutta la riga nel DB
            trxm.addUnconfirmedTrx(trxHash, SVER_ID, SVE_ID);
        } else {
            // se c'era già, vuol dire che il listener l'aveva già aggiunto,
            // ma devo riempire gli ID
            trxm.updateUnconfirmedTrx(trxHash, SVER_ID, SVE_ID);

        }
        trxm.closeConnection();
        return "The data will be available at: "
                + "http://localhost:8080/Sim/SIoT/Transaction/" + trxHash;

    }

    @Override
    public String rechargeCredit(String trxHash, int userID, int amount) throws RemoteException {
        trxm = new TrxManager();
        trxm.addChargeRecord(trxHash, userID, amount);
        trxm.closeConnection();
        return "The credit will be available after the transaction will "
                + "be confirmed!";
    }

    @Override
    public String requestDatawithCredit(String SVER_ID, 
            String SVE_ID, int userID) throws RemoteException {
        trxm = new TrxManager();
        String res = trxm.getDataWithCredit(SVER_ID, SVE_ID, userID);
        trxm.closeConnection();
        return res;
    }

    @Override
    public int getCredit(int userID) throws RemoteException {
        trxm = new TrxManager();
        int credit = trxm.getCredit(userID);
        trxm.closeConnection();
        return credit;
    }
}
