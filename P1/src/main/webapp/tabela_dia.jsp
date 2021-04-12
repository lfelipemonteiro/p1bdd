<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Data</title>
</head>
<body>
	<c:out value="${data}"></c:out>
	<table>
		<tbody>
			<c:forEach var="grupos" items="${listagem}">
				<tr>
					<td>${grupos.getCodigoTimeA()}</td>
					<td>${grupos.getCodigoTimeB()}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>