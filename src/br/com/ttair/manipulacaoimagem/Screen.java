/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ttair.manipulacaoimagem;

import java.util.Vector;

/**
 *
 * @author Jesimon Barreto
 */
public class Screen {
    
    private int id;
    private String name=null;
    private Vector buttons = new Vector();

    public void addScreenComponents(Button Button) {
        this.buttons.add(Button);
    }

    public Vector getScreensComponents() {
        return buttons;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void clearScreensComponents(){
        buttons.clear();
    }
    
}
