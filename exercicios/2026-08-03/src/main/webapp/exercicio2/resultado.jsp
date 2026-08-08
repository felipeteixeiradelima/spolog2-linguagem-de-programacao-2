<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <title>Resultado</title>
    </head>
    <body>
        <header>
            <h1>Conversor de Medidas</h1>
            <h2>Resultado</h2>
            <hr />
        </header>

        <main>
            <div>
                <%
                    Object medidaBruta = request.getAttribute("medida");
                    Object medidaConvertidaBruta = request.getAttribute("medida-convertida");
                    String grandezaOrigem = (String) request.getAttribute("grandeza-origem");
                    String grandezaDestino = (String) request.getAttribute("grandeza-destino");
                    if (medidaBruta == null || medidaConvertidaBruta == null) {
                        out.println("<p>A medida \"" + medidaBruta + "\" é inválida!</p>");
                    } else {
                        double medida = Double.parseDouble(medidaBruta.toString());
                        double medidaConvertida = Double.parseDouble(medidaConvertidaBruta.toString());
                        out.println("<p>" + medida + " " + grandezaOrigem + " equivale a " + medidaConvertida + " " + grandezaDestino + "!<p>");
                    }
                %>
            </div>
        </main>
    </body>
</html>
