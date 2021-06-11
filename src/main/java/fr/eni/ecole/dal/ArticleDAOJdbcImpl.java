package fr.eni.ecole.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.eni.ecole.bo.ArticleSold;
import fr.eni.ecole.bo.Category;
import fr.eni.ecole.bo.Users;
import fr.eni.ecole.bo.Withdrawal;

public class ArticleDAOJdbcImpl implements ArticleDAO {

	private final String INSERT = "insert into ARTICLES_VENDUS(nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie)values(?,?,?,?,?,?,?,?)";

	// On r�cup�re ce dont on a besoin + les id.
	private final String SELECT_ARTICLE_WITHNUM = "SELECT DISTINCT Articles_vendus.no_article, Articles_vendus.nom_article, Articles_vendus.description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, CATEGORIES.no_categorie, CATEGORIES.libelle, UTILISATEURS.no_utilisateur,UTILISATEURS.pseudo, Retraits.no_article, Retraits.rue, Retraits.code_postal, Retraits.ville, (SELECT UTILISATEURS.pseudo\r\n"
			+ "FROM ENCHERES INNER JOIN UTILISATEURS on Encheres.no_utilisateur = UTILISATEURS.no_utilisateur where Encheres.no_article = ?\r\n"
			+ "and ENCHERES.montant_enchere = (SELECT MAX (Encheres.montant_enchere) FROM ENCHERES INNER JOIN UTILISATEURS on Encheres.no_utilisateur = UTILISATEURS.no_utilisateur where Encheres.no_article = ?))\r\n"
			+ " as pseudo_enchereur FROM ARTICLES_VENDUS INNER JOIN ENCHERES on Articles_vendus.no_article = Encheres.no_article INNER JOIN CATEGORIES on Articles_vendus.no_categorie = CATEGORIES.no_categorie INNER JOIN UTILISATEURS on ARTICLES_VENDUS.no_utilisateur = UTILISATEURS.no_utilisateur INNER JOIN RETRAITS on ARTICLES_VENDUS.no_article = RETRAITS.no_article WHERE Articles_vendus.no_article = ?";
	private final String SELECT_ARTICLE_USER = "SELECT DISTINCT Articles_vendus.no_article, Articles_vendus.nom_article, Articles_vendus.description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, CATEGORIES.no_categorie, CATEGORIES.libelle, UTILISATEURS.no_utilisateur,UTILISATEURS.pseudo, Retraits.no_article, Retraits.rue, Retraits.code_postal, Retraits.ville  FROM ARTICLES_VENDUS INNER JOIN ENCHERES on Articles_vendus.no_article = Encheres.no_article INNER JOIN CATEGORIES on Articles_vendus.no_categorie = CATEGORIES.no_categorie INNER JOIN UTILISATEURS on ARTICLES_VENDUS.no_utilisateur = UTILISATEURS.no_utilisateur INNER JOIN RETRAITS on ARTICLES_VENDUS.no_article = RETRAITS.no_article WHERE Utilisateurs.pseudo = ?;";
	private final String SELECT_ARTICLE_AUCTION = "SELECT DISTINCT Articles_vendus.no_article, Articles_vendus.nom_article, Articles_vendus.description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, CATEGORIES.no_categorie, CATEGORIES.libelle, UTILISATEURS.no_utilisateur,UTILISATEURS.pseudo, Retraits.no_article, Retraits.rue, Retraits.code_postal, Retraits.ville  FROM ARTICLES_VENDUS INNER JOIN ENCHERES on Articles_vendus.no_article = Encheres.no_article INNER JOIN CATEGORIES on Articles_vendus.no_categorie = CATEGORIES.no_categorie INNER JOIN UTILISATEURS on ARTICLES_VENDUS.no_utilisateur = UTILISATEURS.no_utilisateur INNER JOIN RETRAITS on ARTICLES_VENDUS.no_article = RETRAITS.no_article WHERE Encheres.no_utilisateur = ? and Articles_vendus.date_fin_encheres > SYSDATETIME();";
	private final String SELECT_ARTICLE_WON_USER = "SELECT DISTINCT Articles_vendus.no_article, Articles_vendus.nom_article, ARTICLES_VENDUS.prix_vente, UTILISATEURS.pseudo FROM ENCHERES INNER JOIN UTILISATEURS on Encheres.no_utilisateur = UTILISATEURS.no_utilisateur INNER JOIN ARTICLES_VENDUS on Articles_vendus.no_article = Encheres.no_article WHERE Articles_vendus.date_fin_encheres < SYSDATETIME() and Encheres.montant_enchere = ARTICLES_VENDUS.prix_vente and Utilisateurs.pseudo = ?;";
	private final String SELECT_ARTICLE_LOST_USER = "SELECT DISTINCT Articles_vendus.no_article, Articles_vendus.nom_article, ARTICLES_VENDUS.prix_vente, UTILISATEURS.pseudo FROM ENCHERES INNER JOIN UTILISATEURS on Encheres.no_utilisateur = UTILISATEURS.no_utilisateur INNER JOIN ARTICLES_VENDUS on Articles_vendus.no_article = Encheres.no_article WHERE Articles_vendus.date_fin_encheres < SYSDATETIME() and Encheres.montant_enchere = ARTICLES_VENDUS.prix_vente and Utilisateurs.pseudo != ? and Encheres.no_utilisateur = ?;";
	private final String INSERT_WITHDRAWAL = "INSERT INTO Retraits values (?,?,?,?);";
	private final String INSERT_AUCTION = "INSERT INTO Encheres values (?,?,?,?);";
	private final String UPDATE_AUCTION = "UPDATE Encheres SET montant_enchere = ? WHERE no_article = ? and no_utilisateur = ? ;";
	private final String SELECT_ALL_ARTICLES = "SELECT DISTINCT Articles_vendus.no_article, Articles_vendus.nom_article, Articles_vendus.description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, CATEGORIES.no_categorie, CATEGORIES.libelle, UTILISATEURS.no_utilisateur,UTILISATEURS.pseudo, Retraits.no_article, Retraits.rue, Retraits.code_postal, Retraits.ville FROM ARTICLES_VENDUS INNER JOIN ENCHERES on Articles_vendus.no_article = Encheres.no_article INNER JOIN CATEGORIES on Articles_vendus.no_categorie = CATEGORIES.no_categorie INNER JOIN UTILISATEURS on ARTICLES_VENDUS.no_utilisateur = UTILISATEURS.no_utilisateur INNER JOIN RETRAITS on ARTICLES_VENDUS.no_article = RETRAITS.no_article where Articles_vendus.date_fin_encheres > SYSDATETIME();";
	private final String UPDATE_SELLING_PRICE = "UPDATE Articles_vendus SET prix_vente = ? WHERE no_article = ?;";
	private final String VERIFY_AUCTION = "SELECT no_utilisateur FROM ENCHERES WHERE no_utilisateur = ? and no_article = ?;";

