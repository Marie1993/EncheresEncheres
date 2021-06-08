package fr.eni.ecole.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.ecole.bll.ArticleManager;
import fr.eni.ecole.bo.ArticleSold;
import fr.eni.ecole.dal.ArticleDAOJdbcImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet_creation_article
 */
@WebServlet("/Servlet_creation_article")
public class Servlet_creation_article extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Servlet_creation_article() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/creationArticle.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String articleName = request.getParameter("nameArticle");
		System.out.println("article name"+ articleName);
		String description= request.getParameter("description");
		System.out.println("description "+description);
		
	
	
		
		
		List<Integer> ListeCodesErreur = new ArrayList<>();
		
		LocalDateTime auctionStartingDate = null;
		LocalDateTime autionEndingDate = null;
	
		//lecture date
		try
		{
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
			auctionStartingDate = LocalDateTime.parse(request.getParameter("startAuction"),dtf);
		}
		catch(DateTimeParseException e)
		{
			e.printStackTrace();
			ListeCodesErreur.add(CodesResultatServlets.AUCTION_START_DATE_FORMAT_ERREUR);
		}
		
	
		try
		{
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
			autionEndingDate = LocalDateTime.parse(request.getParameter("endAuction"),dtf);
		}
		catch(DateTimeParseException e)
		{
			e.printStackTrace();
			ListeCodesErreur.add(CodesResultatServlets.AUCTION_END_DATE_FORMAT_ERREUR);
		}
			
		
		System.out.println("date debut" + auctionStartingDate);
		System.out.println("date debut" + autionEndingDate);
		
		Integer startingPrice = Integer.parseInt(request.getParameter("sellerPrice"));
		System.out.println("prix " + startingPrice);
		
		Integer sellingPrice = 0;
		
		Integer numCategory = Integer.parseInt(request.getParameter("categories"));
		System.out.println("num catégorie" + numCategory);
	
		// recupération num utilisateur à faire avec session
		Integer numUsers = 1; 
		
		
		//ArticleManager articleManager = new ArticleManager();
		//try {
		//	articleManager.addArticle(articleName, description, auctionStartingDate, autionEndingDate, startingPrice, sellingPrice, numCategory, numUsers);
		//} catch (SQLException e) {
			
		//	e.printStackTrace();
		//}
		
		ArticleSold article = new ArticleSold(articleName, description, auctionStartingDate, autionEndingDate, startingPrice, sellingPrice, numCategory, numUsers);
		ArticleDAOJdbcImpl articleDaojdbcImpl = new ArticleDAOJdbcImpl();
		try {
			articleDaojdbcImpl.insert(article);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// recuperer les infos / au retrait
	
		
	}

}
