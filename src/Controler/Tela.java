package Controler;

import Modelo.*;
import Auxiliar.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.logging.*;

/**
 *
 * @author junio
 */
public class Tela extends javax.swing.JFrame implements MouseListener, KeyListener {

    private Hero hHero;
    private ArrayList<Elemento> eElementos;
    private Fases Fase;
    private ControleDeJogo cControle = new ControleDeJogo();
    private Graphics g2;

    public Tela() {
        Desenhador.setCenario(this);
        
        initComponents();

        this.addMouseListener(this);
        
        this.addKeyListener(this);
        
        /*Cria a janela do tamanho do cenario + insets (bordas) da janela*/
        this.setSize(Consts.DIMENSAO_TELA * Consts.TAMANHO_CELULA + getInsets().left + getInsets().right,
                Consts.DIMENSAO_TELA * Consts.TAMANHO_CELULA + getInsets().top + getInsets().bottom);

        /*Este array vai guardar os elementos graficos*/
        eElementos = new ArrayList<Elemento>(150);
        
        /*CRIANDO PROTAGONISTA, necessariamente precisa estar na posicao 0 do array*/
        hHero = new Hero("Skooter1.png");
        
        //INICIA O JOGO NA FASE1
        Fase = new Fases(150);
        Fase.setFase1(hHero);
        eElementos = Fase; //ADICIONA OS ELEMENTOS DA FASE1 NO ARRAY DE ELEMENTOS
    }

     public Graphics getGraphicsBuffer() {
        return g2;
    }

