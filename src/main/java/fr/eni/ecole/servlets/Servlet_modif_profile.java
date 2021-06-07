package fr.eni.ecole.servlets;

import java.io.IOException;
import java.sql.SQLException;

import fr.eni.ecole.bll.UsersManager;
import fr.eni.ecole.bo.Users;
import fr.eni.ecole.dal.UserDAOJdbcImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Servlet_modif
 */
@WebServlet("/Servlet_modif_profile")
public class Servlet_modif_profile extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Servlet_modif_profile() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/modifyProfile.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UsersManager UsersManager = new UsersManager();
		
		int numUser = Integer.parseInt(request.getParameter("numUser"));
		Users user = new Users (numUser, request.getParameter("pseudo"),request.getParameter("name"),request.getParameter("surname"),request.getParameter("email"),request.getParameter("phone"),request.getParameter("numStreet"),request.getParameter("postalCode"),request.getParameter("city"), request.getParameter("password"));
		try {
			UsersManager.Update_User(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// On met à jour les attributs de session
		session.setAttribute("User", user);
		request.getRequestDispatcher("/WEB-INF/myProfile.jsp").forward(request, response);
	}
	

}
