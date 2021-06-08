/**
 * 
 */
package fr.eni.ecole.bo;

import java.time.LocalDate;
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
	private LocalDateTime autionEndingDate;
	private Integer startingPrice;
	private Integer sellingPrice;
	private Boolean isSold;
	private Integer numCategory;
	private Integer numUser;
	
	/**
	 * Constructeur.
	 */
	public ArticleSold() {
		super();
	}
	/**
	 * Constructeur. pour la base de données
	 * @param articleNum
	 * @param articleName
	 * @param description
	 * @param auctionStartingDate
	 * @param autionEndingDate
	 * @param startingPrice
	 * @param sellingPrice
	 * @param isSold
	 */
	public ArticleSold( String articleName, String description, LocalDateTime auctionStartingDate,
			LocalDateTime autionEndingDate, Integer startingPrice, Integer sellingPrice, Integer numCategory, Integer numUser) {
		super();
		
		this.articleName = articleName;
		this.description = description;
		this.auctionStartingDate = auctionStartingDate;
		this.autionEndingDate = autionEndingDate;
		this.startingPrice = startingPrice;
		this.sellingPrice = sellingPrice;
		this.numCategory = numCategory;
		this.numUser = numUser;
		
	}
	
	
	
	
	
	
	public ArticleSold(Integer articleNum, String articleName, String description, LocalDateTime auctionStartingDate,
			LocalDateTime autionEndingDate, Integer startingPrice, Integer sellingPrice, Boolean isSold) {
		super();
		this.articleNum = articleNum;
		this.articleName = articleName;
		this.description = description;
		this.auctionStartingDate = auctionStartingDate;
		this.autionEndingDate = autionEndingDate;
		this.startingPrice = startingPrice;
		this.sellingPrice = sellingPrice;
		this.isSold = isSold;
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
	public LocalDateTime getAutionEndingDate() {
		return autionEndingDate;
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
	public Integer getNumCategory() {
		return numCategory;
	}
	public Integer getNumUser() {
		return numUser;
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
	public void setAutionEndingDate(LocalDateTime autionEndingDate) {
		this.autionEndingDate = autionEndingDate;
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
	public void setNumCategory(Integer numCategory) {
		this.numCategory = numCategory;
	}
	
	public void setNumUser(Integer numUser) {
		this.numUser = numUser;
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
		builder.append(autionEndingDate);
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
