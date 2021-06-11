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
	
		<h1>Mes enchères en cours</h1>

	<c:forEach items="${liste_article_user}" var="AuctionsUser">
		<c:if
			test="${sessionScope ['User'].nickname != AuctionsUser.user.nickname}">


			<div class="form">
			

				<a
					href="<c:url value="/Servlet_article">
            <c:param name="num" value="${AuctionsUser.articleNum}"/>
        </c:url>
    ">${AuctionsUser.articleName}</a> <br>
				Prix : ${AuctionsUser.sellingPrice} <br>
				Fin de l'enchère :
				${AuctionsUser.auctionEndingDate}
				<div> Vendeur : <a
					href="<c:url value="/Servlet_show_user">
            <c:param name="nickname" value="${AuctionsUser.user.nickname}"/>
        </c:url>
    ">${AuctionsUser.user.nickname}</a> </div>


			</div>
		</c:if>

	</c:forEach>
	
	<h2>Mes enchères remportées :</h2>

		<div id="AuctionsAll">


			<div class="liste_article_won">
				<c:forEach items="${liste_article_won}" var="ArticleWon">




					<h4>
						<a
							href="<c:url value="/Servlet_article">
            <c:param name="num" value="${ArticleWon.articleNum}"/>
        </c:url>
    ">${ArticleWon.articleName}</a>
					</h4>


				</c:forEach>

			</div>


</body>
</html>