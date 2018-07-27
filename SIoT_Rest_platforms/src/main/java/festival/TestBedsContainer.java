/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package festival;

import java.util.ArrayList;

/**
 *
 * @author Salvo
 */
public class TestBedsContainer {

    ArrayList<Testbeds> testbeds = new ArrayList<>();
    ArrayList<Resources> resources = new ArrayList<>();

    public ArrayList<Resources> getResources() {
        return resources;
    }

    public void setResources(ArrayList<Resources> resources) {
        this.resources = resources;
    }

    public ArrayList<Testbeds> getTestbeds() {
        return testbeds;
    }

    public void setTestbeds(ArrayList<Testbeds> testbeds) {
        this.testbeds = testbeds;
    }

}
