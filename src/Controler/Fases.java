package Controler;

import Auxiliar.*;
import Modelo.*;
import java.util.ArrayList;

public class Fases extends ArrayList<Elemento> {

    private int numFase = 0; //REPRESENTA FASE A SER JOGADA

    Fases(int Tamanho) {
        super(Tamanho);
    }

    public int getNumFase() {
        return numFase;
    }

    public void setNumFase(int numFase) {
        this.numFase = numFase;
    }

    public void setInicio(Hero unHero) {
        numFase = -1;
        this.clear(); //LIMPA ARRAY DE ELEMENTOS
        unHero.setPosicao(9, 5); //SETA POSIÇÃO INICIAL DO HEROI
        this.add(unHero); //ADICIONA O HEROI NA POSICAO 0 DO ARRAY

        this.add(new Quadrado("LetraS.png", new Posicao(3, 2)));
        this.add(new Quadrado("Letra_k.png", new Posicao(3, 3)));
        this.add(new Quadrado("Letra_o.png", new Posicao(3, 4)));
        this.add(new Quadrado("Letra_o.png", new Posicao(3, 5)));
        this.add(new Quadrado("Letra_t.png", new Posicao(3, 6)));
        this.add(new Quadrado("Letra_e.png", new Posicao(3, 7)));
        this.add(new Quadrado("Letra_r.png", new Posicao(3, 8)));

        this.add(new Quadrado("LetraP.png", new Posicao(5, 1)));
        this.add(new Quadrado("Letra_r.png", new Posicao(5, 2)));
        this.add(new Quadrado("Letra_e.png", new Posicao(5, 3)));
        this.add(new Quadrado("Letra_s.png", new Posicao(5, 4)));
        this.add(new Quadrado("Letra_s.png", new Posicao(5, 5)));
        this.add(new Quadrado("Letra_i.png", new Posicao(5, 6)));
        this.add(new Quadrado("Letra_o.png", new Posicao(5, 7)));
        this.add(new Quadrado("Letra_n.png", new Posicao(5, 8)));
        this.add(new Quadrado("Letra_e.png", new Posicao(5, 9)));

        this.add(new Quadrado("LetraS.png", new Posicao(6, 1)));
        this.add(new Quadrado("Letra_p.png", new Posicao(6, 2)));
        this.add(new Quadrado("Letra_a.png", new Posicao(6, 3)));
        this.add(new Quadrado("Letra_c.png", new Posicao(6, 4)));
        this.add(new Quadrado("Letra_e.png", new Posicao(6, 5)));
        this.add(new Quadrado("Letra_p.png", new Posicao(6, 7)));
        this.add(new Quadrado("Letra_a.png", new Posicao(6, 8)));
        this.add(new Quadrado("Letra_r.png", new Posicao(6, 9)));
        this.add(new Quadrado("Letra_a.png", new Posicao(6, 10)));
        
        this.add(new Quadrado("Letra_i.png", new Posicao(7, 2)));
        this.add(new Quadrado("Letra_n.png", new Posicao(7, 3)));
        this.add(new Quadrado("Letra_i.png", new Posicao(7, 4)));
        this.add(new Quadrado("Letra_c.png", new Posicao(7, 5)));
        this.add(new Quadrado("Letra_i.png", new Posicao(7, 6)));
        this.add(new Quadrado("Letra_a.png", new Posicao(7, 7)));
        this.add(new Quadrado("Letra_r.png", new Posicao(7, 8)));
        

    }

