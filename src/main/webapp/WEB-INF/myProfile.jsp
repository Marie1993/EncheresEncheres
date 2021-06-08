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
		
		
		
		<div>Pseudo : ${sessionScope ['User'].nickname}</div>

		<div>Nom : ${sessionScope ['User'].name}</div>

		<div>Prénom : ${sessionScope ['User'].surname}</div>

		<div>Email : ${sessionScope ['User'].email}</div>

		<div>Téléphone : ${sessionScope ['User'].phone}</div>

		<div>Rue : ${sessionScope ['User'].numStreet}</div>

		<div>Code postal : ${sessionScope ['User'].postalCode}</div>

		<div>Ville : ${sessionScope ['User'].city}</div>
	</div>
</div>

<a href="/EncheresEncheres//Servlet_modif_profile">Modifier mon profil</a>

</body>
</html>