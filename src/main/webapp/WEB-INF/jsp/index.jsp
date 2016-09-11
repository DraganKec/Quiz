<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html lang="en">
<link href="/styles.css" rel="stylesheet" type="text/css" />
<body>
	<form action="questions" method="post">
		<div class="container">
			<div class="button">
				Upisite svoje ime <input type="text" name="playerName" id="playerName">
			</div>
			<div class="button">
				Izaberite kategoriju: <select name="categoryid">
					<option value="1">Muzika</option>
					<option value="2">Film</option>
					<option value="3">Sport</option>
				</select>
			</div>
			<div class="button">
				Broj pitanja: <select name="numberQuestions">
					<option value="3">3</option>
					<option value="5">5</option>
					<option value="10">10</option>
				</select>
			</div>
			<div class="button">
				<input type="submit" value="Pitanja">
			</div>
		</div>
	</form>
	<br>	
</body>

</html>