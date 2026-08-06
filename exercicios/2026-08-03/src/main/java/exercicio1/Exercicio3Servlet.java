package exercicio1;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Exercicio3Servlet
 */
@WebServlet("/Exercicio3Servlet")
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

		try (PrintWriter out = response.getWriter()) {
			out.println("<!DOCTYPE html>");
			out.println("<html lang=\"pt-br\">");
			out.println("<head>");
			out.println("<meta charset=\"UTF-8\">");
			out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
			out.println("<title>Resultado - Exercicio 2 (Java Servlet)</title>");
			out.println("</head>");

			double temperatura;
			String operacao = request.getParameter("operacao");
			String stringTemperatura = request.getParameter("temperatura");

			if (stringTemperatura.isEmpty()) {
				out.println("Preencha todos os campos.");
				return;
			}

			try {
				temperatura = Double.parseDouble(stringTemperatura);
			} catch (NumberFormatException e) {
				out.println("Digite um número válido (números decimais são separados por .).");
				return;
			}

			double resultado = converter(temperatura, operacao);

			out.println("<p>Resultado: " + resultado + "</p>");
		}
	}
}