    public void setFase1(Hero unHero) {
        numFase = 1; //REPRESENTA FASE 1 DE JOGO
        this.clear(); //LIMPA ARRAY DE ELEMENTOS
        unHero.setPosicao(4, 4); //SETA POSIÇÃO INICIAL DO HEROI
        this.add(unHero); //ADICIONA O HEROI NA POSICAO 0 DO ARRAY

        //INCLUSÃO DOS ELEMENTOS FIXOS DE CENÁRIO
        this.add(new Quadrado(Consts.QUADRADOVERMELHO, new Posicao(1, 1)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO, new Posicao(1, 3)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO, new Posicao(1, 5)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO, new Posicao(1, 7)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO, new Posicao(1, 9)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO, new Posicao(3, 1)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO, new Posicao(3, 3)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO, new Posicao(3, 5)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO, new Posicao(3, 7)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO, new Posicao(3, 9)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO, new Posicao(5, 1)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO, new Posicao(5, 3)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO, new Posicao(5, 5)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO, new Posicao(5, 7)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO, new Posicao(5, 9)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO, new Posicao(7, 1)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO, new Posicao(7, 3)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO, new Posicao(7, 5)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO, new Posicao(7, 7)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO, new Posicao(7, 9)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO, new Posicao(9, 1)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO, new Posicao(9, 3)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO, new Posicao(9, 5)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO, new Posicao(9, 7)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO, new Posicao(9, 9)));

        //INCLUSÃO DOS ELEMENTOS MÓVEIS DO CENÁRIO
        this.add(new Bloco(Consts.BLOCOVERDE, new Posicao(0, 1)));
        this.add(new Bloco(Consts.BLOCOVERDE, new Posicao(0, 5)));
        this.add(new Bloco(Consts.BLOCOVERDE, new Posicao(1, 2)));
        this.add(new Bloco(Consts.BLOCOVERDE, new Posicao(1, 8)));
        this.add(new Bloco(Consts.BLOCOVERDE, new Posicao(1, 10)));
        this.add(new Bloco(Consts.BLOCOVERDE, new Posicao(2, 1)));
        this.add(new Bloco(Consts.BLOCOVERDE, new Posicao(2, 5)));
        this.add(new Bloco(Consts.BLOCOVERDE, new Posicao(3, 0)));
        this.add(new Bloco(Consts.BLOCOVERDE, new Posicao(3, 8)));
        this.add(new Bloco(Consts.BLOCOVERDE, new Posicao(4, 1)));
        this.add(new Bloco(Consts.BLOCOVERDE, new Posicao(4, 9)));
        this.add(new Bloco(Consts.BLOCOVERDE, new Posicao(5, 2)));
        this.add(new Bloco(Consts.BLOCOVERDE, new Posicao(5, 6)));
        this.add(new Bloco(Consts.BLOCOVERDE, new Posicao(6, 5)));
        this.add(new Bloco(Consts.BLOCOVERDE, new Posicao(6, 7)));
        this.add(new Bloco(Consts.BLOCOVERDE, new Posicao(7, 8)));
        this.add(new Bloco(Consts.BLOCOVERDE, new Posicao(7, 10)));
        this.add(new Bloco(Consts.BLOCOVERDE, new Posicao(8, 3)));
        this.add(new Bloco(Consts.BLOCOVERDE, new Posicao(8, 9)));
        this.add(new Bloco(Consts.BLOCOVERDE, new Posicao(9, 0)));
        this.add(new Bloco(Consts.BLOCOVERDE, new Posicao(9, 2)));
        this.add(new Bloco(Consts.BLOCOVERDE, new Posicao(9, 6)));
        this.add(new Bloco(Consts.BLOCOVERDE, new Posicao(9, 8)));
        this.add(new Bloco(Consts.BLOCOVERDE, new Posicao(10, 7)));

        //INCLUSÃO DOS ROBOS DO CENÁRIO, SETANDO POSIÇÃO INICIAL DOS MESMOS
        this.add(new Robo(Consts.ROBOAMARELO, new Posicao(2, 0)));
        this.add(new Robo(Consts.ROBOROSA, new Posicao(0, 9)));
        this.add(new Robo(Consts.ROBOVERDE, new Posicao(10, 2)));
        this.add(new Robo(Consts.ROBOAZUL, new Posicao(10, 9)));

        //INCLUSÃO DOS ELEMENTOS COLECIONÁVEIS DO CENÁRIO
        this.add(new Consumiveis(Consts.MORANGO, new Posicao(10, 0)));
        this.add(new Consumiveis(Consts.BANANA, new Posicao(0, 10)));
        this.add(new Consumiveis(Consts.CEREJA, new Posicao(10, 10)));
        this.add(new Consumiveis(Consts.UVA, new Posicao(0, 0)));
    }

