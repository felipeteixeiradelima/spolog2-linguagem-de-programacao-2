package exercicio3;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/exercicio3/QuizDificilServlet")
public class QuizDificilServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public QuizDificilServlet() {
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

        double pontos = 0.0;
        String[] respostas = new String[4];
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/exercicio3/resultado.jsp");

        for (int i = 0; i < 4; i++) {
            respostas[i] = request.getParameter("pergunta-" + (i + 1));
        }

        if (respostas[0].equals("turquia")) {
            pontos++;
        } else {
            pontos -= 0.5;
        }

        if (respostas[1].equals("1958")) {
            pontos++;
        } else {
            pontos -= 0.5;
        }

        if (respostas[2].equals("boxe")) {
            pontos++;
        } else {
            pontos -= 0.5;
        }

        if (respostas[3].equals("mclaren")) {
            pontos++;
        } else {
            pontos -= 0.5;
        }

        request.setAttribute("dificuldade", "Difícil");
        request.setAttribute("pontos", pontos);
        requestDispatcher.forward(request, response);
    }
}
