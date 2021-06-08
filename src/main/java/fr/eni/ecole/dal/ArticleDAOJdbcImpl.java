package fr.eni.ecole.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.sql.Timestamp;

import fr.eni.ecole.bo.ArticleSold;

public class ArticleDAOJdbcImpl implements ArticleDAO {
	
	private final String INSERT = "insert into ARTICLES_VENDUS(nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie)values(?,?,?,?,?,?,?,?)";
	
	//methode permettant d'ouvrir la connexion
	Connection toConnect() throws SQLException {
		Connection cnx = ConnectionProvider.getConnection();
		return cnx;
	}
	
	@Override
	public void insert (ArticleSold article)  throws SQLException {
		Connection cnx = null;
		try {
			cnx = ConnectionProvider.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	
		
		PreparedStatement pstmt = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
		pstmt.setString(1, article.getArticleName());
		pstmt.setString(2, article.getDescription());
	
		pstmt.setTimestamp(3, java.sql.Timestamp.valueOf(article.getAuctionStartingDate()));
		pstmt.setTimestamp(4, java.sql.Timestamp.valueOf(article.getAutionEndingDate()));
		pstmt.setInt(5, article.getStartingPrice());
		pstmt.setInt(6, article.getSellingPrice());
		// num utilisateur qui met en vente l'article ????  à recupérer avec la sessione n cours
		pstmt.setInt(7, article.getNumUser());
		pstmt.setInt(8,article.getNumCategory());
		pstmt.executeUpdate();
		ResultSet rs = pstmt.getGeneratedKeys();
		if(rs.next()) {
			article.setArticleNum(rs.getInt(1));
			}
		rs.close();
		pstmt.close();
		cnx.close();
		

		
		
	}
	
	

}
