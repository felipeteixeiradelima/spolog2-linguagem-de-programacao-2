package util;

import java.math.BigDecimal;
import java.util.Scanner;

public class ScannerUtil {
    private static final Scanner scanner = new Scanner(System.in);

    public static String getUserInput(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    public static Long extractId() {
        Long id = null;
        do {
            try {
                id = Long.parseLong(getUserInput("Informe o ID do estudante: "));
            } catch (NumberFormatException ignored) {
            }
        } while (id == null);
        return id;
    }

    public static String extractNome() {
        String nome;
        do {
            nome = getUserInput("NOME: ");
        } while (nome == null || nome.isBlank());
        return nome;
    }

    public static Character extractSexo() {
        Character sexo;
        do {
            sexo = Character.toLowerCase(getUserInput("SEXO (Digite 'm' ou 'f'): ").charAt(0));
        } while (sexo == null || !(sexo.equals('M') || sexo.equals('F')));
        return sexo;
    }

    public static Boolean extractPcd() {
        String input;
        Boolean pcd = null;
        char primeiroCaractere;

        do {
            input = getUserInput("PCD  (Digite 's' ou 'n'): ");
            primeiroCaractere = Character.toLowerCase(input.charAt(0));
            pcd = switch (primeiroCaractere) {
                case 's', '1' -> true;
                case 'n', '0' -> false;
                default -> pcd;
            };
        } while (pcd == null);
        return pcd;
    }

    public static BigDecimal extractIra() {
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
}
