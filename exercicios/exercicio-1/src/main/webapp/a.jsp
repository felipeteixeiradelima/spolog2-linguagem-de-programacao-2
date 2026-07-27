<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Melancias</title>
</head>
<body>
    <%!String[][] matrizFornecedores = {
        {"Melancias do Luizão", "7.00", "0.00"},
        {"MariCelancias", "20.00", "4.00"},
        {"Lucas Hortifrutes", "12.00", "0.00"},
        {"Felipe Frutas", "18.00", "3.00"},
        {"Feirinha do Marcão", "6.50", "0.00"}
    }; %>

    <%
    for (String[] fornecedor : matrizFornecedores) {
    	String nome = fornecedor[0];
		double preco = Double.parseDouble(fornecedor[1]);
		double frete = Double.parseDouble(fornecedor[2]);
		
		if (preco <= 8 & frete == 0) {
			out.println("<p>O fornecedor " + nome + " é vantajoso.</p>");
		}
    }
    %>

</body>
</html>
