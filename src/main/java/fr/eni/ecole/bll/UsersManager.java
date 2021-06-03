/**
 * 
 */
package fr.eni.ecole.bll;

import java.sql.SQLException;

import fr.eni.ecole.bo.Users;
import fr.eni.ecole.dal.DAOFactory;
import fr.eni.ecole.dal.UserDAO;


/**
 * @author noemi
 *
 */
public class UsersManager {
	
	private UserDAO UserDAO = DAOFactory.getUserDAO();
	
	
	public boolean LogIn (String nickname, String password) throws SQLException
	{
		return UserDAO.logIn(nickname, password);
	}
	
	
	public void addUsers ( Integer numUser, String nickname, String name, String surname, String email, String phone, String numStreet, String postalCode, String city, String password, Integer credit, Boolean admin ) {
		Users user = new Users();
		
		
	}
	
	public Users Select (String password) throws SQLException
	{
		return UserDAO.Select(password);
	}
	
	

}