    public void setFase2(Hero unHero) {
        numFase = 2; //REPRESENTA FASE 2 DO JOGO
        this.clear(); //LIMPA O ARRAY DE ELEMENTOS
        unHero.setPosicao(5, 5); //SETA POSIÇÃO INICIAL DO HEROI
        this.add(unHero); // ADICIONA O HEROI NA POSIÇÃO 0 DO ARRAY

        //INCLUSÃO DOS ELEMENTOS FIXOS DO CENÁRIO
        this.add(new Quadrado(Consts.QUADRADOVERMELHO, new Posicao(1, 3)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO, new Posicao(1, 7)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO, new Posicao(3, 1)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO, new Posicao(3, 3)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO, new Posicao(3, 5)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO, new Posicao(3, 7)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO, new Posicao(3, 9)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO, new Posicao(5, 3)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO, new Posicao(5, 7)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO, new Posicao(7, 1)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO, new Posicao(7, 3)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO, new Posicao(7, 5)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO, new Posicao(7, 7)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO, new Posicao(7, 9)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO, new Posicao(9, 3)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO, new Posicao(9, 7)));

        //INCLUSAO DAS SETAS DE LIMITAÇÃO DE MOVIMENTO DO CENÁRIO
        this.add(new Seta(Consts.SETAPRACIMA, new Posicao(3, 0), 0));
        this.add(new Seta(Consts.SETAPRACIMA, new Posicao(3, 6), 0));
        this.add(new Seta(Consts.SETAPRACIMA, new Posicao(3, 8), 0));
        this.add(new Seta(Consts.SETAPRACIMA, new Posicao(4, 0), 0));
        this.add(new Seta(Consts.SETAPRACIMA, new Posicao(4, 8), 0));
        this.add(new Seta(Consts.SETAPRACIMA, new Posicao(5, 0), 0));
        this.add(new Seta(Consts.SETAPRACIMA, new Posicao(6, 0), 0));
        this.add(new Seta(Consts.SETAPRACIMA, new Posicao(7, 0), 0));
        this.add(new Seta(Consts.SETAPRACIMA, new Posicao(7, 6), 0));
        this.add(new Seta(Consts.SETAPRACIMA, new Posicao(7, 8), 0));
        this.add(new Seta(Consts.SETAPRACIMA, new Posicao(7, 10), 0));

        this.add(new Seta(Consts.SETAPRABAIXO, new Posicao(2, 4), 1));
        this.add(new Seta(Consts.SETAPRABAIXO, new Posicao(3, 2), 1));
        this.add(new Seta(Consts.SETAPRABAIXO, new Posicao(3, 4), 1));
        this.add(new Seta(Consts.SETAPRABAIXO, new Posicao(3, 10), 1));
        this.add(new Seta(Consts.SETAPRABAIXO, new Posicao(7, 2), 1));
        this.add(new Seta(Consts.SETAPRABAIXO, new Posicao(7, 4), 1));

        this.add(new Seta(Consts.SETAPRADIREITA, new Posicao(0, 3), 3));
        this.add(new Seta(Consts.SETAPRADIREITA, new Posicao(0, 7), 3));
        this.add(new Seta(Consts.SETAPRADIREITA, new Posicao(2, 3), 3));
        this.add(new Seta(Consts.SETAPRADIREITA, new Posicao(4, 3), 3));
        this.add(new Seta(Consts.SETAPRADIREITA, new Posicao(4, 7), 3));
        this.add(new Seta(Consts.SETAPRADIREITA, new Posicao(6, 3), 3));
        this.add(new Seta(Consts.SETAPRADIREITA, new Posicao(8, 3), 3));
        this.add(new Seta(Consts.SETAPRADIREITA, new Posicao(8, 7), 3));
        this.add(new Seta(Consts.SETAPRADIREITA, new Posicao(10, 7), 3));

        this.add(new Seta(Consts.SETAPRAESQUERDA, new Posicao(2, 5), 2));
        this.add(new Seta(Consts.SETAPRAESQUERDA, new Posicao(2, 6), 2));
        this.add(new Seta(Consts.SETAPRAESQUERDA, new Posicao(2, 7), 2));
        this.add(new Seta(Consts.SETAPRAESQUERDA, new Posicao(4, 9), 2));
        this.add(new Seta(Consts.SETAPRAESQUERDA, new Posicao(4, 10), 2));
        this.add(new Seta(Consts.SETAPRAESQUERDA, new Posicao(6, 7), 2));
        this.add(new Seta(Consts.SETAPRAESQUERDA, new Posicao(10, 3), 2));

        //INCLUSÃO DOS ROBOS, SETANDO POSIÇÃO INICIAL
        this.add(new Robo(Consts.ROBOAMARELO, new Posicao(1, 1)));
        this.add(new Robo(Consts.ROBOROSA, new Posicao(9, 1)));
        this.add(new Robo(Consts.ROBOVERDE, new Posicao(1, 9)));
        this.add(new Robo(Consts.ROBOAZUL, new Posicao(9, 9)));

        //INCLUSÃO DOS ELEMENTOS COLECIONÁVEIS DO CENÁRIO
        this.add(new Consumiveis(Consts.MORANGO, new Posicao(5, 9)));
        this.add(new Consumiveis(Consts.BANANA, new Posicao(5, 1)));
        this.add(new Consumiveis(Consts.CEREJA, new Posicao(9, 5)));
        this.add(new Consumiveis(Consts.UVA, new Posicao(1, 5)));
    }

