package personalinformation.contact;

import personalinformation.Utils;

/**
 * Class that rappresent the telephone contact type.
 *
 * @author Daniele Longobardi
 * @version 1.0
 * @since 01/03/2023
 */
public class Telephone extends AbstractContact {
	
	/**
	 * Create an empty {@code Telephone} Object.
	 */
	private Telephone() {
		setType(ContactType.TELEPHONE);
	}
	
	/**
	 * Create a {@code Telephone} Object specifying it's attributes.
	 *
	 * @param telephone_number the {@code String} rappresentation of the telephone number.
	 */
	public Telephone(String telephone_number) {
		this();
		setTelephoneNumber(telephone_number);
	}
	
	@Override
	public String getValue() {
		return this.telephone_number;
	}

	/**
	 * Set the value for the telephone number.
	 *
	 * @param telephone_number the telephone number value.
	 *
	 * @throw NullPointerException if the value is {@code null}.
	 * @throw IllegalArgumentException
	 */
	private void setTelephoneNumber(String telephone_number) {
		if(telephone_number == null)
			throw new NullPointerException("Value cannot be null. Parameter name: telephone_number");
		
		if(!Utils.containsOnlyDigits(telephone_number))
			throw new IllegalArgumentException("Value must contains only digits. Parameter name: telephone_number");
		
		if(telephone_number.length() < 8 || telephone_number.length() > 10)
			throw new IllegalArgumentException("Value must be 8 to 10 digit length. Parameter name: telephone_number");
		
		this.telephone_number = telephone_number;
	}
	
	private String telephone_number;
}