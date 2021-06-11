<%@page import="fr.eni.ecole.messages.LecteurMessages"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="CSS\CSS.css">
<style type="text/css"> 
a:link 
{ 
 text-decoration:none; 
} 
</style>
<title>Insert title here</title>
</head>

<header >
	
	
		<h1>ENI-Enchères</h1>

		<c:if test="${sessionScope.connexion != null}">
			<%@ include file="header_connected.jsp"%>
		</c:if>

	</header>

<body>

<div class="error_message">
	<%
			List<Integer> listeCodesErreurs = (List<Integer>)request.getAttribute("listeCodesErreurs");
			if(listeCodesErreurs!=null)
			{
	
				for(int codeErreur:listeCodesErreurs)
				{
		
					%>
					
					<p><%=LecteurMessages.getMessageErreur(codeErreur)%></p>
		<%	
					
				}
			}
		%>
</div> 

	<form method="post" action="/EncheresEncheres/Servlet_creation_article">

		<h1>Mettre un bien en ligne</h1>

		<div class ="form">
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
		<input type="number" name="sellerPrice" id="sellerPrice" placeholder="0"/>
		
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

		<div class="btn">
			<input type="submit" class="button" value="Enregistrer">
	
		 <input class="button"  type="button" onclick="window.location.href = 'http://localhost:8080/EncheresEncheres/';" value="Annuler"/>
		</div>
		</div>
	</form>

</body>
</html>