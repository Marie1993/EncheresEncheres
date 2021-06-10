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
 * Servlet implementation class Servlet_show_user
 */
@WebServlet("/Servlet_show_user")
public class Servlet_show_user extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("nickname"));
		UsersManager UsersManager = new UsersManager();
		HttpSession session = request.getSession();
		String nickname = request.getParameter("nickname");
		try {
			Users user_profile = UsersManager.Select(nickname);
			session.setAttribute("User_profile", user_profile);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/UserProfile.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
