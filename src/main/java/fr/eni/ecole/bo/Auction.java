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
 * @date 1 juin 2021 - 10:24:37
 */
public class Auction {
	private LocalDateTime auctionDate;
	private Integer auctionAmount;
	/**
	 * Constructeur.
	 */
	public Auction() {
		super();
	}
	/**
	 * Constructeur.
	 * @param auctionDate
	 * @param auctionAmount
	 */
	public Auction(LocalDateTime auctionDate, Integer auctionAmount) {
		super();
		this.auctionDate = auctionDate;
		this.auctionAmount = auctionAmount;
	}
	/**
	 * Getter pour auctionDate.
	 * @return the auctionDate
	 */
	public LocalDateTime getAuctionDate() {
		return auctionDate;
	}
	/**
	 * Getter pour auctionAmount.
	 * @return the auctionAmount
	 */
	public Integer getAuctionAmount() {
		return auctionAmount;
	}
	/**
	 * Setter pour auctionDate.
	 * @param auctionDate the auctionDate to set
	 */
	public void setAuctionDate(LocalDateTime auctionDate) {
		this.auctionDate = auctionDate;
	}
	/**
	 * Setter pour auctionAmount.
	 * @param auctionAmount the auctionAmount to set
	 */
	public void setAuctionAmount(Integer auctionAmount) {
		this.auctionAmount = auctionAmount;
	}
	/**
	* {@inheritDoc}
	*/
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Auction [auctionDate=");
		builder.append(auctionDate);
		builder.append(", auctionAmount=");
		builder.append(auctionAmount);
		builder.append("]");
		return builder.toString();
	}
}
