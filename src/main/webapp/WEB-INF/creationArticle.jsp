<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form method="post" action="/Encheres/Servlet_creation_article">

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
			<select name="categories" id="categories">
				<option value="all">Toutes</option>
				<option value="computing">Informatique</option>
				<option value="furniture">Ameublement</option>
				<option value="clothes">Vêtements</option>
				<option value="sport">Sport et Loisirs</option>
			</select>
		</div>
		<!--  uploader image -->
		
		<div> <input type="number" /> </div>


		<div>
			<label for="sellerPrice">Votre prix de vente :</label>
		</div>
		<input type="text" name="sellerPrice" id="sellerPrice" />

		<div>
			<input type="submit" value="Valider">
		</div>
		
		
	</form>

</body>
</html>