/**
 * 
 */
package fr.eni.ecole.bll;

import java.sql.SQLException;

import fr.eni.BusinessException;
import fr.eni.ecole.bo.Users;
import fr.eni.ecole.dal.DAOFactory;
import fr.eni.ecole.dal.UserDAO;
import fr.eni.ecole.dal.UserDAOJdbcImpl;


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
	

	public Users addUsers (String nickname, String name, String surname, String email, String phone, String numStreet, String postalCode, String city, String password, Integer credit, Boolean admin ) throws BusinessException, SQLException {
		
		BusinessException businessException = new BusinessException();
		
		System.out.println("je suis ds la bll");
		
		this.validateNickName(nickname, businessException);
		this.validateEmail(email,businessException);
		
		Users users = null;
		
		
		if(!businessException.hasErreurs()) {
			users = new Users ();
			
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
			try {
				this.UserDAO.insert(users);
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
		else 
		{
			throw businessException;
			
		}
		return users;
		
	
		
		
		
			
	}
	

	
		
	


	private void validateEmail(String email, BusinessException businessException) throws SQLException {
		
		UserDAOJdbcImpl userDAOJdbc = new UserDAOJdbcImpl();
		Users userBDD = userDAOJdbc.Select(email);
		if ( userBDD != null ) {
			businessException.addErreur(CodesResultatBLL.EMAIL_EXIST);
			System.out.println("ce mail existe deja"); }		
	}


// n'accepte que les caractère alphanumérique
	private void validateNickName(String nickname, BusinessException businessException) throws SQLException {
		//nickname unique
		Boolean nicknameExist = validateNicknameExist( nickname,  businessException);
		if (!nicknameExist) {
				if (!nickname.matches("^[a-zA-Z0-9]*$") ) 
				{ 		businessException.addErreur(CodesResultatBLL.NICKNAME_ALPHA);
				System.out.println("mot de passe pas alphanumerique + remonte erreur");
				}	
		}
	}



	private Boolean validateNicknameExist(String nickname, BusinessException businessException) throws SQLException {
		Boolean exist;
		UserDAOJdbcImpl userDAOJdbc = new UserDAOJdbcImpl();
		Users userBDD = userDAOJdbc.Select(nickname);
		if ( userBDD != null ) {
			businessException.addErreur(CodesResultatBLL.NICKNAME_EXIST);
			System.out.println("ce psedo existe deja");	
			exist = true;
		} else { exist = false; }
		return exist;
	}


	public Users Select (String password) throws SQLException
	{
		return UserDAO.Select(password);
	}


	public void Update_User(Users user) throws SQLException {
		UserDAO.Update_User(user);
		
	}
	
	public void Delete_User(int numUser) throws SQLException {
		UserDAO.Delete_User(numUser);
		
	}
		
	
	

}