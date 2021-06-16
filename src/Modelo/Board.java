package Modelo;

import Auxiliar.*;
import java.io.Serializable;
/**
 *
 * @author jackal
 */
public class Board  extends Element implements Serializable {
    
    public Board(Posicao P1) {
        super(Consts.BOARDIMAGE);
        this.setPosicao(P1.getLinha(), P1.getColuna());
        this.bTransponivel = false;
    }

    public void voltaAUltimaPosicao(){
        this.pPosicao.volta();
    }
}
