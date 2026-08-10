<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <title>Resultado</title>
        <link rel="stylesheet" href="styles.css" />
    </head>
    <body>
        <header>
            <h1>Conversor de Medidas</h1>
            <h2>Resultado</h2>
            <hr />
        </header>

        <main>
            <div class="resultado">
                <%
                    Object medidaBruta = request.getAttribute("medida");
                    Object medidaConvertidaBruta = request.getAttribute("medida-convertida");
                    String grandezaOrigem = (String) request.getAttribute("grandeza-origem");
                    String grandezaDestino = (String) request.getAttribute("grandeza-destino");
                    if (medidaBruta == null || medidaConvertidaBruta == null) {
                        out.println("<p>A medida <strong>\"" + medidaBruta + "\"</strong> é inválida!</p>");
                    } else {
                        double medida = Double.parseDouble(medidaBruta.toString());
                        double medidaConvertida = Double.parseDouble(medidaConvertidaBruta.toString());
                        out.println("<p><strong>" + medida + " " + grandezaOrigem + "</strong> equivalem a <strong>" + medidaConvertida + " " + grandezaDestino + "</strong>!</p>");
                    }
                %>
            </div>
        </main>
    </body>
</html>
