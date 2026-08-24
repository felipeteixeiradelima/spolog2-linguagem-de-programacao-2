package view.estudante;

import controller.EstudanteController;
import model.Estudante;

import java.util.Scanner;

public class ConsultaEstudantePorId {
    static Scanner scanner = new Scanner(System.in);

    public static void exibeInterface() {
        Long id;
        String formato = "%1$-2s %2$-25s %3$-6s %4$-7s% %5$-7s%n";

        System.out.println("\nCONSULTA DE ESTUDANTE POR ID:");
        System.out.println("Informe o ID do Estudante:");
        id = Long.parseLong(scanner.nextLine());

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
