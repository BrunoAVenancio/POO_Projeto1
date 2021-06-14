package Modelo;

import java.io.Serializable;
/**
 *
 * @author jackal
 */
public class Monster  extends Elemento implements Serializable {
    private boolean bRight;

    public Monster(String sNomeImagePNG) {
        super(sNomeImagePNG);
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
