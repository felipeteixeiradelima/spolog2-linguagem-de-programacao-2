package exercicio1;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Exercicio4Etapa1Servlet
 */
@WebServlet("/exercicio1/Exercicio4Etapa1Servlet")
public class Exercicio4Etapa1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public Exercicio4Etapa1Servlet() {
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

		try (PrintWriter out = response.getWriter()) {
			out.println("<!doctype html>\n" + //
					"<html lang=\"pt-br\">\n" + //
					"    <head>\n" + //
					"        <meta charset=\"UTF-8\" />\n" + //
					"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n" + //
					"        <title>Cadastro Cliente</title>\n" + //
					"		 <link rel=\"stylesheet\" href=\"styles.css\" />\n" + //
					"    </head>\n" + //
					"    <body>\n" + //
					"        <header>\n" + //
					"            <h1>Catálogo de Livros</h1>\n" + //
					"            <h2>Cadastro Cliente</h2>\n" + //
					"            <hr />\n" + //
					"        </header>\n" + //
					"        <main>\n" + //
					"            <form action=\"Exercicio4Etapa2Servlet\" method=\"POST\" class=\"visivel\">\n" + //
					"                <div>\n" + //
					"                    <label for=\"nome\" class=\"form-label\">Nome Completo</label>\n" + //
					"                    <input type=\"text\" name=\"nome\" required />\n" + //
					"                </div>\n" + //
					"                <div>\n" + //
					"                    <label for=\"cpf\" class=\"form-label\">CPF</label>\n" + //
					"                    <input type=\"text\" name=\"cpf\" required />\n" + //
					"                </div>\n" + //
					"                <div>\n" + //
					"                    <label for=\"sexo\" class=\"form-label\">Sexo</label>\n" + //
					"                    <div class=\"radio\">\n" + //
					"                        <input\n" + //
					"                            type=\"radio\"\n" + //
					"                            name=\"sexo\"\n" + //
					"                            id=\"masculino\"\n" + //
					"                            value=\"Masculino\"\n" + //
					"                            checked\n" + //
					"                            required\n" + //
					"                        />\n" + //
					"                        <label for=\"masculino\">Masculino</label>\n" + //
					"                        <input\n" + //
					"                            type=\"radio\"\n" + //
					"                            name=\"sexo\"\n" + //
					"                            id=\"feminino\"\n" + //
					"                            value=\"Feminino\"\n" + //
					"                            required\n" + //
					"                        />\n" + //
					"                        <label for=\"feminino\">Feminino</label>\n" + //
					"                        <input\n" + //
					"                            type=\"radio\"\n" + //
					"                            name=\"sexo\"\n" + //
					"                            id=\"outro\"\n" + //
					"                            value=\"Outro\"\n" + //
					"                            required\n" + //
					"                        />\n" + //
					"                        <label for=\"outro\">Outro</label>\n" + //
					"                    </div>\n" + //
					"                </div>\n" + //
					"                <div>\n" + //
					"                    <label for=\"endereco\" class=\"form-label\">Endereço</label>\n" + //
					"                    <input type=\"text\" name=\"endereco\" required />\n" + //
					"                </div>\n" + //
					"                <div>\n" + //
					"                    <label for=\"cidade\" class=\"form-label\">Cidade</label>\n" + //
					"                    <input type=\"text\" name=\"cidade\" required />\n" + //
					"                </div>\n" + //
					"                <div>\n" + //
					"                    <label for=\"estado\" class=\"form-label\">Estado</label>\n" + //
					"                    <select name=\"estado\" id=\"estado\" required>\n" + //
					"                        <option value=\"SP\">SP</option>\n" + //
					"                        <option value=\"RJ\">RJ</option>\n" + //
					"                        <option value=\"MG\">MG</option>\n" + //
					"                        <option value=\"ES\">ES</option>\n" + //
					"                    </select>\n" + //
					"                </div>\n" + //
					"                <input type=\"hidden\" name=\"nome-livro\" value=\"" + nomeLivro + "\"/>" + //
					"                <input type=\"hidden\" name=\"preco-livro\" value=\"" + precoLivro + "\"/>" + //
					"                <button type=\"submit\">Próximo</button>\n" + //
					"            </form>\n" + //
					"        </main>\n" + //
					"    </body>\n" + //
					"</html>\n");
		}
	}
}
