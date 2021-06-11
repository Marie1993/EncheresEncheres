package fr.eni.ecole.dal;

import java.sql.SQLException;
import java.util.ArrayList;

import fr.eni.ecole.bo.ArticleSold;
import fr.eni.ecole.bo.Users;

public interface ArticleDAO {
	
	public void insert (ArticleSold article)  throws SQLException;

	ArticleSold Select_article(int articleNum);
	
	public ArrayList<ArticleSold> Select_all() throws SQLException;
	
	public void Insert_withdrawal(ArticleSold article);
	
	public void Insert_auction(ArticleSold article);
	
	public void Update_article(int SellingPrice, int articleNum);
	
	public void Update_auction(ArticleSold article);
	
	public boolean Verify_auction (ArticleSold article) throws SQLException;

	ArrayList<ArticleSold> Select_by_user(Users user) throws SQLException;
	
	ArrayList<ArticleSold> Select_user_auctions(Users user) throws SQLException;
	
	public ArrayList<ArticleSold> Select_article_won_user (Users user) throws SQLException;
	

}