    public void setFase3(Hero unHero) {
        numFase = 3; //REPRESENTA FASE 3 DO JOGO
        this.clear(); //LIMPA ARRAY DE ELEMENTOS
        unHero.setPosicao(5, 5); //SETA POSIÇÃO INICIAL DO HEROI
        this.add(unHero); //ADICIONA O HEROI NA POSIÇÃO 0 DO ARRAY

        //INCLUSÃO DOS ELEMENTOS MÓVEIS DO CENÁRIO
        this.add(new Bloco(Consts.BLOCOVERMELHO, new Posicao(1, 1)));
        this.add(new Bloco(Consts.BLOCOVERMELHO, new Posicao(1, 2)));
        this.add(new Bloco(Consts.BLOCOVERMELHO, new Posicao(1, 3)));
        this.add(new Bloco(Consts.BLOCOVERMELHO, new Posicao(1, 4)));
        this.add(new Bloco(Consts.BLOCOVERMELHO, new Posicao(1, 5)));
        this.add(new Bloco(Consts.BLOCOVERMELHO, new Posicao(1, 6)));
        this.add(new Bloco(Consts.BLOCOVERMELHO, new Posicao(1, 7)));
        this.add(new Bloco(Consts.BLOCOVERMELHO, new Posicao(1, 8)));
        this.add(new Bloco(Consts.BLOCOVERMELHO, new Posicao(1, 9)));
        this.add(new Bloco(Consts.BLOCOVERMELHO, new Posicao(2, 1)));
        this.add(new Bloco(Consts.BLOCOVERMELHO, new Posicao(2, 9)));
        this.add(new Bloco(Consts.BLOCOVERMELHO, new Posicao(3, 1)));
        this.add(new Bloco(Consts.BLOCOVERMELHO, new Posicao(3, 3)));
        this.add(new Bloco(Consts.BLOCOVERMELHO, new Posicao(3, 4)));
        this.add(new Bloco(Consts.BLOCOVERMELHO, new Posicao(3, 5)));
        this.add(new Bloco(Consts.BLOCOVERMELHO, new Posicao(3, 6)));
        this.add(new Bloco(Consts.BLOCOVERMELHO, new Posicao(3, 7)));
        this.add(new Bloco(Consts.BLOCOVERMELHO, new Posicao(3, 9)));
        this.add(new Bloco(Consts.BLOCOVERMELHO, new Posicao(4, 1)));
        this.add(new Bloco(Consts.BLOCOVERMELHO, new Posicao(4, 3)));
        this.add(new Bloco(Consts.BLOCOVERMELHO, new Posicao(4, 7)));
        this.add(new Bloco(Consts.BLOCOVERMELHO, new Posicao(4, 9)));
        this.add(new Bloco(Consts.BLOCOVERMELHO, new Posicao(5, 1)));
        this.add(new Bloco(Consts.BLOCOVERMELHO, new Posicao(5, 3)));
        this.add(new Bloco(Consts.BLOCOVERMELHO, new Posicao(5, 7)));
        this.add(new Bloco(Consts.BLOCOVERMELHO, new Posicao(5, 9)));
        this.add(new Bloco(Consts.BLOCOVERMELHO, new Posicao(6, 1)));
        this.add(new Bloco(Consts.BLOCOVERMELHO, new Posicao(6, 3)));
        this.add(new Bloco(Consts.BLOCOVERMELHO, new Posicao(6, 7)));
        this.add(new Bloco(Consts.BLOCOVERMELHO, new Posicao(6, 9)));
        this.add(new Bloco(Consts.BLOCOVERMELHO, new Posicao(7, 1)));
        this.add(new Bloco(Consts.BLOCOVERMELHO, new Posicao(7, 3)));
        this.add(new Bloco(Consts.BLOCOVERMELHO, new Posicao(7, 4)));
        this.add(new Bloco(Consts.BLOCOVERMELHO, new Posicao(7, 5)));
        this.add(new Bloco(Consts.BLOCOVERMELHO, new Posicao(7, 6)));
        this.add(new Bloco(Consts.BLOCOVERMELHO, new Posicao(7, 7)));
        this.add(new Bloco(Consts.BLOCOVERMELHO, new Posicao(7, 9)));
        this.add(new Bloco(Consts.BLOCOVERMELHO, new Posicao(8, 1)));
        this.add(new Bloco(Consts.BLOCOVERMELHO, new Posicao(8, 9)));
        this.add(new Bloco(Consts.BLOCOVERMELHO, new Posicao(9, 1)));
        this.add(new Bloco(Consts.BLOCOVERMELHO, new Posicao(9, 2)));
        this.add(new Bloco(Consts.BLOCOVERMELHO, new Posicao(9, 3)));
        this.add(new Bloco(Consts.BLOCOVERMELHO, new Posicao(9, 4)));
        this.add(new Bloco(Consts.BLOCOVERMELHO, new Posicao(9, 5)));
        this.add(new Bloco(Consts.BLOCOVERMELHO, new Posicao(9, 6)));
        this.add(new Bloco(Consts.BLOCOVERMELHO, new Posicao(9, 7)));
        this.add(new Bloco(Consts.BLOCOVERMELHO, new Posicao(9, 8)));
        this.add(new Bloco(Consts.BLOCOVERMELHO, new Posicao(9, 9)));

        //INCLUSÃO DOS ROBOS DO JOGO
        this.add(new Robo(Consts.ROBOAMARELO, new Posicao(0, 5)));
        this.add(new Robo(Consts.ROBOROSA, new Posicao(2, 5)));
        this.add(new Robo(Consts.ROBOVERDE, new Posicao(8, 5)));
        this.add(new Robo(Consts.ROBOAZUL, new Posicao(10, 5)));

        //INCLUSÃO DOS ELEMENTOS COLECIONÁVEIS NO CENÁRIO
        this.add(new Consumiveis(Consts.SOL, new Posicao(5, 0)));
        this.add(new Consumiveis(Consts.CHAVE, new Posicao(5, 10)));
        this.add(new Consumiveis(Consts.LAMPADA, new Posicao(5, 8)));
        this.add(new Consumiveis(Consts.VELA, new Posicao(5, 2)));
    }

