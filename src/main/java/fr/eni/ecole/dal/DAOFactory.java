/**
 * 
 */
package fr.eni.ecole.dal;

/**
 * @author noemi
 *	Créé une instance de UserDAOJdbcImpl
 */
public class DAOFactory {

	public static UserDAO getUserDAO() {
		return new UserDAOJdbcImpl();
	}
	
	public static ArticleDAO getArticleDAO() {
		return new ArticleDAOJdbcImpl();
	}

}
