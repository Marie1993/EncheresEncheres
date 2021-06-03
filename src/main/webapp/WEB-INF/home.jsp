<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accueiiiil</title>
</head>
<body>
	<h1>ENI-Enchères</h1>

	<c:if test="${sessionScope.connexion eq null}">
		<a href="#">S'inscrire -</a>
		<a href="/EncheresEncheres/Servlet_login">Se connecter</a>
	</c:if>


	<c:if test="${sessionScope.connexion != null}">
    <a href="/EncheresEncheres/Servlet_profile">Mon profil</a>
</c:if>

	<h2>Liste des enchères</h2>

	<h3>Filtres :</h3>
	<label for="site-search"></label>
	<input type="search" id="site-search" name="q"
		aria-label="Search through site content"
		placeholder="Le nom de l'article contient">

	<button>Rechercher</button>

	<h4>Catégorie :</h4>
<<<<<<< Updated upstream

	<nav>
		<ul>
			<li class="deroulant"><a href="#">Toutes</a>
				<ul class="sous">
					<li><a href="#">Informatique</a></li>
					<li><a href="#">Ameublement</a></li>
					<li><a href="#">Vêtements</a></li>
					<li><a href="#">Sport et Loisir</a></li>
				</ul>
	</nav>

=======
	
		<nav>
			<ul>
				<li class="deroulant"><a href="#">Toutes</a>
					<ul class="sous">
						<li><a href="#">Informatique</a></li>
						<li><a href="#">Ameublement</a></li>
						<li><a href="#">Vêtements</a></li>
						<li><a href="#">Sport et Loisir</a></li>
					</ul>
		</nav>
	
	
	
	
	
	
	
	
	
	
>>>>>>> Stashed changes
</body>
</html>