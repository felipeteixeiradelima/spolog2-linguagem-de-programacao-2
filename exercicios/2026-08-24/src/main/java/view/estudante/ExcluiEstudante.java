package view.estudante;

import controller.EstudanteController;
import util.ScannerUtil;

public class ExcluiEstudante {
    public static void exibeInterface() {
        Long id;

        System.out.println("\nALTERAÇÃO DE ESTUDANTE:");

        id = ScannerUtil.extractId();

        new EstudanteController().excluiEstudante(id);

        System.out.println("Estudante excluído com sucesso.\n");
    }
}
