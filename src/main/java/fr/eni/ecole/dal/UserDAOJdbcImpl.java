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
 * @author noemi ///
 *
 */
public class UserDAOJdbcImpl implements UserDAO {
	private final String LOG_IN = "SELECT pseudo FROM UTILISATEURS WHERE pseudo = ? and mot_de_passe = ? or email = ? and mot_de_passe = ?;";
	private final String SELECT = "SELECT * FROM UTILISATEURS WHERE pseudo = ? or email = ?;";
	private static final String INSERT_USER = " insert into utilisateurs (pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur) values (?,?,?,?,?,?,?,?,?,?,?)";
	private final String UPDATE_ACCOUNT = "UPDATE Utilisateurs SET pseudo = ?, nom = ?, prenom = ?, email = ?, telephone = ?, rue = ?, code_postal = ?, ville = ?, mot_de_passe = ? WHERE no_utilisateur = ? ;";
	private final String DELETE_USER = "DELETE FROM Utilisateurs WHERE no_utilisateur = ?;";

	Connection seConnecter() throws SQLException {
		Connection cnx = ConnectionProvider.getConnection();
		return cnx;
	}

	// Méthode qui va permettre de chercher si un utilisateur est dans la BDD :
	// retourne true si c'est le cas, false sinon.
	@Override
	public boolean logIn(String id, String password) throws SQLException {
		Connection cnx = seConnecter();
		PreparedStatement stmt = cnx.prepareStatement(LOG_IN);
		stmt.setString(1, id);
		stmt.setString(2, password);
		stmt.setString(3, id);
		stmt.setString(4, password);
		System.out.println(id);
		System.out.println(password);
		ResultSet rs = stmt.executeQuery();
		if (rs.next())
			return true;
		else
			return false;

	}	
	
	@Override

	public void insert (Users user) throws SQLException  {
		
		Connection cnx = null;
		try {
			cnx = ConnectionProvider.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		PreparedStatement pstmt = cnx.prepareStatement(INSERT_USER, PreparedStatement.RETURN_GENERATED_KEYS);
		pstmt.setString(1, user.getNickname());
		pstmt.setString(2, user.getName());
		pstmt.setString(3, user.getSurname());
		pstmt.setString(4, user.getEmail());
		pstmt.setString(5, user.getPhone());
		pstmt.setString(6, user.getNumStreet());
		pstmt.setString(7, user.getPostalCode());
		pstmt.setString(8, user.getCity());
		pstmt.setString(9, user.getPassword());
		pstmt.setInt(10, 50);
		pstmt.setBoolean(11, user.getAdmin());
		pstmt.executeUpdate();
		ResultSet rs = pstmt.getGeneratedKeys();
		if(rs.next()) {
			user.setNumUser(rs.getInt(1));
		}
		
		rs.close();
		pstmt.close();
		cnx.close();
	}

	@Override
	public Users Select(String id) throws SQLException {
		Users user = null;
		Connection cnx = seConnecter();
		PreparedStatement stmt = cnx.prepareStatement(SELECT);
		stmt.setString(1, id);
		stmt.setString(2, id);
		ResultSet rs = stmt.executeQuery();
		if (rs.next())
			user = new Users(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getInt(11),
					rs.getBoolean(12));
		return user;

	}
	
	public void Update_User (Users user) throws SQLException {
		Connection cnx = seConnecter();
		PreparedStatement stmt = cnx.prepareStatement(UPDATE_ACCOUNT);
		stmt.setString(1, user.getNickname());
		stmt.setString(2, user.getName());
		stmt.setString(3, user.getSurname());
		stmt.setString(4, user.getEmail());
		stmt.setString(5, user.getPhone());
		stmt.setString(6, user.getNumStreet());
		stmt.setString(7, user.getPostalCode());
		stmt.setString(8, user.getCity());
		stmt.setString(9, user.getPassword());
		stmt.setInt(10, user.getNumUser());
		stmt.executeUpdate();
		
}

	@Override
	public void Delete_User(int numUser) throws SQLException {
		Connection cnx = seConnecter();
		PreparedStatement stmt = cnx.prepareStatement(DELETE_USER);
		stmt.setInt(1, numUser);
		stmt.executeUpdate();
		stmt.close();
		cnx.close();
		
	}
}