/**
 * 
 */
package fr.eni.ecole.dal;

import java.sql.SQLException;

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

	
	/**insertion nouvel utilisateur dans la base de donnée
	 * @param user
	 * @throws SQLException
	 */
	void insert(Users user) throws SQLException;

}
