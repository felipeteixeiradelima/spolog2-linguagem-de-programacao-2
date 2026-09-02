package view.estudante;

import controller.EstudanteController;
import util.ScannerUtil;

import java.math.BigDecimal;


public class InsereEstudante {

    public static void exibeInterface() {
        String nome;
        Character sexo;
        Boolean pcd;
        BigDecimal ira;

        System.out.println("\nINSERÇÃO DE ESTUDANTE:");

        nome = ScannerUtil.extractNome();
        sexo = ScannerUtil.extractSexo();
        pcd = ScannerUtil.extractPcd();
        ira = ScannerUtil.extractIra();

        new EstudanteController().insereEstudante(nome, sexo, pcd, ira);

        System.out.println("Estudante cadastrado com sucesso.\n");
    }
}
