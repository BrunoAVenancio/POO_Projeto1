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
public class Quadrado1 extends Elemento{
    public Quadrado1(String sNomeImagePNG, Posicao P1){
        super(sNomeImagePNG);
        this.setPosicao(P1.getLinha(), P1.getColuna());
        this.bTransponivel = false;
        this.bRetiravel = true;
        
    }
    
    public void voltaAUltimaPosicao(){
        this.pPosicao.volta();
    }
}
