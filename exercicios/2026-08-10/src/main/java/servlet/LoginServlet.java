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
        RequestDispatcher indexDispatcher = getServletContext().getRequestDispatcher("/index.jsp");

        sessao.setAttribute("usuarioLogado", false);
        sessao.invalidate();

        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }

        indexDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        RequestDispatcher loginDispatcher = getServletContext().getRequestDispatcher("/login.jsp");
        RequestDispatcher pedidoDispatcher = getServletContext().getRequestDispatcher("/pedido.jsp");
        Object isUsuarioLogado = sessao.getAttribute("isUsuarioLogado");

        // 1. Usuário veio de index.jsp já logado
        if (isUsuarioLogado != null && isUsuarioLogado.equals(true)) {
            pedidoDispatcher.forward(request, response);
            return;
        }

        String usuario = request.getParameter("usuario");
        String senha = request.getParameter("senha");

        final String USUARIO = "admin";
        final String SENHA = "12345";

        request.setAttribute("mensagemErro", null);

        // 2. Usuário veio dessa página, com usuário e senha coretos
        if (usuario.equals(USUARIO) && senha.equals(SENHA)) {
            sessao.setAttribute("usuarioLogado", true);
            pedidoDispatcher.forward(request, response);
            return;
        }

        // 3. Usuário veio dessa página, com usuário incorreto
        if (!usuario.equals(USUARIO)) {
            request.setAttribute("mensagemErro", "Usuário inválido!");
            loginDispatcher.forward(request, response);
            return;
        }

        // 4. Usuário veio dessa página, com senha incorreta
        request.setAttribute("mensagemErro", "Senha incorreta!");
        loginDispatcher.forward(request, response);
    }
}
