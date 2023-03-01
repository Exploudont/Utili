package personalinformation.contact;

/**
 * Abstract implementation of the major methods for a {@code Contact} object.
 *
 * @author Daniele Longobardi
 * @version 1.0
 * @since 01/03/2023
 */
abstract class AbstractContact
					implements Contact, java.io.Serializable {

	@Override
	public abstract String getValue();
	
	@Override
	public ContactType getType() {
		return this.type;
	}
	
	/**
	 * Set the value of the contact type.
	 *
	 * @param type the type of the contact.
	 *
	 * @throw NullPointerException if the value is {@code null}.
	 */
	protected void setType(ContactType type) {
		if(type == null)
			throw new NullPointerException("Value cannot be null. Parameter name: type");
		
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "type> " + getType() + "\nvalue> " + getValue();
	}
	
	private ContactType type;
}