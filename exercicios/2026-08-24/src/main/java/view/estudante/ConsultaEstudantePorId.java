package view.estudante;

import controller.EstudanteController;
import model.Estudante;
import util.ScannerUtil;


public class ConsultaEstudantePorId {

    public static void exibeInterface() {
        Long id;
        String formato = "%1$-3s %2$-50s %3$-8s %4$-8s %5$-8s%n";

        System.out.println("\nCONSULTA DE ESTUDANTE POR ID:");
        id = ScannerUtil.extractId();

        Estudante estudante = new EstudanteController().consultaEstudantePorId(id);

        if (estudante == null) {
            System.out.printf("Nenhum estudante encontrado para o ID '%d'.", id);
            return;
        }

        System.out.printf(formato, "ID", " | NOME", " | SEXO", " | PDC", " | IRA");
        System.out.printf(
                formato,
                estudante.getId(),
                " | " + estudante.getNome(),
                " | " + estudante.getSexo(),
                " | " + (estudante.getPcd() ? "Sim" : "Não"),
                " | " + estudante.getIra()
        );
        System.out.println();
    }
}
