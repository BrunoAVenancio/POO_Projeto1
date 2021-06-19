package Modelo;

import Auxiliar.*;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;
import javax.swing.ImageIcon;

/**
 *
 * @author Junio
 */
public abstract class Elemento implements Serializable {

    protected ImageIcon iImages;
    protected int iCurrentImage;
    protected Posicao pPosicao;
    protected boolean bTransponivel;
    protected boolean bRetiravel;
    protected boolean bMortal;
    protected boolean bMovel;
    protected int bDirecao;
    protected boolean bColecional;
    protected boolean bTravessia;

    /*Se encostar, morre?*/

    /*protected Elemento(String[] sNomeImagePNG) {
        this.pPosicao = new Posicao(1, 1);
        this.bTransponivel = true;
        this.bMortal = false;
        iCurrentImage = 0;
        //iImages = new ImageIcon[4];
        try {
            for (int i = 0; i < sNomeImagePNG.length; i++) {
                iImages[i] = new ImageIcon(new java.io.File(".").getCanonicalPath() + Consts.PATH + sNomeImagePNG);
                Image img = iImages[iCurrentImage].getImage();
                BufferedImage bi = new BufferedImage(Consts.CELL_SIDE, Consts.CELL_SIDE, BufferedImage.TYPE_INT_ARGB);
                Graphics g = bi.createGraphics();
                g.drawImage(img, 0, 0, Consts.CELL_SIDE, Consts.CELL_SIDE, null);
                iImages[iCurrentImage] = new ImageIcon(bi);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }*/

    protected Elemento(String sNomeImagePNG) {
        this.pPosicao = new Posicao(1, 1);
        this.bTransponivel = true;
        this.bMortal = false;
        this.bRetiravel = false;
        this.bMovel = false;
        this.bColecional = false;
        this.bTravessia = false;
        
        this.bDirecao = -1;
        //iCurrentImage = 0;
        //iImages = new ImageIcon[4];
        try {
            iImages/*[iCurrentImage]*/ = new ImageIcon(new java.io.File(".").getCanonicalPath() + Consts.PATH + sNomeImagePNG);
            Image img = iImages/*[iCurrentImage]*/.getImage();
            BufferedImage bi = new BufferedImage(Consts.CELL_SIDE, Consts.CELL_SIDE, BufferedImage.TYPE_INT_ARGB);
            Graphics g = bi.createGraphics();
            g.drawImage(img, 0, 0, Consts.CELL_SIDE, Consts.CELL_SIDE, null);
            iImages/*[iCurrentImage]*/ = new ImageIcon(bi);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public boolean isbTravessia() {
        return bTravessia;
    }

    public Posicao getPosicao() {
        return pPosicao;
    }

    public boolean isbColecional() {
        return bColecional;
    }
    
    public int getiCurrentImage() {
        return iCurrentImage;
    }

    public boolean isbMovel() {
        return bMovel;
    }

    public boolean isbRetiravel() {
        return bRetiravel;
    }

    public boolean isbMortal() {
        return bMortal;
    }

    public int getbDirecao() {
        return bDirecao;
    }

    public void setbDirecao(int bDirecao) {
        this.bDirecao = bDirecao;
    }
    
    public void setiCurrentImage(int iCurrentImage) {
        this.iCurrentImage = iCurrentImage;
    }

    public boolean isbTransponivel() {
        return bTransponivel;
    }

    public void setbTransponivel(boolean bTransponivel) {
        this.bTransponivel = bTransponivel;
    }

    public boolean setPosicao(int linha, int coluna) {
        return pPosicao.setPosicao(linha, coluna);
    }

    public boolean moveUp() {
        //boolean statusMovimento = this.pPosicao.moveUp();
        this.bDirecao = 0;
        if(!Desenhador.getTelaDoJogo().ehPosicaoValidaRelativoUmPersonagem(this)){
            this.getPosicao().volta();
            return false;
        }
        return /*statusMovimento;*/this.pPosicao.moveUp();
    }

    public boolean moveDown() {
        //boolean statusMovimento = this.pPosicao.moveDown();
        this.bDirecao = 1;
        if(!Desenhador.getTelaDoJogo().ehPosicaoValidaRelativoUmPersonagem(this)){
            this.getPosicao().volta();
            return false;
        }
        return /*statusMovimento;*/this.pPosicao.moveDown();
    }

    public boolean moveRight() {
        //boolean statusMovimento = this.pPosicao.moveRight();
        this.bDirecao = 3;
        if(!Desenhador.getTelaDoJogo().ehPosicaoValidaRelativoUmPersonagem(this)){
            this.getPosicao().volta();
            return false;
        }
        return /*statusMovimento;*/this.pPosicao.moveRight();

    }

    public boolean moveLeft() {
        //boolean statusMovimento = this.pPosicao.moveLeft();
        this.bDirecao = 2;
        if(!Desenhador.getTelaDoJogo().ehPosicaoValidaRelativoUmPersonagem(this)){
            this.getPosicao().volta();
            return false;
        }
        return /*statusMovimento;*/this.pPosicao.moveLeft();

    }

    public void autoDesenho() {
        Desenhador.desenhar(this.iImages, pPosicao.getColuna(), pPosicao.getLinha());
    }
}
