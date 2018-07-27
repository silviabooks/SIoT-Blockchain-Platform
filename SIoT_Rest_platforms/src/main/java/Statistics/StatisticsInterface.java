/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Statistics;

import java.util.List;
import javax.swing.JTextField;

/**
 *
 * @author Salvo
 */
public interface StatisticsInterface {

   // void write_stat(List<ClientInterface> lista_client, GridsSystems GRIDS_SYSTEMS, JTextField NumNode, JTextField exp_coeff);
    void write_stat_search(String pe, String pb,int buildings,int floor, int offices,int number_of_nodes,int depth_of_search_setting,
            int ext_hop,int int_hop, Float time,  int depth_of_search_count, int counter);

    public void write_stat_Custom_search(int areas,int number_of_nodes,
            int ext_hop,int int_hop, Float time);
    
    public void betweenness(String uid, String meta, float score);
}
