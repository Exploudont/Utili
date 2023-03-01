package personalinformation.contact;

/**
 * Class that rappresent the basic contact informations.
 *
 * @author Daniele Longobardi
 * @version 1.0
 * @since 01/03/2023
 */
public interface Contact {
	/**
	 * Return the value of the contact.
	 *
	 * @return the {@code String} rappresentation of the contact.
	 */
	String getValue();
	
	/**
	 * Return the type of the contact.
	 *
	 * @return the type of the contact.
	 */
	ContactType getType();
}