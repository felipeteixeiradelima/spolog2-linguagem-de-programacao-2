package exercicio2;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/exercicio2/MetrosPesServlet")
public class MetrosPesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public MetrosPesServlet() {
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
            request.setAttribute("grandeza-origem", "metros");
            request.setAttribute("grandeza-destino", "pés");

            String medida = request.getParameter("medida").replace(",", ".");
            request.setAttribute("medida", medida);

            double medidaMetros = Double.parseDouble(medida);
            double medidaPes = medidaMetros * 3.28;

            request.setAttribute("medida-convertida", medidaPes);
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            requestDispatcher.forward(request, response);
        }
    }
}
