<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" type="text/css" href="CSS\CSS.css">
<style type="text/css">
a:link {
	text-decoration: none;
}
</style>

<title>Accueil</title>
<header>


	<h1>ENI-Enchères</h1>

	<c:if test="${sessionScope.connexion eq null}">
		<%@ include file="header_notconnected.jsp"%>
	</c:if>

	<c:if test="${sessionScope.connexion != null}">
		<%@ include file="header_connected.jsp"%>
	</c:if>

</header>



</head>
<body>
<div class="recherche">
	<img src="images\ban2.jpeg" id="ban" />



	<h3>un bien particulier à touver ? </h3>
	<label for="site-search"></label>
	<input type="search" id="site-search" name="q"
		aria-label="Search through site content"
		placeholder="Le nom de l'article contient">

	<button class="button">Rechercher</button>
</div>
	
	
	
	<div id="menu">

    <div class="example">
      <a href=#><img src="images\inf.jpeg" alt="tile3" width="200" height="320px" alt="house" /></a>
      <div class="fadedbox">
        <div class="title text"> Informatique </div>
      </div>
    </div>
    
    <div class="example">
      <a href=#><img src="images\sport.jpeg" alt="tile3" width="200" height="320px" alt="house" /></a>
      <div class="fadedbox">
        <div class="title text"> Sport </div>
      </div>
    </div>
	
    <div class="example">
      <a href=#><img src="images\meuble.jpeg" alt="tile3" width="200" height="320px" alt="house" /></a>
      <div class="fadedbox">
        <div class="title text"> Ameublement </div>
      </div>
    </div>
    
    <div class="example">
      <a href=#><img src="images\mode.jpeg" alt="tile3" width="200" height="320px" alt="house" /></a>
      <div class="fadedbox">
        <div class="title text"> Mode </div>
      </div>
    </div>
	</div>
		
	<h2>Touts nos biens disponibles : </h2>
	
<div id="AuctionsAll">

	
	<div class="listAuction">
	<c:forEach items="${liste_article}" var="ArticleSold">


		

			<h4><a
				href="<c:url value="/Servlet_article">
            <c:param name="num" value="${ArticleSold.articleNum}"/>
        </c:url>
    ">${ArticleSold.articleName}</a></h4>
    
		<div>	Prix : ${ArticleSold.sellingPrice} </div>
		
		<div>Fin de l'enchère :
			${ArticleSold.auctionEndingDate} </div>
			Vendeur : <a
				href="<c:url value="/Servlet_show_user">
            <c:param name="nickname" value="${ArticleSold.user.nickname}"/>
        </c:url>
    ">${ArticleSold.user.nickname}</a></div>


		
	<div class="listAuction">
	</c:forEach>

</div></div>







</body>
</html>