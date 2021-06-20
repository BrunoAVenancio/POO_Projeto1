package Modelo;

import Auxiliar.Posicao;

public class Consumiveis extends Elemento {
    public Consumiveis(String sNomeImagePNG, Posicao P1){
        super(sNomeImagePNG);
        this.setPosicao(P1.getLinha(), P1.getColuna());
        this.bRetiravel = false;
        this.bColecional = true;
    }
    
    public void voltaAUltimaPosicao(){
        this.pPosicao.volta();
    }
}
