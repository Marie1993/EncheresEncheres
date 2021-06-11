package fr.eni.ecole.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import fr.eni.ecole.bo.ArticleSold;
import fr.eni.ecole.bo.Users;
import fr.eni.ecole.dal.ArticleDAOJdbcImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;




/**
 * Servlet implementation class Servlet
 */

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public static boolean connection = false;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ArticleDAOJdbcImpl articleDAO = new ArticleDAOJdbcImpl ();
		try {
			ArrayList <ArticleSold> liste_article = articleDAO.Select_all();
			session.setAttribute("liste_article", liste_article);
			if (session.getAttribute("connexion") != null)
			{Users user = (Users) session.getAttribute("User");
			ArrayList <ArticleSold> liste_article_won = articleDAO.Select_article_won_user(user);
			session.setAttribute("liste_article_won", liste_article_won);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/home.jsp");
		
	
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
