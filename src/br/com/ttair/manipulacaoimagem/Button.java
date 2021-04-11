/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ttair.manipulacaoimagem;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

/**
 *
 * @author Jesimon Barreto
 */
public class Button extends AShape {

    private ImageObserver imagemOb;
    private BufferedImage image = null;
    private String name = null;
    private String pathImage=null;

    public Button(BufferedImage image, ImageObserver thi) throws Exception {
        this.imagemOb = thi;
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNome() {
        return this.name;
    }

public void setPathImage(String path) {
        this.pathImage = path;
    }

    public String getPathImage() {
        return this.pathImage;
    }
    
    @Override
    public void draw(Graphics grphcs) {
        grphcs.drawImage(image, this.getPoint(0).x, this.getPoint(0).y, this.getPoint(1).x, this.getPoint(1).y, imagemOb);
    }

    public boolean contain(Point ponto) {
        boolean contem = false;
        if (ponto.x > this.getPoint(0).x && ponto.y > this.getPoint(0).y) {
            if (ponto.x < (this.getPoint(1).x + this.getPoint(0).x) && ponto.y < (this.getPoint(1).y + this.getPoint(0).y)) {
                contem = true;
            }
        }
        return contem;
    }

}
