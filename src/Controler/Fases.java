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
public class Fases extends ArrayList<Element>{
    int NumberFase = 0;
    Fases(int Size){
        super(Size);
    }
    
    public void setFase1(Hero unHero){
        NumberFase = 1;
        this.clear();
        this.add(unHero);
        this.add(new Monster(new Posicao(9,1)));
        this.add(new Monster(new Posicao(9,13)));
        this.add(new Monster(new Posicao(11,6)));

        this.add(new Board(new Posicao(0,0)));
        this.add(new Board(new Posicao(0,1)));
        this.add(new Board(new Posicao(0,2)));
        this.add(new Board(new Posicao(0,3)));
        this.add(new Board(new Posicao(0,4)));
        this.add(new Board(new Posicao(0,5)));
        this.add(new Board(new Posicao(0,6)));
        this.add(new Board(new Posicao(0,7)));
        this.add(new Board(new Posicao(0,8)));
        this.add(new Board(new Posicao(0,9)));
        this.add(new Board(new Posicao(0,10)));
        this.add(new Board(new Posicao(0,11)));
        this.add(new Board(new Posicao(0,12)));
        this.add(new Board(new Posicao(0,13)));
        this.add(new Board(new Posicao(0,14)));
        this.add(new Board(new Posicao(12,0)));
        this.add(new Board(new Posicao(12,1)));
        this.add(new Board(new Posicao(12,2)));
        this.add(new Board(new Posicao(12,3)));
        this.add(new Board(new Posicao(12,4)));
        this.add(new Board(new Posicao(12,5)));
        this.add(new Board(new Posicao(12,6)));
        this.add(new Board(new Posicao(12,7)));
        this.add(new Board(new Posicao(12,8)));
        this.add(new Board(new Posicao(12,9)));
        this.add(new Board(new Posicao(12,10)));
        this.add(new Board(new Posicao(12,11)));
        this.add(new Board(new Posicao(12,12)));
        this.add(new Board(new Posicao(12,13)));
        this.add(new Board(new Posicao(12,14)));
        this.add(new Board(new Posicao(1,0)));
        this.add(new Board(new Posicao(2,0)));
        this.add(new Board(new Posicao(3,0)));
        this.add(new Board(new Posicao(4,0)));
        this.add(new Board(new Posicao(5,0)));
        this.add(new Board(new Posicao(6,0)));
        this.add(new Board(new Posicao(7,0)));
        this.add(new Board(new Posicao(8,0)));
        this.add(new Board(new Posicao(9,0)));
        this.add(new Board(new Posicao(10,0)));
        this.add(new Board(new Posicao(11,0)));
        this.add(new Board(new Posicao(1,14)));
        this.add(new Board(new Posicao(2,14)));
        this.add(new Board(new Posicao(3,14)));
        this.add(new Board(new Posicao(4,14)));
        this.add(new Board(new Posicao(5,14)));
        this.add(new Board(new Posicao(6,14)));
        this.add(new Board(new Posicao(7,14)));
        this.add(new Board(new Posicao(8,14)));
        this.add(new Board(new Posicao(9,14)));
        this.add(new Board(new Posicao(10,14)));
        this.add(new Board(new Posicao(11,14)));
        
        this.add(new Column(new Posicao(1,10)));
        this.add(new Column(new Posicao(2,2)));
        this.add(new Column(new Posicao(2,4)));
        this.add(new Column(new Posicao(2,6)));
        this.add(new Column(new Posicao(2,8)));
        this.add(new Column(new Posicao(2,10)));
        this.add(new Column(new Posicao(2,12)));
        this.add(new Column(new Posicao(4,2)));
        this.add(new Column(new Posicao(4,4)));
        this.add(new Column(new Posicao(4,6)));
        this.add(new Column(new Posicao(4,8)));
        this.add(new Column(new Posicao(4,10)));
        this.add(new Column(new Posicao(4,12)));
        this.add(new Column(new Posicao(5,4)));
        this.add(new Column(new Posicao(5,8)));
        this.add(new Column(new Posicao(6,1)));
        this.add(new Column(new Posicao(6,2)));
        this.add(new Column(new Posicao(6,3)));
        this.add(new Column(new Posicao(6,4)));
        this.add(new Column(new Posicao(6,6)));
        this.add(new Column(new Posicao(6,8)));
        this.add(new Column(new Posicao(6,9)));
        this.add(new Column(new Posicao(6,10)));
        this.add(new Column(new Posicao(6,12)));
        this.add(new Column(new Posicao(7,1)));
        this.add(new Column(new Posicao(8,1)));
        this.add(new Column(new Posicao(8,2)));
        this.add(new Column(new Posicao(8,4)));
        this.add(new Column(new Posicao(8,6)));
        this.add(new Column(new Posicao(8,8)));
        this.add(new Column(new Posicao(8,10)));
        this.add(new Column(new Posicao(8,12)));
        this.add(new Column(new Posicao(10,2)));
        this.add(new Column(new Posicao(10,4)));
        this.add(new Column(new Posicao(10,6)));
        this.add(new Column(new Posicao(10,8)));
        this.add(new Column(new Posicao(10,10)));
        this.add(new Column(new Posicao(10,12)));
        
        this.add(new Colectible(new Posicao(1,7)));
        this.add(new Colectible(new Posicao(1,11)));
        this.add(new Colectible(new Posicao(2,7)));
        this.add(new Colectible(new Posicao(3,1)));
        this.add(new Colectible(new Posicao(3,3)));
        this.add(new Colectible(new Posicao(3,4)));
        this.add(new Colectible(new Posicao(3,5)));
        this.add(new Colectible(new Posicao(3,8)));
        this.add(new Colectible(new Posicao(3,11)));
        this.add(new Colectible(new Posicao(4,11)));
        this.add(new Colectible(new Posicao(5,2)));
        this.add(new Colectible(new Posicao(5,9)));
        this.add(new Colectible(new Posicao(5,11)));
        this.add(new Colectible(new Posicao(6,5)));
        this.add(new Colectible(new Posicao(6,11)));
        this.add(new Colectible(new Posicao(6,13)));
        this.add(new Colectible(new Posicao(7,2)));
        this.add(new Colectible(new Posicao(7,3)));
        this.add(new Colectible(new Posicao(7,4)));
        this.add(new Colectible(new Posicao(7,6)));
        this.add(new Colectible(new Posicao(7,9)));
        this.add(new Colectible(new Posicao(7,12)));
        this.add(new Colectible(new Posicao(8,3)));
        this.add(new Colectible(new Posicao(8,9)));
        this.add(new Colectible(new Posicao(9,3)));
        this.add(new Colectible(new Posicao(9,4)));
        this.add(new Colectible(new Posicao(9,5)));
        this.add(new Colectible(new Posicao(9,8)));
        this.add(new Colectible(new Posicao(10,3)));
        this.add(new Colectible(new Posicao(10,5)));
        this.add(new Colectible(new Posicao(10,11)));
        this.add(new Colectible(new Posicao(11,7)));
        this.add(new Colectible(new Posicao(11,9)));
    }
}
