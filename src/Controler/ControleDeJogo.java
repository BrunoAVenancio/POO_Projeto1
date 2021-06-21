package Controler;

import Auxiliar.*;
import Modelo.*;
import java.util.ArrayList;

/**
 *
 * @author junio
 */
//CLASSE RESPONSAVEL PELO CONTROLE DOS ELEMENTOS DO JOGO
public class ControleDeJogo {

    //INSTRUCAO PARA DESENHAR TODOS OS ELEMENTOS DO ARRAY
    public void desenhaTudo(ArrayList<Elemento> e) {
        for (int i = e.size()-1; i >=0; i--) {
            e.get(i).autoDesenho();
        }
    }

    //INSTRUCAO PARA PROCESSAR TODOS OS ELEMENTOS DO ARRAY E VALIDA-LOS
    public void processaTudo(ArrayList<Elemento> e) {
        Hero hHero = (Hero) e.get(0);
        /*O heroi (protagonista) eh sempre o primeiro do array*/
        Elemento eTemp;
        /*Processa todos os demais em relacao ao heroi*/
        for (int i = 1; i < e.size(); i++) {
            eTemp = e.get(i);
            /*Pega o i-esimo elemento do jogo*/
 /*Verifica se o heroi se sobrepoe ao i-ésimo elemento*/
            if (hHero.getPosicao().estaNaMesmaPosicao(eTemp.getPosicao())) /*Nem todos os elementos podem ser transpostos pelo heroi*/ {
                if (eTemp.isbTransponivel() && !eTemp.isbTravessia()) {
                    e.remove(eTemp);
                }
            }
        }
    }

    //INSTRUCAO PARA VALIDAR POSIÇÃO
    public boolean ehPosicaoValidaRelativoUmPersonagem(ArrayList<Elemento> e, Elemento unElemento) {
        Elemento eTemp;
        for (int i = 1; i < e.size(); i++) { //VARRE TODOS OS ELEMENTOS DO ARRAY DE ELEMENTOS
            eTemp = e.get(i);
            if (eTemp == unElemento) //VERIFICA SE O ELEMENTO DO ARRAY NAO O ELEMENTO A SER VALIDADA A POSIÇÃO
            {
                continue;
            }
            if ((!eTemp.isbTransponivel() || eTemp.isbColecional())) { //VERIFICA SE O ELEMENTO É TRANSPONIVEL OU COLECIONAVEL
                if (eTemp.getPosicao().estaNaMesmaPosicao(unElemento.getPosicao())) {
                    return false; //RETORNA FALSE SE A POSIÇÃO NÃO É VÁLIDA
                }
            }
        }
        return true; //RETORNA TRUE SE A POSIÇÃO É VÁLIDA
    }

    //Movimenta o heroi a uma posicao e interage de acordo com o elemento que esta na mesma posicao
    public boolean moverHeroi(ArrayList<Elemento> e, int linha, int coluna, Hero unHero, Fases fase) {
        Elemento eTemp;
        if (linha < 0 || linha > 10 || coluna < 0 || coluna > 10) { //VERIFICA SE A POSIÇÃO FORNECIDA ESTA DENTRO DOS LIMITES DE TELA
            return false; //RETORNA FALSA SE A POSIÇÃO É INVÁLIDA
        }
        Hero heroTemp = new Hero("");
        heroTemp.setPosicao(linha, coluna);
        for (int i = 1; i < e.size(); i++) {  //VARRE ARRAY DE ELEMENTOS
            eTemp = e.get(i);
            if (eTemp.isbRobo()) { //VERIFICA SE O ELEMENTO É UM ROBO
                if (eTemp.getPosicao().estaNaMesmaPosicao(heroTemp.getPosicao())) { //VALIDA A SOBREPOSIÇÃO
                    unHero.setNumeroDeVida(unHero.getNumeroDeVida() - 1); //ELEIMINA VIDA EM ENCONTRO COM ROBO
                    fase.resetarFase(unHero); //RESETA A FASE AO INÍCIO
                    return false; //RETORNA FALSO QUANDO HEROI ESBARRA EM MONSTRO
                }
            }
            if ((!eTemp.isbTransponivel() && (!eTemp.isbTravessia()) || eTemp.getbDirecao() != unHero.getbDirecao()) && !eTemp.isbColecional() ) { //SE OBJETO É INSTRANSPONÍVEL OU COLECIONÁVEL RETORNA FALSE TAMBÉM
                if (eTemp.getPosicao().estaNaMesmaPosicao(heroTemp.getPosicao())) {
                    return false;
                }
            }
        }
        unHero.setPosicao(linha, coluna); //REPOSICIONA O HEROI A POSICAO INFORMADA
        return true; // RETORNA TRUE QUANDO HEROI NAO ESBARRA EM ELEMENTO ALGUM
    }

