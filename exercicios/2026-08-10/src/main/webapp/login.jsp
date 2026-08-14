<!--<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>-->
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <title>Login</title>
        <link rel="stylesheet" href="styles.css" />
    </head>
    <body>
        <%@page import="jakarta.servlet.http.HttpSession" %>

        <%
            HttpSession sessao = request.getSession();
            RequestDispatcher verificaLoginDispatcher = getServletContext().getRequestDispatcher("/LoginServlet");

            sessao.setMaxInactiveInterval(300);

            if (sessao.getAttribute("isUsuarioLogado") == null) {
                sessao.setAttribute("isUsuarioLogado", false);
            }

            if (!sessao.isNew() && !sessao.getAttribute("isUsuarioLogado").equals(false)) {
                verificaLoginDispatcher.forward(request, response);
            }
        %>

        <header>
            <a href="index.jsp">
                <img
                    class="logo"
                    src="resources/logo/Marca_IFSP_2015_SPO_01.png"
                    alt="Logo IFSP SPO"
                />
            </a>
            <div class="header-title">
                <h1>Loja de Produtos de Informática</h1>
                <h2>Login</h2>
            </div>
        </header>

        <main>
            <form class="login-form" action="LoginServlet" method="post">
                <h3>Fazer login</h3>

                <div>
                    <label class="form-label" for="usuario">Usuário</label>
                    <input type="text" name="usuario" id="usuario" minlength="5" required>
                </div>

                <div>
                    <label class="form-label" for="senha">Senha</label>
                    <input type="password" name="senha" id="senha" minlength="5" required>
                </div>

                <%
                    if (request.getAttribute("mensagemErro") != null) {
                %>
                    <aside><p>${mensagemErro}</p></aside>
                <%
                    }
                %>

                <button type="submit">Entrar</button>
            </form>
        </main>

        <footer>
            <p>Felipe Teixeira de Lima &copy; 2026</p>
        </footer>
    </body>
</html>
