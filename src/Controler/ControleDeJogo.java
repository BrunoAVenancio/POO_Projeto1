package Controler;

import Modelo.Elemento;
import Modelo.Hero;
import Auxiliar.Posicao;
import java.util.ArrayList;

/**
 *
 * @author junio
 */
public class ControleDeJogo {
    private int vidas;
    public void desenhaTudo(ArrayList<Elemento> e){
        for(int i = 0; i < e.size(); i++){
            e.get(i).autoDesenho();
        }
    }
    public void processaTudo(ArrayList<Elemento> e){
        Hero hHero = (Hero)e.get(0); /*O heroi (protagonista) eh sempre o primeiro do array*/
        Elemento eTemp;
        /*Processa todos os demais em relacao ao heroi*/
        for(int i = 1; i < e.size(); i++){
            eTemp = e.get(i); /*Pega o i-esimo elemento do jogo*/
            /*Verifica se o heroi se sobrepoe ao i-ésimo elemento*/
            if(hHero.getPosicao().estaNaMesmaPosicao(eTemp.getPosicao()))
                /*Nem todos os elementos podem ser transpostos pelo heroi*/
                if(eTemp.isbTransponivel())
                    e.remove(eTemp);
        }
    }
    public boolean ehPosicaoValida(ArrayList<Elemento> e, Posicao p){
        Elemento eTemp;
        /*Validacao da posicao de todos os elementos com relacao a Posicao p*/
        for(int i = 1; i < e.size(); i++){ /*Olha todos os elementos*/
            eTemp = e.get(i); /*Pega o i-esimo elemento do jogo*/
            if(!eTemp.isbTransponivel())
                if(eTemp.getPosicao().estaNaMesmaPosicao(p) && !eTemp.isbMortal())
                    return false; /*A posicao p é invalida, pois ha um elemento (i-esimo eTemp) intransponivel lá*/
        }
        return true;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }
    
    public boolean ehPosicaoValidaRelativoUmPersonagem(ArrayList<Elemento> e, Elemento unElemento ){
        Elemento eTemp;
        for(int i = 1; i < e.size(); i++){
            eTemp = e.get(i); 
            if(eTemp == unElemento)
                continue;
            if(!eTemp.isbTransponivel()){
                if(eTemp.getPosicao().estaNaMesmaPosicao(unElemento.getPosicao()))
                    return false;
            }
        }
        return true;
    }
    
    public boolean PersonagemMorreu(Elemento eTemp, Hero unHero){
        if(eTemp.getPosicao() == unHero.getPosicao()){
                if(eTemp.isbMortal())
                    return true;
        }
        return false;
    }
    
    
 /*   public boolean isThere(ArrayList<Elemento> e, Elemento unElemento ){
        Elemento eTemp;
        for(int i = 1; i < e.size(); i++){ 
            eTemp = e.get(i); 
            if(eTemp == unElemento)
                return true; 
        }
        return false;
    }*/
    
    /*public boolean RemoveElemento(ArrayList<Elemento> e, Hero unHero){
        Elemento eTemp;
        for(int i = 1; i < e.size(); i++){ 
            eTemp = e.get(i); 
            if(eTemp.isbRetiravel() && unHero.getbDirecao() == 0){
                if(eTemp.getPosicao().getLinha() == unHero.getPosicao().getLinha()-1 && eTemp.getPosicao().getColuna() == unHero.getPosicao().getColuna()){
                    e.remove(i);
                    return true;
                }
            }else if(eTemp.isbRetiravel() && unHero.getbDirecao() == 1){
                if(eTemp.getPosicao().getLinha() == unHero.getPosicao().getLinha()+1 && eTemp.getPosicao().getColuna() == unHero.getPosicao().getColuna()){
                    e.remove(i);
                    return true;
                }
            }else if(eTemp.isbRetiravel() && unHero.getbDirecao() == 2){
                if(eTemp.getPosicao().getLinha() == unHero.getPosicao().getLinha() && eTemp.getPosicao().getColuna() == unHero.getPosicao().getColuna()-1){
                    e.remove(i);
                    return true;
                }
            }else if(eTemp.isbRetiravel()  && unHero.getbDirecao() == 3){
                if(eTemp.getPosicao().getLinha() == unHero.getPosicao().getLinha() && eTemp.getPosicao().getColuna() == unHero.getPosicao().getColuna()+1){
                    e.remove(i);
                    return true;
                }
            }
        }
        return false;
    }*/
    
    public boolean MoverElemento(ArrayList<Elemento> e, Hero unHero){
        Elemento eTemp;
        for(int i = 1; i < e.size(); i++){ 
            eTemp = e.get(i); 
            if(eTemp.isbMovel() && unHero.getbDirecao() == 0){
                if(eTemp.getPosicao().getLinha() == unHero.getPosicao().getLinha()-1 && this.ehPosicaoValidaRelativoUmPersonagem(e, unHero)){
                    e.get(i).setPosicao(eTemp.getPosicao().getLinha() - 1, eTemp.getPosicao().getColuna());
                    return true;
                }
            }else if(eTemp.isbMovel() && unHero.getbDirecao() == 1){
                if(eTemp.getPosicao().getLinha() == unHero.getPosicao().getLinha()+1 && this.ehPosicaoValidaRelativoUmPersonagem(e, unHero)){
                    e.get(i).setPosicao(eTemp.getPosicao().getLinha() + 1, eTemp.getPosicao().getColuna());
                    return true;
                }
            }else if(eTemp.isbMovel() && unHero.getbDirecao() == 2){
                if(eTemp.getPosicao().getColuna() == unHero.getPosicao().getColuna()-1 && this.ehPosicaoValidaRelativoUmPersonagem(e, unHero)){
                    e.get(i).setPosicao(eTemp.getPosicao().getLinha(), eTemp.getPosicao().getColuna()-1);
                    return true;
                }
            }else if(eTemp.isbMovel()  && unHero.getbDirecao() == 3){
                if(eTemp.getPosicao().getColuna() == unHero.getPosicao().getColuna()+1 && this.ehPosicaoValidaRelativoUmPersonagem(e, unHero)){
                    e.get(i).setPosicao(eTemp.getPosicao().getLinha(), eTemp.getPosicao().getColuna()+1);
                    return true;
                }
            }
        }
        return false;
    }
}
