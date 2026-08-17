<!--<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>-->
<!doctype html>
<html lang="pt-br">
    <head>
        <title>Loja de Produtos de Informática</title>
        <link rel="stylesheet" href="styles.css" />
        <link rel="icon" type="image/jpg" href="resources/logo/Marca_IFSP_2015_Simpl_V_1.jpg">
    </head>
    <body>
        <%@page import="jakarta.servlet.http.HttpSession" %>

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
                <h2>Home</h2>
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
            <form method="POST" action="CarrinhoServlet">
                <section class="product-list">
                    <button type="submit">Fechar Carrinho</button>
                    <section class="card-container">
                        <label class="card">
                            <input
                                type="checkbox"
                                name="produtos"
                                id="qcy-h3"
                                value="resources/cards/qcy-h3.jpeg|Fones de Ouvido Bluetooth QCY H3 Preto|O QCY H3 ANC é um headphone over-ear sem fio de excelente custo-benefício. Ele destaca-se pelo Cancelamento Ativo de Ruído (ANC) adaptativo de até 43 dB, drivers dinâmicos de 40 mm com revestimento de titânio (certificação Hi-Res no modo com fio) e bateria com autonomia impressionante de até 60 horas.|249.90"
                            />
                            <img
                                class="card-image"
                                src="resources/cards/qcy-h3.jpeg"
                                alt="Imagem do produto"
                            />
                            <div class="card-content">
                                <h3 class="card-title">Fones de Ouvido Bluetooth QCY H3 Preto</h3>
                                <p class="card-description">
                                    O QCY H3 ANC é um headphone over-ear sem fio de excelente
                                    custo-benefício. Ele destaca-se pelo Cancelamento Ativo de Ruído
                                    (ANC) adaptativo de até 43 dB, drivers dinâmicos de 40 mm com
                                    revestimento de titânio (certificação Hi-Res no modo com fio) e
                                    bateria com autonomia impressionante de até 60 horas.
                                </p>
                                <p><strong>Preço:</strong> R$ 249,90</p>
                            </div>
                        </label>

                        <label class="card">
                            <input
                                type="checkbox"
                                name="produtos"
                                id="logitech-mk220"
                                value="resources/cards/logitech-mk220.jpg|Combo Teclado e Mouse sem fio Logitech MK220|O Combo Teclado e Mouse sem fio Logitech MK220 destaca-se pelo design compacto (teclado 36% menor que o padrão, mas com layout ABNT2 completo e teclado numérico), conexão sem fio de 2,4 GHz com alcance de até 10 metros, e longa autonomia de pilhas (até 24 meses para o teclado).|199.90"
                            />
                            <img
                                class="card-image"
                                src="resources/cards/logitech-mk220.jpg"
                                alt="Imagem do produto"
                            />
                            <div class="card-content">
                                <h3 class="card-title">
                                    Combo Teclado e Mouse sem fio Logitech MK220
                                </h3>
                                <p class="card-description">
                                    O Combo Teclado e Mouse sem fio Logitech MK220 destaca-se pelo
                                    design compacto (teclado 36% menor que o padrão, mas com layout
                                    ABNT2 completo e teclado numérico), conexão sem fio de 2,4 GHz
                                    com alcance de até 10 metros, e longa autonomia de pilhas (até
                                    24 meses para o teclado).
                                </p>
                                <p><strong>Preço:</strong> R$ 199,90</p>
                            </div>
                        </label>

                        <label class="card">
                            <input
                                type="checkbox"
                                name="produtos"
                                id="hp-deskjet-ink-advantage-2975"
                                value="resources/cards/hp-deskjet-ink-advantage-2975.jpg|Impressora Multifuncional HP DeskJet Ink Advantage 2975|A Impressora Multifuncional HP DeskJet Ink Advantage 2975 é um modelo 3 em 1 (imprime, copia e digitaliza) voltado para uso doméstico, estudantes e home office. Possui design compacto, conectividade Wi-Fi de banda dupla com autorrecuperação e suporte a impressão via celular pelo aplicativo HP Smart.|485.50"
                            />
                            <img
                                class="card-image"
                                src="resources/cards/hp-deskjet-ink-advantage-2975.jpg"
                                alt="Imagem do produto"
                            />
                            <div class="card-content">
                                <h3 class="card-title">
                                    Impressora Multifuncional HP DeskJet Ink Advantage 2975
                                </h3>
                                <p class="card-description">
                                    A Impressora Multifuncional HP DeskJet Ink Advantage 2975 é um
                                    modelo 3 em 1 (imprime, copia e digitaliza) voltado para uso
                                    doméstico, estudantes e home office. Possui design compacto,
                                    conectividade Wi-Fi de banda dupla com autorrecuperação e
                                    suporte a impressão via celular pelo aplicativo HP Smart.
                                </p>
                                <p><strong>Preço:</strong> R$ 485,50</p>
                            </div>
                        </label>

                        <label class="card">
                            <input
                                type="checkbox"
                                name="produtos"
                                id="san-disk-cruzer-blade-64"
                                value="resources/cards/san-disk-cruzer-blade-64.jpg|Pen Drive SanDisk Cruzer Blade 64GB|O Pen Drive Cruzer Blade SanDisk 64GB (modelo SDCZ50-064G-B35) é um dispositivo de armazenamento portátil ultracompacto. Ele conta com interface USB 2.0, visual nas cores preto e vermelho, e permite transferir e guardar fotos, músicas e documentos de forma simples pelo sistema arrastar e soltar.|42.50"
                            />
                            <img
                                class="card-image"
                                src="resources/cards/san-disk-cruzer-blade-64.jpg"
                                alt="Imagem do produto"
                            />
                            <div class="card-content">
                                <h3 class="card-title">Pen Drive SanDisk Cruzer Blade 64GB</h3>
                                <p class="card-description">
                                    O Pen Drive Cruzer Blade SanDisk 64GB (modelo SDCZ50-064G-B35) é
                                    um dispositivo de armazenamento portátil ultracompacto. Ele
                                    conta com interface USB 2.0, visual nas cores preto e vermelho,
                                    e permite transferir e guardar fotos, músicas e documentos de
                                    forma simples pelo sistema arrastar e soltar.
                                </p>
                                <p><strong>Preço:</strong> R$ 42,50</p>
                            </div>
                        </label>
                    </section>
                    <button type="submit">Fechar Carrinho</button>
                </section>
            </form>
        </main>

        <footer>
            <p>Felipe Teixeira de Lima &copy; 2026</p>
        </footer>

        <script>
            // Script que obriga o usuário a selecionar pelo menos 1 item para fechar o carrinho

            const checkboxes = Array.from(document.querySelectorAll('input[name="produtos"]'));

            function enforceAtLeastOneChecked() {
                const anyChecked = checkboxes.some(cb => cb.checked);

                checkboxes.forEach(cb => {
                    cb.required = !anyChecked;
                });
            }

            document.addEventListener('DOMContentLoaded', () => {
                enforceAtLeastOneChecked();

                checkboxes.forEach(checkbox => {
                    checkbox.addEventListener('change', enforceAtLeastOneChecked);
                });
            });
        </script>
    </body>
</html>
