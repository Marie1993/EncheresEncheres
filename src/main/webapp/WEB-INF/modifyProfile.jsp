<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form method="post" action="/EncheresEncheres/Servlet_modif_profile">

  <h1> Inscription</h1>
  
  <input type="hidden" id="numUser" name="numUser" value="${sessionScope ['User'].numUser}" placeholder = "${sessionScope ['User'].numUser}" />
  
  <label for="pseudo">Votre pseudo :</label>
       <input type="text" name="pseudo" id="pseudo" value ="${sessionScope ['User'].nickname}" placeholder = "${sessionScope ['User'].nickname}" />
        
     <label for ="nom">Nom :</label>  <input type="text" name="name" id="name" value ="${sessionScope ['User'].name}" placeholder = "${sessionScope ['User'].name}" />
     
      <label for ="prenom">Prénom :</label>  <input type="text" name="surname" id="surname" value ="${sessionScope ['User'].surname}" placeholder = "${sessionScope ['User'].surname}" />
      
       <label for ="email">Email :</label>  <input type="text" name="email" id="email" value ="${sessionScope ['User'].email}" placeholder = "${sessionScope ['User'].email}" />
       
       <label for ="phone">Téléphone :</label>  <input type="text" name="phone" id="phone" value ="${sessionScope ['User'].phone}" placeholder = "${sessionScope ['User'].phone}" />
       
       <label for ="numStreet">Rue :</label>  <input type="text" name="numStreet" id="numStreet" value ="${sessionScope ['User'].numStreet}" placeholder = "${sessionScope ['User'].numStreet}" />
       
       <label for ="postalCode">Code postal :</label>  <input type="text" name="postalCode" id="postalCode" value ="${sessionScope ['User'].postalCode}" placeholder = "${sessionScope ['User'].postalCode}" />
       
       <label for ="city">Ville :</label>  <input type="text" name="city" id="city" value ="${sessionScope ['User'].city}" placeholder = "${sessionScope ['User'].city}" />
       
        <label for ="password">Mot de passe :</label>  <input type="password" name="password" id="password" value ="${sessionScope ['User'].password}" placeholder = "${sessionScope ['User'].password}" />
       
      
      
             <div><input type="submit" value = "Valider"></div>  
      
       
</form>

</body>
</html>