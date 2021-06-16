package Modelo;

import Auxiliar.*;
import java.io.Serializable;
/**
 *
 * @author jackal
 */
public class Monster  extends Element implements Serializable {
    private boolean bRight;

    public Monster(Posicao P1) {
        super(Consts.MONSTER1IMAGE);
        this.setPosicao(P1.getLinha(), P1.getColuna());
        bRight = true;
        this.bTransponivel = false;
    }
    
    public void autoDesenho(){
        if(bRight)
            this.setPosicao(pPosicao.getLinha(), pPosicao.getColuna()+1);
        else
            this.setPosicao(pPosicao.getLinha(), pPosicao.getColuna()-1);           

        super.autoDesenho();
        bRight = !bRight;
    }
}
