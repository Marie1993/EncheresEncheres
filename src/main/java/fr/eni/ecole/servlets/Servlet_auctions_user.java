package fr.eni.ecole.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import fr.eni.ecole.bll.ArticleManager;
import fr.eni.ecole.bo.ArticleSold;
import fr.eni.ecole.bo.Users;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Servlet_articles_user
 */
@WebServlet("/Servlet_auctions_user")
public class Servlet_auctions_user extends HttpServlet {
	private static final long serialVersionUID = 1L;

 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArticleManager ArticleManager = new ArticleManager ();
		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("User");
		try {
			ArrayList <ArticleSold> liste_auctions = ArticleManager.Select_user_auctions(user);
			session.setAttribute("liste_article_user", liste_auctions);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/myAuctions.jsp");
		
	
		rd.forward(request,  response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
