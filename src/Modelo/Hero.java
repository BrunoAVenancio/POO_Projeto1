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
    
    public Hero(String sNomeImagePNG) {
        super(sNomeImagePNG);
        //iAlternancia = 0;
        //iIncremento = 1;
        this.bTransponivel = false;
        this.bRetiravel = false;
    }

    public void voltaAUltimaPosicao(){
        this.pPosicao.volta();
    }
    
    public void autoDesenho(){
       /* this.setiCurrentImage(iAlternancia);
        iAlternancia += iIncremento;
        if(iAlternancia == 2){
            iIncremento = -1;
        }else if(iAlternancia == 0){
            iIncremento = 1;
        }*/
        super.autoDesenho();
    }
}
