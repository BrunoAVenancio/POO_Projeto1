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
public class Borda extends Elemento {
    public Borda(String sNomeImagePNG, Posicao P1){
        super(sNomeImagePNG);
        this.setPosicao(P1.getLinha(), P1.getColuna());
        
    }
    
    public void voltaAUltimaPosicao(){
        this.pPosicao.volta();
    }
}