package view.estudante;

import controller.EstudanteController;

import java.math.BigDecimal;
import java.util.Scanner;

public class InsereEstudante {
    private static Scanner scanner = new Scanner(System.in);

    private static String getUserInput(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    private static String extractNome() {
        String nome;
        do {
            nome = getUserInput("NOME: ");
        } while (nome == null || nome.isBlank());
        return nome;
    }

    private static Character extractSexo() {
        Character sexo;
        do {
            sexo = Character.toLowerCase(getUserInput("SEXO (Digite 'm' ou 'f'): ").charAt(0));
        } while (sexo == null || !(sexo.equals("M") || sexo.equals("F")));
        return sexo;
    }

    private static Boolean extractPcd() {
        String input;
        Boolean pcd = null;
        char primeiroCaractere;

        do {
            input = getUserInput("PCD  (Digite 's' ou 'n'): ");
            primeiroCaractere = Character.toLowerCase(input.charAt(0));
            switch (primeiroCaractere) {
                case 's', '1':
                    pcd = true;
                    break;
                case 'n', '0':
                    pcd = false;
                    break;
            }
        } while (pcd == null);
        return pcd;
    }

    private static BigDecimal extractIra() {
        String input;
        BigDecimal ira = null;
        boolean isMaiorQueZero = false;
        boolean isMenorOuIgualADez = false;

        do {
            input = getUserInput("IRA  (Digite valor entre 0 e 10): ");
            try {
                ira = new BigDecimal(input.replace(',', '.'));
                isMaiorQueZero = ira.compareTo(BigDecimal.ZERO) > 0;
                isMenorOuIgualADez = ira.compareTo(BigDecimal.TEN) <= 0;
            } catch (Exception ignored) {
            }
        } while (ira == null || !(isMenorOuIgualADez && isMaiorQueZero));
        return ira;
    }

    public static void exibeInterface() {
        String nome;
        Character sexo;
        Boolean pcd;
        BigDecimal ira;

        System.out.println("\nINSERÇÃO DE ESTUDANTE:");

        nome = extractNome();
        sexo = extractSexo();
        pcd = extractPcd();
        ira = extractIra();

        new EstudanteController().insereEstudante(nome, sexo, pcd, ira);

        System.out.println("Estudante cadastrado com sucesso.\n");
    }
}
