/**
 * 
 */
package fr.eni.ecole.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.ecole.bo.ArticleSold;
import fr.eni.ecole.bo.Users;

/**
 * @author noemie ///
 *
 */
public class UserDAOJdbcImpl implements UserDAO {
	private final String LOG_IN = "SELECT pseudo FROM UTILISATEURS WHERE pseudo = ? and mot_de_passe = ? or email = ? and mot_de_passe = ?;";
	private final String SELECT = "SELECT * FROM UTILISATEURS WHERE pseudo = ? or email = ?;";
	private static final String INSERT_USER = " insert into utilisateurs (pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur) values (?,?,?,?,?,?,?,?,?,?,?)";
	private final String UPDATE_ACCOUNT = "UPDATE Utilisateurs SET pseudo = ?, nom = ?, prenom = ?, email = ?, telephone = ?, rue = ?, code_postal = ?, ville = ?, mot_de_passe = ? WHERE no_utilisateur = ? ;";
	private final String DELETE_USER = "DELETE FROM Utilisateurs WHERE no_utilisateur = ?;";
	private final String UPDATE_CREDIT = "UPDATE Utilisateurs SET credit = ? where no_utilisateur = ?;";

	Connection seConnecter() throws SQLException {
		Connection cnx = ConnectionProvider.getConnection();
		return cnx;
	}

	// MÃ©thode qui va permettre de chercher si un utilisateur est dans la BDD :
	// retourne true si c'est le cas, false sinon.
	// Faire des try catch
	@Override
	public boolean logIn(String id, String password) throws SQLException {
		boolean connexion = false;
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(LOG_IN);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			pstmt.setString(3, id);
			pstmt.setString(4, password);
			System.out.println(id);
			System.out.println(password);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next())
				connexion = true;
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connexion;
	}

	@Override

	public void insert(Users user) throws SQLException {

		// Syntaxe qui permet de savoir que la connexion ne doit être active que dans le
		// try/catch. Il la libère dès qu'on en sort.
		try (Connection cnx = ConnectionProvider.getConnection()) {

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
			if (rs.next()) {
				user.setNumUser(rs.getInt(1));
			}

			rs.close();
			pstmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Users Select(String id) throws SQLException {
		Users user = null;
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(SELECT);
			pstmt.setString(1, id);
			pstmt.setString(2, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next())
				user = new Users(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getInt(11), rs.getBoolean(12));
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;

	}

	public void Update_User(Users user) throws SQLException {
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(UPDATE_ACCOUNT);
			pstmt.setString(1, user.getNickname());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getSurname());
			pstmt.setString(4, user.getEmail());
			pstmt.setString(5, user.getPhone());
			pstmt.setString(6, user.getNumStreet());
			pstmt.setString(7, user.getPostalCode());
			pstmt.setString(8, user.getCity());
			pstmt.setString(9, user.getPassword());
			pstmt.setInt(10, user.getNumUser());
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void Delete_User(int numUser) throws SQLException {
		try (Connection cnx = ConnectionProvider.getConnection()) {
		PreparedStatement pstmt = cnx.prepareStatement(DELETE_USER);
		pstmt.setInt(1, numUser);
		pstmt.executeUpdate();
		pstmt.close();
		cnx.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void Update_credit(ArticleSold article) throws SQLException {
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(UPDATE_CREDIT);
			pstmt.setInt(1, article.getUser().getCredit() - article.getSellingPrice());
			pstmt.setInt(2, article.getUser().getNumUser());
			pstmt.executeUpdate();
			pstmt.close();
			cnx.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}