    //INSTRUCAO ṔARA VALIDAR A POSIÇÃO DE MOVIMENTO DOS ROBOS
    public boolean ehPosicaoValidaAoRobo(ArrayList<Elemento> e, int linha, int coluna) {
        Elemento eTemp;
        if (linha < 0 || linha > 10 || coluna < 0 || coluna > 10) {//VERIFICA SE A POSIÇÃO FORNECIDA ESTA DENTRO DOS LIMITES DE TELA
            return false; //RETORNA FALSA SE A POSIÇÃO É INVÁLIDA
        }
        Robo roboTemp = new Robo(Consts.ROBOROSA, new Posicao(linha, coluna)); //MONTA ROBO TEMPORARIO COM POSIÇÃO FORNECIDA
        for (int i = 1; i < e.size(); i++) { // VARRE O ARRAY DE ELEMENTOS
            eTemp = e.get(i);
            if (eTemp.isbTravessia() || !eTemp.isbTransponivel() || eTemp.isbColecional()) { //VERIFICA SE O ELEMENTO EM OBSERVAÇÃO É ATRAVESSAVEL OU INTRASNPONÍVEL OU COLECIONÁVEL
                if (eTemp.getPosicao().estaNaMesmaPosicao(roboTemp.getPosicao())) {
                    return false; //RETORNA FALSE QUANDO ROBO CHOCA COM O ELEMENTO
                }
            }
        }
        return true; //RETORNA TRUE QUANDO ROBO NAO SE CHOCA COM NADA
    }

    //INSTRUCAO PARA DIMINUIR A VIDA DO HEROI EM CASO DE CONTATO COM OS ROBOS
    public boolean MatarHeroi(Hero unHero, Fases fase, Robo unRobo) {
        if (unHero.getPosicao().estaNaMesmaPosicao(unRobo.getPosicao())) { //VERIFICA SE O ROBO E O HEROI ESTAO NA MESMA POSICAO
            unHero.setNumeroDeVida(unHero.getNumeroDeVida() - 1); //DIMINUI A VIDA DO HEROI QUANDO SE ENCONTRAM
            fase.resetarFase(unHero); //RESETA A FASE
            return true; //RETORNA TRUE QUANDO ROBO E HEROI SE SOBREPOE
        }
        return false; //RETORNA FALSE QUANDO NÃO HÁ COLISÃO DO HEROI COM ROBO
    }

    //INSTRUCAO PARA REMOVER ELEMENTOS DA TELA CONFORME MOVIMENTACAO DO HEROI
    public boolean RemoveElemento(ArrayList<Elemento> e, Hero unHero) {
        Elemento eTemp;
        for (int i = 1; i < e.size(); i++) { //VARRE O ARRAY DE ELEMENTOS
            eTemp = e.get(i);
            if (eTemp.isbRetiravel() && unHero.getbDirecao() == 0) { //VERIFICA SE O OBJETO É RETIRÁVEL E O HEROI SE MOVE PARA CIMA
                if (eTemp.getPosicao().getLinha() == unHero.getPosicao().getLinha() - 1 && eTemp.getPosicao().getColuna() == unHero.getPosicao().getColuna()) {
                    // VERIFICA SE O ELEMENTO RETIRÁVEL ESTÁ A FRENTE DO HEROI
                    e.remove(i); //REMOVE O RETIRÁVEL DO ARRAY DE ELEMENTOS
                    return true; //RETORNA TRUE QUANDO HEROI REMOVE UM RETIRÁVEL
                }
            } else if (eTemp.isbRetiravel() && unHero.getbDirecao() == 1) { // MESMA VERIFICACAO ANTERIOR PARA QUANDO HEROI SE MOVE PARA BAIXO
                if (eTemp.getPosicao().getLinha() == unHero.getPosicao().getLinha() + 1 && eTemp.getPosicao().getColuna() == unHero.getPosicao().getColuna()) {
                    e.remove(i);
                    return true;
                }
            } else if (eTemp.isbRetiravel() && unHero.getbDirecao() == 2) { // MESMA VERIFICACAO ANTERIOR PARA QUANDO HEROI SE MOVE PARA ESQUERDA
                if (eTemp.getPosicao().getLinha() == unHero.getPosicao().getLinha() && eTemp.getPosicao().getColuna() == unHero.getPosicao().getColuna() - 1) {
                    e.remove(i);
                    return true;
                }
            } else if (eTemp.isbRetiravel() && unHero.getbDirecao() == 3) {  // MESMA VERIFICACAO ANTERIOR PARA QUANDO HEROI SE MOVE PARA DIREITA
                if (eTemp.getPosicao().getLinha() == unHero.getPosicao().getLinha() && eTemp.getPosicao().getColuna() == unHero.getPosicao().getColuna() + 1) {
                    e.remove(i);
                    return true;
                }
            }
        }
        return false; //RETORNA FALSE QUANDO HEROI NAO ENCONTRA ELEMENTO COLECIONAVEL A FRENTE DELE
    }

