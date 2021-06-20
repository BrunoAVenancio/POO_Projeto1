package Modelo;

import Auxiliar.Posicao;

public class Bloco extends Elemento {
    public Bloco(String sNomeImagePNG, Posicao P1){
        super(sNomeImagePNG);
        this.setPosicao(P1.getLinha(), P1.getColuna());
        this.bTransponivel = false;
        this.bRetiravel = true;
        this.bMovel = true;
        
    }
    
    public void voltaAUltimaPosicao(){
        this.pPosicao.volta();
    }
}
