<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="CSS\Template.css">
<title></title>
</head>
<body>
	<div class="profil">
		<div>Pseudo : 	${sessionScope ['User'].nickname}</div>

		<div>Nom : 	${sessionScope ['User'].name}</div>

		<div>Prénom : 	${sessionScope ['User'].surname}</div>

		<div>Email : 	${sessionScope ['User'].email}</div>

		<div>Téléphone : 	${sessionScope ['User'].phone}</div>

		<div>Rue : 	${sessionScope ['User'].numStreet}</div>

		<div>Code postal : 	${sessionScope ['User'].postalCode}</div>

		<div>Ville : 	${sessionScope ['User'].city}</div>
	</div>

</body>
</html>