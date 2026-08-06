package exercicio1;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Exercicio4Etapa3Servlet
 */
@WebServlet("/Exercicio4Etapa3Servlet")
public class Exercicio4Etapa3Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     */
    public Exercicio4Etapa3Servlet() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        String nomeLivro = request.getParameter("nome-livro");
        double precoLivro = Double.parseDouble(request.getParameter("preco-livro"));

        String nomeCliente = request.getParameter("nome");
        String cpfCliente = request.getParameter("cpf");
        String sexoCliente = request.getParameter("sexo");
        String enderecoCliente = request.getParameter("endereco");
        String cidadeCliente = request.getParameter("cidade");
        String estadoCliente = request.getParameter("estado");

        String formaPagamento = request.getParameter("forma-pagamento");
        String parcelamento = request.getParameter("parcelamento");

        try (PrintWriter out = response.getWriter()) {
            out.println("<!doctype html>\n" + //
                    "<html lang=\"pt-br\">\n" + //
                    "    <head>\n" + //
                    "        <meta charset=\"UTF-8\" />\n" + //
                    "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n" + //
                    "        <title>Informações da Compra</title>\n" + //
                    "        <style>\n" + //
                    "            main {\n" + //
                    "                display: flex;\n" + //
                    "                flex-direction: column;\n" + //
                    "                width: 50%;\n" + //
                    "                max-width: 720px;\n" + //
                    "                margin: auto;\n" + //
                    "            }\n" + //
                    "        </style>\n" + //
                    "    </head>\n" + //
                    "    <body>\n" + //
                    "        <header>\n" + //
                    "            <h1>Catálogo de Livros</h1>\n" + //
                    "            <h2>Informações da Compra</h2>\n" + //
                    "            <hr />\n" + //
                    "        </header>\n" + //
                    "        <main>\n" + //
                    "            <h3>Informações do Livro</h3>\n" + //
                    "            <p class=\"item\"><strong>Nome do Livro:</strong> " + nomeLivro + "</p>\n" + //
                    "            <p class=\"item\"><strong>Preço do Livro:</strong> " + precoLivro + "</p>\n" + //
                    "            <h3>Informações do Cliente</h3>\n" + //
                    "            <p class=\"item\"><strong>Nome do Cliente:</strong> " + nomeCliente + "</p>\n" + //
                    "            <p class=\"item\"><strong>CPF do Cliente:</strong> " + cpfCliente + "</p>\n" + //
                    "            <p class=\"item\"><strong>Sexo do Cliente:</strong> " + sexoCliente + "</p>\n" + //
                    "            <p class=\"item\"><strong>Endereço do Cliente:</strong> " + enderecoCliente + "</p>\n"
                    + //
                    "            <p class=\"item\"><strong>Cidade do Cliente:</strong> " + cidadeCliente + "</p>\n" + //
                    "            <p class=\"item\"><strong>Estado do Cliente:</strong> " + estadoCliente + "</p>\n" + //
                    "            <h3>Informações do Pagamento</h3>\n" + //
                    "            <p class=\"item\"><strong>Forma de Pagamento:</strong> " + formaPagamento + "</p>\n" + //
                    "            <p class=\"item\"><strong>Parcelamento:</strong> " + parcelamento + "</p>\n" + //
                    "        </main>\n" + //
                    "    </body>\n" + //
                    "</html>\n");
        }
    }
}
