package fr.eni.ecole.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.BusinessException;
import fr.eni.ecole.bll.UsersManager;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet_account_creation
 */
@WebServlet("/Servlet_account_creation")
public class Servlet_account_creation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
    /**
     * Default constructor. 
     */
    public Servlet_account_creation() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/creationProfile.jsp");
			rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Integer>listeCodesErreurs = new ArrayList<>();
		
		String nickname = request.getParameter("pseudo");
		System.out.println(nickname);
		System.out.println("pseudo est alphanumérique : "+nickname.matches("^[a-zA-Z0-9]*$"));
		

		if (nickname.isBlank() ) {
		 listeCodesErreurs.add(CodesResultatServlets.NICKNAME_BLANCK);
		}
		
		String password = request.getParameter("pass");
		System.out.println(password);
		if (password.isBlank() ) {
			 listeCodesErreurs.add(CodesResultatServlets.PASSWORD_BLANCK);
			}

		String name = request.getParameter("name");
		System.out.println(name);
		
		String surname = request.getParameter("surname");
		System.out.println(surname);
		
		String email = request.getParameter("email");
		System.out.println(email);
		if (email.isBlank() ) {
			 listeCodesErreurs.add(CodesResultatServlets.PASSWORD_EMAIL);
			}
		
		String phone  = request.getParameter("tel");
		System.out.println(phone);
		
		String numStreet  = request.getParameter("street");
		System.out.println(numStreet);
		
		String postalCode  = request.getParameter("postalCode");
		System.out.println(postalCode);
		
		String city  = request.getParameter("city");
		System.out.println(city);
		
		
		Integer credit = 0 ;
		Boolean admin = false ;
		
		//j'ajoute l'utilisateur
		
		if(listeCodesErreurs.size()>0) {
			//je renvoie les erreurs et retourne sur le profil
			request.setAttribute("listeCodesErreurs", listeCodesErreurs);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/creationProfile.jsp");
			rd.forward(request, response);
			System.out.println("je suis dans le if");
		}
		else 
		{
			
			UsersManager usersManager = new UsersManager();
			try {
				usersManager.addUsers(nickname, name, surname, email, phone, numStreet, postalCode, city, password, credit, admin);
				// si tout se passe bien on redirige vers acceuil
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/home.jsp");
				rd.forward(request, response);
			} catch (  BusinessException e ) {
				// sinon retour page création + liste des erreurs
				e.printStackTrace();	
				request.setAttribute("listeCodesErreurs", ((BusinessException) e).getListeCodesErreur());
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/creationProfile.jsp");
				rd.forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
			
		}
	
		
		
	
	}

}
