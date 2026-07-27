<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pizzaria</title>
</head>
<body>
	<%!String[][] matrizClientes = {
        {"Luiz", "10", "400.00"},
        {"Mariana", "30", "1000.00"},
        {"Lucas", "7", "300.00"},
        {"Felipe", "25", "900.00"},
        {"Marcos", "8", "350.00"},
        {"Lincoln", "15", "600.00"},
        {"Beatriz", "4", "160.00"},
        {"Ana Luiza", "6", "280.00"},
        {"Pedro", "18", "800.00"},
        {"João", "9", "360.00"}
    }; %>
 
    <%
    for (String[] cliente : matrizClientes) {
    	String nome = cliente[0];
		double quantidadePizzasTotal = Integer.parseInt(cliente[1]);
		double gastoTotal = Double.parseDouble(cliente[2]);

		if (quantidadePizzasTotal >= 10 | gastoTotal >= 500) {
			out.println("<p>O cliente " + nome + " tem direito a uma pizza da promoção.</p>");
		}
    }
    %>
 
</body>
</html>