    //INSTRUCAO PARA MOVER OS BLOCOS MÓVEIS DA FASE 1 E 3 DO JOGO
    public boolean MoverElemento(ArrayList<Elemento> e, Hero unHero) {
        Elemento eTemp;
        for (int i = 1; i < e.size(); i++) { //VARRE O ARRAY DE ELEMENTOS
            eTemp = e.get(i);
            if (eTemp.isbMovel() && unHero.getbDirecao() == 0) { //VERIFICA SE O ELEMENTO É MÓVEL E O HEROI ESTÁ SE MOVENDO PARA CIMA
                if (eTemp.getPosicao().getLinha() == (unHero.getPosicao().getLinha() - 1) && eTemp.getPosicao().getColuna() == unHero.getPosicao().getColuna()){ 
                    //VERIFICA SE O ELEMENTO ESTÁ A FRENTE DO HEROI
                    e.get(i).setPosicao(eTemp.getPosicao().getLinha() - 1, eTemp.getPosicao().getColuna()); //MOVIMENTO O ELEMENTO PARA CIMA
                    if (!this.ehPosicaoValidaRelativoUmPersonagem(e, e.get(i))) { //VERIFICA SE O MOVIMENTO É VALIDO
                        e.get(i).getPosicao().volta();
                        return false; //RETORNA FALSE QUANDO O ELEMENTO MÓVEL NÃO PODE SER MOVIDO
                    }
                    return true; //RETORNA TRUE QUANDO O ELEMENTO MÓVEL É MOVIDO
                }
            } else if (eTemp.isbMovel() && unHero.getbDirecao() == 1) { //MESMA VERIFICAÇÃO ACIMA, PORÉM QUANDO HEROI SE MOVIMENTA PARA BAIXO
                if (eTemp.getPosicao().getLinha() == (unHero.getPosicao().getLinha() + 1) && eTemp.getPosicao().getColuna() == unHero.getPosicao().getColuna() /*&& !this.ehPosicaoValidaRelativoUmPersonagem(e, unHero)*/) {
                    e.get(i).setPosicao(eTemp.getPosicao().getLinha() + 1, eTemp.getPosicao().getColuna());
                    if (!this.ehPosicaoValidaRelativoUmPersonagem(e, e.get(i))) {
                        e.get(i).getPosicao().volta();
                        return false;
                    }
                    return true;
                }
            } else if (eTemp.isbMovel() && unHero.getbDirecao() == 2) { //MESMA VERIFICAÇÃO ACIMA, PORÉM QUANDO HEROI SE MOVIMENTA PARA ESQUERDA
                if (eTemp.getPosicao().getLinha() == unHero.getPosicao().getLinha() && eTemp.getPosicao().getColuna() == (unHero.getPosicao().getColuna() - 1) /*&& !this.ehPosicaoValidaRelativoUmPersonagem(e, unHero)*/) {
                    e.get(i).setPosicao(eTemp.getPosicao().getLinha(), eTemp.getPosicao().getColuna() - 1);
                    if (!this.ehPosicaoValidaRelativoUmPersonagem(e, e.get(i))) {
                        e.get(i).getPosicao().volta();
                        return false;
                    }
                    return true;
                }
            } else if (eTemp.isbMovel() && unHero.getbDirecao() == 3) { //MESMA VERIFICAÇÃO ACIMA, PORÉM QUANDO HEROI SE MOVIMENTA PARA DIREITA
                if (eTemp.getPosicao().getLinha() == unHero.getPosicao().getLinha() && eTemp.getPosicao().getColuna() == (unHero.getPosicao().getColuna() + 1) /*&& !this.ehPosicaoValidaRelativoUmPersonagem(e, unHero)*/) {
                    e.get(i).setPosicao(eTemp.getPosicao().getLinha(), eTemp.getPosicao().getColuna() + 1);
                    if (!this.ehPosicaoValidaRelativoUmPersonagem(e, e.get(i))) {
                        e.get(i).getPosicao().volta();
                        return false;
                    }
                    return true;
                }
            }
        }
        return false; //RETORNA FALSE QUANDO NENHUM ELEMENTO FOI MOVIDO
    }

