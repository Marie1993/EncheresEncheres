package fr.eni.ecole.servlets;

import java.io.IOException;
import java.sql.SQLException;

import fr.eni.ecole.bll.ArticleManager;
import fr.eni.ecole.bo.ArticleSold;
import fr.eni.ecole.bo.Users;
import fr.eni.ecole.dal.UserDAOJdbcImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Servlet_article
 */
@WebServlet("/Servlet_article")
public class Servlet_article extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ArticleManager articleManager = new ArticleManager();
	UserDAOJdbcImpl userDAO = new UserDAOJdbcImpl();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("connexion") != null) {
			int numArticle = Integer.parseInt(request.getParameter("num"));
			ArticleSold article = articleManager.Select_article(numArticle);
			session.setAttribute("article", article);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/article.jsp");
			rd.forward(request, response);
		} else {
			request.setAttribute("refusconnexion", "Veuillez vous connecter pour continuer");
			request.getRequestDispatcher("/WEB-INF/connection.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response) Méthode pour enchérir
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		// On récupère l'user de la session en cours.
		Users user = (Users) session.getAttribute("User");
		// On récupère l'article en cours.
		ArticleSold article = (ArticleSold) session.getAttribute("article");
		// On récupère l'enchère faite.
		int sellingPrice = Integer.parseInt(request.getParameter("sellingPrice"));
		// On change le sellingPrice ainsi que l'utilisateur qui est associé à l'article
		// (du vendeur à l'enchéreur)
		// Avant cela, il faut faire les modifs pour récupérer l'ancien acheteur et
		// l'ancien prix. Avec ça, on peut restituer l'argent

		try {
			userDAO.Update_credit_refund(article);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		// On update maintenant le nouveau prix et nouvel acheteur.
		article.setSellingPrice(sellingPrice);
		article.setUser(user);
		// On créé un booléen qui nous permet de voir si l'utilisateur a déjà fait une
		// enchère sur l'objet.
		Boolean auction;
		try {
			auction = articleManager.Verify_auction(article);
			if (auction == false) {
				articleManager.Insert_auction(article);
			} else
				// Sinon ça update la ligne avec la nouvelle enchère
				articleManager.Update_auction(article);
			// On met à jour l'article avec le nouveau prix.
			articleManager.Update_article(sellingPrice, article.getArticleNum());
			// On retire à l'utilisateur le crédit utilisé.
			try {
				userDAO.Update_credit_subtract(article);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			article = articleManager.Select_article(article.getArticleNum());
			user = userDAO.Select(article.getEnchereur().getNickname());
			session.setAttribute("article", article);
			session.setAttribute("User", user);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// S'il n'a jamais fait d'enchère, cela en créé une.
		// On renvoie sur la page.

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/article.jsp");
		rd.forward(request, response);

	}

}
