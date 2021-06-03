<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Se connecter</title>
</head>
<body>
	<form method="POST" action="/Encheres/Servlet_login">
		<label for="nickname">Pseudo</label> <input name="nickname"
			type="text">
		<label for="password">Mot de passe</label> <input
			name="password" type="password">
		<br />
		
		<input type="submit" value = "Valider">

	</form>

</body>
</html>