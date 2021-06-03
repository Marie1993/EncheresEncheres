<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="CSS\Template.css">

<title>Se connecter</title>
</head>
<body>
<div class = "body">


	<div class="error_message">${requestScope.connexion}</div>

	<form method="POST" action="/EncheresEncheres/Servlet_login">
		<div class="form">
			<div class="nickname">
				<label for="nickname">Pseudo ou adresse e-mail</label> <input
					name="id" type="text">
			</div>
			<div class="password">
				<div class = "label_password"><label for="password">Mot de passe</label></div>
				<div class = "input_password"><input name="password" type="password"></div></div>
			<div class = "btn"><input type="submit"
					value="Valider"></div>
		</div>
	</form>

</div>
</body>
</html>