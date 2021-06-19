package Controler;

import Modelo.*;
import Auxiliar.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.logging.*;

/**
 *
 * @author junio
 */
public class Tela extends javax.swing.JFrame implements MouseListener, KeyListener {

    private Hero hHero;
    private ArrayList<Elemento> eElementos;
    private Fases Fase;
    private ControleDeJogo cControle = new ControleDeJogo();
    private Graphics g2;

    /**
     * Creates new form
     */
    public Tela() {
        Desenhador.setCenario(this);
        /*Desenhador funciona no modo estatico*/
        initComponents();

        this.addMouseListener(this);
        /*mouse*/
        this.addKeyListener(this);
        /*teclado*/


 /*Cria a janela do tamanho do cenario + insets (bordas) da janela*/
        this.setSize(Consts.RES * Consts.CELL_SIDE + getInsets().left + getInsets().right,
                Consts.RES * Consts.CELL_SIDE + getInsets().top + getInsets().bottom);

        /*Este array vai guardar os elementos graficos*/
        eElementos = new ArrayList<Elemento>(150);
        /*String[] arrayDeImagens = new String[3];
        arrayDeImagens[0] = "Skooter1.png";
        arrayDeImagens[1] = "Skooter3.png";
        arrayDeImagens[2] = "Skooter2.png";*/

 /*Cria eElementos adiciona elementos*/
 /*O protagonista (heroi) necessariamente precisa estar na posicao 0 do array*/
        hHero = new Hero("Skooter1.png");
        /* https://www.online-image-editor.com/ */
        //hHero.setPosicao(4, 4);

        Fase = new Fases(150);
        Fase.setFase3(hHero);
        eElementos = Fase;
    }

    /*--------------------------------------------------*/
    public void addElemento(Elemento umElemento) {
        eElementos.add(umElemento);
    }

    public void removeElemento(Elemento umElemento) {
        eElementos.remove(umElemento);
    }

    public Graphics getGraphicsBuffer() {
        return g2;
    }

