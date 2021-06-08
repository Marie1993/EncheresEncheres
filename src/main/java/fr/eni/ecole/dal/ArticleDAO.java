package fr.eni.ecole.dal;

import java.sql.SQLException;

import fr.eni.ecole.bo.ArticleSold;

public interface ArticleDAO {
	
	public void insert (ArticleSold article)  throws SQLException;

}
