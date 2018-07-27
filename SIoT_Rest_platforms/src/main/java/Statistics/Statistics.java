/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Statistics;

import Systems.GridsSystems;
import com.csvreader.CsvWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

/**
 *
 * @author Salvo
 */
public class Statistics implements StatisticsInterface, Serializable {

    public Statistics() {
    }

    /* 
  
    @Override
  public void write_stat(List<ClientInterface> lista_client, GridsSystems GRIDS_SYSTEMS, JTextField NumNode, JTextField exp_coeff) {
        int dim = 0;
        for (int u = 0; u <= GRIDS_SYSTEMS.getServerList().size() - 1; u++) {

            for (int j = 0; j <= lista_client.size() - 1; j++) {
                if (lista_client.get(j).getPort() == GRIDS_SYSTEMS.getServerList().get(u).getPort()) {
                    dim = dim + GRIDS_SYSTEMS.getServerList().get(u).getGRIDS_RS().get(lista_client.get(j).getUID()).getSVER().size();

                }

            }
        }

        int dim_media = dim / lista_client.size();

        CsvWriter csvOutput = null;
        try {
            String outputFile = "statistics2.csv";
            boolean alreadyExists = new File(outputFile).exists();
            csvOutput = new CsvWriter(new FileWriter(outputFile, true), ';');

            if (!alreadyExists) {
                csvOutput.write("N_OF_NODES");
                csvOutput.write("MEAN_FRIENDS");
                csvOutput.write("EXP_COEFF");

                csvOutput.endRecord();
            }
            csvOutput.write(NumNode.getText());
            csvOutput.write(Integer.toString(dim_media));
            csvOutput.write(exp_coeff.getText());
            csvOutput.endRecord();
            csvOutput.close();
        } catch (IOException ex) {
            Logger.getLogger(GridsSystems.class.getName()).log(Level.SEVERE, null, ex);
            return;
        } finally {
            csvOutput.close();
            return;
        }

    } 
     */
    @Override
    public void write_stat_search(String pe, String pb, int buildings, int floor, int offices, int number_of_nodes, int depth_of_search_setting,
            int ext_hop, int int_hop, Float time, int depth_of_search_count, int counter) {

        CsvWriter csvOutput = null;
        try {
            String outputFile = "sim_pe_pb/statistics_" + pe + "_" + pb + ".csv";
            boolean alreadyExists = new File(outputFile).exists();
            csvOutput = new CsvWriter(new FileWriter(outputFile, true), ';');

            if (!alreadyExists) {
                csvOutput.write("BUILDINGS");
                csvOutput.write("FLOORS");
                csvOutput.write("OFFICES");
                csvOutput.write("N_OF_NODES");
                csvOutput.write("DEPTH_MAX");
                csvOutput.write("DEPTH_REACHED");
                csvOutput.write("EXT_HOP");
                csvOutput.write("INT_HOP");
                csvOutput.write("DISC_TIME (ms)");

                csvOutput.endRecord();
            }
            csvOutput.write(Integer.toString(buildings));
            csvOutput.write(Integer.toString(floor));
            csvOutput.write(Integer.toString(offices));
            csvOutput.write(Integer.toString(number_of_nodes));
            csvOutput.write(Integer.toString(depth_of_search_setting));
            csvOutput.write(Integer.toString(depth_of_search_count));
            csvOutput.write(Integer.toString(ext_hop));
            csvOutput.write(Integer.toString(int_hop));
            csvOutput.write(Float.toString(time));

            csvOutput.endRecord();
            csvOutput.close();
        } catch (IOException ex) {
            Logger.getLogger(GridsSystems.class.getName()).log(Level.SEVERE, null, ex);
            return;
        } finally {
            csvOutput.close();
            return;
        }

    }

    @Override
    public void write_stat_Custom_search(int areas, int number_of_nodes,
            int ext_hop, int int_hop, Float time) {

        CsvWriter csvOutput = null;
        try {
            String outputFile = "sim_custom/statistics.csv";
            boolean alreadyExists = new File(outputFile).exists();
            csvOutput = new CsvWriter(new FileWriter(outputFile, true), ';');

            if (!alreadyExists) {
              
                    csvOutput.write("AREA_" );
                
                csvOutput.write("N_OF_NODES");
                csvOutput.write("EXT_HOP");
                csvOutput.write("INT_HOP");
                csvOutput.write("DISC_TIME (ms)");

                csvOutput.endRecord();
            }
          
                csvOutput.write(Integer.toString(areas));
           
            csvOutput.write(Integer.toString(number_of_nodes));
            csvOutput.write(Integer.toString(ext_hop));
            csvOutput.write(Integer.toString(int_hop));
            csvOutput.write(Float.toString(time));

            csvOutput.endRecord();
            csvOutput.close();
        } catch (IOException ex) {
            Logger.getLogger(GridsSystems.class.getName()).log(Level.SEVERE, null, ex);
            return;
        } finally {
            csvOutput.close();
            return;
        }

    }

    @Override
    public void betweenness(String uid, String meta, float score) {

        CsvWriter csvOutput = null;
        try {
            String outputFile = "sim_custom/beetweennes.csv";
            boolean alreadyExists = new File(outputFile).exists();
            csvOutput = new CsvWriter(new FileWriter(outputFile, true), ';');

            if (!alreadyExists) {

                csvOutput.write("UID");
                csvOutput.write("META");
                csvOutput.write("SCORE");

                csvOutput.endRecord();
            }

            csvOutput.write(uid);
            csvOutput.write(meta);
            csvOutput.write(Float.toString(score));

            csvOutput.endRecord();
            csvOutput.close();
        } catch (IOException ex) {
            Logger.getLogger(GridsSystems.class.getName()).log(Level.SEVERE, null, ex);
            return;
        } finally {
            csvOutput.close();
            return;
        }

    }

}