    public void setFase4(Hero unHero) {
        numFase = 4; //REPRESENTA A FASE 4 DO JOGO
        this.clear(); //LIMPANDO O ARRAY DE ELEMENTOS
        unHero.setPosicao(5, 5); //SETA POSIÇÃO INICIAL DO HEROI
        this.add(unHero); //ADICIONA O HEROI NA POSIÇÃO 0 DO ARRAY

        //INCLUSÃO DOS ELEMENTOS FIXOS DO CENÁRIO
        this.add(new Quadrado(Consts.QUADRADOVERMELHO, new Posicao(0, 3)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO, new Posicao(0, 7)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO, new Posicao(1, 0)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO, new Posicao(1, 8)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO, new Posicao(2, 5)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO, new Posicao(3, 2)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO, new Posicao(3, 10)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO, new Posicao(5, 2)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO, new Posicao(5, 8)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO, new Posicao(6, 3)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO, new Posicao(7, 0)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO, new Posicao(8, 1)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO, new Posicao(8, 7)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO, new Posicao(8, 10)));
        this.add(new Quadrado(Consts.QUADRADOVERMELHO, new Posicao(10, 1)));

        //INCLUSÃO DOS ELEMENTOS RETIRÁVEIS DO CENÁRIO
        this.add(new Quadrado1(Consts.QUADRADOVERDE, new Posicao(1, 1)));
        this.add(new Quadrado1(Consts.QUADRADOVERDE, new Posicao(1, 3)));
        this.add(new Quadrado1(Consts.QUADRADOVERDE, new Posicao(1, 5)));
        this.add(new Quadrado1(Consts.QUADRADOVERDE, new Posicao(1, 7)));
        this.add(new Quadrado1(Consts.QUADRADOVERDE, new Posicao(1, 9)));
        this.add(new Quadrado1(Consts.QUADRADOVERDE, new Posicao(2, 2)));
        this.add(new Quadrado1(Consts.QUADRADOVERDE, new Posicao(2, 4)));
        this.add(new Quadrado1(Consts.QUADRADOVERDE, new Posicao(2, 6)));
        this.add(new Quadrado1(Consts.QUADRADOVERDE, new Posicao(2, 8)));
        this.add(new Quadrado1(Consts.QUADRADOVERDE, new Posicao(3, 1)));
        this.add(new Quadrado1(Consts.QUADRADOVERDE, new Posicao(3, 3)));
        this.add(new Quadrado1(Consts.QUADRADOVERDE, new Posicao(3, 5)));
        this.add(new Quadrado1(Consts.QUADRADOVERDE, new Posicao(3, 7)));
        this.add(new Quadrado1(Consts.QUADRADOVERDE, new Posicao(3, 9)));
        this.add(new Quadrado1(Consts.QUADRADOVERDE, new Posicao(4, 2)));
        this.add(new Quadrado1(Consts.QUADRADOVERDE, new Posicao(4, 4)));
        this.add(new Quadrado1(Consts.QUADRADOVERDE, new Posicao(4, 6)));
        this.add(new Quadrado1(Consts.QUADRADOVERDE, new Posicao(4, 8)));
        this.add(new Quadrado1(Consts.QUADRADOVERDE, new Posicao(5, 1)));
        this.add(new Quadrado1(Consts.QUADRADOVERDE, new Posicao(5, 3)));
        this.add(new Quadrado1(Consts.QUADRADOVERDE, new Posicao(5, 7)));
        this.add(new Quadrado1(Consts.QUADRADOVERDE, new Posicao(5, 9)));
        this.add(new Quadrado1(Consts.QUADRADOVERDE, new Posicao(6, 2)));
        this.add(new Quadrado1(Consts.QUADRADOVERDE, new Posicao(6, 4)));
        this.add(new Quadrado1(Consts.QUADRADOVERDE, new Posicao(6, 6)));
        this.add(new Quadrado1(Consts.QUADRADOVERDE, new Posicao(6, 8)));
        this.add(new Quadrado1(Consts.QUADRADOVERDE, new Posicao(7, 1)));
        this.add(new Quadrado1(Consts.QUADRADOVERDE, new Posicao(7, 3)));
        this.add(new Quadrado1(Consts.QUADRADOVERDE, new Posicao(7, 5)));
        this.add(new Quadrado1(Consts.QUADRADOVERDE, new Posicao(7, 7)));
        this.add(new Quadrado1(Consts.QUADRADOVERDE, new Posicao(7, 9)));
        this.add(new Quadrado1(Consts.QUADRADOVERDE, new Posicao(8, 2)));
        this.add(new Quadrado1(Consts.QUADRADOVERDE, new Posicao(8, 4)));
        this.add(new Quadrado1(Consts.QUADRADOVERDE, new Posicao(8, 6)));
        this.add(new Quadrado1(Consts.QUADRADOVERDE, new Posicao(8, 8)));
        this.add(new Quadrado1(Consts.QUADRADOVERDE, new Posicao(9, 1)));
        this.add(new Quadrado1(Consts.QUADRADOVERDE, new Posicao(9, 3)));
        this.add(new Quadrado1(Consts.QUADRADOVERDE, new Posicao(9, 5)));
        this.add(new Quadrado1(Consts.QUADRADOVERDE, new Posicao(9, 7)));
        this.add(new Quadrado1(Consts.QUADRADOVERDE, new Posicao(9, 9)));

        //INCLUSÃO DOS ROBOS, SETANDO A POSIÇÃO INICIAL NO CENÁRIO
        this.add(new Robo(Consts.ROBOAMARELO, new Posicao(1, 4)));
        this.add(new Robo(Consts.ROBOROSA, new Posicao(9, 2)));
        this.add(new Robo(Consts.ROBOVERDE, new Posicao(6, 1)));
        this.add(new Robo(Consts.ROBOAZUL, new Posicao(6, 9)));

        //INCLUSÃO DOS ELEMENTOS COLECIONÁVEIS DO CENÁRIO
        this.add(new Consumiveis(Consts.SOL, new Posicao(0, 0)));
        this.add(new Consumiveis(Consts.CHAVE, new Posicao(10, 10)));
        this.add(new Consumiveis(Consts.LAMPADA, new Posicao(0, 10)));
        this.add(new Consumiveis(Consts.VELA, new Posicao(10, 0)));
    }

