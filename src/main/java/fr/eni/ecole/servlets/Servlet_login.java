package fr.eni.ecole.servlets;

import java.io.IOException;
import java.sql.SQLException;

import fr.eni.ecole.bll.UsersManager;
import fr.eni.ecole.bo.Users;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Servlet_login
 */
@WebServlet("/Servlet_login")
public class Servlet_login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet_login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/connection.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		UsersManager UsersManager = new UsersManager();
		try {
			boolean connection = UsersManager.LogIn(id, password);
			// Si on est connecté, ça redirige vers la page d'accueil.
			if (connection != true) {
				request.setAttribute("connexion", "Nous n'avons pas pu vous connecter, veuillez réessayer");
				request.getRequestDispatcher("/WEB-INF/connection.jsp").forward(request, response);
			}

			else {
				HttpSession session = request.getSession();
				Users user = UsersManager.Select(id);
				session.setAttribute("User", user);
				session.setAttribute("connexion",true);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/home.jsp");
				rd.forward(request,  response);
			}
			// Sinon, cela affiche un message d'erreur.

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}