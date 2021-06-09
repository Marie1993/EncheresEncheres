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
		System.out.println(request.getParameter("num"));
		HttpSession session = request.getSession();
		int numArticle = Integer.parseInt(request.getParameter("num"));
		ArticleSold article = articleManager.Select_article(numArticle);
		session.setAttribute("article", article);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/article.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response) M�thode pour ench�rir
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		// On r�cup�re l'user de la session en cours.
		Users user = (Users) session.getAttribute("User");
		// On r�cup�re l'article en cours.
		ArticleSold article = (ArticleSold) session.getAttribute("article");
		// On r�cup�re l'ench�re faite.
		int sellingPrice = Integer.parseInt(request.getParameter("sellingPrice"));
		// On change le sellingPrice ainsi que l'utilisateur qui est associ� � l'article
		// (du vendeur � l'ench�reur)
		article.setSellingPrice(sellingPrice);
		article.setUser(user);
		// On cr�� un bool�en qui nous permet de voir si l'utilisateur a d�j� fait une ench�re sur l'objet.
		Boolean auction;
		try {
			auction = articleManager.Verify_auction(article);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// S'il n'a jamais fait d'ench�re, cela en cr�� une.
		if (auction = false)
			articleManager.Insert_auction(article);
		else
			// Sinon �a update la ligne avec la nouvelle ench�re
			articleManager.Update_auction(article);
		// On met � jour l'article avec le nouveau prix.
		articleManager.Update_article(sellingPrice, article.getArticleNum());
		// On retire � l'utilisateur le cr�dit utilis�.
		try {
			userDAO.Update_credit(article);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/Servlet");
		rd.forward(request, response);
	}

}
