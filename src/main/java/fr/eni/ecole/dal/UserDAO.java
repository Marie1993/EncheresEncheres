/**
 * 
 */
package fr.eni.ecole.dal;

import java.sql.SQLException;
import java.util.ArrayList;

import fr.eni.ecole.bo.Users;

/**
 * @author noemi
 *
 */
public interface UserDAO {

	/**
	 * @param nickname
	 * @param password
	 * @return
	 * @throws SQLException
	 */
	boolean logIn(String nickname, String password) throws SQLException;

	
	/**insertion nouvel utilisateur dans la base de donn�e
	 * @param user
	 * @throws SQLException
	 */
	void insert(Users users) throws SQLException;
	
	Users Select (String password) throws SQLException;
	
	void Update_User (Users user) throws SQLException;
	
	void Delete_User (int NumUser) throws SQLException;

}