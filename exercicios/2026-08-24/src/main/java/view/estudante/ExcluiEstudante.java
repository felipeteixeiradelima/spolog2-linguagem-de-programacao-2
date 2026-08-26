package view.estudante;

import controller.EstudanteController;
import util.ScannerUtil;

public class ExcluiEstudante {
    public static void exibeInterface() {
        Long id;

        System.out.println("\nALTERAÇÃO DE ESTUDANTE:");

        id = ScannerUtil.extractId();

        boolean sucesso = new EstudanteController().excluiEstudante(id);

        if (!sucesso) {
            System.out.println("Falha ao excluir estudante. Verifique o ID digitado.\n");
            return;
        }

        System.out.println("Estudante excluído com sucesso.\n");
    }
}
