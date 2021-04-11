package ExectarP;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import TTAirManagers.Processing.PALayerShape;
import TTAirManagers.Processing.PScreenPanel;
import processing.core.PImage;

/**
 *
 * @author Jesimon Barreto
 */
public class PNewShape extends PALayerShape {

    public PNewShape(PScreenPanel psp, String ImagePath) {
        super(psp);
        image = this.getPanel().loadImage(ImagePath);
    }

    private PImage image = null;
    
    @Override
    public void pSetup() {
    }

    @Override
    public void pDraw() {
       this.getPanel().image(image, this.getPoints(0).x, this.getPoints(0).y, this.getPoints(1).x, this.getPoints(1).y);
    }

}
