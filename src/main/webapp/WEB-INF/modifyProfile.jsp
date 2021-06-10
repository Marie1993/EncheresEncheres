<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="CSS\CSS.css">
<style type="text/css"> 
a:link 
{ 
 text-decoration:none; 
} 
</style>
<title>Insert title here</title>
</head>

	<header >
	
	
		<h1>ENI-Enchères</h1>

			<%@ include file="header_connected.jsp"%>
		
	</header>

<body>

	<form method="post" action="/EncheresEncheres/Servlet_modif_profile">

		<h1>Modifier mon profil</h1>

		<input type="hidden" id="numUser" name="numUser"
			value="${sessionScope ['User'].numUser}"
			placeholder="${sessionScope ['User'].numUser}" />

		<div>
			<label for="pseudo">Votre pseudo :</label> <input type="text"
				name="pseudo" id="pseudo" value="${sessionScope ['User'].nickname}"
				placeholder="${sessionScope ['User'].nickname}" />
		</div>

		<div>
			<label for="nom">Nom :</label> <input type="text" name="name"
				id="name" value="${sessionScope ['User'].name}"
				placeholder="${sessionScope ['User'].name}" />
		</div>

		<div>
			<label for="prenom">Prénom :</label> <input type="text"
				name="surname" id="surname" value="${sessionScope ['User'].surname}"
				placeholder="${sessionScope ['User'].surname}" />
		</div>

		<div>
			<label for="email">Email :</label> <input type="text" name="email"
				id="email" value="${sessionScope ['User'].email}"
				placeholder="${sessionScope ['User'].email}" />
		</div>

		<div>
			<label for="phone">Téléphone :</label> <input type="text"
				name="phone" id="phone" value="${sessionScope ['User'].phone}"
				placeholder="${sessionScope ['User'].phone}" />
		</div>

		<div>
			<label for="numStreet">Rue :</label> <input type="text"
				name="numStreet" id="numStreet"
				value="${sessionScope ['User'].numStreet}"
				placeholder="${sessionScope ['User'].numStreet}" />
		</div>

		<div>
			<label for="postalCode">Code postal :</label> <input type="text"
				name="postalCode" id="postalCode"
				value="${sessionScope ['User'].postalCode}"
				placeholder="${sessionScope ['User'].postalCode}" />
		</div>
		<div>
			<label for="city">Ville :</label><input type="text" name="city"
				id="city" value="${sessionScope ['User'].city}"
				placeholder="${sessionScope ['User'].city}" />
		</div>
		<div>
			<label for="password">Mot de passe :</label> <input type="password"
				name="password" id="password"
				value="${sessionScope ['User'].password}"
				placeholder="${sessionScope ['User'].password}" />
		</div>



		<div>
			<input type="submit" value="Valider">
		</div>
	</form>
	
	<a href = "/EncheresEncheres/Servlet">Retour à l'accueil</a>
	<a href = "/EncheresEncheres/Servlet_delete_account">Supprimer mon compte</a>

</body>
</html>