    /*Este metodo eh executado a cada Consts.FRAME_INTERVAL milissegundos*/
    public void paint(Graphics gOld) {
        Image newImage;
        Graphics g = this.getBufferStrategy().getDrawGraphics();
        /*Criamos um contexto gráfico*/
        g2 = g.create(getInsets().left, getInsets().top, getWidth() - getInsets().right, getHeight() - getInsets().top);

        /*Desenha cenário*/
        for (int i = 0; i < Consts.DIMENSAO_TELA; i++) {
            for (int j = 0; j < Consts.DIMENSAO_TELA; j++) {
                try {
                    /*Linha para alterar o background*/
                    if(Fase.getNumFase() == 1){
                        newImage = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Consts.PATH + "background.png");
                    }else if(Fase.getNumFase() == 2){
                        newImage = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Consts.PATH + "Background.png");
                    }else if(Fase.getNumFase() == 3){
                        newImage = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Consts.PATH + "Background3.png");
                    }else if(Fase.getNumFase() == 4){
                        newImage = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Consts.PATH + "Background4.png");
                    }else{
                        newImage = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Consts.PATH + "Background0.png");
                    }
                    g2.drawImage(newImage, j * Consts.TAMANHO_CELULA, i * Consts.TAMANHO_CELULA, Consts.TAMANHO_CELULA, Consts.TAMANHO_CELULA, null);

                } catch (IOException ex) {
                    Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        
        if (!this.eElementos.isEmpty()) { //SE ARRAY DE ELEMENTOS NÃO ESTÁ VAZIO
            this.cControle.desenhaTudo(eElementos); //DESENHA TUDO
            this.cControle.processaTudo(eElementos); //VERIFICA TODOS OS ELEMENTOS
            
            /*APÓS JOGO INICIADO VERIFICA SE OS COLECIONÁVEIS DA FASE FORAM PEGOS OU SE O HEROI NÃO PERDEU
            TODAS AS VIDAS E SETA A PRÓXIMA FASE OU MOSTRA MENSAGEM DE VITÓRIA OU DERROTA*/
            if(!this.cControle.ahColecionaveisAinda(eElementos) && Fase.getNumFase() == 1 && hHero.getNumeroDeVida() != 0){ 
                //CASO TERMINE FASE 1
                this.Fase.setFase2(hHero);
            }else if(!this.cControle.ahColecionaveisAinda(eElementos) && Fase.getNumFase() == 2 && hHero.getNumeroDeVida() != 0){
                //CASO TERMINE FASE 2
                this.Fase.setFase3(hHero);
            }else if(!this.cControle.ahColecionaveisAinda(eElementos) && Fase.getNumFase() == 3 && hHero.getNumeroDeVida() != 0){
                //CASO TERMINE FASE 3
                this.Fase.setFase4(hHero);
            }else if(!this.cControle.ahColecionaveisAinda(eElementos) && Fase.getNumFase() == 4 && hHero.getNumeroDeVida() != 0){
                //CASO TERMINE FASE 4
                this.Fase.setVitoria(hHero);
            }else if(hHero.getNumeroDeVida() == 0){ 
                //CASO PERCA TODAS AS VIDAS
                this.Fase.setDerrota(hHero);
            }
        }

        g.dispose();
        g2.dispose();
        if (!getBufferStrategy().contentsLost()) {
            getBufferStrategy().show();
        }
    }

    public void go() {
        TimerTask redesenhar = new TimerTask() {
            public void run() {
                repaint();
                /*(executa o metodo paint)*/
            }
        };

        /*Redesenha (executa o metodo paint) tudo a cada Consts.FRAME_INTERVAL milissegundos*/
        Timer timer = new Timer();
        timer.schedule(redesenhar, 0, Consts.INTERVALO_FRAME);
    }

    public void keyPressed(KeyEvent e) {
        boolean isMovement = false;
        /*Movimento do heroi via teclado*/
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            hHero.setbDirecao(0);
            isMovement = true;
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            hHero.setbDirecao(1);
            isMovement = true;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            hHero.setbDirecao(2);
            isMovement = true;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            hHero.setbDirecao(3);
            isMovement = true;
        } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {//TECLA SPACE RETIRA OS ELEMENTOS QUANDO POSSÍVEL
            if(Fase.getNumFase() == 1 || Fase.getNumFase() == 4){
                switch(hHero.getbDirecao()){
                    case 0:
                        cControle.RemoveElemento(eElementos, hHero);
                        break;
                    case 1:
                        cControle.RemoveElemento(eElementos, hHero);
                        break;
                    case 2:
                        cControle.RemoveElemento(eElementos, hHero);
                        break;
                    case 3:
                        cControle.RemoveElemento(eElementos, hHero);
                        break;
                }
            }
        }
        
        //VERIFICA SE HÁ MOVIMENTAÇÃO E COMO PROCEDER
        if(isMovement){
            if (Fase.getNumFase() == 1 || Fase.getNumFase() == 3) { //NAS FASE 1 E 3
                cControle.MoverElemento(eElementos, hHero); //VERIFICA SE HEROI ESTÁ MOVENDO ELEMENTO MÓVEL
                cControle.ElementoColecionavel(eElementos, hHero); //VERIFICA SE HEROI ESTÁ PEGADO ELEMENTO COLECIONÁVEL
                hHero.posicaoNovaDoHeroi(); //VERIFICA NOVA POSIÇÃO DO HEROI
                cControle.moverHeroi(eElementos, hHero.getLinhaNova(), hHero.getColunaNova(), hHero, Fase); //REPOSICIONA O HEROI
            }else if(Fase.getNumFase() == 2){ //NA FASE 2
                //VERIFICA SE O HEROI ESTÁ INTERAGINDO CORRETAMENTE COM AS SETAS
                cControle.AndarNasSetas(eElementos, hHero.getLinhaNova(), hHero.getColunaNova(), hHero, Fase);
                hHero.posicaoNovaDoHeroi();//VERIFICA NOVA POSIÇÃO DO HEROI
                cControle.moverHeroi(eElementos, hHero.getLinhaNova(), hHero.getColunaNova(), hHero, Fase); //REPOSICIONA O HEROI
            }else if(Fase.getNumFase() == 4){ //NA FASE 4
                hHero.posicaoNovaDoHeroi(); //VERIFICA NOVA POSIÇÃO DO HEROI
                cControle.moverHeroi(eElementos, hHero.getLinhaNova(), hHero.getColunaNova(), hHero, Fase); //REPOSICIONA O HEROI
            }
            isMovement = false;
        }
        
        this.setTitle("-> Cell: " + (hHero.getPosicao().getColuna()) + ", " + (hHero.getPosicao().getLinha()));
    }

    //UTILIZANDO INSTRUÇÃO DE VALIDAÇÃO DE MOVIMENTO DA CLASSE CONTROLE DE JOGO NA CLASSE TELA
    public boolean ehPosicaoValidaRelativoUmPersonagem(Elemento unPersona) {
        return cControle.ehPosicaoValidaRelativoUmPersonagem(this.eElementos, unPersona);
    }
    
    //UTILIZANDO INSTRUÇÃO DE VALIDAÇÃO DE MOVIMENTO DO ROBO DA CLASSE CONTROLE DE JOGO NA CLASSE TELA
    public boolean ehPosicaoValidaAoRobo(int linha, int coluna){
        return cControle.ehPosicaoValidaAoRobo(this.eElementos, linha, coluna);
    }

    //UTILIZANDO INSTRUÇÃO DE COLISÃO DO HEROI COM ROBO DA CLASSE CONTROLE DE JOGO NA CLASSE TELA
    public boolean matouHeroi(Robo unRobo){
        return cControle.MatarHeroi(hHero, Fase, unRobo);
    }
    
    //INSTRUÇÕES PARA USO DE MOUSE, NÃO FORAM UTILIZADAS
    public void mousePressed(MouseEvent e) {

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("POO2021");
        setAutoRequestFocus(false);
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 561, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    public void mouseMoved(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }
}
