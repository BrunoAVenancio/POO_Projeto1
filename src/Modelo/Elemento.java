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

    protected ImageIcon iImages; //VARIÁVEL PARA SALVAR IMAGEM DO ELEMENTO
    protected Posicao pPosicao; //VARIÁVEL PARA SALVAR A POSIÇÃO DO ELEMENTO
    protected boolean bTransponivel; //INFORMA SE ELEMENTO É TRANSPONÍVEL
    protected boolean bRetiravel; //INFORMA SE ELEMENTO É RETIRÁVEL
    protected boolean bMortal; //INFORMA SE ELEMENTO É MORTAL
    protected boolean bMovel; //INFORMA SE ELEMENTO É MÓVEL
    protected int bDirecao; //INFORMA A DIREÇÃO DO ELEMENTO, QUANDO NECESSÁRIO
    protected boolean bColecional; //INFORMA SE ELEMENTO É COLECIONÁVLE
    protected boolean bTravessia; //INFORMA SE ELEMENTO É ATRAVESSÁVEL
    protected boolean bRobo; //INFORMA SE ELEMENTO É UM ROBO

protected Elemento(String sNomeImagePNG) {
        this.pPosicao = new Posicao(1, 1); //SETANDO CONFIGURAÇÕES INICIAIS PADRÕES DOS ELEMENTOS
        this.bTransponivel = true;
        this.bMortal = false;
        this.bRetiravel = false;
        this.bMovel = false;
        this.bColecional = false;
        this.bTravessia = false;
        this.bDirecao = -1;
        
        //ATRIBUINDO IMAGEM AO ELEMENTO
        try {
            iImages = new ImageIcon(new java.io.File(".").getCanonicalPath() + Consts.PATH + sNomeImagePNG);
            Image img = iImages.getImage();
            BufferedImage bi = new BufferedImage(Consts.TAMANHO_CELULA, Consts.TAMANHO_CELULA, BufferedImage.TYPE_INT_ARGB);
            Graphics g = bi.createGraphics();
            g.drawImage(img, 0, 0, Consts.TAMANHO_CELULA, Consts.TAMANHO_CELULA, null);
            iImages = new ImageIcon(bi);

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
    
    public boolean isbMovel() {
        return bMovel;
    }

    public boolean isbRetiravel() {
        return bRetiravel;
    }

    public boolean isbMortal() {
        return bMortal;
    }
    public boolean isbRobo() {
        return bRobo;
    }
    public int getbDirecao() {
        return bDirecao;
    }

    public void setbDirecao(int bDirecao) {
        this.bDirecao = bDirecao;
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

    //MOVIMENTO O ELEMENTO PARA CIMA, QUANDO POSSÍVEL
    public boolean moveUp() {
        this.bDirecao = 0;
        if(!Desenhador.getTelaDoJogo().ehPosicaoValidaRelativoUmPersonagem(this)){
            this.getPosicao().volta();
            return false;
        }
        return this.pPosicao.moveUp();
    }

    //MOVIMENTO O ELEMENTO PARA BAIXO, QUANDO POSSÍVEL
    public boolean moveDown() {
        this.bDirecao = 1;
        if(!Desenhador.getTelaDoJogo().ehPosicaoValidaRelativoUmPersonagem(this)){
            this.getPosicao().volta();
            return false;
        }
        return this.pPosicao.moveDown();
    }

    //MOVIMENTO O ELEMENTO PARA DIREITA, QUANDO POSSÍVEL
    public boolean moveRight() {
        this.bDirecao = 3;
        if(!Desenhador.getTelaDoJogo().ehPosicaoValidaRelativoUmPersonagem(this)){
            this.getPosicao().volta();
            return false;
        }
        return this.pPosicao.moveRight();

    }

    //MOVIMENTO O ELEMENTO PARA ESQUERDA, QUANDO POSSÍVEL
    public boolean moveLeft() {
        this.bDirecao = 2;
        if(!Desenhador.getTelaDoJogo().ehPosicaoValidaRelativoUmPersonagem(this)){
            this.getPosicao().volta();
            return false;
        }
        return this.pPosicao.moveLeft();

    }

    //INSTRUÇÃO PARA DESENHAR O ELEMENTO
    public void autoDesenho() {
        Desenhador.desenhar(this.iImages, pPosicao.getColuna(), pPosicao.getLinha());
    }
}
