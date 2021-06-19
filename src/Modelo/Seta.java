/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Auxiliar.*;

/**
 *
 * @author jackal
 */
public class Seta extends Elemento{
    public Seta(String sNomeImagePNG, Posicao P1, int nDirecao){
        super(sNomeImagePNG);
        this.setPosicao(P1.getLinha(), P1.getColuna());
        this.bTransponivel = false;
        this.bTravessia = true;        
        this.bDirecao = nDirecao;
    }
    
    public void voltaAUltimaPosicao(){
        this.pPosicao.volta();
    }
    
    public void Interacao(Hero unHero){
        switch(this.bDirecao){
            case 0:
                unHero.moveUp();
                break;
            case 1:
                unHero.moveDown();
                break;
            case 2:
                unHero.moveLeft();
                break;
            case 3:
                unHero.moveRight();
                break;
        }
    }
}
