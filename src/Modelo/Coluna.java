package Modelo;

import java.io.Serializable;
/**
 *
 * @author jackal
 */
public class Coluna  extends Elemento implements Serializable {
    
    public Coluna(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.bTransponivel = false;
    }

    public void voltaAUltimaPosicao(){
        this.pPosicao.volta();
    }
}
