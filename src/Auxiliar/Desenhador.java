package Auxiliar;

import java.awt.Graphics;
import java.io.Serializable;
import javax.swing.ImageIcon;
import Controler.Tela;

/**
 *
 * @author junio
 */

//CLASSE RESPONSAVEL POR DESENHAR OS ELEMENTOS
public class Desenhador implements Serializable {
    static Tela tCenarioOndeSeDesenha;
    public static void setCenario(Tela umTCenarioOndeDesenhar) {
        tCenarioOndeSeDesenha = umTCenarioOndeDesenhar;
    }

    public static Tela getTelaDoJogo() {
        return tCenarioOndeSeDesenha;
    }
    
    public static void desenhar(ImageIcon iImage, int iColuna, int iLinha) {
        iImage.paintIcon(tCenarioOndeSeDesenha,getGraphicsDaTela(),iColuna * Consts.TAMANHO_CELULA, iLinha * Consts.TAMANHO_CELULA);
    }
    
    /*private, entao eh usaddo soh aqui dentro*/
    private static Graphics getGraphicsDaTela() {
        return tCenarioOndeSeDesenha.getGraphicsBuffer();
    }
    

}
