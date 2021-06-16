package Modelo;

import Auxiliar.*;
import java.io.Serializable;

/**
 *
 * @author Junio
 */
public class Hero extends Element implements Serializable{
    private int direction;
    public Hero(String sNomeImagePNG) {
        super(sNomeImagePNG);
        direction = 0;
    }

    public void voltaAUltimaPosicao(){
        this.pPosicao.volta();
    }
    
    /*public void colocarBomba(){
        Bomba Bomba1 = new Bomba(Consts.BOMBIMAGE);
        Bomba1.setPosicao(this.getPosicao().getLinha(), this.getPosicao().getColuna());
    }*/

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }
    
    
}
