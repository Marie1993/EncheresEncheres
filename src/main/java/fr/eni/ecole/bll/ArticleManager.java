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
		article.setAutionEndingDate(autionEndingDate);
		article.setStartingPrice(startingPrice);
		article.setSellingPrice(sellingPrice); // pour l'instant null
		article.setNumCategory(numCategory);
		article.setNumUser(numUser);
		this.articleDAO.insert(article);
		
		return article;
	}

}
