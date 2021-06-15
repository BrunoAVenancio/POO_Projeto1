package Modelo;

import java.io.Serializable;

/**
 *
 * @author jackal
 */
public class Necessary extends Elemento implements Serializable {
    
    public Necessary(String sNomeImagePNG){
        super(sNomeImagePNG);
        this.bTransponivel = false;
    }    
    
    public void voltaAUltimaPosicao(){
        this.pPosicao.volta();
    }
}
