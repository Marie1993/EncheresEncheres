package fr.eni.ecole.dal;

public class ArticlesDAOJdbcImpl implements ArticlesDAO {

	private final String SELECT_ALL = "SELECT nom_article, description, (SELECT FORMAT (date_fin_encheres, 'dd-MM-yy')) as date, prix_initial, prix_vente, Categories.libelle, UTILISATEURS.pseudo, Retraits.rue, Retraits.code_postal, Retraits.ville FROM ARTICLES_VENDUS INNER JOIN CATEGORIES on Articles_vendus.no_categorie = CATEGORIES.no_categorie INNER JOIN UTILISATEURS on ARTICLES_VENDUS.no_utilisateur = UTILISATEURS.no_utilisateur INNER JOIN RETRAITS on ARTICLES_VENDUS.no_article = RETRAITS.no_article;";

	@Override
	public void Select_article() {
		// TODO Auto-generated method stub

	}

}
