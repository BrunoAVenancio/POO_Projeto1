/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Auxiliar.*;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author jackal
 */
public class Bomb extends Element {
    public Bomb(Posicao P1){
        super(Consts.BOMBIMAGE);
        this.setPosicao(P1.getLinha(), P1.getColuna());
        this.bTransponivel = false;
    }    
    
    public void voltaAUltimaPosicao(){
        this.pPosicao.volta();
    }
    
   /*public void contagemExplosao(Hero hHero, Bomb Bomba){
        for(int i=0; i<(5*Consts.FRAME_INTERVAL);i++){
        
        }
        Explosion Explosao1 = new Explosion(Bomba.getPosicao());
        if(Bomba.getPosicao().moveDown())
        if (hHero.getDirection() == 1) {
            hHero.moveDown();
        } else if (hHero.getDirection() == 2) {
            hHero.moveUp();
        } else if (hHero.getDirection() == 3) {
            hHero.moveRight();
        } else if (hHero.getDirection() == 4) {
            hHero.moveLeft();
        }

        
    }*/
}
