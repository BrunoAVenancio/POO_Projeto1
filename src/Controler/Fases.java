/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Auxiliar.*;
import Modelo.*;
import java.util.ArrayList;

/**
 *
 * @author jackal
 */
public class Fases extends ArrayList<Elemento>{
    Fases(int Tamanho){
        super(Tamanho);
    }
    
    public void setFase1(Hero unHero){
        this.clear();
        this.add(unHero);
        
        this.add(new QuadradoVermelho(new Posicao(1,1)));
        this.add(new QuadradoVermelho(new Posicao(1,3)));
        this.add(new QuadradoVermelho(new Posicao(1,5)));
        this.add(new QuadradoVermelho(new Posicao(1,7)));
        this.add(new QuadradoVermelho(new Posicao(1,9)));
        this.add(new QuadradoVermelho(new Posicao(3,1)));
        this.add(new QuadradoVermelho(new Posicao(3,3)));
        this.add(new QuadradoVermelho(new Posicao(3,5)));
        this.add(new QuadradoVermelho(new Posicao(3,7)));
        this.add(new QuadradoVermelho(new Posicao(3,9)));
        this.add(new QuadradoVermelho(new Posicao(5,1)));
        this.add(new QuadradoVermelho(new Posicao(5,3)));
        this.add(new QuadradoVermelho(new Posicao(5,5)));
        this.add(new QuadradoVermelho(new Posicao(5,7)));
        this.add(new QuadradoVermelho(new Posicao(5,9)));
        this.add(new QuadradoVermelho(new Posicao(7,1)));
        this.add(new QuadradoVermelho(new Posicao(7,3)));
        this.add(new QuadradoVermelho(new Posicao(7,5)));
        this.add(new QuadradoVermelho(new Posicao(7,7)));
        this.add(new QuadradoVermelho(new Posicao(7,9)));
        this.add(new QuadradoVermelho(new Posicao(9,1)));
        this.add(new QuadradoVermelho(new Posicao(9,3)));
        this.add(new QuadradoVermelho(new Posicao(9,5)));
        this.add(new QuadradoVermelho(new Posicao(9,7)));
        this.add(new QuadradoVermelho(new Posicao(9,9)));
        
        this.add(new BlocoVerde(new Posicao(0,1)));
        this.add(new BlocoVerde(new Posicao(0,5)));
        this.add(new BlocoVerde(new Posicao(1,2)));
        this.add(new BlocoVerde(new Posicao(1,8)));
        this.add(new BlocoVerde(new Posicao(1,10)));
        this.add(new BlocoVerde(new Posicao(2,1)));
        this.add(new BlocoVerde(new Posicao(2,5)));
        this.add(new BlocoVerde(new Posicao(3,0)));
        this.add(new BlocoVerde(new Posicao(3,8)));
        this.add(new BlocoVerde(new Posicao(4,1)));
        this.add(new BlocoVerde(new Posicao(4,9)));
        this.add(new BlocoVerde(new Posicao(5,2)));
        this.add(new BlocoVerde(new Posicao(5,6)));
        this.add(new BlocoVerde(new Posicao(6,5)));
        this.add(new BlocoVerde(new Posicao(6,7)));
        this.add(new BlocoVerde(new Posicao(7,8)));
        this.add(new BlocoVerde(new Posicao(7,10)));
        this.add(new BlocoVerde(new Posicao(8,3)));
        this.add(new BlocoVerde(new Posicao(8,9)));
        this.add(new BlocoVerde(new Posicao(9,0)));
        this.add(new BlocoVerde(new Posicao(9,2)));
        this.add(new BlocoVerde(new Posicao(9,6)));
        this.add(new BlocoVerde(new Posicao(9,8)));
        this.add(new BlocoVerde(new Posicao(10,7)));
        
        this.add(new Robo("RoboAmarelo.png",new Posicao(2,0)));
        this.add(new Robo("RoboRosa.png",new Posicao(0,9)));
        this.add(new Robo("RoboVerde.png",new Posicao(10,2)));
        this.add(new Robo("RoboAzul.png",new Posicao(10,9)));
        
        this.add(new FrutasConsumiveis("Morango.png",new Posicao(10,0)));
        this.add(new FrutasConsumiveis("Banana.png",new Posicao(0,10)));
        this.add(new FrutasConsumiveis("Cereja.png",new Posicao(10,10)));
        this.add(new FrutasConsumiveis("UVA.png",new Posicao(0,0)));
    }
}
