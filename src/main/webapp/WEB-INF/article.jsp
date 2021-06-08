<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="CSS\Template.css">
<title></title>
</head>
<body>
<div class = "page">
	<header>

		<c:if test="${sessionScope.connexion eq null}">
			<%@ include file="header_notconnected.jsp"%>
		</c:if>


		<c:if test="${sessionScope.connexion != null}">
			<%@ include file="header_connected.jsp"%>
		</c:if>
	</header>

	<div class="profil">
		
		
		
		<div>Nom de l'article : ${sessionScope ['article'].articleName}</div>

		<div>Description : ${sessionScope ['article'].description}</div>
		
		<div>Catégorie : ${sessionScope ['article'].category.wording}</div>

		<div>Début de l'enchère : ${sessionScope ['article'].auctionStartingDate}</div>

		<div>Fin de l'enchère : ${sessionScope ['article'].auctionEndingDate}</div>

		<div>Prix de base : ${sessionScope ['article'].startingPrice}</div>
		
		<div>Prix actuel : ${sessionScope ['article'].sellingPrice}</div>

		<div>Vendeur : ${sessionScope ['article'].user.nickname}</div>
		
		<div>Point de retrait : ${sessionScope ['article'].withdrawal.streetNum}</div>
		
		<div>${sessionScope ['article'].withdrawal.postalCode}
		${sessionScope ['article'].withdrawal.cityName}</div>

		
	</div>
</div>



</body>
</html>