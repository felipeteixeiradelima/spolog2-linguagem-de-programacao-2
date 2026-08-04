package refactorexercicio2;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Exercicio2Servlet
 */
@WebServlet("/Exercicio2Servlet")
public class Exercicio2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public Exercicio2Servlet() {
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

	private double Exercicio2Servlet(double valor1, double valor2, String operacao) {
		double resultado = 0.0;

		switch (operacao) {
			case "+":
				resultado = valor1 + valor2;
				break;
			case "-":
				resultado = valor1 - valor2;
				break;
			case "*":
				resultado = valor1 * valor2;
				break;
			case "/":
				resultado = valor1 / valor2;
				break;
			case "%":
				resultado = valor1 % valor2;
				break;
		}

		return resultado;
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");

		try (PrintWriter out = response.getWriter()) {
			out.println("<!DOCTYPE html>");
			out.println("<html lang=\"pt-br\">");
			out.println("<head>");
			out.println("<meta charset=\"UTF-8\">");
			out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
			out.println("<title>Resultado - Exercicio 2 (Java Servlet)</title>");
			out.println("</head>");

			double valor1;
			double valor2;
			String operacao = request.getParameter("operacao");
			String stringValor1 = request.getParameter("valor1");
			String stringValor2 = request.getParameter("valor2");

			if (stringValor1.isEmpty() | stringValor2.isEmpty() | operacao.isEmpty()) {
				out.println("Preencha todos os campos.");
				return;
			}

			try {
				valor1 = Double.parseDouble(stringValor1);
				valor2 = Double.parseDouble(stringValor2);
			} catch (NumberFormatException e) {
				out.println("Digite números válidos (números decimais são separados por .).");
				return;
			}

			double resultado = Exercicio2Servlet(valor1, valor2, operacao);

			out.println("<p>Resultado: " + resultado + "</p>");

		}
	}
}