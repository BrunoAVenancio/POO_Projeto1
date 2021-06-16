package Modelo;

import Auxiliar.*;
import java.io.Serializable;

/**
 *
 * @author jackal
 */
public class Colectible extends Element implements Serializable {
    
    public Colectible(Posicao P1){
        super(Consts.COLLECTIBLEIMAGE);
        this.setPosicao(P1.getLinha(), P1.getColuna());
        this.bTransponivel = false;
        this.bColecionavel = true;
    }    
    
    public void voltaAUltimaPosicao(){
        this.pPosicao.volta();
    }
}
