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
                out.println(request.getAttribute("medida"));
                out.println(request.getAttribute("medida-convertida"));
                out.println(request.getAttribute("grandeza-origem"));
                out.println(request.getAttribute("grandeza-destino"));
                
                <!-- double medida = (double) request.getAttribute("medida");
                Object medidaConvertidaBruta = request.getAttribute("medida-convertida");
                String grandezaOrigem = (String) request.getAttribute("grandeza-origem");
                String grandezaDestino = (String) request.getAttribute("grandeza-destino");

                if (medidaConvertidaBruta == null) {
                    out.println("<p>A medida \"" + medida + "\" é inválida!</p>");
                } else {
                    double medidaConvertida = (double) medidaConvertidaBruta;
                    out.println("<p>" + medida + " " + grandezaOrigem + " equivale a " + medidaConvertida + " " + grandezaDestino + "!<p>");
                } -->
            %>
        </main>
    </body>
</html>
