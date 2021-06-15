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
                Consts.RESLINHA * Consts.CELL_SIDE + getInsets().top + getInsets().bottom);

        /*Este array vai guardar os elementos graficos*/
        eElementos = new ArrayList<Elemento>(100);

    
        /*Cria eElementos adiciona elementos*/
        /*O protagonista (heroi) necessariamente precisa estar na posicao 0 do array*/
        hHero = new Hero("Bomberman_icone-removebg-preview.png"); /* https://www.online-image-editor.com/ */
        hHero.setPosicao(1, 1);
        this.addElemento(hHero);
        
        Monster cMonster1 = new Monster("Monstro1_icone-removebg-preview.png");
        cMonster1.setPosicao(9, 1);
        this.addElemento(cMonster1);     

        Monster cMonster2 = new Monster("Monstro1_icone-removebg-preview.png");
        cMonster2.setPosicao(9, 13);
        this.addElemento(cMonster2);

        Monster cMonster3 = new Monster("Monstro1_icone-removebg-preview.png");
        cMonster3.setPosicao(11, 6);        
        this.addElemento(cMonster3);
        
        //Monster cMonster4 = new Monster("Monstro4_icone-removebg-preview.png");
        //cMonster4.setPosicao(8, 8);        
        //this.addElemento(cMonster4);

        Coluna cBorda1 = new Coluna("borda_icona.png");
        cBorda1.setPosicao(0, 0);
        this.addElemento(cBorda1);
        
        Coluna cBorda2 = new Coluna("borda_icona.png");
        cBorda2.setPosicao(0, 1);
        this.addElemento(cBorda2);
        
        Coluna cBorda3 = new Coluna("borda_icona.png");
        cBorda3.setPosicao(0, 2);
        this.addElemento(cBorda3);
        
        Coluna cBorda4 = new Coluna("borda_icona.png");
        cBorda4.setPosicao(0, 3);
        this.addElemento(cBorda4);
        
        Coluna cBorda5 = new Coluna("borda_icona.png");
        cBorda5.setPosicao(0, 4);
        this.addElemento(cBorda5);
        
        Coluna cBorda6 = new Coluna("borda_icona.png");
        cBorda6.setPosicao(0, 5);
        this.addElemento(cBorda6);
        
        Coluna cBorda7 = new Coluna("borda_icona.png");
        cBorda7.setPosicao(0, 6);
        this.addElemento(cBorda7);
        
        Coluna cBorda8 = new Coluna("borda_icona.png");
        cBorda8.setPosicao(0, 7);
        this.addElemento(cBorda8);
        
        Coluna cBorda9 = new Coluna("borda_icona.png");
        cBorda9.setPosicao(0, 8);
        this.addElemento(cBorda9);
        
        Coluna cBorda10 = new Coluna("borda_icona.png");
        cBorda10.setPosicao(0, 9);
        this.addElemento(cBorda10);
        
        Coluna cBorda11 = new Coluna("borda_icona.png");
        cBorda11.setPosicao(0, 10);
        this.addElemento(cBorda11);
        
        Coluna cBorda41 = new Coluna("borda_icona.png");
        cBorda41.setPosicao(0, 11);
        this.addElemento(cBorda41);
        
        Coluna cBorda42 = new Coluna("borda_icona.png");
        cBorda42.setPosicao(0, 12);
        this.addElemento(cBorda42);
        
        Coluna cBorda43 = new Coluna("borda_icona.png");
        cBorda43.setPosicao(0, 13);
        this.addElemento(cBorda43);
        
        Coluna cBorda44 = new Coluna("borda_icona.png");
        cBorda44.setPosicao(0, 14);
        this.addElemento(cBorda44);
        
        Coluna cBorda12 = new Coluna("borda_icona.png");
        cBorda12.setPosicao(12, 0);
        this.addElemento(cBorda12);
        
        Coluna cBorda13 = new Coluna("borda_icona.png");
        cBorda13.setPosicao(12, 1);
        this.addElemento(cBorda13);
        
        Coluna cBorda14 = new Coluna("borda_icona.png");
        cBorda14.setPosicao(12, 2);
        this.addElemento(cBorda14);
        
        Coluna cBorda15 = new Coluna("borda_icona.png");
        cBorda15.setPosicao(12, 3);
        this.addElemento(cBorda15);
        
        Coluna cBorda16 = new Coluna("borda_icona.png");
        cBorda16.setPosicao(12, 4);
        this.addElemento(cBorda16);
        
        Coluna cBorda17 = new Coluna("borda_icona.png");
        cBorda17.setPosicao(12, 5);
        this.addElemento(cBorda17);
        
        Coluna cBorda18 = new Coluna("borda_icona.png");
        cBorda18.setPosicao(12, 6);
        this.addElemento(cBorda18);
        
        Coluna cBorda19 = new Coluna("borda_icona.png");
        cBorda19.setPosicao(12, 7);
        this.addElemento(cBorda19);
        
        Coluna cBorda20 = new Coluna("borda_icona.png");
        cBorda20.setPosicao(12, 8);
        this.addElemento(cBorda20);
        
        Coluna cBorda21 = new Coluna("borda_icona.png");
        cBorda21.setPosicao(12, 9);
        this.addElemento(cBorda21);
        
        Coluna cBorda22 = new Coluna("borda_icona.png");
        cBorda22.setPosicao(12, 10);
        this.addElemento(cBorda22);
        
        Coluna cBorda45 = new Coluna("borda_icona.png");
        cBorda45.setPosicao(12, 11);
        this.addElemento(cBorda45);
        
        Coluna cBorda46 = new Coluna("borda_icona.png");
        cBorda46.setPosicao(12, 12);
        this.addElemento(cBorda46);
        
        Coluna cBorda47 = new Coluna("borda_icona.png");
        cBorda47.setPosicao(12, 13);
        this.addElemento(cBorda47);
        
        Coluna cBorda48 = new Coluna("borda_icona.png");
        cBorda48.setPosicao(12, 14);
        this.addElemento(cBorda48);
        
        Coluna cBorda23 = new Coluna("borda_icona.png"); 
        cBorda23.setPosicao(1, 0);
        this.addElemento(cBorda23);
        
        Coluna cBorda24 = new Coluna("borda_icona.png"); 
        cBorda24.setPosicao(2, 0);
        this.addElemento(cBorda24);
        
        Coluna cBorda25 = new Coluna("borda_icona.png"); 
        cBorda25.setPosicao(3, 0);
        this.addElemento(cBorda25);
        
        Coluna cBorda26 = new Coluna("borda_icona.png"); 
        cBorda26.setPosicao(4, 0);
        this.addElemento(cBorda26);
        
        Coluna cBorda27 = new Coluna("borda_icona.png"); 
        cBorda27.setPosicao(5, 0);
        this.addElemento(cBorda27);
        
        Coluna cBorda28 = new Coluna("borda_icona.png"); 
        cBorda28.setPosicao(6, 0);
        this.addElemento(cBorda28);
        
        Coluna cBorda29 = new Coluna("borda_icona.png"); 
        cBorda29.setPosicao(7, 0);
        this.addElemento(cBorda29);
        
        Coluna cBorda30 = new Coluna("borda_icona.png"); 
        cBorda30.setPosicao(8, 0);
        this.addElemento(cBorda30);
        
        Coluna cBorda31 = new Coluna("borda_icona.png"); 
        cBorda31.setPosicao(9, 0);
        this.addElemento(cBorda31);
        
        Coluna cBorda49 = new Coluna("borda_icona.png"); 
        cBorda49.setPosicao(10, 0);
        this.addElemento(cBorda49);
        
        Coluna cBorda50 = new Coluna("borda_icona.png"); 
        cBorda50.setPosicao(11, 0);
        this.addElemento(cBorda50);
        
