/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resourcesupdater;

import com.mashape.unirest.http.exceptions.UnirestException;
import festival.FestivalResources;
import java.io.IOException;
import java.sql.SQLException;
import thingspeak.ThingSpeakException;

/**
 *
 * @author Salvo
 */
public class ResourcesUpdater {

    public void UpdateThingsSpeack_SVE_Resources() throws UnirestException,
            ThingSpeakException, SQLException, ClassNotFoundException {
        ThingSpeakUpdater l = new ThingSpeakUpdater();
        l.updateThingsSpeack_SVE_DB();
    }

    public void UpdateFestival_SVE_Resources() throws UnirestException,
            ThingSpeakException, SQLException, ClassNotFoundException, IOException {
        FestivalResources f = new FestivalResources();
        f.getResources();
    }

}
