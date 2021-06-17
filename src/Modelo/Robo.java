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
        r = new Random();
    }
    
    public void autoDesenho(){
        int iDirecao = r.nextInt(4);
        switch(iDirecao){
            case 0:
                this.moveUp();
                break;
            case 1:
                this.moveDown();
                break;
            case 2:
                this.moveRight();
                break;
            case 3:
                this.moveLeft();
                break;
        }
       
        super.autoDesenho();
        
    }
}
