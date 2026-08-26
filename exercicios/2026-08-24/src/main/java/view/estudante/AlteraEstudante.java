package view.estudante;

import controller.EstudanteController;
import util.ScannerUtil;

import java.math.BigDecimal;

public class AlteraEstudante {
    public static void exibeInterface() {
        Long id;
        String nome;
        Character sexo;
        Boolean pcd;
        BigDecimal ira;

        System.out.println("\nALTERAÇÃO DE ESTUDANTE:");

        id = ScannerUtil.extractId();
        nome = ScannerUtil.extractNome();
        sexo = ScannerUtil.extractSexo();
        pcd = ScannerUtil.extractPcd();
        ira = ScannerUtil.extractIra();

        new EstudanteController().alteraEstudante(id, nome, sexo, pcd, ira);

        System.out.println("Estudante alterado com sucesso.\n");
    }
}