    //INSTRUÇÃO PARA CASO DE VITÓRIA
    public void setVitoria(Hero unHero) {
        numFase = 5; //REPRESENTA VITÓRIA NO JOGO
        this.clear(); //LIMPA ARRAY DE ELEMENTOS 
        unHero.setPosicao(4, 5); //POSICIONA O HEROI NA TELA
        this.add(unHero); //ADICIONA O HEROI NA POSIÇÃO 0 DO CENÁRIO

        //INCLUSÃO DOS ELEMENTOS DA MENSAGEM FINAL
        this.add(new Quadrado("LetraP.png", new Posicao(3, 2)));
        this.add(new Quadrado("Letra_a.png", new Posicao(3, 3)));
        this.add(new Quadrado("Letra_r.png", new Posicao(3, 4)));
        this.add(new Quadrado("Letra_a.png", new Posicao(3, 5)));
        this.add(new Quadrado("Letra_b.png", new Posicao(3, 6)));
        this.add(new Quadrado("Letra_e.png", new Posicao(3, 7)));
        this.add(new Quadrado("Letra_n.png", new Posicao(3, 8)));
        this.add(new Quadrado("Letra_s.png", new Posicao(3, 9)));
        
        this.add(new Quadrado("LetraB.png", new Posicao(8, 4)));
        this.add(new Quadrado("Letra_r.png", new Posicao(8, 5)));
        this.add(new Quadrado("Letra_u.png", new Posicao(8, 6)));
        this.add(new Quadrado("Letra_n.png", new Posicao(8, 7)));
        this.add(new Quadrado("Letra_o.png", new Posicao(8, 8)));
        
        this.add(new Quadrado("LetraM.png", new Posicao(9, 4)));
        this.add(new Quadrado("Letra_a.png", new Posicao(9, 5)));
        this.add(new Quadrado("Letra_r.png", new Posicao(9, 6)));
        this.add(new Quadrado("Letra_c.png", new Posicao(9, 7)));
        this.add(new Quadrado("Letra_i.png", new Posicao(9, 8)));
        this.add(new Quadrado("Letra_o.png", new Posicao(9, 9)));
    }

