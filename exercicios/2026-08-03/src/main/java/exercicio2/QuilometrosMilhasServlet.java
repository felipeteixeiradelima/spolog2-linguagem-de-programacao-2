package exercicio2;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/exercicio2/QuilometrosMilhasServlet")
public class QuilometrosMilhasServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public QuilometrosMilhasServlet() {
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
            request.setAttribute("grandeza-origem", "quilômetros");
            request.setAttribute("grandeza-destino", "milhas");

            String medida = request.getParameter("medida").replace(",", ".");
            request.setAttribute("medida", medida);

            double medidaQuilometros = Double.parseDouble(medida);
            double medidaMilhas = medidaQuilometros * 0.62;

            request.setAttribute("medida-convertida", medidaMilhas);
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
