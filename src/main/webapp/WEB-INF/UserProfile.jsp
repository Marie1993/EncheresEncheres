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

<title></title>
</head>
<body>
<div class = "page">
	<header>
<h1>ENI-Enchères</h1>
		<c:if test="${sessionScope.connexion eq null}">
			<%@ include file="header_notconnected.jsp"%>
		</c:if>


		<c:if test="${sessionScope.connexion != null}">
			<%@ include file="header_connected.jsp"%>
		</c:if>
	</header>
<div id="article">
	<div class="profil">
		
		
		
		<div>Pseudo : ${User_profile.nickname}</div>

		<div>Nom : ${User_profile.name}</div>

		<div>Prénom : ${User_profile.surname}</div>

		<div>Email : ${User_profile.email}</div>

		<div>Téléphone : ${User_profile.phone}</div>

		<div>Rue : ${User_profile.numStreet}</div>

		<div>Code postal : ${User_profile.postalCode}</div>

		<div>Ville : ${User_profile.city}</div>
		
	</div>
</div></div>

</body>
</html>