//        Coluna cBorda51 = new Coluna("borda_icona.png"); 
//        cBorda51.setPosicao(12, 0);
//        this.addElemento(cBorda51);
        
//        Coluna cBorda52 = new Coluna("borda_icona.png"); 
//        cBorda52.setPosicao(13, 0);
//        this.addElemento(cBorda52);
        
        Coluna cBorda32 = new Coluna("borda_icona.png"); 
        cBorda32.setPosicao(1, 14);
        this.addElemento(cBorda32);
        
        Coluna cBorda33 = new Coluna("borda_icona.png"); 
        cBorda33.setPosicao(2, 14);
        this.addElemento(cBorda33);
        
        Coluna cBorda34 = new Coluna("borda_icona.png"); 
        cBorda34.setPosicao(3, 14);
        this.addElemento(cBorda34);
        
        Coluna cBorda35 = new Coluna("borda_icona.png"); 
        cBorda35.setPosicao(4, 14);
        this.addElemento(cBorda35);
        
        Coluna cBorda36 = new Coluna("borda_icona.png"); 
        cBorda36.setPosicao(5, 14);
        this.addElemento(cBorda36);
        
        Coluna cBorda37 = new Coluna("borda_icona.png"); 
        cBorda37.setPosicao(6, 14);
        this.addElemento(cBorda37);
        
        Coluna cBorda38 = new Coluna("borda_icona.png"); 
        cBorda38.setPosicao(7, 14);
        this.addElemento(cBorda38);
        
        Coluna cBorda39 = new Coluna("borda_icona.png"); 
        cBorda39.setPosicao(8, 14);
        this.addElemento(cBorda39);
        
        Coluna cBorda40 = new Coluna("borda_icona.png"); 
        cBorda40.setPosicao(9, 14);
        this.addElemento(cBorda40);
        
        Coluna cBorda53 = new Coluna("borda_icona.png"); 
        cBorda53.setPosicao(10, 14);
        this.addElemento(cBorda53);

        Coluna cBorda54 = new Coluna("borda_icona.png"); 
        cBorda54.setPosicao(11, 14);
        this.addElemento(cBorda54);

