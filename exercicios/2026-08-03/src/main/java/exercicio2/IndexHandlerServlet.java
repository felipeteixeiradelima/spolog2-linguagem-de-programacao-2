package exercicio2;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/exercicio2/IndexHandlerServlet")
public class IndexHandlerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public IndexHandlerServlet() {
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

        RequestDispatcher requestDispatcher = null;

        try {
            String operacao = request.getParameter("operacao");

            switch (operacao) {
                case "milhas-quilometros":
                    requestDispatcher = getServletContext()
                            .getRequestDispatcher("/exercicio2/MilhasQuilometrosServlet");
                    break;
                case "quilometros-milhas":
                    requestDispatcher = getServletContext()
                            .getRequestDispatcher("/exercicio2/QuilometrosMilhasServlet");
                    break;
                case "pes-metros":
                    requestDispatcher = getServletContext().getRequestDispatcher("/exercicio2/PesMetrosServlet");
                    break;
                case "metros-pes":
                    requestDispatcher = getServletContext().getRequestDispatcher("/exercicio2/MetrosPesServlet");
                    break;
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            requestDispatcher.forward(request, response);
        }
    }
}
