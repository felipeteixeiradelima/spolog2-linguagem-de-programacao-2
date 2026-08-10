package exercicio3;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/exercicio3/IndexHandlerServlet")
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

        String dificuldade = request.getParameter("dificuldade");
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/exercicio3/quiz.jsp");

        switch (dificuldade) {
            case "facil":
                request.setAttribute("title", "Quiz Fácil");
                request.setAttribute("action", "QuizFacilServlet");
                break;
            case "dificil":
                request.setAttribute("title", "Quiz Difícil");
                request.setAttribute("action", "QuizDificilServlet");
                break;
        }

        request.setAttribute("dificuldade", dificuldade);
        requestDispatcher.forward(request, response);
    }
}
