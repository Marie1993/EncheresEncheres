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
	
	
	public Users addUsers (String nickname, String name, String surname, String email, String phone, String numStreet, String postalCode, String city, String password, Integer credit, Boolean admin ) throws SQLException {
		Users user = new Users();
	

		this.validateNickName();
		this.validateEmail();
		
		Users users = new Users();
		users.setNickname(nickname);
		users.setName(name);
		users.setSurname(surname);
		users.setEmail(email);
		users.setPhone(phone);
		users.setNumStreet(numStreet);
		users.setPostalCode(postalCode);
		users.setCity(city);
		users.setPassword(password);
		users.setCredit(credit);
		users.setAdmin(admin);
		this.UserDAO.insert(users);
				
		return users;
			
	}
	
	
	
	
	
	private void validateEmail() {
		// TODO Auto-generated method stub
		
	}



	private void validateNickName() {
		// TODO Auto-generated method stub
		
	}



	public Users Select (String password) throws SQLException
	{
		return UserDAO.Select(password);
	}


	public void Update_User(Users user) throws SQLException {
		UserDAO.Update_User(user);
		
	}
	
	
	

}