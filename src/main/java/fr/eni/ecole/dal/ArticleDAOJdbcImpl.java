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
	
	// On récupère ce dont on a besoin + les id.
		private final String SELECT_ARTICLE = "SELECT Articles_vendus.no_article, description, (SELECT FORMAT (date_fin_encheres, 'dd-MM-yy')) as date, prix_initial, prix_vente, CATEGORIES.no_categorie, CATEGORIES.libelle, UTILISATEURS.no_utilisateur,UTILISATEURS.pseudo, Retraits.no_article, Retraits.rue, Retraits.code_postal, Retraits.ville, Encheres.no_utilisateur, Encheres.no_article, Encheres.date_enchere, Encheres.montant_enchere FROM ARTICLES_VENDUS INNER JOIN ENCHERES on Articles_vendus.no_article = Encheres.no_article INNER JOIN CATEGORIES on Articles_vendus.no_categorie = CATEGORIES.no_categorie INNER JOIN UTILISATEURS on ARTICLES_VENDUS.no_utilisateur = UTILISATEURS.no_utilisateur INNER JOIN RETRAITS on ARTICLES_VENDUS.no_article = RETRAITS.no_article WHERE ARTICLES_VENDUS.no_article = ?;";

		@Override
		public void Select_article(int articleNum) {
			// Modifier la classe Article pour qu'elle ait un utilisateur et un point de retrait et une catégorie. On met les colonnes correspondantes puis on ajoute.
			try (Connection cnx = ConnectionProvider.getConnection())
			{PreparedStatement pstmt = cnx.prepareStatement(SELECT_ARTICLE);
			pstmt.setInt(1, articleNum);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next ())
			{
				
			}
				
				
			} catch (Exception e) {
				// TODO: handle exception
			}

		}
	
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
		// num utilisateur qui met en vente l'article ????  Ã  recupÃ©rer avec la sessione n cours
		pstmt.setInt(7, article.getUser().getNumUser());
		pstmt.setInt(8,article.getCategory().getCategoryNum());
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
