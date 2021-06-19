package Controler;

import Auxiliar.*;
import Modelo.*;
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
                if(eTemp.isbTransponivel() && !eTemp.isbTravessia())
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
            if((!eTemp.isbTransponivel() || eTemp.isbColecional()) /*&& unElemento.getbDirecao() != eTemp.getbDirecao()*/){
                if(eTemp.getPosicao().estaNaMesmaPosicao(unElemento.getPosicao()))
                    return false;
            }
        }
        return true;
    }
    
        
    public boolean MatarHeroi(Hero unHero, Fases fase, Robo unRobo){
        if(unRobo.getbDirecao() == 0){
            if(unHero.getPosicao().getLinha() == unRobo.getPosicao().getLinha()-1 && unHero.getPosicao().getColuna() == unRobo.getPosicao().getColuna()){
                fase.setFase1(unHero);
                return true;
            }
        }else if(unRobo.getbDirecao() == 1){
            if(unHero.getPosicao().getLinha() == unRobo.getPosicao().getLinha()+1 && unHero.getPosicao().getColuna() == unRobo.getPosicao().getColuna()){
                fase.setFase1(unHero);
                return true;
            }
        }else if(unRobo.getbDirecao() == 2){
            if(unHero.getPosicao().getLinha() == unRobo.getPosicao().getLinha() && unHero.getPosicao().getColuna() == unRobo.getPosicao().getColuna()-1){
                fase.setFase1(unHero);
                return true;
            }
        }else if(unRobo.getbDirecao() == 3){
            if(unHero.getPosicao().getLinha() == unRobo.getPosicao().getLinha() && unHero.getPosicao().getColuna() == unRobo.getPosicao().getColuna()+1){
                fase.setFase1(unHero);
                return true;    
            }
        }
        return false;
    }
    
 /*   public boolean PersonagemMorreu(Elemento eTemp, Hero unHero){
        if(eTemp.getPosicao() == unHero.getPosicao()){
                if(eTemp.isbMortal())
                    return true;
        }
        return false;
    }*/
    
    
 /*   public boolean isThere(ArrayList<Elemento> e, Elemento unElemento ){
        Elemento eTemp;
        for(int i = 1; i < e.size(); i++){ 
            eTemp = e.get(i); 
            if(eTemp == unElemento)
                return true; 
        }
        return false;
    }*/
    
    public boolean RemoveElemento(ArrayList<Elemento> e, Hero unHero){
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
    }
    
    public boolean MoverElemento(ArrayList<Elemento> e, Hero unHero){
        Elemento eTemp;
        for(int i = 1; i < e.size(); i++){ 
            eTemp = e.get(i); 
            if(eTemp != unHero){
                if(eTemp.isbMovel() && unHero.getbDirecao() == 0){
                    if(eTemp.getPosicao().getLinha() == (unHero.getPosicao().getLinha()-1) && eTemp.getPosicao().getColuna() == unHero.getPosicao().getColuna()){
                        e.get(i).setPosicao(eTemp.getPosicao().getLinha() - 1, eTemp.getPosicao().getColuna());
                        if(!this.ehPosicaoValidaRelativoUmPersonagem(e, e.get(i))){
                            e.get(i).getPosicao().volta();
                            return false;
                        }
                        return true;
                    }
                }else if(eTemp.isbMovel() && unHero.getbDirecao() == 1){
                    if(eTemp.getPosicao().getLinha() == (unHero.getPosicao().getLinha()+1) && eTemp.getPosicao().getColuna() == unHero.getPosicao().getColuna() /*&& !this.ehPosicaoValidaRelativoUmPersonagem(e, unHero)*/){
                        e.get(i).setPosicao(eTemp.getPosicao().getLinha() + 1, eTemp.getPosicao().getColuna());
                        if(!this.ehPosicaoValidaRelativoUmPersonagem(e, e.get(i))){
                            e.get(i).getPosicao().volta();
                            return false;
                        }
                        return true;
                    }
                }else if(eTemp.isbMovel() && unHero.getbDirecao() == 2){
                    if(eTemp.getPosicao().getLinha() == unHero.getPosicao().getLinha() && eTemp.getPosicao().getColuna() == (unHero.getPosicao().getColuna()-1) /*&& !this.ehPosicaoValidaRelativoUmPersonagem(e, unHero)*/){
                        e.get(i).setPosicao(eTemp.getPosicao().getLinha(), eTemp.getPosicao().getColuna()-1);
                        if(!this.ehPosicaoValidaRelativoUmPersonagem(e, e.get(i))){
                            e.get(i).getPosicao().volta();
                            return false;
                        }
                        return true;
                    }
                }else if(eTemp.isbMovel()  && unHero.getbDirecao() == 3){
                    if(eTemp.getPosicao().getLinha() == unHero.getPosicao().getLinha() && eTemp.getPosicao().getColuna() == (unHero.getPosicao().getColuna()+1) /*&& !this.ehPosicaoValidaRelativoUmPersonagem(e, unHero)*/){
                        e.get(i).setPosicao(eTemp.getPosicao().getLinha(), eTemp.getPosicao().getColuna()+1);
                        if(!this.ehPosicaoValidaRelativoUmPersonagem(e, e.get(i))){
                            e.get(i).getPosicao().volta();
                            return false;
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public boolean ElementoColecionavel(ArrayList<Elemento> e, Hero unHero){
        Elemento eTemp;
        for(int i = 1; i < e.size(); i++){ 
            eTemp = e.get(i); 
            if(eTemp.isbColecional() && unHero.getbDirecao() == 0){
                if(eTemp.getPosicao().getLinha() == (unHero.getPosicao().getLinha()-1) && eTemp.getPosicao().getColuna() == unHero.getPosicao().getColuna() && !this.ehPosicaoValidaRelativoUmPersonagem(e, unHero)){
                    e.remove(i);
                    return true;
                }
            }else if(eTemp.isbColecional() && unHero.getbDirecao() == 1){
                if(eTemp.getPosicao().getLinha() == (unHero.getPosicao().getLinha()+1) && eTemp.getPosicao().getColuna() == unHero.getPosicao().getColuna() && !this.ehPosicaoValidaRelativoUmPersonagem(e, unHero)){
                    e.remove(i);
                    return true;
                }
            }else if(eTemp.isbMovel() && unHero.getbDirecao() == 2){
                if(eTemp.getPosicao().getLinha() == unHero.getPosicao().getLinha() && eTemp.getPosicao().getColuna() == (unHero.getPosicao().getColuna()-1) && !this.ehPosicaoValidaRelativoUmPersonagem(e, unHero)){
                    e.remove(i);
                    return true;
                }
            }else if(eTemp.isbMovel()  && unHero.getbDirecao() == 3){
                if(eTemp.getPosicao().getLinha() == unHero.getPosicao().getLinha() && eTemp.getPosicao().getColuna() == (unHero.getPosicao().getColuna()+1) && !this.ehPosicaoValidaRelativoUmPersonagem(e, unHero)){
                    e.remove(i);
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean ahColecionaveisAinda(ArrayList<Elemento> e){
        Elemento eTemp;
        for(int i = 1; i < e.size(); i++){
            if(e.get(i).isbColecional())
                return true;
        }
        return false;
    }
    
    public boolean AndarNasSetas(ArrayList<Elemento> e, Hero unHero){
        Elemento eTemp;
        for(int i = 1; i < e.size(); i++){ 
            eTemp = e.get(i);
            if(eTemp.isbTravessia() && unHero.getbDirecao() == 0 && eTemp.getbDirecao() == unHero.getbDirecao()){
                if(eTemp.getPosicao().getLinha() == (unHero.getPosicao().getLinha()-1) && eTemp.getPosicao().getColuna() == unHero.getPosicao().getColuna() && eTemp.getbDirecao() == unHero.getbDirecao()){
                    eTemp.setbTransponivel(true);
                    unHero.moveUp();
                    return true;
                }if(eTemp.getPosicao().getLinha() == (unHero.getPosicao().getLinha()+1) && eTemp.getPosicao().getColuna() == unHero.getPosicao().getColuna() && eTemp.getbDirecao() == unHero.getbDirecao()){
                    eTemp.setbTransponivel(false);
                    return false;
                }
            }else if(eTemp.isbTravessia() && unHero.getbDirecao() == 1 && eTemp.getbDirecao() == unHero.getbDirecao()){
                if(eTemp.getPosicao().getLinha() == (unHero.getPosicao().getLinha()+1) && eTemp.getPosicao().getColuna() == unHero.getPosicao().getColuna() && eTemp.getbDirecao() == unHero.getbDirecao()){
                    eTemp.setbTransponivel(true);
                    unHero.moveDown();
                    return true;
                }if(eTemp.getPosicao().getLinha() == (unHero.getPosicao().getLinha()-1) && eTemp.getPosicao().getColuna() == unHero.getPosicao().getColuna() && eTemp.getbDirecao() == unHero.getbDirecao()){
                    eTemp.setbTransponivel(false);
                    return false;
                }
            }else if(eTemp.isbTravessia() && unHero.getbDirecao() == 2 && eTemp.getbDirecao() == unHero.getbDirecao()){
                if(eTemp.getPosicao().getLinha() == unHero.getPosicao().getLinha() && eTemp.getPosicao().getColuna() == (unHero.getPosicao().getColuna()-1) && eTemp.getbDirecao() == unHero.getbDirecao()){
                    eTemp.setbTransponivel(true);
                    unHero.moveLeft();
                    return true;
                }if(eTemp.getPosicao().getLinha() == unHero.getPosicao().getLinha() && eTemp.getPosicao().getColuna() == (unHero.getPosicao().getColuna()+1) && eTemp.getbDirecao() == unHero.getbDirecao()){
                    eTemp.setbTransponivel(false);
                    return false;
                }
            }else if(eTemp.isbTravessia()  && unHero.getbDirecao() == 3 && eTemp.getbDirecao() == unHero.getbDirecao()){
                if(eTemp.getPosicao().getLinha() == unHero.getPosicao().getLinha() && eTemp.getPosicao().getColuna() == (unHero.getPosicao().getColuna()+1) && eTemp.getbDirecao() == unHero.getbDirecao()){
                    eTemp.setbTransponivel(true);
                    unHero.moveRight();
                    return true;
                }if(eTemp.getPosicao().getLinha() == unHero.getPosicao().getLinha() && eTemp.getPosicao().getColuna() == (unHero.getPosicao().getColuna()-1) && eTemp.getbDirecao() == unHero.getbDirecao()){
                    eTemp.setbTransponivel(false);
                    return false;
                }
            }
        }
        return false;
    }
    
    public boolean PassouAsSetas(ArrayList<Elemento> e, Hero unHero){
        Elemento eTemp;
        for(int i = 1; i < e.size(); i++){ 
            eTemp = e.get(i);
            if(eTemp.isbTravessia() && /*unHero.getbDirecao() == 0 &&*/ unHero.getbDirecao() == eTemp.getbDirecao()){
                if(eTemp.getPosicao().getLinha() == (unHero.getPosicao().getLinha()+1) && eTemp.getPosicao().getColuna() == unHero.getPosicao().getColuna() && eTemp.getbDirecao() == unHero.getbDirecao()){
                    eTemp.setbTransponivel(false);
                    return true;
                }
            }else if(eTemp.isbTravessia() && /*unHero.getbDirecao() == 1 &&*/ unHero.getbDirecao() == eTemp.getbDirecao()){
                if(eTemp.getPosicao().getLinha() == (unHero.getPosicao().getLinha()-1) && eTemp.getPosicao().getColuna() == unHero.getPosicao().getColuna() && eTemp.getbDirecao() == unHero.getbDirecao()){
                    eTemp.setbTransponivel(false);
                    return true;
                }
            }else if(eTemp.isbTravessia() && /*unHero.getbDirecao() == 2 &&*/ unHero.getbDirecao() == eTemp.getbDirecao()){
                if(eTemp.getPosicao().getLinha() == unHero.getPosicao().getLinha() && eTemp.getPosicao().getColuna() == (unHero.getPosicao().getColuna()+1) && eTemp.getbDirecao() == unHero.getbDirecao()){
                    eTemp.setbTransponivel(false);
                    return true;
                }
            }else if(eTemp.isbTravessia()  && /*unHero.getbDirecao() == 3 &&*/ unHero.getbDirecao() == eTemp.getbDirecao()){
                if(eTemp.getPosicao().getLinha() == unHero.getPosicao().getLinha() && eTemp.getPosicao().getColuna() == (unHero.getPosicao().getColuna()-1) && eTemp.getbDirecao() == unHero.getbDirecao()){
                    eTemp.setbTransponivel(false);
                    return true;
                }
            }
        }
        return false;
    }
}
