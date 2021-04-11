
import TTAirManagers.Processing.PScreenPanel;
import javax.swing.JFrame;

/**
 *
 * @author Jesimon Barreto
 */
public class Principal {

    public static void main(String[] args){
        int frameX=640,frameY=480;
        //Criando um objeto do Painel do processing, do TTAirManagers.Processing
        PScreenPanel p=new MyPScreenPanel();
        //Criando um objeto do tipo PAlayerShape é necessário passar um objeto PScrennPanel como parametro
        PNewShape imagem_Vingadores = new PNewShape(p, "F:/imagens/imagem_Vingadores.png");
        imagem_Vingadores.setPoint(50 , 50 , 0);
        imagem_Vingadores.setPoint(50 , 50 , 1);
        p.addPLayerShape(imagem_Vingadores);

        //Definindo cor do fundo do painel em RGB, dependendo da quantidade de parametro
        p.setBackGround(0);
        //Defini o tamanho do painel, se não for definido a configuração padrao é ativada
        p.sSize(frameX, frameY);
        /*configura o modo do painel do Processing, que pode ser em '2D' ou '3D' se 
         * não for usar essa configuração nao precisa definir esse metodo
        */
        p.setMode("3D");
        //Esse metodo faz as configurações finais do painel  
        p.pStart();
        
        //Criando frame e definindo configurações
        JFrame frame = new JFrame();
        frame.setSize(frameX,frameY);
        //Adicionando painel no Frame
        frame.add(p);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
   
           
}