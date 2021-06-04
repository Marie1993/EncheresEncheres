package fr.eni.ecole.servlets;

import java.io.IOException;
import java.sql.SQLException;

import fr.eni.ecole.bll.UsersManager;
import fr.eni.ecole.bo.Users;
import fr.eni.ecole.dal.UserDAOJdbcImpl;
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
		String nickname = request.getParameter("pseudo");
		
		String password = request.getParameter("pass");
		
		String name = request.getParameter("name");
		
		String surname = request.getParameter("surname");
		
		String email = request.getParameter("email");
		
		String phone  = request.getParameter("tel");
		
		String numStreet  = request.getParameter("street");
		
		String postalCode  = request.getParameter("postalCode");
		
		
		String city  = request.getParameter("city");
		
		
		Integer credit = 0 ;
		Boolean admin = false ;
		
		//j'ajoute l'utilisateur
		
		Users users = new Users(nickname, name, surname, email, phone, numStreet, postalCode, city, password, credit, admin);
		System.out.println(users.getCity());
		System.out.println(users.getName());
		
		UserDAOJdbcImpl userDAOJdbcImpl = new UserDAOJdbcImpl();
		
		try {
			userDAOJdbcImpl.insert(users);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//UsersManager usersManager = new UsersManager();
		//try {
		//	usersManager.addUsers(nickname, name, surname, email, phone, numStreet, postalCode, city, password, credit, admin);
			//si tout se passe bien je vais vers la page de consultation profil créé
		//} catch (SQLException e) { // businessException
		//	//sinon retour a la page d'ajout + affichage des erreurs
		//	e.printStackTrace();
		//	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/creationProfile.jsp");
		//	rd.forward(request, response);
		//}
	
	}

}
