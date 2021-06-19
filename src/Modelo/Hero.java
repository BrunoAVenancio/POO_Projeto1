package Modelo;

import Auxiliar.Consts;
import Auxiliar.Desenhador;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Junio
 */
public class Hero extends Elemento implements Serializable{
    //private int iAlternancia;
    //private int iIncremento;
    int linhaNova;
    int colunaNova;
    int numeroDeVida;
    
    public Hero(String sNomeImagePNG) {
        super(sNomeImagePNG);
        //iAlternancia = 0;
        //iIncremento = 1;
        this.numeroDeVida = 3;
        this.bTransponivel = true;
        this.bRetiravel = false;
    }

    public void voltaAUltimaPosicao(){
        this.pPosicao.volta();
    }
    
    public int  getLinhaNova(){
        return this.linhaNova;
    }
    
    public int  getColunaNova(){
        return this.colunaNova;
    }
    
    public int getNumeroDeVida(){
        return this.numeroDeVida;
    }
    
    public void setNumeroDeVida(int vida){
        this.numeroDeVida = vida;
    }
    
    public void posicaoNovaDoHeroi(){
        this.linhaNova = this.pPosicao.getLinha();
        this.colunaNova = this.pPosicao.getColuna();
        switch(this.bDirecao){
                case 0:
                    this.linhaNova--;
                    break;
                case 1:
                    this.linhaNova++;
                    break;
                case 2:
                    this.colunaNova--;
                    break;
                case 3:
                    this.colunaNova++;
                    break;
            }
    }
    
   // public void autoDesenho(){
       /* this.setiCurrentImage(iAlternancia);
        iAlternancia += iIncremento;
        if(iAlternancia == 2){
            iIncremento = -1;
        }else if(iAlternancia == 0){
            iIncremento = 1;
        }*/
     /*   super.autoDesenho();
    }*/
}
