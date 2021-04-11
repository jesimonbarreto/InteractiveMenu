/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ttair.manipulacaoimagem;

import java.util.Formatter;
import java.util.Vector;

/**
 *
 * @author Jesimon Barreto
 */
public class GenerateCode {

    public void gerarClassePrincipal(Vector newShapes) {
        try {
            Formatter arquivo = new Formatter("C:\\Users\\Jesimon Barreto\\Desktop\\testeJAVA\\Run.java");
            arquivo.format(""
                    + "import TTAirManagers.Processing.PScreenPanel;\n"
                    + "import javax.swing.JFrame;\n"
                    + "\n"
                    + "/**\n"
                    + " *\n"
                    + " * @author Jesimon Barreto\n"
                    + " */\n"
                    + "public class Run {\n"
                    + "\n"
                    + "    public static void main(String[] args){\n"
                    + "        int frameX=640,frameY=480;\n"
                    + "        //Criando um objeto do Painel do processing, do TTAirManagers.Processing\n"
                    + "        PScreenPanel p=new MyPScreenPanel();\n"
                    + "        //Criando um objeto do tipo PAlayerShape é necessário passar um objeto PScrennPanel como parametro\n");

            for (int i = 0; i < newShapes.size(); i++) {
                Button ns = (Button) newShapes.get(i);
                arquivo.format("        PNewShape " + ns.getNome() + " = new PNewShape(p, \"" + ns.getPathImage() + "\");\n");
                arquivo.format("        " + ns.getNome() + ".setPoints(" + ns.getPoint(0).x + " , " + ns.getPoint(0).y + " , 0);\n");
                arquivo.format("        " + ns.getNome() + ".setPoints(" + ns.getPoint(1).x + " , " + ns.getPoint(1).y + " , 1);\n");
                arquivo.format("        p.addPLayerShape(" + ns.getNome() + ");\n");
            }

            arquivo.format("\n"
                    + "        //Definindo cor do fundo do painel em RGB, dependendo da quantidade de parametro\n"
                    + "        p.setBackGround(0);\n"
                    + "        //Defini o tamanho do painel, se não for definido a configuração padrao é ativada\n"
                    + "        p.sSize(frameX, frameY);\n"
                    + "        /*configura o modo do painel do Processing, que pode ser em '2D' ou '3D' se \n"
                    + "         * não for usar essa configuração nao precisa definir esse metodo\n"
                    + "        */\n"
                    + "        p.setMode(\"3D\");\n"
                    + "        //Esse metodo faz as configurações finais do painel  \n"
                    + "        p.pStart();\n"
                    + "        \n"
                    + "        //Criando frame e definindo configurações\n"
                    + "        JFrame frame = new JFrame();\n"
                    + "        frame.setSize(frameX,frameY);\n"
                    + "        //Adicionando painel no Frame\n"
                    + "        frame.add(p);\n"
                    + "        frame.setLocationRelativeTo(null);\n"
                    + "        frame.setResizable(false);\n"
                    + "        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);\n"
                    + "        frame.setVisible(true);\n"
                    + "\n"
                    + "    }\n"
                    + "   \n"
                    + "           \n"
                    + "}"
            );
            arquivo.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        gerarClassePanel();
        gerarClassepNewShape();
    }

    public void gerarClassePanel() {
        try {
            Formatter arquivo = new Formatter("C:\\Users\\Jesimon Barreto\\Desktop\\testeJAVA\\MyPScreenPanel.java");
            arquivo.format(""
                    + "import TTAirManagers.Processing.PALayerShape;\n"
                    + "import TTAirManagers.Processing.PScreenPanel;\n"
                    + "import java.awt.Image;\n"
                    + "import java.awt.Point;\n"
                    + "import java.io.IOException;\n"
                    + "import java.util.Vector;\n"
                    + "import static processing.core.PConstants.P2D;\n"
                    + "import static processing.core.PConstants.P3D;\n"
                    + "import processing.core.PImage;\n"
                    + "\n"
                    + "/**\n"
                    + " *\n"
                    + " * @author Jesimon Barreto\n"
                    + " */\n"
                    + "public class MyPScreenPanel extends PScreenPanel {\n"
                    + "\n"
                    + "    private Vector shapes = new Vector();\n"
                    + "    private int x = 640, y = 480, color = 0, cont = 0;\n"
                    + "    private float color2 = 0, color3 = 0, color4 = 0;\n"
                    + "    private String mode = null;\n"
                    + "    private boolean backGound = true;\n"
                    + "    \n"
                    + "\n"
                    + "    public MyPScreenPanel() {\n"
                    + "\n"
                    + "    }\n"
                    + "\n"
                    + "    public void addPLayerShape(PALayerShape pALayerShape) {\n"
                    + "        shapes.add(pALayerShape);\n"
                    + "    }\n"
                    + "\n"
                    + "    public PImage getImageProcessing(Image image) {\n"
                    + "        return this.loadImageMT(image);\n"
                    + "    }\n"
                    + "\n"
                    + "    @Override\n"
                    + "    public void setup() {\n"
                    + "        mode();\n"
                    + "        for (int i = 0; i < shapes.size(); i++) {\n"
                    + "            PALayerShape a = (PALayerShape) shapes.get(i);\n"
                    + "            a.pSetup();\n"
                    + "        }\n"
                    + "    }\n"
                    + "\n"
                    + "    @Override\n"
                    + "    public void draw() {\n"
                    + "        background();\n"
                    + "        for (int i = 0; i < shapes.size(); i++) {\n"
                    + "            PALayerShape a = (PALayerShape) shapes.get(i);\n"
                    + "            a.pDraw();\n"
                    + "        }\n"
                    + "\n"
                    + "       //Colocar codições e codigos aqui, é como se fosse o paint da biblioteca do kinect\n"
                    + "    }\n"
                    + "\n"
                    + "    public PImage Image(String pathImage) throws IOException {\n"
                    + "        PImage image = loadImage(pathImage);\n"
                    + "        return image;\n"
                    + "    }\n"
                    + "\n"
                    + "    public void sSize(int x, int y) {\n"
                    + "        this.x = x;\n"
                    + "        this.y = y;\n"
                    + "    }\n"
                    + "\n"
                    + "    public void setMode(String mode) {\n"
                    + "        this.mode = mode;\n"
                    + "    }\n"
                    + "\n"
                    + "    public void setBackgraund(boolean bg) {\n"
                    + "        backGound = bg;\n"
                    + "    }\n"
                    + "\n"
                    + "    private void mode() {\n"
                    + "        if (mode == null) {\n"
                    + "            size(x, y);\n"
                    + "        } else if (mode.equals(\"2D\")) {\n"
                    + "            size(x, y, P2D);\n"
                    + "        } else if (mode.equals(\"3D\")) {\n"
                    + "            size(x, y, P3D);\n"
                    + "        } else {\n"
                    + "            System.out.println(\"Error: Mode\");\n"
                    + "        }\n"
                    + "    }\n"
                    + "\n"
                    + "    public void setBackGround(int color) {\n"
                    + "        this.color = color;\n"
                    + "    }\n"
                    + "\n"
                    + "    public void setBackGround(int color, float color2) {\n"
                    + "        this.color = color;\n"
                    + "        this.color2 = color2;\n"
                    + "    }\n"
                    + "\n"
                    + "    public void setBackGround(int color, float color2, float color3) {\n"
                    + "        this.color = color;\n"
                    + "        this.color2 = color2;\n"
                    + "        this.color3 = color3;\n"
                    + "    }\n"
                    + "\n"
                    + "    public void setBackGround(int color, float color2, float color3, float color4) {\n"
                    + "        this.color = color;\n"
                    + "        this.color2 = color2;\n"
                    + "        this.color3 = color3;\n"
                    + "        this.color4 = color4;\n"
                    + "    }\n"
                    + "\n"
                    + "    private void background() {\n"
                    + "        if (color == 0 && color2 == 0 && color3 == 0 && color4 == 0) {\n"
                    + "            if (backGound) {\n"
                    + "                background(color);\n"
                    + "            }\n"
                    + "        } else if (color2 != 0 && color3 == 0 && color4 == 0) {\n"
                    + "            background(color, color2);\n"
                    + "        } else if (color3 != 0 && color4 == 0) {\n"
                    + "            background(color, color2, color3);\n"
                    + "        } else if (color4 != 0) {\n"
                    + "            background(color, color2, color3, color4);\n"
                    + "        }\n"
                    + "    }\n"
                    + "\n"
                    + "    public void pStart() {\n"
                    + "        this.setVisible(true);\n"
                    + "        this.init();\n"
                    + "    }\n"
                    + "\n"
                    + "    public Point getsSize() {\n"
                    + "        return new Point(x, y);\n"
                    + "    }\n"
                    + "}");
            arquivo.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void gerarClassepNewShape() {
        try {
            Formatter arquivo = new Formatter("C:\\Users\\Jesimon Barreto\\Desktop\\testeJAVA\\PNewShape.java");
            arquivo.format(""
                    + "import TTAirManagers.Processing.PALayerShape;\n"
                    + "import TTAirManagers.Processing.PScreenPanel;\n"
                    + "import processing.core.PImage;\n"
                    + "\n"
                    + "/**\n"
                    + " *\n"
                    + " * @author Jesimon Barreto\n"
                    + " */\n"
                    + "public class PNewShape extends PALayerShape {\n"
                    + "\n"
                    + "    public PNewShape(PScreenPanel psp, String ImagePath) {\n"
                    + "        super(psp);\n"
                    + "        image = this.getPanel().loadImage(ImagePath);\n"
                    + "    }\n"
                    + "\n"
                    + "    private PImage image = null;\n"
                    + "    \n"
                    + "    @Override\n"
                    + "    public void pSetup() {\n"
                    + "    }\n"
                    + "\n"
                    + "    @Override\n"
                    + "    public void pDraw() {\n"
                    + "       this.getPanel().image(image, this.getPoints(0).x, this.getPoints(0).y, this.getPoints(1).x, this.getPoints(1).y);\n"
                    + "    }\n"
                    + "\n"
                    + "}");
            arquivo.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
