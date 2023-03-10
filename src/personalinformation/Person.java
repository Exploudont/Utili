package personalinformation;

import personalinformation.contact.Contact;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Class that rappresent a generic person.
 * 
 * @author Daniele Longobardi
 * @since 02/02/2023
 * @version 1.0.2
 */
public class Person implements java.io.Serializable {
	
	/**
	 * Constructs a new empty {@code Person}.
	 */
	public Person() {
		contacts = new ArrayList<Contact>();
	}
	
	/**
	 * Constructs a new {@code Person} specifying it's attributes.
	 *
	 * @param anagraphic the anagraphic of a person.
	 * @param address the address of a person.
	 */
	public Person(Anagraphic anagraphic, Address address) {
		this();
		setAnagraphic(anagraphic);
		setAddress(address);
	}
	
	/**
	 * Constructs a new {@code Person} specifying it's attributes.
	 *
	 * @param anagraphic the anagraphic of a person.
	 * @param address the address of a person.
	 * @param contacts the contacts of a person
	 */
	public Person(Anagraphic anagraphic, Address address, Collection<Contact> contacts) {
		this(anagraphic, address);
		addContact(contacts);
	}
	
	/**
	 * Return the value of the anagraphic.
	 *
	 * @return the value of the anagraphic.
	 */
	public Anagraphic getAnagraphic() {
		return this.anagraphic;
	}
	
	/**
	 * Return the value of the address.
	 *
	 * @return the value of the address.
	 */
	public Address getAddress() {
		return this.address;
	}
	
	/**
	 * Return the value of the contacts.
	 *
	 * @return the value of the contacts.
	 */
	public List<Contact> getContacts() {
		return this.contacts;
	}
	
	/**
	 * Add a {@code Collection} of contacts.
	 *
	 * @param contacts the contacts
	 */
	public void addContact(Collection<Contact> contacts) {
		for(Contact c : contacts)
			addContact(c);
	}
	
	/**
	 * Add a contact.
	 *
	 * @param contact the contact
	 *
	 * @throw NullPointerException if the value is {@code null}.
	 */
	public void addContact(Contact contact) {
		if(address == null)
			throw new NullPointerException("Value cannot be null. Parameter name: address");
		
		this.contacts.add(contact);
	}
	
	/**
	 * Set the value of the anagraphic.
	 *
	 * @param anagraphic the anagraphic
	 *
	 * @throw NullPointerException if the value is {@code null}.
	 */
	public void setAnagraphic(Anagraphic anagraphic) {
		if(anagraphic == null)
			throw new NullPointerException("Value cannot be null. Parameter name: anagraphic");
		
		this.anagraphic = anagraphic;
	}
	
	/**
	 * Set the value of the address.
	 *
	 * @param address the address
	 *
	 * @throw NullPointerException if the value is {@code null}.
	 */
	public void setAddress(Address address) {
		if(address == null)
			throw new NullPointerException("Value cannot be null. Parameter name: address");
		
		this.address = address;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		if(getAnagraphic() != null) {
			sb.append("== Anagraphic ==\n");
			sb.append(getAnagraphic().toString());
		}
		
		if(getAddress() != null) {
			sb.append("\n== Address ==\n");
			sb.append(getAddress().toString());
		}
		
		for(Contact c : getContacts())
			sb.append("\n== Contact ==\n" + c.toString());
		
		//getContacts().forEach(c -> sb.append("== Contact ==\n" + c.toString()));
		
		return sb.toString();
	}
		
	private Anagraphic anagraphic;
	private Address address;
	private List<Contact> contacts;
}



