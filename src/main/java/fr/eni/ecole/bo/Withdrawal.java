/**
 * 
 */
package fr.eni.ecole.bo;

/**
 * Classe en charge
 * @author Alex
 * @version Ench-res - v1.0
 * @date 1 juin 2021 - 10:35:19
 */
public class Withdrawal {
	private String streetNum;
	private String postalCode;
	private String cityName;
	/**
	 * Constructeur.
	 */
	public Withdrawal() {
		super();
	}
	/**
	 * Getter pour streetNum.
	 * @return the streetNum
	 */
	public String getStreetNum() {
		return streetNum;
	}
	/**
	 * Getter pour postalCode.
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}
	/**
	 * Getter pour cityName.
	 * @return the cityName
	 */
	public String getCityName() {
		return cityName;
	}
	/**
	 * Setter pour streetNum.
	 * @param streetNum the streetNum to set
	 */
	public void setStreetNum(String streetNum) {
		this.streetNum = streetNum;
	}
	/**
	 * Setter pour postalCode.
	 * @param postalCode the postalCode to set
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	/**
	 * Setter pour cityName.
	 * @param cityName the cityName to set
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	/**
	 * Constructeur.
	 * @param streetNum
	 * @param postalCode
	 * @param cityName
	 */
	public Withdrawal(String streetNum, String postalCode, String cityName) {
		super();
		this.streetNum = streetNum;
		this.postalCode = postalCode;
		this.cityName = cityName;
	}
	/**
	* {@inheritDoc}
	*/
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Withdrawal [streetNum=");
		builder.append(streetNum);
		builder.append(", postalCode=");
		builder.append(postalCode);
		builder.append(", cityName=");
		builder.append(cityName);
		builder.append("]");
		return builder.toString();
	}
}
