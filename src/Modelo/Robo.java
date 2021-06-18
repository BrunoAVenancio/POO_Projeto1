/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Auxiliar.*;
import java.io.Serializable;
import java.util.*;

/**
 *
 * @author jackal
 */
public class Robo extends Elemento  implements Serializable{
    Random r;
    public Robo(String sNomeImagePNG, Posicao P1){
        super(sNomeImagePNG);
        this.setPosicao(P1.getLinha(), P1.getColuna());
        this.bTransponivel = false;
        this.bRetiravel = false;
        this.bMortal = true;
        r = new Random();
    }
    
    public void autoDesenho(){
        int iDirecao = r.nextInt(4);
        switch(iDirecao){
            case 0:
                this.moveUp();
                this.bDirecao = 0;
                break;
            case 1:
                this.moveDown();
                this.bDirecao = 1;
                break;
            case 2:
                this.moveRight();
                this.bDirecao = 2;
                break;
            case 3:
                this.moveLeft();
                this.bDirecao = 3;
                break;
        }
        
        if(!Desenhador.getTelaDoJogo().ehPosicaoValidaRelativoUmPersonagem(this)){
            this.getPosicao().volta();
        }
        super.autoDesenho();
        
    }
}
