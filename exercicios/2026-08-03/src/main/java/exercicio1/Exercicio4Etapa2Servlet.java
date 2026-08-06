package exercicio1;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Exercicio4Etapa2Servlet
 */
@WebServlet("/Exercicio4Etapa2Servlet")
public class Exercicio4Etapa2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public Exercicio4Etapa2Servlet() {
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
		double precoLivro2Parcelas = precoLivro / 2;
		double precoLivro3Parcelas = precoLivro / 3;

		String nomeCliente = request.getParameter("nome");
		String cpfCliente = request.getParameter("cpf");
		String sexoCliente = request.getParameter("sexo");
		String enderecoCliente = request.getParameter("endereco");
		String cidadeCliente = request.getParameter("cidade");
		String estadoCliente = request.getParameter("estado");

		try (PrintWriter out = response.getWriter()) {
			out.println("<!doctype html>\n" + //
					"<html lang=\"pt-br\">\n" + //
					"    <head>\n" + //
					"        <meta charset=\"UTF-8\" />\n" + //
					"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n" + //
					"        <title>Pagamento</title>\n" + //
					"        <style>\n" + //
					"            main {\n" + //
					"                display: flex;\n" + //
					"                width: 50%;\n" + //
					"                max-width: 720px;\n" + //
					"                margin: auto;\n" + //
					"            }\n" + //
					"            form {\n" + //
					"                display: flex;\n" + //
					"                flex-direction: column;\n" + //
					"                align-items: center;\n" + //
					"                width: 100%;\n" + //
					"            }\n" + //
					"            .form-item {\n" + //
					"                display: flex;\n" + //
					"                flex-direction: column;\n" + //
					"                width: 100%;\n" + //
					"                margin: 10px;\n" + //
					"            }\n" + //
					"            label {\n" + //
					"                margin: 2.5px;\n" + //
					"            }\n" + //
					"            input {\n" + //
					"                margin: 2.5px;\n" + //
					"                height: 20px;\n" + //
					"            }\n" + //
					"            .radio {\n" + //
					"                display: flex;\n" + //
					"            }\n" + //
					"        </style>\n" + //
					"    </head>\n" + //
					"    <body>\n" + //
					"        <header>\n" + //
					"            <h1>Catálogo de Livros</h1>\n" + //
					"            <h2>Pagamento</h2>\n" + //
					"            <hr />\n" + //
					"        </header>\n" + //
					"        <main>\n" + //
					"            <form action=\"Exercicio4Etapa3Servlet\" method=\"POST\">\n" + //
					"                <div class=\"form-item radio\">\n" + //
					"                    <label for=\"forma-pagamento\">Forma de Pagamento</label>\n" + //
					"                    <div class=\"radio\">\n" + //
					"                        <input\n" + //
					"                            type=\"radio\"\n" + //
					"                            name=\"forma-pagamento\"\n" + //
					"                            id=\"cartao-credito\"\n" + //
					"                            value=\"Cartão de Crédito\"\n" + //
					"                            checked\n" + //
					"                            required\n" + //
					"                        />\n" + //
					"                        <label for=\"cartao-credito\">Cartão de Crédito</label>\n" + //
					"                        <input\n" + //
					"                            type=\"radio\"\n" + //
					"                            name=\"forma-pagamento\"\n" + //
					"                            id=\"pix\"\n" + //
					"                            value=\"PIX\"\n" + //
					"                            required\n" + //
					"                        />\n" + //
					"                        <label for=\"pix\">PIX</label>\n" + //
					"                        <input\n" + //
					"                            type=\"radio\"\n" + //
					"                            name=\"forma-pagamento\"\n" + //
					"                            id=\"boleto\"\n" + //
					"                            value=\"Boleto Bancário\"\n" + //
					"                            required\n" + //
					"                        />\n" + //
					"                        <label for=\"boleto\">Boleto Bancário</label>\n" + //
					"                    </div>\n" + //
					"                </div>\n" + //
					"                <div class=\"form-item\">\n" + //
					"                    <label for=\"parcelamento\">Parcelamento</label>\n" + //
					"                    <select name=\"parcelamento\" id=\"parcelamento\" required>\n" + //
					"                        <option value=\"1 x R$" + precoLivro + "\">1 x R$" + precoLivro
					+ "</option>\n"
					+ //
					"                        <option value=\"2 x R$" + precoLivro2Parcelas + "\">2 x R$"
					+ precoLivro2Parcelas + "</option>\n"
					+ //
					"                        <option value=\"3 x R$" + precoLivro3Parcelas + "\">3 x R$"
					+ precoLivro3Parcelas + "</option>\n"
					+ //
					"                    </select>\n" + //
					"                </div>\n" + //
					"                <input type=\"hidden\" name=\"nome-livro\" value=\"" + nomeLivro + "\"/>" + //
					"                <input type=\"hidden\" name=\"preco-livro\" value=\"" + precoLivro + "\"/>" + //
					"                <input type=\"hidden\" name=\"nome\" value=\"" + nomeCliente + "\"/>" + //
					"                <input type=\"hidden\" name=\"cpf\" value=\"" + cpfCliente + "\"/>" + //
					"                <input type=\"hidden\" name=\"sexo\" value=\"" + sexoCliente + "\"/>" + //
					"                <input type=\"hidden\" name=\"endereco\" value=\"" + enderecoCliente
					+ "\"/>" + //
					"                <input type=\"hidden\" name=\"cidade\" value=\"" + cidadeCliente + "\"/>" + //
					"                <input type=\"hidden\" name=\"estado\" value=\"" + estadoCliente + "\"/>" + //
					"                <button type=\"submit\">Finalizar Compra</button>\n" + //
					"            </form>\n" + //
					"        </main>\n" + //
					"    </body>\n" + //
					"</html>\n");
		}
	}
}
