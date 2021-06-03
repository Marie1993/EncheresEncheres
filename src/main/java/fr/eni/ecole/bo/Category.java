/**
 * 
 */
package fr.eni.ecole.bo;

/**
 * Classe en charge
 * @author Alex
 * @version Ench-res - v1.0
 * @date 1 juin 2021 - 10:31:07
 */
public class Category {
	private Integer categoryNum;
	private String wording;
	/**
	 * Constructeur.
	 */
	public Category() {
		super();
	}
	/**
	 * Constructeur.
	 * @param categoryNum
	 * @param wording
	 */
	public Category(Integer categoryNum, String wording) {
		super();
		this.categoryNum = categoryNum;
		this.wording = wording;
	}
	/**
	 * Getter pour categoryNum.
	 * @return the categoryNum
	 */
	public Integer getCategoryNum() {
		return categoryNum;
	}
	/**
	 * Getter pour wording.
	 * @return the wording
	 */
	public String getWording() {
		return wording;
	}
	/**
	 * Setter pour categoryNum.
	 * @param categoryNum the categoryNum to set
	 */
	public void setCategoryNum(Integer categoryNum) {
		this.categoryNum = categoryNum;
	}
	/**
	 * Setter pour wording.
	 * @param wording the wording to set
	 */
	public void setWording(String wording) {
		this.wording = wording;
	}
	/**
	* {@inheritDoc}
	*/
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Category [categoryNum=");
		builder.append(categoryNum);
		builder.append(", wording=");
		builder.append(wording);
		builder.append("]");
		return builder.toString();
	}
}
