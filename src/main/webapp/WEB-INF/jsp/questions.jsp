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
	<form action="/anotherQuestions">
		<br>
		<h1>${title}</h1>
		<br>
		<table>

			<c:forEach var="answers" items="${answersList}">
				<tr>
					<td><input type="submit" type="button"
						value="${answers.answer }" onclick="myFunction();"
						name="playersAnswer" /></td>
				</tr>
			</c:forEach>
		</table>
	</form>
<h1>Tacan odgovor: ${trueanswer }</h1>

<h4>Rezultat: ${results }</h4>

</body>
</html>