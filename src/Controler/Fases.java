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
    private int numFase = 0;
    Fases(int Tamanho){
        super(Tamanho);
    }

    public int getNumFase() {
        return numFase;
    }

    public void setNumFase(int numFase) {
        this.numFase = numFase;
    }
    
    
    public void setFase1(Hero unHero){
        numFase = 1;
        this.clear();
        unHero.setPosicao(4, 4);
        this.add(unHero);
        
        this.add(new Quadrado(Consts.QUADRADOVERMELHO, new Posicao(1,1)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO, new Posicao(1,3)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO, new Posicao(1,5)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO, new Posicao(1,7)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO, new Posicao(1,9)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO, new Posicao(3,1)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO, new Posicao(3,3)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO, new Posicao(3,5)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO, new Posicao(3,7)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO, new Posicao(3,9)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO, new Posicao(5,1)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO, new Posicao(5,3)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO, new Posicao(5,5)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO, new Posicao(5,7)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO, new Posicao(5,9)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO, new Posicao(7,1)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO, new Posicao(7,3)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO, new Posicao(7,5)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO, new Posicao(7,7)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO, new Posicao(7,9)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO, new Posicao(9,1)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO, new Posicao(9,3)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO, new Posicao(9,5)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO, new Posicao(9,7)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO, new Posicao(9,9)));
        
        this.add(new Bloco(Consts.BLOCOVERDE, new Posicao(0,1)));
        this.add(new Bloco(Consts.BLOCOVERDE, new Posicao(0,5)));
        this.add(new Bloco(Consts.BLOCOVERDE, new Posicao(1,2)));
        this.add(new Bloco(Consts.BLOCOVERDE, new Posicao(1,8)));
        this.add(new Bloco(Consts.BLOCOVERDE, new Posicao(1,10)));
        this.add(new Bloco(Consts.BLOCOVERDE, new Posicao(2,1)));
        this.add(new Bloco(Consts.BLOCOVERDE, new Posicao(2,5)));
        this.add(new Bloco(Consts.BLOCOVERDE, new Posicao(3,0)));
        this.add(new Bloco(Consts.BLOCOVERDE, new Posicao(3,8)));
        this.add(new Bloco(Consts.BLOCOVERDE, new Posicao(4,1)));
        this.add(new Bloco(Consts.BLOCOVERDE, new Posicao(4,9)));
        this.add(new Bloco(Consts.BLOCOVERDE, new Posicao(5,2)));
        this.add(new Bloco(Consts.BLOCOVERDE, new Posicao(5,6)));
        this.add(new Bloco(Consts.BLOCOVERDE, new Posicao(6,5)));
        this.add(new Bloco(Consts.BLOCOVERDE, new Posicao(6,7)));
        this.add(new Bloco(Consts.BLOCOVERDE, new Posicao(7,8)));
        this.add(new Bloco(Consts.BLOCOVERDE, new Posicao(7,10)));
        this.add(new Bloco(Consts.BLOCOVERDE, new Posicao(8,3)));
        this.add(new Bloco(Consts.BLOCOVERDE, new Posicao(8,9)));
        this.add(new Bloco(Consts.BLOCOVERDE, new Posicao(9,0)));
        this.add(new Bloco(Consts.BLOCOVERDE, new Posicao(9,2)));
        this.add(new Bloco(Consts.BLOCOVERDE, new Posicao(9,6)));
        this.add(new Bloco(Consts.BLOCOVERDE, new Posicao(9,8)));
        this.add(new Bloco(Consts.BLOCOVERDE, new Posicao(10,7)));
        
        this.add(new Robo(Consts.ROBOAMARELO,new Posicao(2,0)));
        this.add(new Robo(Consts.ROBOROSA,new Posicao(0,9)));
        this.add(new Robo(Consts.ROBOVERDE,new Posicao(10,2)));
        this.add(new Robo(Consts.ROBOAZUL,new Posicao(10,9)));
        
        this.add(new FrutasConsumiveis(Consts.MORANGO,new Posicao(10,0)));
        this.add(new FrutasConsumiveis(Consts.BANANA,new Posicao(0,10)));
        this.add(new FrutasConsumiveis(Consts.CEREJA,new Posicao(10,10)));
        this.add(new FrutasConsumiveis(Consts.UVA,new Posicao(0,0)));
    }
    
    public void setFase2(Hero unHero){
        numFase = 2;
        this.clear();
        unHero.setPosicao(5, 5);
        this.add(unHero);
        
        this.add(new Quadrado(Consts.QUADRADOVERMELHO,new Posicao(1,3)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO,new Posicao(1,7)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO,new Posicao(3,1)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO,new Posicao(3,3)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO,new Posicao(3,5)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO,new Posicao(3,7)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO,new Posicao(3,9)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO,new Posicao(5,3)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO,new Posicao(5,7)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO,new Posicao(7,1)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO,new Posicao(7,3)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO,new Posicao(7,5)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO,new Posicao(7,7)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO,new Posicao(7,9)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO,new Posicao(9,3)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO,new Posicao(9,7)));
        
        this.add(new Seta(Consts.SETAPRACIMA,new Posicao(3,0),0));
        this.add(new Seta(Consts.SETAPRACIMA,new Posicao(3,6),0));
        this.add(new Seta(Consts.SETAPRACIMA,new Posicao(3,8),0));
        this.add(new Seta(Consts.SETAPRACIMA,new Posicao(4,0),0));
        this.add(new Seta(Consts.SETAPRACIMA,new Posicao(4,8),0));
        this.add(new Seta(Consts.SETAPRACIMA,new Posicao(5,0),0));
        this.add(new Seta(Consts.SETAPRACIMA,new Posicao(6,0),0));
        this.add(new Seta(Consts.SETAPRACIMA,new Posicao(7,0),0));
        this.add(new Seta(Consts.SETAPRACIMA,new Posicao(7,6),0));
        this.add(new Seta(Consts.SETAPRACIMA,new Posicao(7,8),0));
        this.add(new Seta(Consts.SETAPRACIMA,new Posicao(7,10),0));
        
        this.add(new Seta(Consts.SETAPRABAIXO,new Posicao(2,4),1));
        this.add(new Seta(Consts.SETAPRABAIXO,new Posicao(3,2),1));
        this.add(new Seta(Consts.SETAPRABAIXO,new Posicao(3,4),1));
        this.add(new Seta(Consts.SETAPRABAIXO,new Posicao(3,10),1));
        this.add(new Seta(Consts.SETAPRABAIXO,new Posicao(7,2),1));
        this.add(new Seta(Consts.SETAPRABAIXO,new Posicao(7,4),1));

        this.add(new Seta(Consts.SETAPRADIREITA,new Posicao(0,3),3));
        this.add(new Seta(Consts.SETAPRADIREITA,new Posicao(0,7),3));
        this.add(new Seta(Consts.SETAPRADIREITA,new Posicao(2,3),3));
        this.add(new Seta(Consts.SETAPRADIREITA,new Posicao(4,3),3));
        this.add(new Seta(Consts.SETAPRADIREITA,new Posicao(4,7),3));
        this.add(new Seta(Consts.SETAPRADIREITA,new Posicao(6,3),3));
        this.add(new Seta(Consts.SETAPRADIREITA,new Posicao(8,3),3));
        this.add(new Seta(Consts.SETAPRADIREITA,new Posicao(8,7),3));
        this.add(new Seta(Consts.SETAPRADIREITA,new Posicao(10,7),3));

        this.add(new Seta(Consts.SETAPRAESQUERDA,new Posicao(2,5),2));
        this.add(new Seta(Consts.SETAPRAESQUERDA,new Posicao(2,6),2));
        this.add(new Seta(Consts.SETAPRAESQUERDA,new Posicao(2,7),2));
        this.add(new Seta(Consts.SETAPRAESQUERDA,new Posicao(4,9),2));
        this.add(new Seta(Consts.SETAPRAESQUERDA,new Posicao(4,10),2));
        this.add(new Seta(Consts.SETAPRAESQUERDA,new Posicao(6,7),2));
        this.add(new Seta(Consts.SETAPRAESQUERDA,new Posicao(10,3),2));
        
        this.add(new Robo(Consts.ROBOAMARELO,new Posicao(1,1)));
        this.add(new Robo(Consts.ROBOROSA,new Posicao(9,1)));
        this.add(new Robo(Consts.ROBOVERDE,new Posicao(1,9)));
        this.add(new Robo(Consts.ROBOAZUL,new Posicao(9,9)));
        
        this.add(new FrutasConsumiveis(Consts.MORANGO,new Posicao(5,9)));
        this.add(new FrutasConsumiveis(Consts.BANANA,new Posicao(5,1)));
        this.add(new FrutasConsumiveis(Consts.CEREJA,new Posicao(9,5)));
        this.add(new FrutasConsumiveis(Consts.UVA,new Posicao(1,5)));
    }
    
    public void setFase3(Hero unHero){
        numFase = 3;
        this.clear();
        unHero.setPosicao(5, 5);
        this.add(unHero);
        
        this.add(new Bloco(Consts.BLOCOVERMELHO,new Posicao(1,1)));
        this.add(new Bloco(Consts.BLOCOVERMELHO,new Posicao(1,2)));
        this.add(new Bloco(Consts.BLOCOVERMELHO,new Posicao(1,3)));
        this.add(new Bloco(Consts.BLOCOVERMELHO,new Posicao(1,4)));
        this.add(new Bloco(Consts.BLOCOVERMELHO,new Posicao(1,5)));
        this.add(new Bloco(Consts.BLOCOVERMELHO,new Posicao(1,6)));
        this.add(new Bloco(Consts.BLOCOVERMELHO,new Posicao(1,7)));
        this.add(new Bloco(Consts.BLOCOVERMELHO,new Posicao(1,8)));
        this.add(new Bloco(Consts.BLOCOVERMELHO,new Posicao(1,9)));
        this.add(new Bloco(Consts.BLOCOVERMELHO,new Posicao(2,1)));
        this.add(new Bloco(Consts.BLOCOVERMELHO,new Posicao(2,9)));
        this.add(new Bloco(Consts.BLOCOVERMELHO,new Posicao(3,1)));
        this.add(new Bloco(Consts.BLOCOVERMELHO,new Posicao(3,3)));
        this.add(new Bloco(Consts.BLOCOVERMELHO,new Posicao(3,4)));
        this.add(new Bloco(Consts.BLOCOVERMELHO,new Posicao(3,5)));
        this.add(new Bloco(Consts.BLOCOVERMELHO,new Posicao(3,6)));
        this.add(new Bloco(Consts.BLOCOVERMELHO,new Posicao(3,7)));
        this.add(new Bloco(Consts.BLOCOVERMELHO,new Posicao(3,9)));
        this.add(new Bloco(Consts.BLOCOVERMELHO,new Posicao(4,1)));
        this.add(new Bloco(Consts.BLOCOVERMELHO,new Posicao(4,3)));
        this.add(new Bloco(Consts.BLOCOVERMELHO,new Posicao(4,7)));
        this.add(new Bloco(Consts.BLOCOVERMELHO,new Posicao(4,9)));
        this.add(new Bloco(Consts.BLOCOVERMELHO,new Posicao(5,1)));
        this.add(new Bloco(Consts.BLOCOVERMELHO,new Posicao(5,3)));
        this.add(new Bloco(Consts.BLOCOVERMELHO,new Posicao(5,7)));
        this.add(new Bloco(Consts.BLOCOVERMELHO,new Posicao(5,9)));
        this.add(new Bloco(Consts.BLOCOVERMELHO,new Posicao(6,1)));
        this.add(new Bloco(Consts.BLOCOVERMELHO,new Posicao(6,3)));
        this.add(new Bloco(Consts.BLOCOVERMELHO,new Posicao(6,7)));
        this.add(new Bloco(Consts.BLOCOVERMELHO,new Posicao(6,9)));
        this.add(new Bloco(Consts.BLOCOVERMELHO,new Posicao(7,1)));
        this.add(new Bloco(Consts.BLOCOVERMELHO,new Posicao(7,3)));
        this.add(new Bloco(Consts.BLOCOVERMELHO,new Posicao(7,4)));
        this.add(new Bloco(Consts.BLOCOVERMELHO,new Posicao(7,5)));
        this.add(new Bloco(Consts.BLOCOVERMELHO,new Posicao(7,6)));
        this.add(new Bloco(Consts.BLOCOVERMELHO,new Posicao(7,7)));
        this.add(new Bloco(Consts.BLOCOVERMELHO,new Posicao(7,9)));
        this.add(new Bloco(Consts.BLOCOVERMELHO,new Posicao(8,1)));
        this.add(new Bloco(Consts.BLOCOVERMELHO,new Posicao(8,9)));
        this.add(new Bloco(Consts.BLOCOVERMELHO,new Posicao(9,1)));
        this.add(new Bloco(Consts.BLOCOVERMELHO,new Posicao(9,2)));
        this.add(new Bloco(Consts.BLOCOVERMELHO,new Posicao(9,3)));
        this.add(new Bloco(Consts.BLOCOVERMELHO,new Posicao(9,4)));
        this.add(new Bloco(Consts.BLOCOVERMELHO,new Posicao(9,5)));
        this.add(new Bloco(Consts.BLOCOVERMELHO,new Posicao(9,6)));
        this.add(new Bloco(Consts.BLOCOVERMELHO,new Posicao(9,7)));
        this.add(new Bloco(Consts.BLOCOVERMELHO,new Posicao(9,8)));
        this.add(new Bloco(Consts.BLOCOVERMELHO,new Posicao(9,9)));
        
        this.add(new Robo(Consts.ROBOAMARELO,new Posicao(0,5)));
        this.add(new Robo(Consts.ROBOROSA,new Posicao(2,5)));
        this.add(new Robo(Consts.ROBOVERDE,new Posicao(8,5)));
        this.add(new Robo(Consts.ROBOAZUL,new Posicao(10,5)));
        
        this.add(new FrutasConsumiveis(Consts.SOL,new Posicao(5,0)));
        this.add(new FrutasConsumiveis(Consts.CHAVE,new Posicao(5,10)));
        this.add(new FrutasConsumiveis(Consts.LAMPADA,new Posicao(5,8)));
        this.add(new FrutasConsumiveis(Consts.VELA,new Posicao(5,2)));
    }
    
    public void setFase4(Hero unHero){
        numFase = 4;
        this.clear();
        unHero.setPosicao(5, 5);
        this.add(unHero);
        
        this.add(new Quadrado(Consts.QUADRADOVERMELHO,new Posicao(0,3)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO,new Posicao(0,7)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO,new Posicao(1,0)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO,new Posicao(1,8)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO,new Posicao(2,5)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO,new Posicao(3,2)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO,new Posicao(3,10)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO,new Posicao(5,2)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO,new Posicao(5,8)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO,new Posicao(6,3)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO,new Posicao(7,0)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO,new Posicao(8,1)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO,new Posicao(8,7)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO,new Posicao(8,10)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO,new Posicao(10,1)));

        this.add(new Quadrado1(Consts.QUADRADOVERDE,new Posicao(1,1)));
        this.add(new Quadrado1(Consts.QUADRADOVERDE,new Posicao(1,3)));
        this.add(new Quadrado1(Consts.QUADRADOVERDE,new Posicao(1,5)));
        this.add(new Quadrado1(Consts.QUADRADOVERDE,new Posicao(1,7)));
        this.add(new Quadrado1(Consts.QUADRADOVERDE,new Posicao(1,9)));
        this.add(new Quadrado1(Consts.QUADRADOVERDE,new Posicao(2,2)));
        this.add(new Quadrado1(Consts.QUADRADOVERDE,new Posicao(2,4)));
        this.add(new Quadrado1(Consts.QUADRADOVERDE,new Posicao(2,6)));
        this.add(new Quadrado1(Consts.QUADRADOVERDE,new Posicao(2,8)));
        this.add(new Quadrado1(Consts.QUADRADOVERDE,new Posicao(3,1)));
        this.add(new Quadrado1(Consts.QUADRADOVERDE,new Posicao(3,3)));
        this.add(new Quadrado1(Consts.QUADRADOVERDE,new Posicao(3,5)));
        this.add(new Quadrado1(Consts.QUADRADOVERDE,new Posicao(3,7)));
        this.add(new Quadrado1(Consts.QUADRADOVERDE,new Posicao(3,9)));
        this.add(new Quadrado1(Consts.QUADRADOVERDE,new Posicao(4,2)));
        this.add(new Quadrado1(Consts.QUADRADOVERDE,new Posicao(4,4)));
        this.add(new Quadrado1(Consts.QUADRADOVERDE,new Posicao(4,6)));
        this.add(new Quadrado1(Consts.QUADRADOVERDE,new Posicao(4,8)));
        this.add(new Quadrado1(Consts.QUADRADOVERDE,new Posicao(5,1)));
        this.add(new Quadrado1(Consts.QUADRADOVERDE,new Posicao(5,3)));
        this.add(new Quadrado1(Consts.QUADRADOVERDE,new Posicao(5,7)));
        this.add(new Quadrado1(Consts.QUADRADOVERDE,new Posicao(5,9)));
        this.add(new Quadrado1(Consts.QUADRADOVERDE,new Posicao(6,2)));
        this.add(new Quadrado1(Consts.QUADRADOVERDE,new Posicao(6,4)));
        this.add(new Quadrado1(Consts.QUADRADOVERDE,new Posicao(6,6)));
        this.add(new Quadrado1(Consts.QUADRADOVERDE,new Posicao(6,8)));
        this.add(new Quadrado1(Consts.QUADRADOVERDE,new Posicao(7,1)));
        this.add(new Quadrado1(Consts.QUADRADOVERDE,new Posicao(7,3)));
        this.add(new Quadrado1(Consts.QUADRADOVERDE,new Posicao(7,5)));
        this.add(new Quadrado1(Consts.QUADRADOVERDE,new Posicao(7,7)));
        this.add(new Quadrado1(Consts.QUADRADOVERDE,new Posicao(7,9)));
        this.add(new Quadrado1(Consts.QUADRADOVERDE,new Posicao(8,2)));
        this.add(new Quadrado1(Consts.QUADRADOVERDE,new Posicao(8,4)));
        this.add(new Quadrado1(Consts.QUADRADOVERDE,new Posicao(8,6)));
        this.add(new Quadrado1(Consts.QUADRADOVERDE,new Posicao(8,8)));
        this.add(new Quadrado1(Consts.QUADRADOVERDE,new Posicao(9,1)));
        this.add(new Quadrado1(Consts.QUADRADOVERDE,new Posicao(9,3)));
        this.add(new Quadrado1(Consts.QUADRADOVERDE,new Posicao(9,5)));
        this.add(new Quadrado1(Consts.QUADRADOVERDE,new Posicao(9,7)));
        this.add(new Quadrado1(Consts.QUADRADOVERDE,new Posicao(9,9)));
        
        this.add(new Robo(Consts.ROBOAMARELO,new Posicao(1,4)));
        this.add(new Robo(Consts.ROBOROSA,new Posicao(9,2)));
        this.add(new Robo(Consts.ROBOVERDE,new Posicao(6,1)));
        this.add(new Robo(Consts.ROBOAZUL,new Posicao(6,9)));
        
        this.add(new FrutasConsumiveis(Consts.SOL,new Posicao(0,0)));
        this.add(new FrutasConsumiveis(Consts.CHAVE,new Posicao(10,10)));
        this.add(new FrutasConsumiveis(Consts.LAMPADA,new Posicao(0,10)));
        this.add(new FrutasConsumiveis(Consts.VELA,new Posicao(10,0)));
    }
    
    public void setVitoria(){
        numFase = 5;
        this.clear();
    }
    
    public void resetarFase(Hero unHero){
        switch(numFase){
            case 1:
                this.setFase1(unHero);
                break;
            case 2:
                this.setFase2(unHero);    
                break;
            case 3:
                this.setFase3(unHero);
                break;
            case 4:
                this.setFase4(unHero);
                break;
        }
    }
}
