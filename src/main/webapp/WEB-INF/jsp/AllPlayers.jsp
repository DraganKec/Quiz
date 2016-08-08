<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display all players</title>
</head>
<body>
	<table>
		<tr>
			<c:forEach var="players" items="${allPlayers}">
				<td>${players.id }</td>
				<td>${players.name }</td>
				<td>${players.results }</td>
			</c:forEach>

		</tr>
	</table>
</body>
</html>