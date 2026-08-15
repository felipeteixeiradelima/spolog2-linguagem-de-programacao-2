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
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

@WebServlet("/PedidoServlet")
public class PedidoServlet extends HttpServlet {
    public PedidoServlet() {
    }

    protected ArrayList<Produto> obterProdutosComprados(HttpServletRequest request) {
        ArrayList<Produto> produtosComprados = new ArrayList<Produto>();
        Cookie[] cookies = request.getCookies();

        for (Cookie cookie : cookies) {
            if (cookie.getName().startsWith("produto")) {
                String cookieValueDecoded = URLDecoder.decode(cookie.getValue(), StandardCharsets.UTF_8);
                Produto produto = new Produto(cookieValueDecoded);
                produtosComprados.add(produto);
            }
        }

        return produtosComprados;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher resultadoDispatcher = getServletContext().getRequestDispatcher("/resultado.jsp");
        ArrayList<Produto> produtosComprados = obterProdutosComprados(request);

        request.setAttribute("produtosComprados", produtosComprados);
        resultadoDispatcher.forward(request, response);
    }
}