//        Coluna cBorda55 = new Coluna("borda_icona.png"); 
//        cBorda55.setPosicao(12, 14);
//        this.addElemento(cBorda55);

//        Coluna cBorda56 = new Coluna("borda_icona.png"); 
//        cBorda56.setPosicao(13, 14);
//        this.addElemento(cBorda56);

        Coluna cColuna1 = new Coluna("coluna_icone.png"); 
        cColuna1.setPosicao(1, 10);
        this.addElemento(cColuna1);
        
        Coluna cColuna2 = new Coluna("coluna_icone.png"); 
        cColuna2.setPosicao(2, 2);
        this.addElemento(cColuna2);
        
        Coluna cColuna3 = new Coluna("coluna_icone.png"); 
        cColuna3.setPosicao(2, 4);
        this.addElemento(cColuna3);

        Coluna cColuna4 = new Coluna("coluna_icone.png"); 
        cColuna4.setPosicao(2, 6);
        this.addElemento(cColuna4);
        
        Coluna cColuna5 = new Coluna("coluna_icone.png"); 
        cColuna5.setPosicao(2, 8);
        this.addElemento(cColuna5);
        
        Coluna cColuna6 = new Coluna("coluna_icone.png"); 
        cColuna6.setPosicao(2, 10);
        this.addElemento(cColuna6);
        
        Coluna cColuna7 = new Coluna("coluna_icone.png"); 
        cColuna7.setPosicao(2, 12);
        this.addElemento(cColuna7);
        
        Coluna cColuna8 = new Coluna("coluna_icone.png"); 
        cColuna8.setPosicao(4, 2);
        this.addElemento(cColuna8);
        
        Coluna cColuna9 = new Coluna("coluna_icone.png"); 
        cColuna9.setPosicao(4, 4);
        this.addElemento(cColuna9);
        
        Coluna cColuna10 = new Coluna("coluna_icone.png"); 
        cColuna10.setPosicao(4, 6);
        this.addElemento(cColuna10);
        
        Coluna cColuna11 = new Coluna("coluna_icone.png"); 
        cColuna11.setPosicao(4, 8);
        this.addElemento(cColuna11);
        
        Coluna cColuna12 = new Coluna("coluna_icone.png"); 
        cColuna12.setPosicao(4, 10);
        this.addElemento(cColuna12);
        
        Coluna cColuna13 = new Coluna("coluna_icone.png"); 
        cColuna13.setPosicao(4, 12);
        this.addElemento(cColuna13);
        
        Coluna cColuna14 = new Coluna("coluna_icone.png"); 
        cColuna14.setPosicao(5, 4);
        this.addElemento(cColuna14);
        
        Coluna cColuna15 = new Coluna("coluna_icone.png"); 
        cColuna15.setPosicao(5, 8);
        this.addElemento(cColuna15);
        
        Coluna cColuna16 = new Coluna("coluna_icone.png"); 
        cColuna16.setPosicao(6, 1);
        this.addElemento(cColuna16);
        
        Coluna cColuna17 = new Coluna("coluna_icone.png"); 
        cColuna17.setPosicao(6, 2);
        this.addElemento(cColuna17);
        
        Coluna cColuna18 = new Coluna("coluna_icone.png"); 
        cColuna18.setPosicao(6, 3);
        this.addElemento(cColuna18);
        
        Coluna cColuna19 = new Coluna("coluna_icone.png"); 
        cColuna19.setPosicao(6, 4);
        this.addElemento(cColuna19);
        
        Coluna cColuna20 = new Coluna("coluna_icone.png"); 
        cColuna20.setPosicao(6, 6);
        this.addElemento(cColuna20);
        
        Coluna cColuna21 = new Coluna("coluna_icone.png"); 
        cColuna21.setPosicao(6, 8);
        this.addElemento(cColuna21);
        
        Coluna cColuna22 = new Coluna("coluna_icone.png"); 
        cColuna22.setPosicao(6, 9);
        this.addElemento(cColuna22);
        
        Coluna cColuna23 = new Coluna("coluna_icone.png"); 
        cColuna23.setPosicao(6, 10);
        this.addElemento(cColuna23);
        
        Coluna cColuna24 = new Coluna("coluna_icone.png"); 
        cColuna24.setPosicao(6, 12);
        this.addElemento(cColuna24);
        
        Coluna cColuna25 = new Coluna("coluna_icone.png"); 
        cColuna25.setPosicao(7, 1);
        this.addElemento(cColuna25);
        
        Coluna cColuna26 = new Coluna("coluna_icone.png"); 
        cColuna26.setPosicao(8, 1);
        this.addElemento(cColuna26);
        
        Coluna cColuna27 = new Coluna("coluna_icone.png"); 
        cColuna27.setPosicao(8, 2);
        this.addElemento(cColuna27);
        
        Coluna cColuna28 = new Coluna("coluna_icone.png"); 
        cColuna28.setPosicao(8, 4);
        this.addElemento(cColuna28);
        
        Coluna cColuna29 = new Coluna("coluna_icone.png"); 
        cColuna29.setPosicao(8, 6);
        this.addElemento(cColuna29);
        
        Coluna cColuna30 = new Coluna("coluna_icone.png"); 
        cColuna30.setPosicao(8, 8);
        this.addElemento(cColuna30);
        
        Coluna cColuna31 = new Coluna("coluna_icone.png"); 
        cColuna31.setPosicao(8, 10);
        this.addElemento(cColuna31);
        
        Coluna cColuna32 = new Coluna("coluna_icone.png"); 
        cColuna32.setPosicao(8, 12);
        this.addElemento(cColuna32);
        
        Coluna cColuna33 = new Coluna("coluna_icone.png"); 
        cColuna33.setPosicao(10, 2);
        this.addElemento(cColuna33);
        
        Coluna cColuna34 = new Coluna("coluna_icone.png"); 
        cColuna34.setPosicao(10, 4);
        this.addElemento(cColuna34);
        
        Coluna cColuna35 = new Coluna("coluna_icone.png"); 
        cColuna35.setPosicao(10, 6);
        this.addElemento(cColuna35);
        
        Coluna cColuna36 = new Coluna("coluna_icone.png"); 
        cColuna36.setPosicao(10, 8);
        this.addElemento(cColuna36);
        
        Coluna cColuna37 = new Coluna("coluna_icone.png"); 
        cColuna37.setPosicao(10, 10);
        this.addElemento(cColuna37);
        
        Coluna cColuna38 = new Coluna("coluna_icone.png"); 
        cColuna38.setPosicao(10, 12);
        this.addElemento(cColuna38);
        
        Necessary cPegue1 = new Necessary("carro_azul.png");
        cPegue1.setPosicao(1, 7);
        this.addElemento(cPegue1);
        
        Necessary cPegue2 = new Necessary("carro_azul.png");
        cPegue2.setPosicao(1, 11);
        this.addElemento(cPegue2);
        
        Necessary cPegue3 = new Necessary("carro_azul.png");
        cPegue3.setPosicao(2, 7);
        this.addElemento(cPegue3);
        
        Necessary cPegue4 = new Necessary("carro_azul.png");
        cPegue4.setPosicao(3, 1);
        this.addElemento(cPegue4);
        
        Necessary cPegue5 = new Necessary("carro_azul.png");
        cPegue5.setPosicao(3, 3);
        this.addElemento(cPegue5);
        
        Necessary cPegue6 = new Necessary("carro_azul.png");
        cPegue6.setPosicao(3, 4);
        this.addElemento(cPegue6);
        
        Necessary cPegue7 = new Necessary("carro_azul.png");
        cPegue7.setPosicao(3, 5);
        this.addElemento(cPegue7);
        
        Necessary cPegue8 = new Necessary("carro_azul.png");
        cPegue8.setPosicao(3, 8);
        this.addElemento(cPegue8);
        
        Necessary cPegue9 = new Necessary("carro_azul.png");
        cPegue9.setPosicao(3, 11);
        this.addElemento(cPegue9);
        
        Necessary cPegue10 = new Necessary("carro_azul.png");
        cPegue10.setPosicao(4, 11);
        this.addElemento(cPegue10);
        
        Necessary cPegue11 = new Necessary("carro_azul.png");
        cPegue11.setPosicao(5, 2);
        this.addElemento(cPegue11);
        
        Necessary cPegue12 = new Necessary("carro_azul.png");
        cPegue12.setPosicao(5, 9);
        this.addElemento(cPegue12);
        
        Necessary cPegue13 = new Necessary("carro_azul.png");
        cPegue13.setPosicao(5, 11);
        this.addElemento(cPegue13);
        
        Necessary cPegue14 = new Necessary("carro_azul.png");
        cPegue14.setPosicao(6, 5);
        this.addElemento(cPegue14);
        
        Necessary cPegue15 = new Necessary("carro_azul.png");
        cPegue15.setPosicao(6, 11);
        this.addElemento(cPegue15);
        
        Necessary cPegue16 = new Necessary("carro_azul.png");
        cPegue16.setPosicao(6, 13);
        this.addElemento(cPegue16);
        
        Necessary cPegue17 = new Necessary("carro_azul.png");
        cPegue17.setPosicao(7, 2);
        this.addElemento(cPegue17);
        
        Necessary cPegue18 = new Necessary("carro_azul.png");
        cPegue18.setPosicao(7, 3);
        this.addElemento(cPegue18);
        
        Necessary cPegue19 = new Necessary("carro_azul.png");
        cPegue19.setPosicao(7, 4);
        this.addElemento(cPegue19);
        
        Necessary cPegue20 = new Necessary("carro_azul.png");
        cPegue20.setPosicao(7, 6);
        this.addElemento(cPegue20);
        
        Necessary cPegue21 = new Necessary("carro_azul.png");
        cPegue21.setPosicao(7, 9);
        this.addElemento(cPegue21);
        
        Necessary cPegue22 = new Necessary("carro_azul.png");
        cPegue22.setPosicao(7, 12);
        this.addElemento(cPegue22);
        
        Necessary cPegue23 = new Necessary("carro_azul.png");
        cPegue23.setPosicao(8, 3);
        this.addElemento(cPegue23);
        
        Necessary cPegue24 = new Necessary("carro_azul.png");
        cPegue24.setPosicao(8, 9);
        this.addElemento(cPegue24);
        
        Necessary cPegue25 = new Necessary("carro_azul.png");
        cPegue25.setPosicao(9, 3);
        this.addElemento(cPegue25);
        
        Necessary cPegue26 = new Necessary("carro_azul.png");
        cPegue26.setPosicao(9, 4);
        this.addElemento(cPegue26);
        
        Necessary cPegue27 = new Necessary("carro_azul.png");
        cPegue27.setPosicao(9, 5);
        this.addElemento(cPegue27);
        
        Necessary cPegue28 = new Necessary("carro_azul.png");
        cPegue28.setPosicao(9, 8);
        this.addElemento(cPegue28);
        
        Necessary cPegue29 = new Necessary("carro_azul.png");
        cPegue29.setPosicao(10, 3);
        this.addElemento(cPegue29);
        
        Necessary cPegue30 = new Necessary("carro_azul.png");
        cPegue30.setPosicao(10, 5);
        this.addElemento(cPegue30);
        
        Necessary cPegue31 = new Necessary("carro_azul.png");
        cPegue31.setPosicao(10, 11);
        this.addElemento(cPegue31);
        
        Necessary cPegue32 = new Necessary("carro_azul.png");
        cPegue32.setPosicao(11, 7);
        this.addElemento(cPegue32);
        
        Necessary cPegue33 = new Necessary("carro_azul.png");
        cPegue33.setPosicao(11, 9);
        this.addElemento(cPegue33);
           
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
