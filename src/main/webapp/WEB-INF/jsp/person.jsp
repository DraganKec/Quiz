<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="getall" method="post">
		Name: <input type="text" value=""> <br> Surname: <input
			type="text" value=""> <br> Age: <input type="text"
			value=""> <br> Address: <input type="text" value="">
		<br> <input type="submit" value="save">
	</form>
	<table>
		<tr>
			<c:forEach var="list" items="${personList}">
				<td>${list.name }</td>
				<td>${list.surName }</td>
			</c:forEach>

		</tr>
	</table>
</body>
</html>