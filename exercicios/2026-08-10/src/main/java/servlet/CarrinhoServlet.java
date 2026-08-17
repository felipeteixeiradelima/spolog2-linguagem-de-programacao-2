package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.Produto;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@WebServlet("/CarrinhoServlet")
public class CarrinhoServlet extends HttpServlet {
    public CarrinhoServlet() {
    }

    protected void limparCookies(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();

        for (Cookie cookie : cookies) {
            if (cookie.getName().startsWith("produto")) {
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher loginDispatcher = getServletContext().getRequestDispatcher("/login.jsp");

        String[] produtosSelecionadosString = request.getParameterValues("produtos");

        limparCookies(request, response);

        for (int i = 0; i < produtosSelecionadosString.length; i++) {
            String produtoSelecionadoString = produtosSelecionadosString[i];
            Cookie produtoSelecionadoCookie = new Cookie("produto" + i, URLEncoder.encode(produtoSelecionadoString, StandardCharsets.UTF_8));
            produtoSelecionadoCookie.setMaxAge(-1);
            response.addCookie(produtoSelecionadoCookie);
        }

        loginDispatcher.forward(request, response);
    }
}
