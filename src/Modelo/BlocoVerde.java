/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Auxiliar.Posicao;

/**
 *
 * @author jackal
 */
public class BlocoVerde extends Elemento {
    public BlocoVerde(Posicao P1){
        super("BlocoVerde.png");
        this.setPosicao(P1.getLinha(), P1.getColuna());
        this.bTransponivel = false;
        
    }
    
    public void voltaAUltimaPosicao(){
        this.pPosicao.volta();
    }
}
