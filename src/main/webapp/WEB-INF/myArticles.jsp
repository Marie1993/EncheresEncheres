<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="CSS\CSS.css">
<style type="text/css">
a:link {
	text-decoration: none;
}
</style>
<meta charset="UTF-8">
<title>Mes annonces</title>
</head>
<body>
<header>
<h1>ENI-Enchères</h1>
<c:if test="${sessionScope.connexion eq null}">
		<%@ include file="header_notconnected.jsp"%>
	</c:if>

	<c:if test="${sessionScope.connexion != null}">
		<%@ include file="header_connected.jsp"%>
	</c:if>
</header>

<h1>Mes articles</h1>



<c:forEach items="${liste_article_user}" var="ArticleSoldUser">


		
<div id="article">

			<div><a
				href="<c:url value="/Servlet_article">
           
           

            <c:param name="num" value="${ArticleSoldUser.articleNum}"/>
        </c:url>
    ">${ArticleSoldUser.articleName}</a> </div><br>
			Prix : ${ArticleSoldUser.sellingPrice} <br>
			
			Fin de l'enchère :
			${ArticleSoldUser.auctionEndingDate} </div>



	
	
	</c:forEach> 
	
	

</body>
</html>