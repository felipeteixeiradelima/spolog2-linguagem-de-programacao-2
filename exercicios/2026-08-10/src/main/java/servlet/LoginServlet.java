package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import util.Produto;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.text.NumberFormat;
import java.util.Locale;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    public LoginServlet() {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        RequestDispatcher indexDispatcher = getServletContext().getRequestDispatcher("/index.jsp");

        sessao.setAttribute("isUsuarioLogado", false);
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

    protected double calculaPrecoTotal(HttpServletRequest request) {
        double precoTotal = 0.0;
        Cookie[] cookies = request.getCookies();

        for (Cookie cookie : cookies) {
            if (cookie.getName().startsWith("produto")) {
                String cookieValueDecoded = URLDecoder.decode(cookie.getValue(), StandardCharsets.UTF_8);
                Produto produto = new Produto(cookieValueDecoded);
                precoTotal += produto.getPreco();
            }
        }

        return precoTotal;
    }

    protected void redirecionarParaLogin(HttpServletRequest request, HttpServletResponse response, String mensagemErro) throws ServletException, IOException {
        RequestDispatcher loginDispatcher = getServletContext().getRequestDispatcher("/login.jsp");

        request.setAttribute("mensagemErro", mensagemErro);
        loginDispatcher.forward(request, response);
    }

    protected void redirecionarParaPedido(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher pedidoDispatcher = getServletContext().getRequestDispatcher("/pedido.jsp");
        NumberFormat formatoReais = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        double precoTotal = calculaPrecoTotal(request);
        String precoTotalFormatado = formatoReais.format(precoTotal);
        String precoDuasParcelasFormatado = formatoReais.format(precoTotal / 2);
        String precoTreParcelasFormatado = formatoReais.format(precoTotal / 3);

        request.setAttribute("precoTotal", precoTotal);
        request.setAttribute("precoTotalFormatado", precoTotalFormatado);
        request.setAttribute("precoDuasParcelasFormatado", precoDuasParcelasFormatado);
        request.setAttribute("precoTreParcelasFormatado", precoTreParcelasFormatado);
        pedidoDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        Object isUsuarioLogado = sessao.getAttribute("isUsuarioLogado");

        // 1. Usuário veio de index.jsp já logado
        if (isUsuarioLogado != null && isUsuarioLogado.equals(true)) {
            redirecionarParaPedido(request, response);
            return;
        }

        String usuario = request.getParameter("usuario");
        String senha = request.getParameter("senha");

        final String USUARIO = "admin";
        final String SENHA = "12345";

        request.setAttribute("mensagemErro", null);

        // 2. Usuário veio dessa página, com usuário e senha coretos
        if (usuario.equals(USUARIO) && senha.equals(SENHA)) {
            sessao.setAttribute("isUsuarioLogado", true);
            redirecionarParaPedido(request, response);
            return;
        }

        // 3. Usuário veio dessa página, com usuário incorreto
        if (!usuario.equals(USUARIO)) {
            redirecionarParaLogin(request, response, "Usuário inválido!");
            return;
        }

        // 4. Usuário veio dessa página, com senha incorreta
        redirecionarParaLogin(request, response, "Senha incorreta!");
    }
}
