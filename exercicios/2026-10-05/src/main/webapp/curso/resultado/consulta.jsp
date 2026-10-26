<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="entity.Curso"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<title>Consulta de Cursos</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
</head>
<body>
  <nav class="navbar navbar-expand-sm navbar-dark bg-dark">
    <ul class="navbar-nav align-items-center">
      <li><a href="index.html" class="h4 px-4 text-decoration-none text-white">Universidade</a></li>
      <li><a href="EstudanteController" class="h5 pt-3 nav-link active">Estudantes</a></li>
      <li><a href="CursoController" class="h5 pt-3 nav-link active">Cursos</a></li>
    </ul>
  </nav>
  <div class="py-3 px-4">
    <h4>Consulta de Cursos</h4>
  </div>
  <div class="px-4">
  <table class="table table-sm">
    <thead class="table-success">
      <tr>
        <th><div class="d-flex justify-content-center">Id</div></th>
        <th><div class="d-flex justify-content-center">Descrição</div></th>
        <th><div class="d-flex justify-content-center">Carga Horária (h)</div></th>
        <th colspan="2"><div class="d-flex justify-content-center">Operações</div></th>
      </tr>
    </thead>
    <tbody>
      <%
      List<Curso> cursos = (List<Curso>) request.getAttribute("cursos");

      for (Curso curso : cursos) {
        String descricao = curso.getDescricao();
        Integer cargaHoraria = curso.getCargaHoraria();
        String cargaHorariaString = "N/A";

        if (descricao == null) {
            descricao = "N/A";
        }

        if (cargaHoraria != null) {
            cargaHorariaString = cargaHoraria.toString();
        }

      	out.println("<tr>");
      	out.println("<td><div class='d-flex justify-content-center'>" + curso.getId() + "</div></td>");
      	out.println("<td><div class='d-flex justify-content-center'>" + descricao + "</div></td>");
      	out.println("<td><div class='d-flex justify-content-center'>" + cargaHorariaString + "</div></td>");

        // Botão Alterar
        out.println("<td><div class='d-flex justify-content-center'><form action='curso/operacao/alteracao.jsp' method='post'>");
      	out.println("<input type='hidden' name='tdId' value='" + curso.getId() + "'>");
      	out.println("<input type='hidden' name='tdDescricao' value='" + curso.getDescricao() + "'>");
      	out.println("<input type='hidden' name='tdCargaHoraria' value='" + curso.getCargaHoraria() + "'>");
      	out.println("<input type='submit' name='btAlterar' value='Alterar' class='btn btn-success px-3 py-0'>");
      	out.println("</form></div></td>");

        // Botão Excluir
      	out.println("<td><div class='d-flex justify-content-center'><form action='curso/operacao/exclusao.jsp' method='post'>");
      	out.println("<input type='hidden' name='tdId' value='" + curso.getId() + "'>");
      	out.println("<input type='hidden' name='tdDescricao' value='" + curso.getDescricao() + "'>");
      	out.println("<input type='hidden' name='tdCargaHoraria' value='" + curso.getCargaHoraria() + "'>");
      	out.println("<input type='submit' name='btExcluir' value='Excluir' class='btn btn-success px-3 py-0'>");
      	out.println("</form></div></td>");
      	out.println("</tr>");
      }
      %>
    </tbody>
  </table>
  <a href="curso/operacao/insercao.jsp" class="btn btn-success">Inserir Curso</a>
  </div>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
</body>
</html>
