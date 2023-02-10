package personalinformation;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Class that rappresent generic anagraphic data.
 * 
 * @author Daniele Longobardi
 * @since 03/02/2023
 * @version 1.0.2
 */
public class Anagraphic implements java.io.Serializable {
	
	/**
	 * Constructs a new {@code Anagraphic} specifying it's attributes.
	 *
	 * @param name the {@code String} rappresentation of the name.
	 * @param surname the {@code String} rappresentation of the surname.
	 * @param gender the {@code Gender} rappresentation of the gender.
	 * @param birthday the {@code Date} rappresentation of the date of birth.
	 * @param fiscal_code the {@code String} rappresentation of the fiscal code.
	 */
	public Anagraphic(String name, String surname, Gender gender, Date birthday, String fiscal_code) {
		setName(name);
		setSurname(surname);
		setGender(gender);
		setBirthday(birthday);
		setFiscalCode(fiscal_code);
	}
	
	/**
	 * Constructs a new {@code Anagraphic} specifying it's attributes.
	 *
	 * @param name the {@code String} rappresentation of the name.
	 * @param surname the {@code String} rappresentation of the surname.
	 * @param gender the {@code Gender} rappresentation of the gender.
	 * @param birthday the {@code String} rappresentation of the date of birth.
	 * @param fiscal_code the {@code String} rappresentation of the fiscal code.
	 */
	public Anagraphic(String name, String surname, Gender gender, String birthday, String fiscal_code) {
		this(name, surname, gender, new Date(birthday), fiscal_code);
	}
	
	/**
	 * Return the value of the name.
	 *
	 * @return return the {@code String} rapresentation of the name.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Return the value of the surname.
	 *
	 * @return return the {@code String} rapresentation of the surname.
	 */
	public String getSurname() {
		return this.surname;
	}

	/**
	 * Return the value of the birthday.
	 *
	 * @return return the {@code Date} rapresentation of the birthday.
	 */
	public Date getBirthday() {
		return this.birthday;
	}

	/**
	 * Return the value of the fiscal code.
	 *
	 * @return return the {@code String} rapresentation of the fiscal code.
	 */
	public String getFiscalCode() {
		return this.fiscal_code;
	}

	/**
	 * Return the value of the gender.
	 *
	 * @return return the {@code Gender} rapresentation of the gender.
	 */
	public Gender getGender() {
		return this.gender;
	}
	
	/**
	 * Set the value of the name.
	 *
	 * @param name the {@code String} rappresentation of the name.
	 *
	 * @throws NullPointerException if the value is {@code null}.
	 * @throws IllegalArgumentException if the value is an empty {@code String}.
	 */
	protected void setName(String name) {
		if(name == null)
			throw new NullPointerException("Value cannot be null. Parameter name: name");
		
		if(name.isEmpty())
			throw new IllegalArgumentException("Value cannot be empty. Parameter name: name");
		
		// no check for minimum length
		
		this.name = name.toUpperCase();
	}
	
	/**
	 * Set the value of the surname.
	 *
	 * @param surname the {@code String} rappresentation of the surname.
	 *
	 * @throws NullPointerException if the value is {@code null}.
	 * @throws IllegalArgumentException if the value is an empty {@code String}.
	 */
	protected void setSurname(String surname) {
		if(surname == null)
			throw new NullPointerException("Value cannot be null. Parameter name: surname");
		
		if(surname.isEmpty())
			throw new IllegalArgumentException("Value cannot be empty. Parameter name: surname");
		
		// no check for minimum length
		
		this.surname = surname.toUpperCase();
	}
	
	/**
	 * Set the value of the birthday.
	 *
	 * @param birthday the {@code Date} rappresentation of the birthday.
	 *
	 * @throws NullPointerException if the value is {@code null}.
	 * @throws IllegalArgumentException if the value is not a valid {@code Date}.
	 */
	protected void setBirthday(Date birthday) {
		if(birthday == null)
			throw new NullPointerException("Value cannot be null. Parameter name: birthday");
		
		if(!Utils.isValidBirthday(birthday))
			throw new IllegalArgumentException("Value must be a valid date. Parameter name: birthday");
		
		this.birthday = birthday;
	}
	
	/**
	 * Set the value of the fiscal code.
	 *
	 * @param fiscal_code the {@code String} rappresentation of the fiscal code.
	 *
	 * @throws NullPointerException if the value is {@code null}.
	 * @throws IllegalArgumentException if the value is not a valid fiscal code.
	 */
	protected void setFiscalCode(String fiscal_code) {		
		if(fiscal_code == null)
			throw new NullPointerException("Value cannot be null. Parameter name: fiscal_code");
	
		if(!Utils.isFiscalCodeValid(fiscal_code))
			throw new IllegalArgumentException("Value must be a valid fiscal code. Parameter name: fiscal_code");
		
		this.fiscal_code = fiscal_code.toUpperCase();
	}
	
	/**
	 * Set the value of the gender.
	 *
	 * @param gender the {@code Gender} rappresentation of the gender.
	 *
	 * @throws NullPointerException if the value is {@code null}.
	 */
	protected void setGender(Gender gender) {
		if(gender == null)
			throw new NullPointerException("Value cannot be null. Parameter name: gender");
		
		this.gender = gender;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("name> " + getName());
		sb.append("\nsurname> " + getSurname());
		sb.append("\nbirthday> " + BIRTHDAY_FORMAT.format(getBirthday()));
		sb.append("\nfiscal code> " + getFiscalCode());
		sb.append("\ngender> " + getGender().toString());
		
		return sb.toString();
	}
	
	private static final DateFormat BIRTHDAY_FORMAT = DateFormat.getDateInstance(DateFormat.SHORT, Locale.TAIWAN);
	
	private String name;
	private String surname;
	private Date birthday;
	private String fiscal_code;
	private Gender gender;
}



