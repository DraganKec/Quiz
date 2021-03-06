<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Rezultati</title>
</head>
<style>
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}

th, td {
	padding: 5px;
	text-align: left;
}
</style>
<body>
	<h2>Igrac ${player} je imao tacnih odgovora ${results }</h2>
	<br>
	<table>
		<tr>
			<th>id</th>
			<th>Ime</th>
			<th>Rezultati</th>
			<th>Vrijeme</th>
		</tr>
			<c:forEach items="${playerresults}" var="player">
			<tr>
				<td>${player.id}</td>				
				<td>${player.name}</td>
				<td>${player.results}</td>
				<td>${player.date}</td>
				</tr>
			</c:forEach>
	</table>

	<form action="/">
		<input type="submit" value="Pocetak">
	</form>
</body>
</html>