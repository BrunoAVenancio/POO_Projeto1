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
        this.bDirecao = 0;
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

    public Posicao getPosicao() {
        return pPosicao;
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
        if(!Desenhador.getTelaDoJogo().ehPosicaoValidaRelativoUmPersonagem(this)){
            this.getPosicao().volta();
            return false;
        }
        return this.pPosicao.moveUp();
    }

    public boolean moveDown() {
        if(!Desenhador.getTelaDoJogo().ehPosicaoValidaRelativoUmPersonagem(this)){
            this.getPosicao().volta();
            return false;
        }
        return this.pPosicao.moveDown();
    }

    public boolean moveRight() {
        if(!Desenhador.getTelaDoJogo().ehPosicaoValidaRelativoUmPersonagem(this)){
            this.getPosicao().volta();
            return false;
        }
        return this.pPosicao.moveRight();

    }

    public boolean moveLeft() {
        if(!Desenhador.getTelaDoJogo().ehPosicaoValidaRelativoUmPersonagem(this)){
            this.getPosicao().volta();
            return false;
        }
        return this.pPosicao.moveLeft();

    }

    public void autoDesenho() {
        Desenhador.desenhar(this.iImages, pPosicao.getColuna(), pPosicao.getLinha());
    }
}
