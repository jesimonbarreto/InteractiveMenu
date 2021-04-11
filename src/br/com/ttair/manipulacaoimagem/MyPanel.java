/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ttair.manipulacaoimagem;

import java.awt.Graphics;
import java.awt.Point;
import java.util.Vector;
import javax.swing.JPanel;

/**
 *
 * @author Jesimon Barreto
 */
public class MyPanel extends JPanel {

    private Vector imagesPanel = new Vector();
    private Vector screens = new Vector();
    //Endereçar novas telas e controle de tela no Painel
    private int pointerScreen = 0, idNewScreen = 1;
    //Selecionar imagens no painel atual
    private int selectedImage = 0;
    //usado para desenhar as miniaturas no Painel
    private int xMiniature = 0, yMiniature = 640, heigthMiniature = 50, widthMiniature = 50;

//Adicionar nova tela a lista de telas
    public void savePanelOnScreen() {
        Screen screen = new Screen();
        for (int i = 0; i < imagesPanel.size(); i++) {
            screen.addScreenComponents((Button) imagesPanel.get(i));
        }
        screen.setId(idNewScreen);
        idNewScreen++;
        pointerScreen++;
        imagesPanel.clear();
        addScreen(screen);
        //Falta implementar o metodo Miniature
        addScreenMiniature(screen);
    }

    public void addScreen(Screen screen) {
        this.screens.add(screen);
    }
//Passar tela que esta no Painel

    public void nextScreenPanel() {
        updatePanelOnList();
        if (pointerScreen == (screens.size() - 1)) {
            pointerScreen = 0;
        } else {
            pointerScreen++;
        }
        loadScreenOnPanel(pointerScreen);
    }
//Voltar tela que esta no Painel

    public void backScreenPanel() {
        updatePanelOnList();
        if (pointerScreen == 0) {
            if (screens.isEmpty()) {
                pointerScreen = 0;
            } else {
                pointerScreen = screens.size() - 1;
            }
        } else {
            pointerScreen--;
        }
        System.out.println(pointerScreen);
        loadScreenOnPanel(pointerScreen);
    }
//Nova tela

    public void newScreenOnPanel() {
        updatePanelOnList();
        clearPanel();
        savePanelOnScreen();
    }
//Limpar tela
    private void clearPanel() {
        imagesPanel.clear();
    }
//Colocar os botoes de uma tela do vetor, passa como parametro a posicao do vetor que a tela ocupa

    private void loadScreenOnPanel(int positionScreen) {
        imagesPanel.clear();
        Vector screensComponentes;
        screensComponentes = ((Screen) screens.get(positionScreen)).getScreensComponents();
        for (int j = 0; j < screensComponentes.size(); j++) {
            this.addShape((Button) screensComponentes.get(j));
        }
        this.repaint();
    }
//Atualiza o vetor pelo que esta no Painel

    private void updatePanelOnList() {
        if (pointerScreen == (idNewScreen-1)) {
            savePanelOnScreen();
        } else {
            ((Screen) screens.get(pointerScreen)).clearScreensComponents();
            for (int i = 0; i < imagesPanel.size(); i++) {
                ((Screen) screens.get(pointerScreen)).addScreenComponents((Button) imagesPanel.get(i));
            }
        }
    }

//Falta implementar esse metodo
    private void addScreenMiniature(Screen screen) {
    }
//Retorna o vetor de botoes

    public Vector getButtons() {
        return imagesPanel;
    }
//Adiciona uma nova imagem(botao) no Painel

    void addShape(AShape desenho) {
        imagesPanel.add(desenho);
        this.repaint();
    }
//Seleciona uma imagem(botao) no painel

    public void SelectButton(Point p) {
        for (int i = 0; i < imagesPanel.size(); i++) {
            Button ns = ((Button) imagesPanel.get(i));
            if (ns.contain(p)) {
                selectedImage = i;
            }
        }
    }
//Mover imagem(botao)

    public void MoveButton(Point p) {
        SelectButton(p);
        Button ns = ((Button) imagesPanel.get(selectedImage));
        ((Button) imagesPanel.get(selectedImage)).setPoint(p.x - (ns.getPoint(1).x / 2),
                p.y - (ns.getPoint(1).y / 2), 0);
    }
//Redimensionar imagem(botao) selecionado

    public void ResizeButton(Point p) {
        Button ns = ((Button) imagesPanel.get(selectedImage));
        ((Button) imagesPanel.get(selectedImage)).setPoint(p.x - ns.getPoint(0).x + 10, p.y - ns.getPoint(0).y + 10, 1);
    }
//Devo apagar

    public int contem(Point p) {
        int position = 10;
        for (int i = 0; i < imagesPanel.size(); i++) {
            Button ns = ((Button) imagesPanel.get(i));
            if (ns.contain(p)) {
                if (p.x > (ns.getPoint(1).x / 2) - 15 && p.x < (ns.getPoint(1).x / 2) + 15) {
                    if (p.y > (ns.getPoint(1).y / 2) - 15 && p.y < (ns.getPoint(1).y / 2) + 15) {
                        ((Button) imagesPanel.get(i)).setPoint(p.x + ns.getPoint(0).x, p.y + ns.getPoint(0).y, 0);
                        ((Button) imagesPanel.get(i)).setPoint(p.x + ns.getPoint(1).x, p.y + ns.getPoint(1).y, 1);
                    }
                } else {
                    // ((NewShape) Buttons.get(i)).setPoint(p.x - ns.getPoint(0).x + 10, p.y - ns.getPoint(0).y + 10, 1);
                    ((Button) imagesPanel.get(i)).setPoint(p.x - (ns.getPoint(1).x / 2), p.y - (ns.getPoint(0).y / 2), 0);
                    position = i;
                    i = imagesPanel.size();
                }
            }
        }
        return position;
    }
//Desenha no painel

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (int i = 0; i < imagesPanel.size(); i++) {
            AShape aux = (AShape) imagesPanel.get(i);
            aux.draw(g);
        }
        this.repaint();
    }
}
