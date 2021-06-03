

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ACCUEIL</title>
</head>
<body>
	<h1>ENI-Enchères</h1>

	//link with the Servlet from the DB
	<a href="#">S'incrire -</a>
	<a href="/Encheres/Servlet_login">Se connecter</a>

	<h2>Liste des enchères</h2>

	<h3>Filtres :</h3>
	<label for="site-search"></label>
	<input type="search" id="site-search" name="q"
		aria-label="Search through site content"
		placeholder="Le nom de l'article contient">

	<button>Rechercher</button>

	<h4>Catégorie :</h4>
	
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
	
</body>
</html>