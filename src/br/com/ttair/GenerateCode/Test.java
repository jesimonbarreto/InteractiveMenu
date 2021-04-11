/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ttair.GenerateCode;

import br.com.ttair.manipulacaoimagem.Button;
import java.util.Formatter;
import java.util.Vector;

/**
 *
 * @author Jesimon Barreto
 */
public class Test {

    public void gerar() {
        try {
            Formatter arquivo = new Formatter("Tes.java");
            arquivo.format("//package br.com.ttair.GenerateCode;\n\n\n\n\n");
            arquivo.format("public class Test {\n\n\n");
            arquivo.format("  public static void main(String[] args) {\n\n");
            arquivo.format("    System.out.println(\"OI\");\n\n");
            arquivo.format("  }\n");
            arquivo.format("}\n");
            arquivo.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {

        Vector e=new Vector();
        
        Aluno jesimon=new Aluno();
        jesimon.nome="JB";
        Aluno tofinho=new Aluno();
        tofinho.nome="Tofinho";
        Aluno joana=new Aluno();
        joana.nome="Joana";
        
        e.add(jesimon);
        e.add(tofinho);
        e.add(joana);
        
        
        System.out.println(((Aluno)e.get(1)).nome);
        
        e.remove(1);
        
        System.out.println(((Aluno)e.get(1)).nome);
        
        e.add(1, tofinho);
        
        for (int i = 0; i < 3; i++) {
             System.out.println(((Aluno)e.get(i)).nome);
        }
        
        
    }

    public void gerarClassePrincipal(Vector newShapes) {
        try {
            Formatter arquivo = new Formatter("C:\\Users\\Jesimon Barreto\\Desktop\\testeJAVA\\Principal.java");
            arquivo.format(""
                    + "import TTAirManagers.Processing.PScreenPanel;\n"
                    + "import javax.swing.JFrame;\n"
                    + "\n"
                    + "/**\n"
                    + " *\n"
                    + " * @author Jesimon Barreto\n"
                    + " */\n"
                    + "public class PEx {\n"
                    + "\n"
                    + "    public static void main(String[] args){\n"
                    + "        int frameX=640,frameY=480;\n"
                    + "        //Criando um objeto do Painel do processing, do TTAirManagers.Processing\n"
                    + "        PScreenPanel p=new PScreenPanel();\n"
                    + "        //Criando um objeto do tipo PAlayerShape é necessário passar um objeto PScrennPanel como parametro\n"
                    + "        NovaImage ni=new NovaImage(p);\n");

            for (int i = 0; i < newShapes.size(); i++) {
                Button ns = (Button) newShapes.get(i);
                arquivo.format("PNewShape " + ns.getNome() + " = new PNewShape(p," + ns.getPathImage() + ");\n");
                arquivo.format(ns.getNome() + ".setPoints(" + ns.getPoint(0).x + " , " + ns.getPoint(0).y + " , 0);\n");
                arquivo.format(ns.getNome() + ".setPoints(" + ns.getPoint(1).x + " , " + ns.getPoint(1).y + " , 1);\n");
                arquivo.format("p.addPLayerShape(" + ns.getNome() + ");\n");
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
    }

}
