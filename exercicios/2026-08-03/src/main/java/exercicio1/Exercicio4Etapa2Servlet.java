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
@WebServlet("/exercicio1/Exercicio4Etapa2Servlet")
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
		String precoLivroFormatado = "R$ " + String.format("%.2f", precoLivro);
		String precoLivro2ParcelasFormatado = "R$ " + String.format("%.2f", precoLivro / 2);
		String precoLivro3ParcelasFormatado = "R$ " + String.format("%.2f", precoLivro / 3);

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
					"        <link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\" />\n" + //
					"    </head>\n" + //
					"    <body>\n" + //
					"        <header>\n" + //
					"            <h1>Catálogo de Livros</h1>\n" + //
					"            <h2>Pagamento</h2>\n" + //
					"            <hr />\n" + //
					"        </header>\n" + //
					"        <main>\n" + //
					"            <form action=\"Exercicio4Etapa3Servlet\" method=\"POST\" class=\"visivel\">\n" + //
					"                <div>\n" + //
					"                    <label for=\"forma-pagamento\" class=\"form-label\">Forma de Pagamento</label>\n"
					+ //
					"                    <div>\n" + //
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
					"                <div>\n" + //
					"                    <label for=\"parcelamento\" class=\"form-label\">Parcelamento</label>\n" + //
					"                    <select name=\"parcelamento\" id=\"parcelamento\" required>\n" + //
					"                        <option value=\"1 x " + precoLivroFormatado + "\">1 x " + precoLivroFormatado
					+ "</option>\n"
					+ //
					"                        <option value=\"2 x " + precoLivro2ParcelasFormatado + "\">2 x "
					+ precoLivro2ParcelasFormatado + "</option>\n"
					+ //
					"                        <option value=\"3 x " + precoLivro3ParcelasFormatado + "\">3 x "
					+ precoLivro3ParcelasFormatado + "</option>\n"
					+ //
					"                    </select>\n" + //
					"                </div>\n" + //
					"                <input type=\"hidden\" name=\"nome-livro\" value=\"" + nomeLivro + "\"/>" + //
					"                <input type=\"hidden\" name=\"preco-livro\" value=\"" + precoLivroFormatado + "\"/>" + //
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
