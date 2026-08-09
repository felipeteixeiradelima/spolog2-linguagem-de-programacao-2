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
 * Servlet implementation class Exercicio3Servlet
 */
@WebServlet("/exercicio1/Exercicio3Servlet")
public class Exercicio3Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public Exercicio3Servlet() {
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

	private double converterCelciusParaFahrenheit(double temperatura) {
		return temperatura * 1.8 + 32;
	}

	private double converterFahrenheitParaCelsius(double temperatura) {
		return (temperatura - 32) / 1.8;
	}

	private double converterCelsiusParaKelvin(double temperatura) {
		return temperatura + 273.15;
	}

	private double converterKelvinParaCelsius(double temperatura) {
		return temperatura - 273.15;
	}

	private double converterFahrenheitParaKelvin(double temperatura) {
		return (temperatura + 459.67) / 1.8;
	}

	private double converterKelvinParaFahrenheit(double temperatura) {
		return temperatura * 1.8 - 459.67;
	}

	private double converter(double temperatura, String tipo) {
		double resultado = 0.0;

		switch (tipo) {
			case "celsius-fahrenheit":
				resultado = converterCelciusParaFahrenheit(temperatura);
				break;
			case "fahrenheit-celsius":
				resultado = converterFahrenheitParaCelsius(temperatura);
				break;
			case "celsius-kelvin":
				resultado = converterCelsiusParaKelvin(temperatura);
				break;
			case "kelvin-celsius":
				resultado = converterKelvinParaCelsius(temperatura);
				break;
			case "fahrenheit-kelvin":
				resultado = converterFahrenheitParaKelvin(temperatura);
				break;
			case "kelvin-fahrenheit":
				resultado = converterKelvinParaFahrenheit(temperatura);
				break;
		}

		return resultado;
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");

		double temperatura = 0.0;
		String operacao = request.getParameter("operacao");
		String stringTemperatura = request.getParameter("temperatura");
		Object resultado = null;
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/exercicio1/resultado.jsp");

		try {
			temperatura = Double.parseDouble(stringTemperatura);
			resultado = converter(temperatura, operacao);
		} catch (NumberFormatException e) {
			resultado = (String) "Valores inválidos. Por favor, insira números válidos.";
		} finally {
			request.setAttribute("title", "Conversor de Temperaturas");
			request.setAttribute("resultado", "<strong>Resultado:</strong> " + resultado);
			dispatcher.forward(request, response);
		}
	}
}
