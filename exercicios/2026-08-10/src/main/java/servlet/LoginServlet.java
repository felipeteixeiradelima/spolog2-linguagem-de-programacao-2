package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    public LoginServlet() {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        RequestDispatcher indexDispatcher = getServletContext().getRequestDispatcher("/index.html");

        sessao.setAttribute("usuarioLogado", false);
        sessao.invalidate();

        Cookie[] cookies = request.getCookies();

        for (Cookie cookie : cookies) {
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }

        indexDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        RequestDispatcher loginDispatcher = getServletContext().getRequestDispatcher("/login.jsp");
        RequestDispatcher cadastramentoDispatcher = getServletContext().getRequestDispatcher("/cadastramento.jsp");

        request.setAttribute("mensagemErro", null);

        if (!request.getParameter("usuario").equals("usuario")) {
            request.setAttribute("mensagemErro", "Usuário inválido!");
            loginDispatcher.forward(request, response);
            System.out.println("Teste Usuario");
            return;
        }

        if (!request.getParameter("senha").equals("senha")) {
            request.setAttribute("mensagemErro", "Senha incorreta!");
            loginDispatcher.forward(request, response);
            System.out.println("Teste Senha");
            return;
        }

        sessao.setAttribute("usuarioLogado", true);
        cadastramentoDispatcher.forward(request, response);
    }
}
