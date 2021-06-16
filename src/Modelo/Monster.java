package Modelo;

import Auxiliar.*;
import java.io.Serializable;
import java.util.*;
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
        Random r = new Random();
        int iDirection = r.nextInt(4);
        switch(iDirection){
            case 0:
                this.moveUp();
                break;
            case 1:
                this.moveDown();
                break;
            case 2:
                this.moveLeft();
                break;
            case 3:
                this.moveRight();
                break;
        }
        if(!Desenhador.getTelaDoJogo().ehPosicaoValidaRelativaUmPersonagem(this)){
            this.getPosicao().volta();
        }
        super.autoDesenho();
    }
        /*if(bRight)
            this.setPosicao(pPosicao.getLinha(), pPosicao.getColuna()+1);
        else
            this.setPosicao(pPosicao.getLinha(), pPosicao.getColuna()-1);           

        super.autoDesenho();
        bRight = !bRight;*/
    
}
