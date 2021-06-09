package fr.eni.ecole.servlets;

import java.io.IOException;

import fr.eni.ecole.bo.ArticleSold;
import fr.eni.ecole.dal.ArticleDAOJdbcImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet_article
 */
@WebServlet("/Servlet_article")
public class Servlet_article extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Servlet_article() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArticleDAOJdbcImpl articleDAO = new ArticleDAOJdbcImpl();
		ArticleSold article = articleDAO.Select_article(2);
		System.out.println(article.getArticleName());
		System.out.println(article.getAuctionStartingDate());
		System.out.println(article.getAuctionEndingDate());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
