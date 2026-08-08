package exercicio2;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/exercicio2/PesMetrosServlet")
public class PesMetrosServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public PesMetrosServlet() {
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/exercicio2/resultado.jsp");

        try {
            request.setAttribute("grandeza-origem", "pés");
            request.setAttribute("grandeza-destino", "metros");

            String medida = request.getParameter("medida").replace(",", ".");
            request.setAttribute("medida", medida);

            double medidaPes = Double.parseDouble(medida);
            double medidaMetros = medidaPes * 0.3048;

            request.setAttribute("medida-convertida", medidaMetros);
        } catch (Exception e) {
            System.err.println("Ocorreu um erro ao processar a solicitação: " + e.toString());
            System.err.println("Causa: " + e.getCause());
            System.err.println("Stack trace:");
            e.printStackTrace();
        } finally {
            requestDispatcher.forward(request, response);
        }
    }
}
