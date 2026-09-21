<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Alteração de Estudante</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="../webjars/bootstrap/5.0.2/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body>
  <nav class="navbar navbar-expand-sm navbar-dark bg-dark">
    <ul class="navbar-nav align-items-center">
      <li><a href="../index.html" class="h4 px-4 text-decoration-none text-white">Universidade</a></li>
      <li><a href="../EstudanteController" class="h5 pt-3 nav-link active">Estudantes</a></li>
      <li><a href="#" class="h5 pt-3 nav-link active">Cursos</a></li>
    </ul>
  </nav>
  <div class="py-3 px-4">
    <h4>Alteração de Estudante</h4>
  </div>
  <div class="px-4">
    <form action="../EstudanteController?op=alteracao" method="post">
        <p>Id <input type="text" name="txId" size="10" value=${param.tdId} readonly></p>
        <p>Nome <input type="text" name="txNome" size="50" value=${param.tdNome} required></p>
      <%
        out.println("<p>IRA <input type='text' name='txIra' size='20' value='" + request.getParameter("tdIra").
                    replace(".", ",") + "'></p>");
      %>
        <input type="checkbox" name="ckPcd" ${param.tdPcd ? "checked" : ""}>
      <div class="pt-3">
        <input type="submit" name="btAlterar" value="Alterar" class="btn btn-success">
        <a href="../EstudanteController" class="btn btn-danger">Cancelar</a>
      </div>
    </form>
  </div>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
</body>
</html>