    //INSTRUCAO PARA VERIFICAR SE O ELEMENTO QUE O HEROI ESTA INTERAGINDO É UM ELEMENTO COLECIONAVEL
    public boolean ElementoColecionavel(ArrayList<Elemento> e, Hero unHero) {
        Elemento eTemp;
        for (int i = 1; i < e.size(); i++) { //VARRE O ARRAY DE ELEMENTOS
            eTemp = e.get(i);
            if (eTemp.isbColecional() && unHero.getbDirecao() == 0) { //VERIFICA SE O ELEMENTO É COLECIONAVEL E O HEROI ESTÁ SE MOVENDO PARA CIMA
                if (eTemp.getPosicao().getLinha() == (unHero.getPosicao().getLinha() - 1) && eTemp.getPosicao().getColuna() == unHero.getPosicao().getColuna() && !this.ehPosicaoValidaRelativoUmPersonagem(e, unHero)) {
                    //VERIFICA SE O ELEMENTO A FRENTE DO HEROI É COLECIONAVEL
                    e.remove(i); //REMOVE O ELEMENTO COLECIONÁVEL DO ARRAY DE ELEMENTOS
                    return true; //RETORNA TRUE QUANDO ELEMENTO COLECIONÁVEL É RETIRADO DO ARRAY
                }
            } else if (eTemp.isbColecional() && unHero.getbDirecao() == 1) { //MESMA VERIFICAÇÃO ACIMA, PORÉM QUANDO HEROI SE MOVIMENTA PARA BAIXO
                if (eTemp.getPosicao().getLinha() == (unHero.getPosicao().getLinha() + 1) && eTemp.getPosicao().getColuna() == unHero.getPosicao().getColuna() && !this.ehPosicaoValidaRelativoUmPersonagem(e, unHero)) {
                    e.remove(i);
                    return true;
                }
            } else if (eTemp.isbColecional() && unHero.getbDirecao() == 2) { //MESMA VERIFICAÇÃO ACIMA, PORÉM QUANDO HEROI SE MOVIMENTA PARA ESQUERDA
                if (eTemp.getPosicao().getLinha() == unHero.getPosicao().getLinha() && eTemp.getPosicao().getColuna() == (unHero.getPosicao().getColuna() - 1) && !this.ehPosicaoValidaRelativoUmPersonagem(e, unHero)) {
                    e.remove(i);
                    return true;
                }
            } else if (eTemp.isbColecional() && unHero.getbDirecao() == 3) { //MESMA VERIFICAÇÃO ACIMA, PORÉM QUANDO HEROI SE MOVIMENTA PARA DIREITA
                if (eTemp.getPosicao().getLinha() == unHero.getPosicao().getLinha() && eTemp.getPosicao().getColuna() == (unHero.getPosicao().getColuna() + 1) && !this.ehPosicaoValidaRelativoUmPersonagem(e, unHero)) {
                    e.remove(i);
                    return true;
                }
            }
        }
        return false; //RETORNA FALSE QUANDO NENHUM ELEMENTO COLECIONÁVEL FOI RETIRADO
    }

