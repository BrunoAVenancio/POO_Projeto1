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
    private ArrayList<Element> eElementos;
    private ControleDeJogo cControle = new ControleDeJogo();
    private Graphics g2;
    /**
     * Creates new form
     */
    public Tela() {
        Desenhador.setCenario(this); /*Desenhador funciona no modo estatico*/
        initComponents();
 
        this.addMouseListener(this); /*mouse*/
        this.addKeyListener(this);   /*teclado*/
        
        /*Cria a janela do tamanho do cenario + insets (bordas) da janela*/
        this.setSize(Consts.RES * Consts.CELL_SIDE + getInsets().left + getInsets().right,
                Consts.RESLINHA * Consts.CELL_SIDE + getInsets().top + getInsets().bottom);

        /*Este array vai guardar os elementos graficos*/
        eElementos = new ArrayList<Element>(100);

    
        /*Cria eElementos adiciona elementos*/
        /*O protagonista (heroi) necessariamente precisa estar na posicao 0 do array*/
        hHero = new Hero(Consts.HEROIMAGE ); /* https://www.online-image-editor.com/ */
        hHero.setPosicao(1, 1);
        Fases fases = new Fases(100);
        fases.setFase1(hHero);
        eElementos = fases;
    }

/*--------------------------------------------------*/
    public void addElemento(Element umElemento) {
        eElementos.add(umElemento);
    }

    public void removeElemento(Element umElemento) {
        eElementos.remove(umElemento);
    }

    public Graphics getGraphicsBuffer(){
        return g2;
    }
    
    /*Este metodo eh executado a cada Consts.FRAME_INTERVAL milissegundos*/    
    public void paint(Graphics gOld) {
        Graphics g = this.getBufferStrategy().getDrawGraphics();
        /*Criamos um contexto gráfico*/
        g2 = g.create(getInsets().left, getInsets().top, getWidth() - getInsets().right, getHeight() - getInsets().top);

        /*Desenha cenário*/
        for (int i = 0; i < Consts.RES; i++) {
            for (int j = 0; j < Consts.RES; j++) {
                try {
                    /*Linha para alterar o background*/
                    Image newImage = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Consts.PATH + "chao de pedra_background.png");
                    g2.drawImage(newImage,j*Consts.CELL_SIDE, i*Consts.CELL_SIDE, Consts.CELL_SIDE, Consts.CELL_SIDE, null);

                } catch (IOException ex) {
                    Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        /*Aqui podem ser inseridos novos processamentos de controle*/
        if (!this.eElementos.isEmpty()) {
            this.cControle.desenhaTudo(eElementos);
            this.cControle.processaTudo(eElementos);
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
                repaint(); /*(executa o metodo paint)*/
            }
        };        
        
        /*Redesenha (executa o metodo paint) tudo a cada Consts.FRAME_INTERVAL milissegundos*/
        Timer timer = new Timer();
        timer.schedule(redesenhar, 0, Consts.FRAME_INTERVAL);
    }

    public void keyPressed(KeyEvent e) {
        /*Movimento do heroi via teclado*/
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            hHero.moveUp();
            hHero.setDirection(1);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            hHero.moveDown();
            hHero.setDirection(2);
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            hHero.moveLeft();
            hHero.setDirection(3);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            hHero.moveRight();
            hHero.setDirection(4);
        } else if (e.getKeyCode() == KeyEvent.VK_SPACE){
            Bomb Explosao = new Bomb(hHero.getPosicao());
            eElementos.add(Explosao);
            Posicao auxPos = hHero.getPosicao();
            if(hHero.getDirection() == 1){
                hHero.moveDown();
            }else if(hHero.getDirection() == 2){
                hHero.moveUp();
            }else if(hHero.getDirection() == 3){
                hHero.moveRight();
            }else if(hHero.getDirection() == 4){
                hHero.moveLeft();
            }
            
            /*eElementos.remove(Explosao);
            
            Explosion Explosao1 = new Explosion(auxPos);
            eElementos.add(Explosao1);
            Explosion Explosao2 = new Explosion(new Posicao(auxPos.getLinha()+1,auxPos.getColuna()));
            eElementos.add(Explosao2);
            Explosion Explosao4 = new Explosion(new Posicao(auxPos.getLinha()-1,auxPos.getColuna()));
            eElementos.add(Explosao4);
            Explosion Explosao6 = new Explosion(new Posicao(auxPos.getLinha(),auxPos.getColuna()+1));
            eElementos.add(Explosao6);
            Explosion Explosao8 = new Explosion(new Posicao(auxPos.getLinha(),auxPos.getColuna()-1));
            eElementos.add(Explosao8);*/
            
            //eElementos.remove(Explosao);
          
          /*hHero = new Hero("Bomberman_icone-removebg-preview.png");
            hHero.setPosicao(0, 7);
            this.addElemento(hHero);*/

        /*  Hero Hero = new Hero("Bomberman_icone-removebg-preview.png");
            Hero.setPosicao(5, 5);
            this.addElemento(Hero);*/
        }
        
        /*Se o heroi for para uma posicao invalida, sobre um elemento intransponivel, volta para onde estava*/
        if (!cControle.ehPosicaoValida(this.eElementos,hHero.getPosicao())) {
            hHero.voltaAUltimaPosicao();
        }

        this.setTitle("-> Cell: " + (hHero.getPosicao().getColuna()) + ", " + (hHero.getPosicao().getLinha()));
    }


  public void mousePressed(MouseEvent e) {
  /*      //Movimento via mouse
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
