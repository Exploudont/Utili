package personalinformation;

/**
 * Class that rappresent the Address.
 *
 * @author Daniele Longobardi
 * @since 02/02/2023
 * @version 1.0.2
 */
public class Address implements java.io.Serializable {
	
	/**
	 * Constructs a new empty {@code Address}.
	 */
	public Address() {}
	
	/**
	 * Constructs a new {@code Address} specifying it's attributes.
	 *
	 * @param street the {@code String} rappresentation of the street.
	 * @param cap the {@code String} rappresentation of the CAP.
	 * @param city the {@code String} rappresentation of the city.
	 * @param province the {@code String} rappresentation of the province.
	 * @param region the {@code String} rappresentation of the region.
	 */
	public Address(String street, String cap, String city, String province, String region) {
		setStreet(street);
		setCAP(cap);
		setCity(city);
		setProvince(province);
		setRegion(region);
	}
	
	/**
	 * Return the value of the street.
	 *
	 * @return return the {@code String} rapresentation of the street.
	 */
	public String getStreet() {
		return this.street;
	}
	
	/**
	 * Return the value of the CAP.
	 *
	 * @return return the {@code String} rapresentation of the CAP.
	 */
	public String getCAP() {
		return this.cap;
	}
	
	/**
	 * Return the value of the city.
	 *
	 * @return return the {@code String} rapresentation of the city.
	 */
	public String getCity() {
		return this.city;
	}
	
	/**
	 * Return the value of the province.
	 *
	 * @return return the {@code String} rapresentation of the province.
	 */
	public String getProvince() {
		return this.province;
	}
	
	/**
	 * Return the value of the region.
	 *
	 * @return return the {@code String} rapresentation of the region.
	 */
	public String getRegion() {
		return this.region;
	}
	
	/**
	 * Set the value of the street.
	 *
	 * @param street the {@code String} rappresentation of the street.
	 *
	 * @throws NullPointerException if the value is {@code null}.
	 * @throws IllegalArgumentException if the value is an empty {@code String}.
	 */
	public void setStreet(String street) {
		if(street == null)
			throw new NullPointerException("Value cannot be null. Parameter name: street");
	
		if(street.isEmpty())
			throw new IllegalArgumentException("Value cannot be empty. Parameter name: street");
		
		this.street = street;
	}
	
	/**
	 * Set the value of the CAP.
	 *
	 * @param cap the {@code String} rappresentation of the cap.
	 *
	 * @throws NullPointerException if the value is {@code null}.
	 * @throws IllegalArgumentException if the value is not a valid {@code String}.
	 */
	public void setCAP(String cap) {
		if(cap == null)
			throw new NullPointerException("Value cannot be null. Parameter name: cap");
	
		if(!Utils.isCAPValid(cap))
			throw new IllegalArgumentException("Value cannot must be a valid CAP. Parameter name: cap");
		
		this.cap = cap;
	}
	
	/**
	 * Set the value of the city.
	 *
	 * @param city the {@code String} rappresentation of the city.
	 *
	 * @throws NullPointerException if the value is {@code null}.
	 * @throws IllegalArgumentException if the value is an empty {@code String}.
	 */
	public void setCity(String city) {
		if(city == null)
			throw new NullPointerException("Value cannot be null. Parameter name: city");
	
		if(city.isEmpty())
			throw new IllegalArgumentException("Value cannot be empty. Parameter name: city");
		
		this.city = city;
	}
	
	/**
	 * Set the value of the province.
	 *
	 * @param province the {@code String} rappresentation of the province.
	 *
	 * @throws NullPointerException if the value is {@code null}.
	 * @throws IllegalArgumentException if the value is an empty {@code String}.
	 */
	public void setProvince(String province) {
		if(province == null)
			throw new NullPointerException("Value cannot be null. Parameter name: province");
	
		if(province.isEmpty())
			throw new IllegalArgumentException("Value cannot be empty. Parameter name: province");
		
		this.province = province;
	}
	
	/**
	 * Set the value of the region.
	 *
	 * @param region the {@code String} rappresentation of the region.
	 *
	 * @throws NullPointerException if the value is {@code null}.
	 * @throws IllegalArgumentException if the value is an empty {@code String}.
	 */
	public void setRegion(String region) {
		if(region == null)
			throw new NullPointerException("Value cannot be null. Parameter name: region");
	
		if(region.isEmpty())
			throw new IllegalArgumentException("Value cannot be empty. Parameter name: region");
		
		this.region = region;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		if(getStreet() != null)
			sb.append("street> " + getStreet());
		
		if(getCAP() != null)
			sb.append("\nCAP> " + getCAP());
		
		if(getCity() != null)
			sb.append("\ncity> " + getCity());
		
		if(getProvince() != null)
			sb.append("\nprovince> " + getProvince());
		
		if(getRegion() != null)
			sb.append("\nregion> " + getRegion());
		
		return sb.toString();
	}
	
	//private AddressType type;
	private String street;
	private String cap;
	private String city;
	private String province;
	private String region;
	
	
}
/*
public enum AddressType {
	STREET, // Via
	SQUARE  // Piazza
			// Viale
}
*/