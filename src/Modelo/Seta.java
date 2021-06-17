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
    private int direcao;
    public Seta(String sNomeImagePNG, Posicao P1, int nDirecao){
        super(sNomeImagePNG);
        this.setPosicao(P1.getLinha(), P1.getColuna());
        this.bTransponivel = false;
        direcao = nDirecao;
    }
    
    public void voltaAUltimaPosicao(){
        this.pPosicao.volta();
    }
}