    /*Este metodo eh executado a cada Consts.FRAME_INTERVAL milissegundos*/
    public void paint(Graphics gOld) {
        Image newImage;
        Graphics g = this.getBufferStrategy().getDrawGraphics();
        /*Criamos um contexto gráfico*/
        g2 = g.create(getInsets().left, getInsets().top, getWidth() - getInsets().right, getHeight() - getInsets().top);

        /*Desenha cenário*/
        for (int i = 0; i < Consts.RES; i++) {
            for (int j = 0; j < Consts.RES; j++) {
                try {
                    /*Linha para alterar o background*/
                    if(Fase.getNumFase() == 1){
                        newImage = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Consts.PATH + "background.png");
                       // g2.drawImage(newImage, j * Consts.CELL_SIDE, i * Consts.CELL_SIDE, Consts.CELL_SIDE, Consts.CELL_SIDE, null);
                    }else if(Fase.getNumFase() == 2){
                        newImage = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Consts.PATH + "Background.png");
                        //g2.drawImage(newImage, j * Consts.CELL_SIDE, i * Consts.CELL_SIDE, Consts.CELL_SIDE, Consts.CELL_SIDE, null);
                    }else if(Fase.getNumFase() == 3){
                        newImage = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Consts.PATH + "Background3.png");
                        //g2.drawImage(newImage, j * Consts.CELL_SIDE, i * Consts.CELL_SIDE, Consts.CELL_SIDE, Consts.CELL_SIDE, null);
                    }else if(Fase.getNumFase() == 4){
                        newImage = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Consts.PATH + "Background4.png");
                        //g2.drawImage(newImage, j * Consts.CELL_SIDE, i * Consts.CELL_SIDE, Consts.CELL_SIDE, Consts.CELL_SIDE, null);
                    }else /*if(Fase.getNumFase() == 5)*/{
                        newImage = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Consts.PATH + "Vitoria-550x550.png");
                    }/*else{
                        newImage = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Consts.PATH + "background.png");
                    }*/
                    g2.drawImage(newImage, j * Consts.CELL_SIDE, i * Consts.CELL_SIDE, Consts.CELL_SIDE, Consts.CELL_SIDE, null);

                } catch (IOException ex) {
                    Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        /*Aqui podem ser inseridos novos processamentos de controle*/
        if (!this.eElementos.isEmpty()) {
            this.cControle.desenhaTudo(eElementos);
            this.cControle.processaTudo(eElementos);
            
            if(!this.cControle.ahColecionaveisAinda(eElementos) && Fase.getNumFase() == 1){
                this.Fase.setFase2(hHero);
            }else if(!this.cControle.ahColecionaveisAinda(eElementos) && Fase.getNumFase() == 2){
                this.Fase.setFase3(hHero);
            }else if(!this.cControle.ahColecionaveisAinda(eElementos) && Fase.getNumFase() == 3){
                this.Fase.setFase4(hHero);
            }else if(!this.cControle.ahColecionaveisAinda(eElementos) && Fase.getNumFase() == 4){
                this.eElementos.clear();
                //this.Fase.setVitoria();
            }
        }

        g.dispose();
        g2.dispose();
        if (!getBufferStrategy().contentsLost()) {
            getBufferStrategy().show();
        }
    }

    public void go() {
        TimerTask redesenhar = new TimerTask() {
            public void run() {
                repaint();
                /*(executa o metodo paint)*/
            }
        };

        /*Redesenha (executa o metodo paint) tudo a cada Consts.FRAME_INTERVAL milissegundos*/
        Timer timer = new Timer();
        timer.schedule(redesenhar, 0, Consts.FRAME_INTERVAL);
    }

    public void keyPressed(KeyEvent e) {
        /*Movimento do heroi via teclado*/
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            hHero.setbDirecao(0);
            if (Fase.getNumFase() == 1 || Fase.getNumFase() == 3) {
                cControle.MoverElemento(eElementos, hHero);
                cControle.ElementoColecionavel(eElementos, hHero);
                hHero.moveUp();
            }else if(Fase.getNumFase() == 2){
                //cControle.AndarNasSetas(eElementos, hHero);
                hHero.moveUp();
            }else if(Fase.getNumFase() == 4){
                hHero.moveUp();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            hHero.setbDirecao(1);
            if (Fase.getNumFase() == 1 || Fase.getNumFase() == 3) {
                cControle.MoverElemento(eElementos, hHero);
                cControle.ElementoColecionavel(eElementos, hHero);
                hHero.moveDown();
            }else if(Fase.getNumFase() == 2){
                //cControle.AndarNasSetas(eElementos, hHero);
                hHero.moveDown();
            }else if(Fase.getNumFase() == 4){
                hHero.moveDown();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            hHero.setbDirecao(2);
            if (Fase.getNumFase() == 1 || Fase.getNumFase() == 3) {
                cControle.MoverElemento(eElementos, hHero);
                cControle.ElementoColecionavel(eElementos, hHero);
                hHero.moveLeft();
            }else if(Fase.getNumFase() == 2){
                //cControle.AndarNasSetas(eElementos, hHero);
                hHero.moveLeft();
            }else if(Fase.getNumFase() == 4){
                hHero.moveLeft();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            hHero.setbDirecao(3);
            if(Fase.getNumFase() == 1 || Fase.getNumFase() == 3){
                cControle.MoverElemento(eElementos, hHero);
                cControle.ElementoColecionavel(eElementos, hHero);
                hHero.moveRight();
            }else if(Fase.getNumFase() == 2){
                //cControle.AndarNasSetas(eElementos, hHero);
                hHero.moveRight();
            }else if(Fase.getNumFase() == 4){
                hHero.moveRight();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            if(Fase.getNumFase() == 1 || Fase.getNumFase() == 4){
                switch(hHero.getbDirecao()){
                    case 0:
                        cControle.RemoveElemento(eElementos, hHero);
                        break;
                    case 1:
                        cControle.RemoveElemento(eElementos, hHero);
                        break;
                    case 2:
                        cControle.RemoveElemento(eElementos, hHero);
                        break;
                    case 3:
                        cControle.RemoveElemento(eElementos, hHero);
                        break;
                }
            }
 /*this.eElementos.clear();
            hHero = new Hero("vacina.png");
            hHero.setPosicao(0, 7);
            this.addElemento(hHero);

            CoronaVirus cTeste = new CoronaVirus("carro_azul.png");
            cTeste.setPosicao(5, 5);
            this.addElemento(cTeste);*/
        }

        /*Se o heroi for para uma posicao invalida, sobre um elemento intransponivel, volta para onde estava*/
        if (!cControle.ehPosicaoValida/*RelativoUmPersonagem*/(this.eElementos,/*hHero*/ hHero.getPosicao())) {
            hHero.voltaAUltimaPosicao();
        }

        this.setTitle("-> Cell: " + (hHero.getPosicao().getColuna()) + ", " + (hHero.getPosicao().getLinha()));
    }

    public boolean ehPosicaoValidaRelativoUmPersonagem(Elemento unPersona) {
        return cControle.ehPosicaoValidaRelativoUmPersonagem(this.eElementos, unPersona);
    }

    public boolean ehPosicaoValida(Posicao P1) {
        return cControle.ehPosicaoValida(this.eElementos, P1);
    }

    public boolean matouHeroi(Robo unRobo){
        return cControle.MatarHeroi(hHero, Fase, unRobo);
    }
    /* public boolean RemoveElemento(ArrayList<Elemento> e, Hero unHero, int Direcao ){
        return cControle.RemoveElemento(this.eElementos, unHero);
    }
    
    public boolean MoverElemento(ArrayList<Elemento> e, Hero unHero, int Direcao ){
        return cControle.MoverElemento(this.eElementos, unHero);
    }*/
    public void mousePressed(MouseEvent e) {
        /*//Movimento via mouse
         int x = e.getX();
         int y = e.getY();
     
         this.setTitle("X: "+ x + ", Y: " + y +
         " -> Cell: " + (y/Consts.CELL_SIDE) + ", " + (x/Consts.CELL_SIDE));
        
         this.hHero.getPosicao().setPosicao(y/Consts.CELL_SIDE, x/Consts.CELL_SIDE);

        //Se o heroi for para uma posicao invalida, sobre um elemento intransponivel, volta para onde estava
        if (!cControle.ehPosicaoValida(this.eElementos,hHero.getPosicao())) {
            hHero.voltaAUltimaPosicao();
        }         
         
        repaint();*/
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("POO2021");
        setAutoRequestFocus(false);
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 561, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    public void mouseMoved(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }
}
