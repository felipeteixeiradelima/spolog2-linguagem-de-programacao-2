package exercicio1;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Exercicio4Etapa3Servlet
 */
@WebServlet("/exercicio1/Exercicio4Etapa3Servlet")
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

        RequestDispatcher dispatcher = request.getRequestDispatcher("/exercicio1/resultado.jsp");

        String nomeLivro = request.getParameter("nome-livro");
        String precoLivro = request.getParameter("preco-livro");

        String nomeCliente = request.getParameter("nome");
        String cpfCliente = request.getParameter("cpf");
        String sexoCliente = request.getParameter("sexo");
        String enderecoCliente = request.getParameter("endereco");
        String cidadeCliente = request.getParameter("cidade");
        String estadoCliente = request.getParameter("estado");

        String formaPagamento = request.getParameter("forma-pagamento");
        String parcelamento = request.getParameter("parcelamento");

        String resultado = "<h3>Informações do Livro</h3>\n" + //
                "<ul>\n" + //
                "<li><strong>Nome:</strong> " + nomeLivro + "</li>\n" + //
                "<li><strong>Preço:</strong> " + precoLivro + "</li>\n" + //
                "</ul>\n" + //
                "<h3>Informações do Cliente</h3>\n" + //
                "<ul>\n" + //
                "<li><strong>Nome:</strong> " + nomeCliente + "</li>\n" + //
                "<li><strong>CPF:</strong> " + cpfCliente + "</li>\n" + //
                "<li><strong>Sexo:</strong> " + sexoCliente + "</li>\n" + //
                "<li><strong>Endereço:</strong> " + enderecoCliente + "</li>\n" + //
                "<li><strong>Cidade:</strong> " + cidadeCliente + "</li>\n" + //
                "<li><strong>Estado:</strong> " + estadoCliente + "</li>\n" + //
                "</ul>\n" + //
                "<h3>Informações do Pagamento</h3>\n" + //
                "<ul>\n" + //
                "<li><strong>Forma de Pagamento:</strong> " + formaPagamento + "</li>\n" + //
                "<li><strong>Parcelamento:</strong> " + parcelamento + "</li>\n" + //
                "</ul>\n";

        request.setAttribute("title", "Catalogo de Livros");
        request.setAttribute("resultado", resultado);

        dispatcher.forward(request, response);
    }
}
