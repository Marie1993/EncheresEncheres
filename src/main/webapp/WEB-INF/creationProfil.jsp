<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form method="post" action="/Encheres/Servlet_account_creation">

  <h1> Inscription</h1>
  
   <p>
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
       <input type="text" name="city" id="city" /> 
       
       <div><input type="submit" value = "Valider"></div>  
   </p>
</form>

</body>
</html>