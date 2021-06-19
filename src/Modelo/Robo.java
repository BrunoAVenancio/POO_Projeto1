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
    int iDirecao = -1;
    int contadorDeInercia = Auxiliar.Consts.ROBOT_MOVE_FRAME_INTERVAL;
    public Robo(String sNomeImagePNG, Posicao P1){
        super(sNomeImagePNG);
        this.setPosicao(P1.getLinha(), P1.getColuna());
        this.bTransponivel = false;
        this.bRetiravel = false;
        this.bMortal = false;
        r = new Random();
    }
    
    public void autoDesenho(){
        if(contadorDeInercia == Auxiliar.Consts.ROBOT_MOVE_FRAME_INTERVAL){
            iDirecao = r.nextInt(4);
            switch(iDirecao){
                case -1:
                    break;
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
            contadorDeInercia = 0;
            
            
        }
        Desenhador.getTelaDoJogo().matouHeroi(this);
        if(!Desenhador.getTelaDoJogo().ehPosicaoValidaRelativoUmPersonagem(this)){
                this.getPosicao().volta();
        }
        contadorDeInercia++;     
        super.autoDesenho();
        
    }
}
