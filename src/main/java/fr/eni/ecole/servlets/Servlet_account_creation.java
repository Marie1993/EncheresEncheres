package fr.eni.ecole.servlets;

import java.io.IOException;

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
		System.out.println(nickname);
		
		String password = request.getParameter("pass");
		System.out.println(password);

		String name = request.getParameter("name");
		System.out.println(name);
		
		String surname = request.getParameter("surname");
		System.out.println(surname);
		
		String email = request.getParameter("email");
		System.out.println(email);
		
		String phone  = request.getParameter("tel");
		System.out.println(phone);
		
		String numStreet  = request.getParameter("street");
		System.out.println(numStreet);
		
		String postalCode  = request.getParameter("postalCode");
		System.out.println(postalCode);
		
		String city  = request.getParameter("city");
		System.out.println(city);
		
	
	}

}
