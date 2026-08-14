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
                <h2>Página de Cadastramento do Pedido</h2>
            </div>
        </header>

        <main>
            <form class="pedido-form" action="PedidoServlet" method="post">
                <h3>Informações do Pedido</h3>
                <div>
                    <label for="nome" class="form-label">Nome Completo</label>
                    <input type="text" name="nome" required />
                </div>

                <div>
                    <label for="cpf" class="form-label">CPF</label>
                    <input type="text" name="cpf" required />
                </div>

                <div>
                    <label for="sexo" class="form-label">Sexo</label>

                    <div class="radio">
                        <input
                            type="radio"
                            name="sexo"
                            id="masculino"
                            value="Masculino"
                            checked
                            required
                        />
                        <label for="masculino">Masculino</label>

                        <input type="radio" name="sexo" id="feminino" value="Feminino" required />
                        <label for="feminino">Feminino</label>

                        <input type="radio" name="sexo" id="outro" value="Outro" required />
                        <label for="outro">Outro</label>
                    </div>
                </div>

                <div>
                    <label for="endereco" class="form-label">Endereço</label>
                    <input type="text" name="endereco" required />
                </div>

                <div>
                    <label for="cidade" class="form-label">Cidade</label>
                    <input type="text" name="cidade" required />
                </div>

                <div>
                    <label for="estado" class="form-label">Estado</label>
                    <select name="estado" id="estado" required>
                        <option value="SP">SP</option>
                        <option value="RJ">RJ</option>
                        <option value="MG">MG</option>
                        <option value="ES">ES</option>
                    </select>
                </div>

                <div>
                    <label for="forma-pagamento" class="form-label">Forma de Pagamento</label>
                    <div>
                        <input
                            type="radio"
                            name="forma-pagamento"
                            id="cartao-credito"
                            value="Cartão de Crédito"
                            checked
                            required
                        />
                        <label for="cartao-credito">Cartão de Crédito</label>
                        <input type="radio" name="forma-pagamento" id="pix" value="PIX" required />
                        <label for="pix">PIX</label>
                        <input
                            type="radio"
                            name="forma-pagamento"
                            id="boleto"
                            value="Boleto Bancário"
                            required
                        />
                        <label for="boleto">Boleto Bancário</label>
                    </div>
                </div>

                <div>
                    <label for="parcelamento" class="form-label">Parcelamento</label>
                    <select name="parcelamento" id="parcelamento" required>
                        <option value="1 x "></option>
                        <option value="2 x "></option>
                        <option value="3 x "></option>
                    </select>
                </div>
                <button type="submit">Finalizar Compra</button>
            </form>
        </main>

        <footer>
            <p>Felipe Teixeira de Lima &copy; 2026</p>
        </footer>
    </body>
</html>
