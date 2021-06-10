<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="CSS\Template.css">
<link rel="stylesheet" type="text/css" href="CSS\CSS.css">
<style type="text/css"> 
a:link 
{ 
 text-decoration:none; 
} 
</style>
<title>Se connecter</title>
</head>

<header >
	
	
		<h1>ENI-Enchères</h1>

		<c:if test="${sessionScope.connexion eq null}">
			<%@ include file="header_notconnected.jsp"%>
		</c:if>


	</header>

<body>
<div class = "body">


	<div class="error_message">${requestScope.connexion}</div>
	
	<div class="error_message">${requestScope.refusconnexion}</div>

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