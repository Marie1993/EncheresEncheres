/**
 * 
 */
package fr.eni.ecole.bo;

/**
 * Classe en charge
 * @author Alex
 * @version Ench-res - v1.0
 * @date 1 juin 2021 - 09:56:19
 */
public class Users {
	private Integer numUser;
	private String nickname;
	private String name;
	private String surname;
	private String email;
	private String phone;
	private String numStreet;
	private String postalCode;
	private String city;
	private String password;
	private Integer credit;
	private Boolean admin;
	/**
	 * Getter pour numUser.
	 * @return the numUser
	 */
	public Integer getNumUser() {
		return numUser;
	}
	/**
	 * Getter pour nickname.
	 * @return the nickname
	 */
	public String getNickname() {
		return nickname;
	}
	/**
	 * Getter pour name.
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * Getter pour surname.
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}
	/**
	 * Getter pour email.
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * Getter pour phone.
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * Getter pour numStreet.
	 * @return the numStreet
	 */
	public String getNumStreet() {
		return numStreet;
	}
	/**
	 * Getter pour postalCode.
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}
	/**
	 * Getter pour city.
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * Getter pour password.
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * Getter pour credit.
	 * @return the credit
	 */
	public Integer getCredit() {
		return credit;
	}
	/**
	 * Getter pour admin.
	 * @return the admin
	 */
	public Boolean getAdmin() {
		return admin;
	}
	/**
	 * Setter pour numUser.
	 * @param numUser the numUser to set
	 */
	public void setNumUser(Integer numUser) {
		this.numUser = numUser;
	}
	/**
	 * Setter pour nickname.
	 * @param nickname the nickname to set
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	/**
	 * Setter pour name.
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Setter pour surname.
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}
	/**
	 * Setter pour email.
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * Setter pour phone.
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * Setter pour numStreet.
	 * @param numStreet the numStreet to set
	 */
	public void setNumStreet(String numStreet) {
		this.numStreet = numStreet;
	}
	/**
	 * Setter pour postalCode.
	 * @param postalCode the postalCode to set
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	/**
	 * Setter pour city.
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * Setter pour password.
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * Setter pour credit.
	 * @param credit the credit to set
	 */
	public void setCredit(Integer credit) {
		this.credit = credit;
	}
	/**
	 * Setter pour admin.
	 * @param admin the admin to set
	 */
	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
	/**
	 * Constructeur.
	 */
	public Users() {
		super();
	}
	/**
	 * Constructeur.
	 * @param numUser
	 * @param nickname
	 * @param name
	 * @param surname
	 * @param email
	 * @param phone
	 * @param numStreet
	 * @param postalCode
	 * @param password
	 * @param credit
	 * @param admin
	 */
	public Users(Integer numUser, String nickname, String name, String surname, String email, String phone,
			String numStreet, String postalCode,String city, String password, Integer credit, Boolean admin) {
		super();
		this.numUser = numUser;
		this.nickname = nickname;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.phone = phone;
		this.numStreet = numStreet;
		this.postalCode = postalCode;
		this.city = city;
		this.password = password;
		this.credit = credit;
		this.admin = admin;
	}
	
	/**
	 * Constructeur.
	 * @param numUser
	 * @param nickname
	 * @param name
	 * @param surname
	 * @param email
	 * @param phone
	 * @param numStreet
	 * @param postalCode
	 * @param password
	 * @param credit
	 * @param admin
	 */
	public Users(String nickname, String name, String surname, String email, String phone,
			String numStreet, String postalCode,String city, String password, Integer credit, Boolean admin) {
		super();

	 /* @param city
	 * @param password
	 * Constructeur pour mettre à jour le profil.
	 */
	public Users(Integer numUser, String nickname, String name, String surname, String email, String phone,
			String numStreet, String postalCode, String city, String password) {
		super();
		this.numUser = numUser;
		this.nickname = nickname;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.phone = phone;
		this.numStreet = numStreet;
		this.postalCode = postalCode;
		this.city = city;
		this.password = password;
		this.credit = credit;
		this.admin = admin;
	}
	/**
	* {@inheritDoc}
	*/
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Users [numUser=");
		builder.append(numUser);
		builder.append(", nickname=");
		builder.append(nickname);
		builder.append(", name=");
		builder.append(name);
		builder.append(", surname=");
		builder.append(surname);
		builder.append(", email=");
		builder.append(email);
		builder.append(", phone=");
		builder.append(phone);
		builder.append(", numStreet=");
		builder.append(numStreet);
		builder.append(", postalCode=");
		builder.append(postalCode);
		builder.append(", password=");
		builder.append(password);
		builder.append(", credit=");
		builder.append(credit);
		builder.append(", admin=");
		builder.append(admin);
		builder.append("]");
		return builder.toString();
	}
	
}
