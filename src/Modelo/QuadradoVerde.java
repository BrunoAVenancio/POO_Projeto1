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
public class QuadradoVerde extends Elemento{
    public QuadradoVerde(Posicao P1){
        super("quadradoverde.png");
        this.setPosicao(P1.getLinha(), P1.getColuna());
        this.bTransponivel = false;
        
    }
    
    public void voltaAUltimaPosicao(){
        this.pPosicao.volta();
    }
}
