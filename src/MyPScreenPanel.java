/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import TTAirManagers.Processing.PALayerShape;
import TTAirManagers.Processing.PScreenPanel;
import java.awt.Image;
import java.awt.Point;
import java.io.IOException;
import java.util.Vector;
import static processing.core.PConstants.P2D;
import static processing.core.PConstants.P3D;
import processing.core.PImage;

/**
 *
 * @author Jesimon Barreto
 */
public class MyPScreenPanel extends PScreenPanel {

    private Vector shapes = new Vector();
    private int x = 640, y = 480, color = 0, cont = 0;
    private float color2 = 0, color3 = 0, color4 = 0;
    private String mode = null;
    private boolean backGound = true;
    

    public MyPScreenPanel() {

    }

    public void addPLayerShape(PALayerShape pALayerShape) {
        shapes.add(pALayerShape);
    }

    public PImage getImageProcessing(Image image) {
        return this.loadImageMT(image);
    }

    @Override
    public void setup() {
        mode();
        for (int i = 0; i < shapes.size(); i++) {
            PALayerShape a = (PALayerShape) shapes.get(i);
            a.pSetup();
        }
    }

    @Override
    public void draw() {
        background();
        for (int i = 0; i < shapes.size(); i++) {
            PALayerShape a = (PALayerShape) shapes.get(i);
            a.pDraw();
        }

        
       //Colocar codições e codigos aqui, é como se fosse o paint da biblioteca do kinect
    }
    
    public void click(){
       
    }

    public PImage Image(String pathImage) throws IOException {
        PImage image = loadImage(pathImage);
        return image;
    }

    public void sSize(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public void setBackgraund(boolean bg) {
        backGound = bg;
    }

    private void mode() {
        if (mode == null) {
            size(x, y);
        } else if (mode.equals("2D")) {
            size(x, y, P2D);
        } else if (mode.equals("3D")) {
            size(x, y, P3D);
        } else {
            System.out.println("Error: Mode");
        }
    }

    public void setBackGround(int color) {
        this.color = color;
    }

    public void setBackGround(int color, float color2) {
        this.color = color;
        this.color2 = color2;
    }

    public void setBackGround(int color, float color2, float color3) {
        this.color = color;
        this.color2 = color2;
        this.color3 = color3;
    }

    public void setBackGround(int color, float color2, float color3, float color4) {
        this.color = color;
        this.color2 = color2;
        this.color3 = color3;
        this.color4 = color4;
    }

    private void background() {
        if (color == 0 && color2 == 0 && color3 == 0 && color4 == 0) {
            if (backGound) {
                background(color);
            }
        } else if (color2 != 0 && color3 == 0 && color4 == 0) {
            background(color, color2);
        } else if (color3 != 0 && color4 == 0) {
            background(color, color2, color3);
        } else if (color4 != 0) {
            background(color, color2, color3, color4);
        }
    }

    public void pStart() {
        this.setVisible(true);
        this.init();
    }

    public Point getsSize() {
        return new Point(x, y);
    }
}
