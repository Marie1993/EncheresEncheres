/**
 * 
 */
package fr.eni.ecole.bo;

import java.time.LocalDateTime;

/**
 * Classe en charge
 * @author Alex
 * @version Ench-res - v1.0
 * @date 1 juin 2021 - 10:06:29
 */
public class ArticleSold {
	private Integer articleNum;
	private String articleName;
	private String description;
	private LocalDateTime auctionStartingDate;
	private LocalDateTime auctionEndingDate;
	private Integer startingPrice;
	private Integer sellingPrice;
	private Boolean isSold;
	private Category category;
	private Users user;
	private Auction auction;
	private Withdrawal withdrawal;
	private Users enchereur;
	
	
	
	
	/**
	 * @param articleNum
	 * @param articleName
	 * @param description
	 * @param auctionStartingDate
	 * @param autionEndingDate
	 * @param startingPrice
	 * @param sellingPrice
	 * @param isSold
	 * @param category
	 * @param user
	 * @param withdrawal
	 * Constructeur pour afficher le détail
	 */
	public ArticleSold(Integer articleNum, String articleName, String description, LocalDateTime auctionStartingDate,
			LocalDateTime autionEndingDate, Integer startingPrice, Integer sellingPrice,
			Category category, Users user, Users enchereur, Withdrawal withdrawal) {
		super();
		this.articleNum = articleNum;
		this.articleName = articleName;
		this.description = description;
		this.auctionStartingDate = auctionStartingDate;
		this.auctionEndingDate = autionEndingDate;
		this.startingPrice = startingPrice;
		this.sellingPrice = sellingPrice;
		this.category = category;
		this.user = user;
		this.enchereur = enchereur;
		this.withdrawal = withdrawal;
	}
	/**
	 * Constructeur.
	 */
	public ArticleSold() {
		super();
	}
	/**
	 * Constructeur. pour la base de donnÃ©es
	 * @param articleNum
	 * @param articleName
	 * @param description
	 * @param auctionStartingDate
	 * @param autionEndingDate
	 * @param startingPrice
	 * @param sellingPrice
	 * @param withdrawal2 
	 * @param isSold
	 */
	public ArticleSold( String articleName, String description, LocalDateTime auctionStartingDate,
			LocalDateTime autionEndingDate, Integer startingPrice, Integer sellingPrice, Users user, Users enchereur, Category category, Withdrawal withdrawal) {
		super();
		
		this.articleName = articleName;
		this.description = description;
		this.auctionStartingDate = auctionStartingDate;
		this.auctionEndingDate = autionEndingDate;
		this.startingPrice = startingPrice;
		this.sellingPrice = sellingPrice;
		this.user = user;
		this.category = category;
		this.withdrawal = withdrawal;

		
	}
	
	
	
	
	
	
	
	/**
	 * @param articleNum
	 * @param articleName
	 * @param description
	 * @param auctionStartingDate
	 * @param auctionEndingDate
	 * @param startingPrice
	 * @param sellingPrice
	 * @param isSold
	 * @param category
	 * @param user
	 * @param enchereur
	 * @param auction
	 * @param withdrawal
	 */
	public ArticleSold(Integer articleNum, String articleName, String description, LocalDateTime auctionStartingDate,
			LocalDateTime auctionEndingDate, Integer startingPrice, Integer sellingPrice,
			Category category, Users user, Withdrawal withdrawal) {
		super();
		this.articleNum = articleNum;
		this.articleName = articleName;
		this.description = description;
		this.auctionStartingDate = auctionStartingDate;
		this.auctionEndingDate = auctionEndingDate;
		this.startingPrice = startingPrice;
		this.sellingPrice = sellingPrice;
		this.category = category;
		this.user = user;
		this.withdrawal = withdrawal;
	}
	public ArticleSold(Integer articleNum, String articleName, String description, LocalDateTime auctionStartingDate,
			LocalDateTime auctionEndingDate, Integer startingPrice, Integer sellingPrice, Boolean isSold) {
		super();
		this.articleNum = articleNum;
		this.articleName = articleName;
		this.description = description;
		this.auctionStartingDate = auctionStartingDate;
		this.auctionEndingDate = auctionEndingDate;
		this.startingPrice = startingPrice;
		this.sellingPrice = sellingPrice;
		this.isSold = isSold;
	}
	
