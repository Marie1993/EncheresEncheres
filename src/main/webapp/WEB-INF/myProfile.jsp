<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" type="text/css" href="CSS\Template.css">

<style type="text/css"> 
a:link 
{ 
 text-decoration:none; 
} 
</style>

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
		
		
		
		<div>Pseudo : ${User.nickname}</div>

		<div>Nom : ${User.name}</div>

		<div>Prénom : ${User.surname}</div>

		<div>Email : $User.email</div>

		<div>Téléphone : $User.phone</div>

		<div>Rue : $User.numStreet</div>

		<div>Code postal : $User.postalCode</div>

		<div>Ville : $User.city</div>
		
		<div>Crédit : $User.credit</div>
	</div>
</div>

<a href="/EncheresEncheres//Servlet_modif_profile">Modifier mon profil</a>

</body>
</html>