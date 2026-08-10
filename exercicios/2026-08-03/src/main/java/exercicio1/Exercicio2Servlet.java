package exercicio1;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Exercicio2Servlet
 */
@WebServlet("/exercicio1/Exercicio2Servlet")
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

	private double calcular(double valor1, double valor2, String operacao) {
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

		double valor1 = 0.0;
		double valor2 = 0.0;
		String operacao = request.getParameter("operacao");
		String stringValor1 = request.getParameter("valor1");
		String stringValor2 = request.getParameter("valor2");
		Object resultado = null;
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/exercicio1/resultado.jsp");

		try {
			valor1 = Double.parseDouble(stringValor1);
			valor2 = Double.parseDouble(stringValor2);
			resultado = calcular(valor1, valor2, operacao);
		} catch (NumberFormatException e) {
			resultado = (String) "Valores inválidos. Por favor, insira números válidos.";
		} finally {
			request.setAttribute("title", "Calculadora");
			request.setAttribute("resultado", "<strong>Resultado:</strong> " + resultado);
			dispatcher.forward(request, response);
		}
	}
}
