/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Auxiliar.*;
import java.io.Serializable;
/**
 *
 * @author jackal
 */
public class Column extends Element implements Serializable {
    public Column(Posicao P1) {
        super(Consts.COLUMNIMAGE);
        this.setPosicao(P1.getLinha(), P1.getColuna());
        this.bTransponivel = false;
    }

    public void voltaAUltimaPosicao(){
        this.pPosicao.volta();
    }
}
