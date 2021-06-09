package fr.eni.ecole.bll;

import java.sql.SQLException;
import java.time.LocalDateTime;

import fr.eni.ecole.bo.ArticleSold;
import fr.eni.ecole.dal.ArticleDAO;
import fr.eni.ecole.dal.DAOFactory;


public class ArticleManager {
	
	
	private ArticleDAO articleDAO =  DAOFactory.getArticleDAO();
	
	public ArticleSold addArticle (String articleName, String description, LocalDateTime auctionStartingDate,
			LocalDateTime autionEndingDate, Integer startingPrice, Integer sellingPrice, Integer numCategory, Integer numUser ) throws SQLException {
		
		ArticleSold article = new ArticleSold();
		
		article.setArticleName(articleName);
		article.setDescription(description);
		article.setAuctionStartingDate(auctionStartingDate);
		article.setAuctionEndingDate(autionEndingDate);
		article.setStartingPrice(startingPrice);
		article.setSellingPrice(sellingPrice); // pour l'instant null

		this.articleDAO.insert(article);
		
		return article;
	}
	
	public ArticleSold Select_article(int articleNum) {
		return this.articleDAO.Select_article(articleNum);
	}

	public Boolean Verify_auction(ArticleSold article) throws SQLException {
		return this.articleDAO.Verify_auction(article);
	}

	public void Insert_auction(ArticleSold article) {
		this.articleDAO.Insert_auction(article);
		
	}

	public void Update_auction(ArticleSold article) {
		this.articleDAO.Update_auction(article);
		
	}

	public void Update_article(int sellingPrice, Integer articleNum) {
		this.articleDAO.Update_article(sellingPrice, articleNum);
		
	}

}
