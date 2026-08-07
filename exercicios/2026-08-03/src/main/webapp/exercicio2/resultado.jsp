<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Resultado</title>
    </head>
    <body>
        <header>
            <h1>Conversor de Medidas</h1>
            <h2>Resultado</h2>
            <hr />
        </header>

        <main>
            <%
                double medida = (double) request.getAttribute("medida");
                double medidaConvertida = (double) request.getAttribute("medida-convertida");
                String grandezaOrigem = request.getAttribute("grandeza-origem");
                String grandezaDestino = request.getAttribute("grandeza-destino");
                
                if (medidaConvertida == null) {
                    out.printf("<p>A medida \"%s\" é inválida!</p>\n", medida);
                } else {
                    out.printf("<p>%s %s equivale a %s %s!\n", medida, grandezaOrigem, medidaConvertida, grandezaDestino);
                }
            %>
        </main>
    </body>
</html>
