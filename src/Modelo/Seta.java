package Modelo;

import Auxiliar.*;

public class Seta extends Elemento{
    public Seta(String sNomeImagePNG, Posicao P1, int nDirecao){
        super(sNomeImagePNG);
        this.setPosicao(P1.getLinha(), P1.getColuna());
        this.bTransponivel = false;
        this.bTravessia = true;        
        this.bDirecao = nDirecao;
    }
    
    public void voltaAUltimaPosicao(){
        this.pPosicao.volta();
    }
}
