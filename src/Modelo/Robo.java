/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Auxiliar.*;
import java.io.Serializable;
import java.util.*;

/**
 *
 * @author jackal
 */
public class Robo extends Elemento  implements Serializable{
    Random r;
    int iDirecao = (new Random()).nextInt(4);
    int linhaNova;
    int colunaNova;
    int contadorDeInercia = Auxiliar.Consts.ROBOT_MOVE_FRAME_INTERVAL;
    public Robo(String sNomeImagePNG, Posicao P1){
        super(sNomeImagePNG);
        this.setPosicao(P1.getLinha(), P1.getColuna());
        this.bTransponivel = false;
        this.bRetiravel = false;
        this.bRobo = true;
        r = new Random();
    }
    
    public void posicaoNovaDoRobo(){
        switch(this.iDirecao){
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
    
    public void autoDesenho(){
        linhaNova = this.pPosicao.getLinha();
        colunaNova = this.pPosicao.getColuna();
        
        this.posicaoNovaDoRobo();
        if(!Desenhador.getTelaDoJogo().ehPosicaoValidaAoRobo(linhaNova,colunaNova)){
            //Reseta a posiciao inicial
            linhaNova = this.pPosicao.getLinha();
            colunaNova = this.pPosicao.getColuna();
            int novaDirecao = r.nextInt(4);
            if(novaDirecao != iDirecao){
                iDirecao = novaDirecao;
            }
            this.posicaoNovaDoRobo();
            contadorDeInercia++;     
        }
        if(Desenhador.getTelaDoJogo().ehPosicaoValidaAoRobo(linhaNova,colunaNova) && contadorDeInercia > Auxiliar.Consts.ROBOT_MOVE_FRAME_INTERVAL){
            this.pPosicao.setPosicao(linhaNova, colunaNova);
            Desenhador.getTelaDoJogo().matouHeroi(this);
            contadorDeInercia = 0; 
        }
        contadorDeInercia++;     
        super.autoDesenho();
        
    }
}