    //INSTRUÇÃO PARA CASO DE DERROTA
    public void setDerrota(Hero unHero) {
        numFase = 0; //REPRESENTA FIM DE JOGO
        this.clear(); //LIMPA ARRAY DE ELEMENTOS
        unHero.setPosicao(4, 5); //POSICIONA O HEROI NA TELA
        this.add(unHero); //ADICIONA O HEROI NA POSIÇÃO 0 DO CENÁRIO

        //INCLUSÃO DOS ELEMENTOS DA MENSAGEM FINAL
        this.add(new Quadrado("LetraG.png", new Posicao(3, 1)));
        this.add(new Quadrado("Letra_a.png", new Posicao(3, 2)));
        this.add(new Quadrado("Letra_m.png", new Posicao(3, 3)));
        this.add(new Quadrado("Letra_e.png", new Posicao(3, 4)));
        this.add(new Quadrado("LetraO.png", new Posicao(3, 6)));
        this.add(new Quadrado("Letra_v.png", new Posicao(3, 7)));
        this.add(new Quadrado("Letra_e.png", new Posicao(3, 8)));
        this.add(new Quadrado("Letra_r.png", new Posicao(3, 9)));
        
        this.add(new Quadrado("LetraB.png", new Posicao(8, 4)));
        this.add(new Quadrado("Letra_r.png", new Posicao(8, 5)));
        this.add(new Quadrado("Letra_u.png", new Posicao(8, 6)));
        this.add(new Quadrado("Letra_n.png", new Posicao(8, 7)));
        this.add(new Quadrado("Letra_o.png", new Posicao(8, 8)));
        
        this.add(new Quadrado("LetraM.png", new Posicao(9, 4)));
        this.add(new Quadrado("Letra_a.png", new Posicao(9, 5)));
        this.add(new Quadrado("Letra_r.png", new Posicao(9, 6)));
        this.add(new Quadrado("Letra_c.png", new Posicao(9, 7)));
        this.add(new Quadrado("Letra_i.png", new Posicao(9, 8)));
        this.add(new Quadrado("Letra_o.png", new Posicao(9, 9)));
    }

    //INSTRUÇÃO PARA RESETAR A FASE QUANDO HEROI MORRE PRO ROBO
    public void resetarFase(Hero unHero) {
        System.out.println("Vida do Heroi: " + unHero.getNumeroDeVida());
        switch (numFase) {
            case 0:
                this.setDerrota(unHero);
                break;
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
            case 5:
                this.setVitoria(unHero);
                break;
        }
    }
}
