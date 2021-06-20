package Modelo;

import java.io.Serializable;

/**
 *
 * @author Junio
 */
public class Hero extends Elemento implements Serializable{
    int linhaNova;
    int colunaNova;
    int numeroDeVida; //INFORMA QUANTAS VIDAS O HEROI POSSUI
    
    public Hero(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.numeroDeVida = 3;
        this.bTransponivel = true;
        this.bRetiravel = false;
    }

    public void voltaAUltimaPosicao(){
        this.pPosicao.volta();
    }
    
    public int  getLinhaNova(){
        return this.linhaNova;
    }
    
    public int  getColunaNova(){
        return this.colunaNova;
    }
    
    public int getNumeroDeVida(){
        return this.numeroDeVida;
    }
    
    public void setNumeroDeVida(int vida){
        this.numeroDeVida = vida;
    }
    
    //REPOSICIONA O HEROI
    public void posicaoNovaDoHeroi(){
        this.linhaNova = this.pPosicao.getLinha();
        this.colunaNova = this.pPosicao.getColuna();
        switch(this.bDirecao){
                case 0:
                    this.linhaNova--;
                    break;
                case 1:
                    this.linhaNova++;
                    break;
                case 2:
                    this.colunaNova--;
                    break;
                case 3:
                    this.colunaNova++;
                    break;
            }
    }
}
