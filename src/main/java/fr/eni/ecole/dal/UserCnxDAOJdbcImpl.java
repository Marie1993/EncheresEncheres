package fr.eni.ecole.dal;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.ecole.bo.Users;

public class UserCnxDAOJdbcImpl implements UserDAO {
	
	private static final String INSERT_USER = " insert into utilisateurs (pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur) values (?,?,?,?,?,?,?,?,?,?,?)";
	
	
	@Override
	public void insert (Users user) throws SQLException  {
		
		Connection cnx = null;
		try {
			cnx = ConnectionProvider.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
	public boolean logIn(String nickname, String password) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public Users Select(String password) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void Update_User(Users user) throws SQLException {
		// TODO Auto-generated method stub
		
	}


	
	
	
}
