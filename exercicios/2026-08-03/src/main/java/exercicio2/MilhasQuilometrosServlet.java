package exercicio2;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/exercicio2/MilhasQuilometrosServlet")
public class MilhasQuilometrosServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public MilhasQuilometrosServlet() {
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
            request.setAttribute("grandeza-origem", "milhas");
            request.setAttribute("grandeza-destino", "quilômetros");

            String medida = request.getParameter("medida").replace(",", ".");
            request.setAttribute("medida", medida);

            double medidaMilhas = Double.parseDouble(medida);
            double medidaQuilometros = medidaMilhas * 1.61;

            request.setAttribute("medida-convertida", medidaQuilometros);
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