	@Override
	public ArticleSold Select_article(int articleNum) {
		ArticleSold article = new ArticleSold();
		// Modifier la classe Article pour qu'elle ait un utilisateur et un point de
		// retrait et une cat�gorie. On met les colonnes correspondantes puis on ajoute.
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ARTICLE_WITHNUM);
			pstmt.setInt(1, articleNum);
			pstmt.setInt(2, articleNum);
			pstmt.setInt(3, articleNum);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				Users user = new Users(rs.getInt(10), rs.getString(11));
				Users enchereur = new Users(rs.getString(16));
				Category category = new Category(rs.getInt(8), rs.getString(9));
				Withdrawal withdrawal = new Withdrawal(rs.getString(13), rs.getString(14), rs.getString(15));
				article = new ArticleSold(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getTimestamp(4).toLocalDateTime(), rs.getTimestamp(5).toLocalDateTime(), rs.getInt(6),
						rs.getInt(7), category, user, enchereur, withdrawal);
			}
			// On r�cup�re le TimeStamp que l'on convertit ensuite en LocalDateTime pour
			// l'ajouter dans le constructeur.

		} catch (Exception e) {
			e.printStackTrace();
		}
		return article;

	}

	@Override
	public ArrayList<ArticleSold> Select_article_won_user(Users user) throws SQLException {
		ArrayList<ArticleSold> liste_article_won = new ArrayList();
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = cnx.prepareStatement(SELECT_ARTICLE_WON_USER);
			stmt.setString(1, user.getNickname());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Users user_won = new Users (rs.getString(4));
				ArticleSold article = new ArticleSold(rs.getInt(1), rs.getString(2), rs.getInt(3), user_won);
				liste_article_won.add(article);
			}

		}
		return liste_article_won;
	}
	
	@Override
	public ArrayList<ArticleSold> Select_article_lost_user(Users user) throws SQLException {
		ArrayList<ArticleSold> liste_article_lost = new ArrayList();
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = cnx.prepareStatement(SELECT_ARTICLE_LOST_USER);
			stmt.setString(1, user.getNickname());
			stmt.setInt(2, user.getNumUser());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Users user_won = new Users (rs.getString(4));
				ArticleSold article = new ArticleSold(rs.getInt(1), rs.getString(2), rs.getInt(3), user_won);
				liste_article_lost.add(article);
			}

		}
		return liste_article_lost;
	}
	
	@Override
	public ArrayList<ArticleSold> Select_by_user(Users user) throws SQLException {
		ArrayList<ArticleSold> liste_article_user = new ArrayList();
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = cnx.prepareStatement(SELECT_ARTICLE_USER);
			stmt.setString(1, user.getNickname());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Users seller = new Users(rs.getInt(10), rs.getString(11));
				Category category = new Category(rs.getInt(8), rs.getString(9));
				Withdrawal withdrawal = new Withdrawal(rs.getString(13), rs.getString(14), rs.getString(15));
				ArticleSold article = new ArticleSold(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getTimestamp(4).toLocalDateTime(), rs.getTimestamp(5).toLocalDateTime(), rs.getInt(6),
						rs.getInt(7), category, seller, withdrawal);
				liste_article_user.add(article);
			}

		}
		return liste_article_user;
	}
	
	@Override
	public ArrayList<ArticleSold> Select_user_auctions(Users user) throws SQLException {
		ArrayList<ArticleSold> liste_auctions = new ArrayList();
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = cnx.prepareStatement(SELECT_ARTICLE_AUCTION);
			stmt.setInt(1, user.getNumUser());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Users seller = new Users(rs.getInt(10), rs.getString(11));
				Category category = new Category(rs.getInt(8), rs.getString(9));
				Withdrawal withdrawal = new Withdrawal(rs.getString(13), rs.getString(14), rs.getString(15));
				ArticleSold article = new ArticleSold(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getTimestamp(4).toLocalDateTime(), rs.getTimestamp(5).toLocalDateTime(), rs.getInt(6),
						rs.getInt(7), category, seller, withdrawal);
				liste_auctions.add(article);
			}

		}
		return liste_auctions;
	}
	
	public ArrayList<ArticleSold> Select_all() throws SQLException {
		ArrayList<ArticleSold> liste_article = new ArrayList();
		try (Connection cnx = ConnectionProvider.getConnection()) {
			Statement stmt = cnx.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_ALL_ARTICLES);
			while (rs.next()) {
				Users user = new Users(rs.getInt(10), rs.getString(11));
				Category category = new Category(rs.getInt(8), rs.getString(9));
				Withdrawal withdrawal = new Withdrawal(rs.getString(13), rs.getString(14), rs.getString(15));
				ArticleSold article = new ArticleSold(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getTimestamp(4).toLocalDateTime(), rs.getTimestamp(5).toLocalDateTime(), rs.getInt(6),
						rs.getInt(7), category, user, withdrawal);
				liste_article.add(article);
			}

		}
		return liste_article;
	}

	@Override
	public void Insert_withdrawal(ArticleSold article) {
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(INSERT_WITHDRAWAL);
			pstmt.setInt(1, article.getArticleNum());
			pstmt.setString(2, article.getWithdrawal().getStreetNum());
			pstmt.setString(3, article.getWithdrawal().getPostalCode());
			pstmt.setString(4, article.getWithdrawal().getCityName());
			pstmt.execute();
			pstmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void Insert_auction(ArticleSold article) {
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(INSERT_AUCTION);
			pstmt.setInt(1, article.getUser().getNumUser());
			pstmt.setInt(2, article.getArticleNum());
			pstmt.setTimestamp(3, java.sql.Timestamp.valueOf(article.getAuctionStartingDate()));
			pstmt.setInt(4, article.getSellingPrice());
			pstmt.execute();
			pstmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insert(ArticleSold article) throws SQLException {
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
		pstmt.setTimestamp(4, java.sql.Timestamp.valueOf(article.getAuctionEndingDate()));
		pstmt.setInt(5, article.getStartingPrice());
		pstmt.setInt(6, article.getSellingPrice());
		// num utilisateur qui met en vente l'article ???? à recupérer avec la
		// sessione n cours
		pstmt.setInt(7, article.getUser().getNumUser());
		pstmt.setInt(8, article.getCategory().getCategoryNum());
		pstmt.executeUpdate();
		ResultSet rs = pstmt.getGeneratedKeys();
		if (rs.next()) {
			article.setArticleNum(rs.getInt(1));
		}
		rs.close();
		pstmt.close();
		cnx.close();

	}

	@Override
	public void Update_article(int SellingPrice, int articleNum) {
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(UPDATE_SELLING_PRICE);
			pstmt.setInt(1, SellingPrice);
			pstmt.setInt(2, articleNum);
			pstmt.execute();
			pstmt.close();

		} catch (SQLException e) {
		}
	}

	@Override
	public void Update_auction(ArticleSold article) {
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(UPDATE_AUCTION);
			pstmt.setInt(1, article.getSellingPrice());
			pstmt.setInt(2, article.getArticleNum());
			pstmt.setInt(3, article.getUser().getNumUser());
			pstmt.execute();
			pstmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean Verify_auction(ArticleSold article) throws SQLException {
		Boolean auction = false;
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(VERIFY_AUCTION);
			pstmt.setInt(1, article.getUser().getNumUser());
			pstmt.setInt(2, article.getArticleNum());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next())
				auction = true;
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return auction;

	}
}
