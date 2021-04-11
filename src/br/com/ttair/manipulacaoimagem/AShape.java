/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ttair.manipulacaoimagem;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author Geral
 */
public abstract class AShape {

    private Color color;
    private Point[] point = new Point[2];
    private String name=null;

    /**
     *
     * @param color
     */
    public void setcolor(Color color) {
        this.color = color;
    }

    public Color getcolor() {
        return this.color;
    }

    public void setPoint(int x, int y, int i) {
        this.point[i] = new Point(x, y);
    }

    public Point getPoint(int i) {
        return this.point[i];
    }

    public abstract void draw(Graphics g);
}
