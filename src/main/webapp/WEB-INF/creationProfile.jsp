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

			<%@ include file="header_notconnected.jsp"%>
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

<form method="post" action="/EncheresEncheres/Servlet_account_creation">

  <h1> Inscription</h1>
  
   <div class="form">
       <div> <label for="pseudo">Votre pseudo :</label></div>
       <input type="text" name="pseudo" id="pseudo" /> 
       
       
       <div><label for="pass">Votre mot de passe :</label></div>
       <input type="password" name="pass" id="pass" /> 
       
        <div><label for="name">Votre nom :</label></div>
       <input type="text" name="name" id="name" /> 
       
        <div><label for="surname">Votre prénom :</label></div>
       <input type="text" name="surname" id="surname" /> 
       
       <div><label for="email">Votre email :</label></div>
       <input type="email" name="email" id="email" /> 
       
       <div><label for="tel">Votre numéo de téléphone :</label></div>
       <input type="text" name="tel" id="tel" /> 
       
       <div><label for="street">Votre rue :</label></div>
       <input type="text" name="street" id="street" /> 
       
       <div><label for="postalCode">Votre code postal :</label></div>
       <input type="text" name="postalCode" id="postalCode" /> 
       
       <div><label for="city">Votre ville :</label></div>
       <input type="text" name="city" id="city" /> <br>
       
       <div class = "btn"><input type="submit" value = "Valider">
        <input type="button" onclick="window.location.href = 'http://localhost:8080/EncheresEncheres/';" value="Annuler"/>
       </div>  
   </div>
</form>

</body>
</html>