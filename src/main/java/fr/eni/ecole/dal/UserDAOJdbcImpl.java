/**
 * 
 */
package fr.eni.ecole.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.ecole.bo.Users;


/**
 * @author noemi
 *
 */
public class UserDAOJdbcImpl implements UserDAO {
	private final String LOG_IN = "SELECT pseudo FROM UTILISATEURS WHERE pseudo = ? and mot_de_passe = ?;";
	
	Connection seConnecter() throws SQLException {
		Connection cnx = ConnectionProvider.getConnection();
		return cnx;
	}

	// Méthode qui va permettre de chercher si un utilisateur est dans la BDD : retourne true si c'est le cas, false sinon.
	@Override
	public boolean logIn(String nickname, String password) throws SQLException {
		Connection cnx = seConnecter();
		PreparedStatement stmt = cnx.prepareStatement(LOG_IN);
		stmt.setString (1,nickname);
		stmt.setString (2,password);
		System.out.println(nickname);
		System.out.println(password);
		ResultSet rs = stmt.executeQuery();
		if (rs.next())
			return true;
		else return false;
		
	}

	@Override
	public void insert(Users user) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
