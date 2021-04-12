<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Jogos</title>
</head>
<style>
</style>
<body>
	GRUPO A
	<table>
		<tr>
			<th>TIME</th>
		</tr>
		<c:forEach var="grupos" items="${listagem_A}">
			<tr>
				<td>${grupos.getCodigoTime()}</td>
			</tr>
		</c:forEach>
	</table>
	GRUPO B
	<table>
		<tr>
			<th>TIME</th>
		</tr>
		<c:forEach var="grupos" items="${listagem_B}">
			<tr>
				<td>${grupos.getCodigoTime()}</td>
			</tr>
		</c:forEach>
	</table>
	GRUPO C
	<table>
		<tr>
			<th>TIME</th>
		</tr>
		<c:forEach var="grupos" items="${listagem_C}">
			<tr>
				<td>${grupos.getCodigoTime()}</td>
			</tr>
		</c:forEach>
	</table>
	GRUPO D
	<table>
		<tr>
			<th>TIME</th>
		</tr>
		<c:forEach var="grupos" items="${listagem_D}">
			<tr>
				<td>${grupos.getCodigoTime()}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>