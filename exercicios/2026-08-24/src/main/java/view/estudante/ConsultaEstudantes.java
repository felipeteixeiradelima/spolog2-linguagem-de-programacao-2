package view.estudante;

import controller.EstudanteController;
import model.Estudante;

import java.util.Scanner;

public class ConsultaEstudantes {
    static Scanner scanner = new Scanner(System.in);

    public static void exibeOpcoesAlterarExcluir() {
        int opcao = 0;

        System.out.println("ALTERAÇÃO / EXCLUSÃO DE ESTUDANTE");
        System.out.println("1) Alterar");
        System.out.println("2) Excluir");
        System.out.println("Digite uma opção (0 para voltar): ");

        do {
            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                continue;
            }

            System.out.println();

            switch (opcao) {
                case 1:
                    AlteraEstudante.exibeInterface();
                    break;
                case 2:
                    ExcluiEstudante.exibeInterface();
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (opcao < 0 && opcao > 2);
    }

    public static void exibeInterface() {
        String formato = "%1$-2s %2$-25s %3$-6s %4$-7s% %5$-7s%n";

        System.out.println("\nCONSULTA DE ESTUDANTES:");
        System.out.printf(formato, "ID", " | NOME", " | SEXO", " | PDC", " | IRA");

        for (Estudante estudante : new EstudanteController().consultaEstudantes()) {
            System.out.printf(
                    formato,
                    estudante.getId(),
                    " | " + estudante.getNome(),
                    " | " + estudante.getSexo(),
                    " | " + (estudante.getPcd() ? "Sim" : "Não"),
                    " | " + estudante.getIra()
            );
        }
        System.out.println();
        exibeOpcoesAlterarExcluir();
    }
}