    //INSTRUCAO PARA VERIFICAR SE AINDA EXISTEM ELEMENTOS COLECIONAVEIS NO ARRAY DE ELEMENTOS DA FASE
    public boolean ahColecionaveisAinda(ArrayList<Elemento> e) {
        Elemento eTemp;
        for (int i = 1; i < e.size(); i++) { //VARRE O ARRAY DE ELEMENTOS
            if (e.get(i).isbColecional()) { //VERIFICA SE EXISTE ALGUM ELEMENTO COLECIONÁVEL NO ARRAY
                return true; //RETORNA TRUE QUANDO ENCONTRA UM ELEMENTO COLECIONÁVEL NO ARRAY
            }
        }
        return false; //RETORNA FALSE QUANDO NÃO ENCONTRA ELEMENTO COLECIONÁVEL NO ARRAY
    }
    
    //USADO NA FASE 2 DAS SETAS, PARA VERIFICAR SE AS DIRECOES DO HEROI E DA SETA QUE IRA SUBIR SAO OPOSTAS, SE FOR , RETORNA TRUE PARA IMPEDIR QUE O HEROI SUBA NELA
    public boolean saoDirecoesOpostas(int direcaoHeroi,  int direcaoSeta){
        if(direcaoHeroi == 0 && direcaoSeta == 1)
            return true;
        else if(direcaoHeroi == 1 && direcaoSeta == 0)
            return true;
        else if(direcaoHeroi == 2 && direcaoSeta == 3)
            return true;
        else if(direcaoHeroi == 3 && direcaoSeta == 2)
            return true;
                    
        return false;
    }

        //INSTRUCAO PARA MOVIMENTAR O HEROI PELAS SETAS DA FASE 2, SOMENTE RETORNA TRUE SE ANDAR EM CIMA DE UMA SETA
    public boolean moverHeroiNaFaseComSetas(ArrayList<Elemento> e, int linha, int coluna, Hero unHero, Fases fase) {
        Elemento eTemp;
        if (linha < 0 || linha > 10 || coluna < 0 || coluna > 10) { //VERIFICA SE A POSIÇÃO FORNECIDA ESTA DENTRO DOS LIMITES DE TELA
            return false; //RETORNA FALSA SE A POSIÇÃO É INVÁLIDA
        }
        Hero heroTemp = new Hero("");
        heroTemp.setPosicao(linha, coluna);
        for (int i = 1; i < e.size(); i++) {  //VARRE ARRAY DE ELEMENTOS
            eTemp = e.get(i);
            if (eTemp.isbRobo()) { //VERIFICA SE O ELEMENTO É UM ROBO
                if (eTemp.getPosicao().estaNaMesmaPosicao(heroTemp.getPosicao())) { //VALIDA A SOBREPOSIÇÃO
                    unHero.setNumeroDeVida(unHero.getNumeroDeVida() - 1); //ELEIMINA VIDA EM ENCONTRO COM ROBO
                    fase.resetarFase(unHero); //RESETA A FASE AO INÍCIO
                    return false; //RETORNA FALSO QUANDO HEROI ESBARRA EM MONSTRO
                }
            }
            else if(eTemp.isbTravessia()){ //VERIFICA SE É UMA SETA
                if(eTemp.getPosicao().estaNaMesmaPosicao(heroTemp.getPosicao()) && !(saoDirecoesOpostas(unHero.getbDirecao(),eTemp.getbDirecao()))){
                    unHero.setPosicao(linha, coluna); //REPOSICIONA O HEROI A POSICAO INFORMADA
                    unHero.setbDirecao(eTemp.getbDirecao()); //SETA A NOVA DIRECAO DO HEROI CONFORME ONDE A SETA APONTA
                    return true;
                }
            }
            if (!eTemp.isbTransponivel()  && !eTemp.isbColecional() ) { //SE OBJETO É INSTRANSPONÍVEL OU COLECIONÁVEL RETORNA FALSE TAMBÉM
                if (eTemp.getPosicao().estaNaMesmaPosicao(heroTemp.getPosicao())) {
                    return false;
                }
            }
        }
        unHero.setPosicao(linha, coluna); //REPOSICIONA O HEROI A POSICAO INFORMADA
        return false; 
    }
}
