/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package festival;

/**
 *
 * @author Salvo
 */
public class Resources {

    private String aggregatorID;
    private String id;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAggregatorID() {
        return aggregatorID;
    }

    public void setAggregatorID(String aggregatorID) {
        this.aggregatorID = aggregatorID;
    }
}
