package view;

import java.util.Scanner;

import controller.LivroController;
import view.livro.AlteraLivro;
import view.livro.ConsultaLivroPorId;
import view.livro.ConsultaLivros;
import view.livro.ExcluiLivro;
import view.livro.InsereLivro;

public class Index {
    public static void main(String[] args) {
        int opcao = 0;

        Scanner entrada = new Scanner(System.in);

        do {
            System.out.println("CADASTRO DE LIVROS:");
            System.out.println("1) Inserir");
            System.out.println("2) Consultar");
            System.out.println("3) Consultar por Id");
            System.out.println("4) Alterar");
            System.out.println("5) Excluir");
            System.out.print("Digite uma opção (0 para sair): ");

            opcao = Integer.parseInt(entrada.nextLine());

            switch (opcao) {
                case 1:
                    InsereLivro.exibeInterface();
                    break;
                case 2:
                    ConsultaLivros.exibeInterface();
                    break;
                case 3:
                    ConsultaLivroPorId.exibeInterface();
                    break;
                case 4:
                    AlteraLivro.exibeInterface();
                    break;
                case 5:
                    ExcluiLivro.exibeInterface();
                    break;
                default:
                    if (opcao != 0)
                        System.out.println("Digite uma opção válida.");
                    else {
                        new LivroController().finalizaEntityManager();
                        System.out.println("Programa encerrado.");
                    }
                    break;
            }
            System.out.println();
        } while (opcao != 0);

        entrada.close();
    }
}