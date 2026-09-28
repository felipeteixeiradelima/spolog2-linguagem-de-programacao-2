<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<title>Cadastro de Estudante</title>
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
    <h4>Cadastro de Estudante</h4>
  </div>
  <div class="px-4">
    <form action="../../EstudanteController?op=insercao" method="post">
      <p>Nome <input type="text" name="txNome" size="50" required></p>
      <p>
          Sexo
          <input type="radio" name="rdSexo" id="masculino" value="M">
          <label for="masculino">Masculino</label>
          <input type="radio" name="rdSexo" id="feminino" value="F">
          <label for="feminino">Feminino</label>
      </p>
      <p>
        <input type="checkbox" name="ckPcd" id="ckPcd">
	    <label for="ckPcd">PDC</label>
	  </p>
      <p>IRA <input type="text" name="txIra" size="5"></p>
      <div class="pt-3">
        <input type="submit" name="btInserir" value="Inserir" class="btn btn-success">
        <a href="../../EstudanteController" class="btn btn-danger">Cancelar</a>
      </div>
    </form>
  </div>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
</body>
</html>
