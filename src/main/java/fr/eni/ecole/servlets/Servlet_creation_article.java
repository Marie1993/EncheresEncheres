package fr.eni.ecole.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.ecole.bll.ArticleManager;
import fr.eni.ecole.bo.ArticleSold;
import fr.eni.ecole.bo.Category;
import fr.eni.ecole.bo.Users;
import fr.eni.ecole.bo.Withdrawal;
import fr.eni.ecole.dal.ArticleDAOJdbcImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/creationArticle.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		String articleName = request.getParameter("nameArticle");
		System.out.println("article name" + articleName);
		String description = request.getParameter("description");
		System.out.println("description " + description);
		String numStreet = request.getParameter("numStreet");
		System.out.println("numStreet" + numStreet);
		String postalCode = request.getParameter("postalCode");
		System.out.println("Code postal" + postalCode);
		String city = request.getParameter("city");
		System.out.println("Ville : " + city);

		List<Integer> ListeCodesErreur = new ArrayList<>();

		LocalDateTime auctionStartingDate = null;
		LocalDateTime auctionEndingDate = null;

		// lecture date
		try {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
			auctionStartingDate = LocalDateTime.parse(request.getParameter("startAuction"), dtf);
		} catch (DateTimeParseException e) {
			e.printStackTrace();
			ListeCodesErreur.add(CodesResultatServlets.AUCTION_START_DATE_FORMAT_ERREUR);
		}

		try {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
			auctionEndingDate = LocalDateTime.parse(request.getParameter("endAuction"), dtf);
		} catch (DateTimeParseException e) {
			e.printStackTrace();
			ListeCodesErreur.add(CodesResultatServlets.AUCTION_END_DATE_FORMAT_ERREUR);
		}

		System.out.println("date debut" + auctionStartingDate);
		System.out.println("date debut" + auctionEndingDate);

		Integer startingPrice = Integer.parseInt(request.getParameter("sellerPrice"));
		System.out.println("prix " + startingPrice);

		Integer sellingPrice = startingPrice;
		
		// Permet de set le libellé par rapport à ce qui a été choisi dans la liste déroulante.
		String wording = null;
		switch (Integer.parseInt(request.getParameter("categories"))) {
		case 1:
			wording = "Informatique";
			break;
		case 2:
			wording = "Ameublement";
			break;
		case 3:
			wording = "Vêtements";
			break;
		case 4:
			wording = "Sports et loisirs";
			break;

		}
		// On créé un article avec les constructeurs de User, Categorie et Withdrawal
		Category category = new Category(Integer.parseInt(request.getParameter("categories")), wording);
		Users user = (Users) session.getAttribute("User");
		Withdrawal withdrawal = new Withdrawal(numStreet, postalCode, city);
		ArticleSold article = new ArticleSold(articleName, description, auctionStartingDate, auctionEndingDate,
				startingPrice, sellingPrice, user, category, withdrawal);
		session.setAttribute("article", article);
		ArticleDAOJdbcImpl articleDaojdbcImpl = new ArticleDAOJdbcImpl();
		try {
			articleDaojdbcImpl.insert(article);
			articleDaojdbcImpl.Insert_withdrawal(article);
			articleDaojdbcImpl.Insert_auction(article);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/article.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// recuperer les infos / au retrait

	}

}
