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
                Consts.RES * Consts.CELL_SIDE + getInsets().top + getInsets().bottom);

        /*Este array vai guardar os elementos graficos*/
        eElementos = new ArrayList<Elemento>(100);

    
        /*Cria eElementos adiciona elementos*/
        /*O protagonista (heroi) necessariamente precisa estar na posicao 0 do array*/
        hHero = new Hero("Bomberman_icone-removebg-preview.png"); /* https://www.online-image-editor.com/ */
        hHero.setPosicao(8, 5);
        this.addElemento(hHero);
        
        Monster cMonster1 = new Monster("Monstro1_icone-removebg-preview.png");
        cMonster1.setPosicao(1, 1);
        this.addElemento(cMonster1);     

        Monster cMonster2 = new Monster("Monstro2_icone-removebg-preview.png");
        cMonster2.setPosicao(3, 3);
        this.addElemento(cMonster2);

        Monster cMonster3 = new Monster("Monstro3_icone-removebg-preview.png");
        cMonster3.setPosicao(6, 6);        
        this.addElemento(cMonster3);
        
        Monster cMonster4 = new Monster("Monstro4_icone-removebg-preview.png");
        cMonster4.setPosicao(8, 8);        
        this.addElemento(cMonster4);

        Coluna cColuna1 = new Coluna("borda_icona.png");
        cColuna1.setPosicao(0, 0);
        this.addElemento(cColuna1);
        
        Coluna cColuna2 = new Coluna("borda_icona.png");
        cColuna2.setPosicao(0, 1);
        this.addElemento(cColuna2);
        
        Coluna cColuna3 = new Coluna("borda_icona.png");
        cColuna3.setPosicao(0, 2);
        this.addElemento(cColuna3);
        
        Coluna cColuna4 = new Coluna("borda_icona.png");
        cColuna4.setPosicao(0, 3);
        this.addElemento(cColuna4);
        
        Coluna cColuna5 = new Coluna("borda_icona.png");
        cColuna5.setPosicao(0, 4);
        this.addElemento(cColuna5);
        
        Coluna cColuna6 = new Coluna("borda_icona.png");
        cColuna6.setPosicao(0, 5);
        this.addElemento(cColuna6);
        
        Coluna cColuna7 = new Coluna("borda_icona.png");
        cColuna7.setPosicao(0, 6);
        this.addElemento(cColuna7);
        
        Coluna cColuna8 = new Coluna("borda_icona.png");
        cColuna8.setPosicao(0, 7);
        this.addElemento(cColuna8);
        
        Coluna cColuna9 = new Coluna("borda_icona.png");
        cColuna9.setPosicao(0, 8);
        this.addElemento(cColuna9);
        
        Coluna cColuna10 = new Coluna("borda_icona.png");
        cColuna10.setPosicao(0, 9);
        this.addElemento(cColuna10);
        
       // Coluna cColuna11 = new Coluna("borda_icona.png");
        //cColuna11.setPosicao(0, 10);
        //this.addElemento(cColuna11);
        
        Coluna cColuna12 = new Coluna("borda_icona.png");
        cColuna12.setPosicao(9, 0);
        this.addElemento(cColuna12);
        
        Coluna cColuna13 = new Coluna("borda_icona.png");
        cColuna13.setPosicao(9, 1);
        this.addElemento(cColuna13);
        
        Coluna cColuna14 = new Coluna("borda_icona.png");
        cColuna14.setPosicao(9, 2);
        this.addElemento(cColuna14);
        
        Coluna cColuna15 = new Coluna("borda_icona.png");
        cColuna15.setPosicao(9, 3);
        this.addElemento(cColuna15);
        
        Coluna cColuna16 = new Coluna("borda_icona.png");
        cColuna16.setPosicao(9, 4);
        this.addElemento(cColuna16);
        
        Coluna cColuna17 = new Coluna("borda_icona.png");
        cColuna17.setPosicao(9, 5);
        this.addElemento(cColuna17);
        
        Coluna cColuna18 = new Coluna("borda_icona.png");
        cColuna18.setPosicao(9, 6);
        this.addElemento(cColuna18);
        
        Coluna cColuna19 = new Coluna("borda_icona.png");
        cColuna19.setPosicao(9, 7);
        this.addElemento(cColuna19);
        
        Coluna cColuna20 = new Coluna("borda_icona.png");
        cColuna20.setPosicao(9, 8);
        this.addElemento(cColuna20);
        
        Coluna cColuna21 = new Coluna("borda_icona.png");
        cColuna21.setPosicao(9, 9);
        this.addElemento(cColuna21);
        
        //Coluna cColuna22 = new Coluna("borda_icona.png");
        //Coluna22.setPosicao(10, 10);
        //this.addElemento(cColuna22);
        
        Coluna cColuna23 = new Coluna("borda_icona.png"); 
        cColuna23.setPosicao(1, 0);
        this.addElemento(cColuna23);
        
        Coluna cColuna24 = new Coluna("borda_icona.png"); 
        cColuna24.setPosicao(2, 0);
        this.addElemento(cColuna24);
        
        Coluna cColuna25 = new Coluna("borda_icona.png"); 
        cColuna25.setPosicao(3, 0);
        this.addElemento(cColuna25);
        
        Coluna cColuna26 = new Coluna("borda_icona.png"); 
        cColuna26.setPosicao(4, 0);
        this.addElemento(cColuna26);
        
        Coluna cColuna27 = new Coluna("borda_icona.png"); 
        cColuna27.setPosicao(5, 0);
        this.addElemento(cColuna27);
        
        Coluna cColuna28 = new Coluna("borda_icona.png"); 
        cColuna28.setPosicao(6, 0);
        this.addElemento(cColuna28);
        
        Coluna cColuna29 = new Coluna("borda_icona.png"); 
        cColuna29.setPosicao(7, 0);
        this.addElemento(cColuna29);
        
        Coluna cColuna30 = new Coluna("borda_icona.png"); 
        cColuna30.setPosicao(8, 0);
        this.addElemento(cColuna30);
        
       // Coluna cColuna31 = new Coluna("borda_icona.png"); 
       // cColuna31.setPosicao(9, 0);
        //this.addElemento(cColuna31);
        
        Coluna cColuna32 = new Coluna("borda_icona.png"); 
        cColuna32.setPosicao(1, 9);
        this.addElemento(cColuna32);
        
        Coluna cColuna33 = new Coluna("borda_icona.png"); 
        cColuna33.setPosicao(2, 9);
        this.addElemento(cColuna33);
        
        Coluna cColuna34 = new Coluna("borda_icona.png"); 
        cColuna34.setPosicao(3, 9);
        this.addElemento(cColuna34);
        
        Coluna cColuna35 = new Coluna("borda_icona.png"); 
        cColuna35.setPosicao(4, 9);
        this.addElemento(cColuna35);
        
        Coluna cColuna36 = new Coluna("borda_icona.png"); 
        cColuna36.setPosicao(5, 9);
        this.addElemento(cColuna36);
        
        Coluna cColuna37 = new Coluna("borda_icona.png"); 
        cColuna37.setPosicao(6, 9);
        this.addElemento(cColuna37);
        
        Coluna cColuna38 = new Coluna("borda_icona.png"); 
        cColuna38.setPosicao(7, 9);
        this.addElemento(cColuna38);
        
        Coluna cColuna39 = new Coluna("borda_icona.png"); 
        cColuna39.setPosicao(8, 9);
        this.addElemento(cColuna39);
        
        //Coluna cColuna40 = new Coluna("borda_icona.png"); 
        //cColuna40.setPosicao(9, 10);
        //this.addElemento(cColuna40);
        
    }

