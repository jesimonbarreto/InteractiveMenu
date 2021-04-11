/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ttair.manipulacaoimagem;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 *
 * @author Jesimon Barreto
 */
public class MouseMovimento implements MouseListener, MouseMotionListener {

    private MyPanel myPanel = null;
    private boolean resize = false;
    
    public MouseMovimento(MyPanel mysp) {
        this.myPanel = mysp;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
            resize = true;
        } else if (e.getClickCount() > 2) {
            resize = false;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Point p = null;
        p = new Point(e.getX(), e.getY());
        myPanel.SelectButton(p);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Point p = null;
        p = new Point(e.getX(), e.getY());
        if (p.x > 0 && p.x < 640 && p.y > 0 && p.y < 480) {
            if (resize) {
                myPanel.ResizeButton(p);
            } else {
                myPanel.MoveButton(p);
            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    public void checkPosition() {

    }

}
