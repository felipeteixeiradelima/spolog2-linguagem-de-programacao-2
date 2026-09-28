<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.math.BigDecimal"%>
<!DOCTYPE html>
<html>
<head>
<title>Exclusão de Estudante</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
</head>
<body>
  <nav class="navbar navbar-expand-sm navbar-dark bg-dark">
    <ul class="navbar-nav align-items-center">
      <li><a href="../../index.html" class="h4 px-4 text-decoration-none text-white">Universidade</a></li>
      <li><a href="../../EstudanteController" class="h5 pt-3 nav-link active">Estudantes</a></li>
      <li><a href="#" class="h5 pt-3 nav-link active">Cursos</a></li>
    </ul>
  </nav>
  <div class="py-3 px-4">
    <h4>Exclusão de Estudante</h4>
  </div>
  <div class="px-4">
    <h5>Deseja realmente excluir este estudante?</h5>
    <p class="my-0"><b>Id: </b> ${param.tdId}</p>
    <p class="my-0"><b>Nome: </b> ${param.tdNome}</p>
    <%
        String printableSexo = "Feminino";
        char sexo = request.getParameter("tdSexo").charAt(0);

        if (sexo == 'M') {
            printableSexo = "Masculino";
        }

        out.println("<p class='my-0'><b>Sexo:</b> " + printableSexo + "</p>");
    %>
    <p class="my-0"><b>PCD: </b> ${param.tdPcd ? "Sim" : "Não"}</p>
    <!--
    <%
    out.println("<p class='my-0'><b>Id:</b> " + request.getParameter("tdId") + "</p>");
    out.println("<p class='my-0'><b>Nome:</b> " + request.getParameter("tdNome") + "</p>");
    out.println("<p class='my-0'><b>IRA:</b> " + request.getParameter("tdIra").replace(".", ",") + "'></p>");
    out.println("<p class='my-0'><b>Disponível:</b> " + request.getParameter("tdPcd") + "</p>");
    %>
    -->
    <form action="../../EstudanteController?op=exclusao" method="post">
      <input type="hidden" name="txId" value=${param.tdId}>
      <!--
      <%
      out.println("<input type='hidden' name='txId' value='" + request.getParameter("tdId") + "'>");
      %>
      -->
      <div class="pt-3">
        <input type="submit" name="btExcluir" value="Excluir" class="btn btn-success">
        <a href="../../EstudanteController" class="btn btn-danger">Cancelar</a>
      </div>
    </form>
  </div>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
</body>
</html>
