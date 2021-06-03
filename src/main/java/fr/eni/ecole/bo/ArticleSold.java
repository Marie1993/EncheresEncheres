/**
 * 
 */
package fr.eni.ecole.bo;

import java.time.LocalDate;

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
	private LocalDate auctionStartingDate;
	private LocalDate autionEndingDate;
	private Integer startingPrice;
	private Integer sellingPrice;
	private Boolean isSold;
	/**
	 * Constructeur.
	 */
	public ArticleSold() {
		super();
	}
	/**
	 * Constructeur.
	 * @param articleNum
	 * @param articleName
	 * @param description
	 * @param auctionStartingDate
	 * @param autionEndingDate
	 * @param startingPrice
	 * @param sellingPrice
	 * @param isSold
	 */
	public ArticleSold(Integer articleNum, String articleName, String description, LocalDate auctionStartingDate,
			LocalDate autionEndingDate, Integer startingPrice, Integer sellingPrice, Boolean isSold) {
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
	public LocalDate getAuctionStartingDate() {
		return auctionStartingDate;
	}
	/**
	 * Getter pour autionEndingDate.
	 * @return the autionEndingDate
	 */
	public LocalDate getAutionEndingDate() {
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
	public void setAuctionStartingDate(LocalDate auctionStartingDate) {
		this.auctionStartingDate = auctionStartingDate;
	}
	/**
	 * Setter pour autionEndingDate.
	 * @param autionEndingDate the autionEndingDate to set
	 */
	public void setAutionEndingDate(LocalDate autionEndingDate) {
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
