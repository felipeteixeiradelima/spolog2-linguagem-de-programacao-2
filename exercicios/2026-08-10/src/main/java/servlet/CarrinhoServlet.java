package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.URLEncoder;

@WebServlet("/CarrinhoServlet")
public class CarrinhoServlet extends HttpServlet {
    public CarrinhoServlet() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher verificaLoginDispatcher = getServletContext().getRequestDispatcher("/LoginServlet");

        String[] produtosSelecionadosString = request.getParameter("produtos");

        for (int i = 0; i < produtosSelecionadosString.length; i++) {
            String produtoSelecionadoString = produtosSelecionadosString[0];
            Cookie produtoSelecionadoCookie = new Cookie("produto" + i, URLEncoder.encode(produtoSelecionadoString));
            produtoSelecionadoCookie.setMaxAge(-1);
            request.addCookie(produtoSelecionadoCookie);
        }

        verificaLoginDispatcher.foward(request, response);
    }
}