	public ArticleSold(String articleName, String description, LocalDateTime auctionStartingDate,
			LocalDateTime auctionEndingDate, Integer startingPrice, Integer sellingPrice, Users user,
			Category category, Withdrawal withdrawal) {
		super();
		this.articleName = articleName;
		this.description = description;
		this.auctionStartingDate = auctionStartingDate;
		this.auctionEndingDate = auctionEndingDate;
		this.startingPrice = startingPrice;
		this.sellingPrice = sellingPrice;
		this.category = category;
		this.user = user;
		this.withdrawal = withdrawal;
	}
	/**
	 * @param articleNum
	 * @param articleName
	 * @param sellingPrice
	 * @param enchereur
	 * Pour afficher les ventes terminées
	 */
	public ArticleSold(Integer articleNum, String articleName, Integer sellingPrice, Users enchereur) {
		super();
		this.articleNum = articleNum;
		this.articleName = articleName;
		this.sellingPrice = sellingPrice;
		this.enchereur = enchereur;
	}
	/**
	 * Getter pour articleNum.
	 * @return the articleNum
	 */
	public Integer getArticleNum() {
		return articleNum;
	}
	/**
	 * Getter pour articleName.
	 * @return the articleName
	 */
	public String getArticleName() {
		return articleName;
	}
	/**
	 * Getter pour description.
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * Getter pour auctionStartingDate.
	 * @return the auctionStartingDate
	 */
	public LocalDateTime getAuctionStartingDate() {
		return auctionStartingDate;
	}
	/**
	 * Getter pour autionEndingDate.
	 * @return the autionEndingDate
	 */
	public LocalDateTime getAuctionEndingDate() {
		return auctionEndingDate;
	}
	/**
	 * Getter pour startingPrice.
	 * @return the startingPrice
	 */
	public Integer getStartingPrice() {
		return startingPrice;
	}
	/**
	 * Getter pour sellingPrice.
	 * @return the sellingPrice
	 */
	public Integer getSellingPrice() {
		return sellingPrice;
	}
	/**
	 * Getter pour isSold.
	 * @return the isSold
	 */
	public Boolean getIsSold() {
		return isSold;
	}

	/**
	 * Setter pour articleNum.
	 * @param articleNum the articleNum to set
	 */
	public void setArticleNum(Integer articleNum) {
		this.articleNum = articleNum;
	}
	/**
	 * Setter pour articleName.
	 * @param articleName the articleName to set
	 */
	public void setArticleName(String articleName) {
		this.articleName = articleName;
	}
	/**
	 * Setter pour description.
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * Setter pour auctionStartingDate.
	 * @param auctionStartingDate the auctionStartingDate to set
	 */
	public void setAuctionStartingDate(LocalDateTime auctionStartingDate) {
		this.auctionStartingDate = auctionStartingDate;
	}
	/**
	 * Setter pour autionEndingDate.
	 * @param autionEndingDate the autionEndingDate to set
	 */
	public void setAuctionEndingDate(LocalDateTime autionEndingDate) {
		this.auctionEndingDate = autionEndingDate;
	}
	/**
	 * Setter pour startingPrice.
	 * @param startingPrice the startingPrice to set
	 */
	public void setStartingPrice(Integer startingPrice) {
		this.startingPrice = startingPrice;
	}
	/**
	 * Setter pour sellingPrice.
	 * @param sellingPrice the sellingPrice to set
	 */
	public void setSellingPrice(Integer sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	/**
	 * Setter pour isSold.
	 * @param isSold the isSold to set
	 */
	public void setIsSold(Boolean isSold) {
		this.isSold = isSold;
	}
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public Auction getAuction() {
		return auction;
	}
	public void setAuction(Auction auction) {
		this.auction = auction;
	}
	public Withdrawal getWithdrawal() {
		return withdrawal;
	}
	public void setWithdrawal(Withdrawal withdrawal) {
		this.withdrawal = withdrawal;
	}
	
	public Users getEnchereur() {
		return enchereur;
	}
	public void setEnchereur(Users enchereur) {
		this.enchereur = enchereur;
	}
	/**
	* {@inheritDoc}
	*/
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ArticleSold [articleNum=");
		builder.append(articleNum);
		builder.append(", articleName=");
		builder.append(articleName);
		builder.append(", description=");
		builder.append(description);
		builder.append(", auctionStartingDate=");
		builder.append(auctionStartingDate);
		builder.append(", autionEndingDate=");
		builder.append(auctionEndingDate);
		builder.append(", startingPrice=");
		builder.append(startingPrice);
		builder.append(", sellingPrice=");
		builder.append(sellingPrice);
		builder.append(", isSold=");
		builder.append(isSold);
		builder.append("]");
		return builder.toString();
	}
	
}
