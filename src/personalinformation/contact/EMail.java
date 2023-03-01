package personalinformation.contact;

/**
 * Class that rappresent the e-mail contact type.
 *
 * @author Daniele Longobardi
 * @version 1.0
 * @since 01/03/2023
 */
public class EMail extends AbstractContact {
	
	/**
	 * Create an empty {@code EMail} Object.
	 */
	private EMail() {
		setType(ContactType.EMAIL);
	}
	
	/**
	 * Create a {@code EMail} Object specifying it's attributes.
	 *
	 * @param email the {@code String} rappresentation of the e-mail.
	 */
	public EMail(String email) {
		this();
		setEMail(email);
	}
	
	@Override
	public String getValue() {
		return this.email;
	}

	/**
	 * Set the value for the e-mail.
	 *
	 * @param email the e-mail value.
	 *
	 * @throw NullPointerException if the value is {@code null}.
	 */
	private void setEMail(String email) {
		if(email == null)
			throw new NullPointerException("Value cannot be null. Parameter name: email");
		
		this.email = email;
	}
	
	private String email;
}