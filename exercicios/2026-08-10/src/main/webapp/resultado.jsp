<!--<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>-->
<!doctype html>
<html lang="pt-br">
    <head>
        <title>Resultado</title>
        <link rel="stylesheet" href="styles.css" />
        <link rel="icon" type="image/jpg" href="resources/logo/Marca_IFSP_2015_Simpl_V_1.jpg">
    </head>
    <body>
        <%@page import="java.util.ArrayList" %>
        <%@page import="util.Produto" %>

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
                <h2>Resultado da Compra</h2>
            </div>

            <%
                HttpSession sessao = request.getSession();
                Object isUsuarioLogado = sessao.getAttribute("isUsuarioLogado");

                if (isUsuarioLogado != null && isUsuarioLogado.equals(true)) {
            %>

            <form method="get" action="LoginServlet">
                <button type="submit">Sair</button>
            </form>

            <% } %>
        </header>

        <main>
            <section class="resultado">
                <aside class="sucess">Compra realizada com sucesso!</aside>
                <section class="informacoes-resultado">
                    <div>
                        <h3>Produtos Comprados</h3>
                    </div>

                    <table class="tabela-produtos-resultado">
                        <thead>
                            <th></th>
                            <th>Nome</th>
                            <th>Descrição</th>
                            <th>Preço</th>
                        </thead>
                        <tbody>

                        <%
                            ArrayList<Produto> produtosComprados = (ArrayList<Produto>) request.getAttribute("produtosComprados");
                            for (Produto produto : produtosComprados) {

                            // Fallback pois EL não consegue acessar a var local produto
                            pageContext.setAttribute("produto", produto);
                        %>
                            <tr>
                                <td>
                                    <img
                                        src="${produto.getCaminhoImagem()}"
                                        class="table-image"
                                        alt="Imagem do produto"
                                    />
                                </td>
                                <td>${produto.getNome()}</td>
                                <td>${produto.getDescricao()}</td>
                                <td>${produto.getPrecoFormatado()}</td>
                            </tr>
                        <%
                            }
                        %>

                        </tbody>
                    </table>

                    <div>
                        <h3>Informações da Compra</h3>
                    </div>

                    <p><strong>Forma de pagamento:</strong> ${param.formaPagamento}</p>
                    <p><strong>Parcelamento:</strong> ${param.parcelamento}</p>
                    <p><strong>Valor total da compra:</strong> ${param.precoTotalFormatado}</p>
                </section>
            </section>
        </main>

        <footer>
            <p>Felipe Teixeira de Lima &copy; 2026</p>
        </footer>
    </body>
</html>
