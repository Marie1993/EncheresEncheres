<%@page import="fr.eni.ecole.messages.LecteurMessages"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@page import="java.util.List"%>
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
		<header>
			<h1>ENI-Enchères</h1>
			<c:if test="${sessionScope.connexion eq null}">
				<%@ include file="header_notconnected.jsp"%>
			</c:if>


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
	

		
<div id="article">


			<div>Nom de l'article : ${sessionScope ['article'].articleName}</div>

			<div>Description : ${sessionScope ['article'].description}</div>

			<div>Catégorie : ${sessionScope ['article'].category.wording}</div>

			<div>Début de l'enchère : ${sessionScope ['article'].auctionStartingDate}
			</div>

			<div>Fin de l'enchère : ${sessionScope ['article'].auctionEndingDate}</div>

			<div>Prix de base : ${sessionScope ['article'].startingPrice}</div>

			<div>Prix actuel : ${sessionScope ['article'].sellingPrice}</div>

			<div>
				Meilleure enchère : <a
					href="<c:url value="/Servlet_show_user">
            <c:param name="nickname" value="${sessionScope ['article'].enchereur.nickname}"/>
        </c:url>
    ">${sessionScope ['article'].enchereur.nickname}</a>
			</div>

			<div>
				Vendeur : <a
					href="<c:url value="/Servlet_show_user">
            <c:param name="nickname" value="${sessionScope ['article'].user.nickname}"/>
        </c:url>
    ">${sessionScope ['article'].user.nickname}</a>
			</div>

			<div>Point de retrait : ${sessionScope ['article'].withdrawal.streetNum}</div>

			<div>${sessionScope ['article'].withdrawal.postalCode}
				${sessionScope ['article'].withdrawal.cityName}</div>

			<c:if test="${sessionScope.connexion != null}">
				<c:if
					test="${sessionScope ['User'].nickname != sessionScope ['article'].user.nickname}">
					<c:if
						test="${sessionScope ['User'].nickname != sessionScope ['article'].enchereur.nickname}">
						<form action="/EncheresEncheres/Servlet_article" method="post">
							<label for="enchere">Enchérir</label><input type="number"
								min="${sessionScope ['article'].sellingPrice}"
								name="sellingPrice"> <input type="submit"
								value="Enchérir">
						</form>
					</c:if>
				</c:if>
			</c:if>


		</div>
	</div>
</div>


</body>
</html>