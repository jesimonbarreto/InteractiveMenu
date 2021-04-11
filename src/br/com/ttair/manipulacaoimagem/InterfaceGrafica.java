/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ttair.manipulacaoimagem;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Jesimon Barreto
 */
public class InterfaceGrafica {

    private JFrame frame = null;
    private Container con;
    private MyPanel panel = new MyPanel();
    private JButton addImage = null;
    private JButton GenerateCode = null;
    private JButton newScreen = null;
    private JButton  nextScreen= null;
    private JButton backScreen = null;

    public void setup() {
        
        frame=new MyFrame(panel);
        MouseMovimento mm = new MouseMovimento(panel);
        frame.addMouseListener(mm);
        frame.addMouseMotionListener(mm);

        addImage = new JButton("Inserir Botão");
        GenerateCode = new JButton("Gerar Código Fonte");
        newScreen = new JButton("nova Tela");
        nextScreen=new JButton("proxima Tela >");
        backScreen=new JButton("< Tela anterior");

        con = frame.getContentPane();

        panel.setBounds(0, 0, 640, 530);
        addImage.setBounds(5, 530, 200, 25);
        GenerateCode.setBounds(250, 530, 200, 25);
        //newScreen.setBounds(x, y, 230, height);
        //nextScreen.setBounds(x, y, width, height);
        //backScreen.setBounds(x, y, width, height);

        con.add(panel);
        con.add(addImage);
        con.add(GenerateCode);
        con.add(newScreen);
        con.add(nextScreen);
        con.add(backScreen);

        frame.setSize(640, 650);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.repaint();
    }

    public void action() {
        setup();
        //botao limpar para limpar os campos de entrada de texto
        addImage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String pathImage = null;
                JFileChooser file = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter(
                        "JPG & PNG Images", "jpg", "png");
                file.setFileFilter(filter);
                file.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int i = file.showSaveDialog(null);
                if (i == 1) {
                    System.out.println("Cancelado");
                } else {
                    pathImage = file.getSelectedFile().getPath();
                    try {
                        Button ns = new Button(loadImage(pathImage), panel);
                        ns.setPoint(50, 50, 0);
                        ns.setPoint(50, 50, 1);
                        char[] vector = file.getSelectedFile().getName().toCharArray();
                        int analisar = 0;
                        String name = "";
                        while (vector[analisar] != '.') {
                          //  if(){
                                
                           // }
                            name = name + vector[analisar];
                            analisar++;
                            
                        }
                        ns.setName(name);
                        ns.setPathImage(setPath(file.getSelectedFile().getPath()));
                        panel.addShape(ns);
                    } catch (Exception ex) {
                        System.out.println("Erro ao adicionar a imagem");
                    }
                }
            }
        });
    }

    public void acao() {
        action();

        GenerateCode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    GenerateCode gc = new GenerateCode();
                    gc.gerarClassePrincipal(panel.getButtons());
                    JOptionPane.showMessageDialog(null, "Código Fonte Gerado com Sucesso", "Alerta", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Ocorreu um Erro ao Gerar", "Alerta", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

    }

    public BufferedImage loadImage(String fileName) {
        BufferedImage image = null;
        try {
            image = (ImageIO.read(new File(fileName)));
        } catch (Exception erro) {
            System.out.println("Error Image");
        }
        return image;
    }

    public String setPath(String p) {
        String path = "";
        char[] c = p.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '\\') {
                c[i] = '/';
            }
            path = path + c[i];
        }
        return path;
    }

    public static void main(String[] args) {
        new InterfaceGrafica().acao();
    }
}
