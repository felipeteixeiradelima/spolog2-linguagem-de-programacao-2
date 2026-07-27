<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="" method="post">
		<div>
			<label for="valor1">Valor 1</label>
			<input type=”text” name="valor1">
		</div>

		<div>
			<label for="valor2">Valor 2</label>
			<input type=”text” name="valor2">
		</div>
		
		<div>
			<label for="operacao">Operação</label>
			<select name="operacao">
				<option value="+">Adição</option>
				<option value="-">Subtração</option>
				<option value="*">Multiplicação</option>
				<option value="/">Divisão</option>
				<option value="%">Módulo (resto da divisão)</option>
			</select>
		</div>
		
		<button type="submit">Calcular</button>
	</form>
	
	<%! Double valor1; %>
	<%! Double valor2; %>
	<%! String operacao; %>
	<%! Double resultado; %>
	
	<%
	valor1 = Double.parseDouble(request.getParameter("valor1"));
	valor2 = Double.parseDouble(request.getParameter("valor2"));
	operacao = request.getParameter("operacao");

    if (valor1 == null | valor2 == null | operacao == null) {
    	return;
    }

    switch (operacao) {
	case "+":
		resultado = valor1 + valor2;
	case "-":
		resultado = valor1 - valor2;
	case "*":
		resultado = valor1 * valor2;
	case "/":
		resultado = valor1 / valor2;
	case "%":
		resultado = valor1 % valor2;
	}

    out.println("<p>Resultado: " + resultado + "</p>");
	%>
</body>
</html>