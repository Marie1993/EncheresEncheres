package fr.eni.ecole.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import fr.eni.ecole.bo.ArticleSold;
import fr.eni.ecole.dal.ArticleDAOJdbcImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Servlet_selection
 */
@WebServlet("/Servlet_selection")
public class Servlet_selection extends HttpServlet {
	private static final long serialVersionUID = 1L;

  

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArticleDAOJdbcImpl ArticleDAO = new ArticleDAOJdbcImpl();
		HttpSession session = request.getSession();
		int numCat = Integer.parseInt(request.getParameter("numCat"));
		try {
			ArrayList <ArticleSold> liste_categorie = ArticleDAO.Select_all_category(numCat);
			session.setAttribute("liste_categorie", liste_categorie);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/homeFilter.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
