<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accueil</title>
</head>
<body>

	<header>
		<h1>ENI-Enchères</h1>

		<c:if test="${sessionScope.connexion eq null}">
			<%@ include file="header_notconnected.jsp"%>
		</c:if>

		<c:if test="${sessionScope.connexion != null}">
			<%@ include file="header_connected.jsp"%>
		</c:if>

	</header>

	<h2>Liste des enchères</h2>
	<c:forEach items="${liste_article}" var="ArticleSold">


		<div>
		
		<a href="<c:url value="/Servlet_article">
            <c:param name="num" value="${ArticleSold.articleNum}"/>
        </c:url>
    ">${ArticleSold.articleName}</a>
			Prix : ${ArticleSold.sellingPrice} Fin de l'enchère :
			${ArticleSold.auctionEndingDate} Vendeur :
			${ArticleSold.user.nickname}

		</div>

	</c:forEach>


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



	<nav>
		<ul>
			<li class="deroulant"><a href="#">Toutes</a>
				<ul class="sous">
					<li><a href="#">Informatique</a></li>
					<li><a href="#">Ameublement</a></li>
					<li><a href="#">Vêtements</a></li>
					<li><a href="#">Sport et Loisirs</a></li>
				</ul>
	</nav>










</body>
</html>