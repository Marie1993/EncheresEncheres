<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form method="post" action="/Encheres/Servlet_creation_article">

  <h1> Mettre un bien en ligne </h1>
  
   <p>
       <div> <label for="nomArticle">Titre annonce :</label></div>
       <input type="text" name="nomArticle" id="nomArticle" /> 
       
       <div><label for="description">Déscription de votre annonce :</label></div>
       <textarea name="description" id="description" rows="10" cols="50"></textarea>
       
       <div> <label for="sellerPrice">Votre prix de vente :</label></div>
       <input type="text" name="sellerPrice" id="sellerPrice" /> 
       
       <div><input type="submit" value = "Valider"></div>  
   </p>
</form>

</body>
</html>