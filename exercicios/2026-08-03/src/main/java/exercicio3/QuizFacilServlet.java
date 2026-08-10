package exercicio3;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/exercicio3/QuizFacilServlet")
public class QuizFacilServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public QuizFacilServlet() {
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

        int pontos = 0;
        String[] respostas = new String[4];
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/exercicio3/resultado.jsp");

        for (int i = 0; i < 4; i++) {
            respostas[i] = request.getParameter("pergunta-" + (i + 1));
        }

        if (respostas[0].equals("espanha")) {
            pontos++;
        }

        if (respostas[1].equals("pele")) {
            pontos++;
        }

        if (respostas[2].equals("futebol-americano")) {
            pontos++;
        }

        if (respostas[3].equals("cricket")) {
            pontos++;
        }

        request.setAttribute("dificuldade", "Fácil");
        request.setAttribute("pontos", pontos);
        requestDispatcher.forward(request, response);
    }
}
