<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sumario</title>
</head>
<body>
	<form action="geraGrupos" method="post">
		<button type="submit" value="gerar">grupos</button>
	</form>

	<form action="geraJogos" method="post">
		<button type="submit" value="Gerar">jogos</button>
	</form>
	<form action="listagemGrupos" method="post">
		<button type="submit" value="mostrar">ver grupos</button>
	</form>
	<form action="pesquisaJogos" method="post">
		<div>
			<label>pesquisa</label>
		</div>
		<div>
			<input type="date" name="data" id="data" placeholder="data">
		</div>
		<div>
			<input type="submit" value="Pesquisar">
		</div>
	</form>
</body>
</html>