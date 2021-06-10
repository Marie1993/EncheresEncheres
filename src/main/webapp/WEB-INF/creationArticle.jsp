<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form method="post" action="/EncheresEncheres/Servlet_creation_article">

		<h1>Mettre un bien en ligne</h1>

		
		<div>
			<label for="nameArticle">Titre annonce :</label>
		</div>
		<input type="text" name="nameArticle" id="nameArticle" />

		<div>
			<label for="description">Description de votre annonce :</label>
		</div>
		<textarea name="description" id="description" rows="10" cols="50"></textarea>

		<div>
			<label for="categories">Catégorie :</label>
		</div>
		<div>
			<select name="categories" id="categories">
				<option value="1">Informatique</option>
				<option value="2">Ameublement</option>
				<option value="3">Vêtements</option>
				<option value="4">Sport et Loisirs</option>
			</select>
		</div>
		<!--  uploader image -->
		
	
		<div>
			<label for="sellerPrice">Votre prix de vente :</label>
		</div>
		<input type="number" name="sellerPrice" id="sellerPrice" />
		
		<div>
			<label for="startAuction">Debut de l'enchère :</label>
		</div>
		<input type="datetime-local" name="startAuction" id="startAuction" />
		
		<div>
			<label for="endAuction">Fin de l'enchère :</label>
		</div>
		<input type="datetime-local" name="endAuction" id="endAuction" />
		
		
		<fieldset>
		<legend>Retrait</legend>
		
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
		
		
		
		</fieldset>

		<div>
			<input type="submit" value="Enregistrer">
	
		 <input type="button" onclick="window.location.href = 'http://localhost:8080/EncheresEncheres/';" value="Annuler"/>
		</div>
		
	</form>

</body>
</html>