/*--------------------------------------------------*/
    public void addElemento(Elemento umElemento) {
        eElementos.add(umElemento);
    }

    public void removeElemento(Elemento umElemento) {
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
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            hHero.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            hHero.moveLeft();
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            hHero.moveRight();
        } else if (e.getKeyCode() == KeyEvent.VK_R) {
            this.eElementos.clear();
            hHero = new Hero("Bomberman_icone-removebg-preview.png");
            hHero.setPosicao(0, 7);
            this.addElemento(hHero);

            Hero Hero = new Hero("Bomberman_icone-removebg-preview.png");
            Hero.setPosicao(5, 5);
            this.addElemento(Hero);
        }
        
        /*Se o heroi for para uma posicao invalida, sobre um elemento intransponivel, volta para onde estava*/
        if (!cControle.ehPosicaoValida(this.eElementos,hHero.getPosicao())) {
            hHero.voltaAUltimaPosicao();
        }

        this.setTitle("-> Cell: " + (hHero.getPosicao().getColuna()) + ", " + (hHero.getPosicao().getLinha()));
    }

    public void mousePressed(MouseEvent e) {
         //Movimento via mouse
         int x = e.getX();
         int y = e.getY();
     
         this.setTitle("X: "+ x + ", Y: " + y +
         " -> Cell: " + (y/Consts.CELL_SIDE) + ", " + (x/Consts.CELL_SIDE));
        
         this.hHero.getPosicao().setPosicao(y/Consts.CELL_SIDE, x/Consts.CELL_SIDE);

        /*Se o heroi for para uma posicao invalida, sobre um elemento intransponivel, volta para onde estava*/
        if (!cControle.ehPosicaoValida(this.eElementos,hHero.getPosicao())) {
            hHero.voltaAUltimaPosicao();
        }         
         
        repaint();
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
