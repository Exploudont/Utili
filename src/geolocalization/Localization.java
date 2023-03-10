package geolocalization;

/**
 * Class that rappresent a Localization.
 *
 * @author Daniele Longobardi
 * @since 10/02/2023
 * @version 1.0.1
 */
public class Localization implements java.io.Serializable {
	
	private final double MIN_LATITUDE = 0;
	private final double MAX_LATITUDE = 90;
	
	private final double MIN_LONGITUDE = 0;
	private final double MAX_LONGITUDE = 180;
	
	
	/**
	 * Constructs a new {@code Localization} specifying it's attributes.
	 *
	 * @param latitude the value of the latitude.
	 * @param longitude the value of the longitude.
	 */
	public Localization(double latitude, double longitude) {
		setLatitude(latitude);
		setLongitude(longitude);
	}


	/**
	 * Set the value of the latitude.
	 *
	 * @param latitude the value of the latitude.
	 *
	 * @throws IllegalArgumentException if the value is not a valid latitude.
	 */	
	protected void setLatitude(double latitude) {
		if(!isValidLatitude(latitude))
			throw new IllegalArgumentException("Value must be a valid value. Parameter name: latitude");
		
		this.latitude = latitude;
	}
	
	/**
	 * Verify if a latitude has valid a value.
	 *
	 * @param latitude the latitude value.
	 * 
	 * @return return {@code true} only if the latitude has a valid value.
	 */
	public static boolean isValidLatitude(final double latitude) {
		return latitude >= MIN_LATITUDE && latitude <= MAX_LATITUDE;
	}
	
	/**
	 * Set the value of the longitude.
	 *
	 * @param longitude the value of the longitude.
	 *
	 * @throws IllegalArgumentException if the value is not a valid longitude.
	 */
	protected void setLongitude(double longitude) {
		if(!isValidLongitude(longitude))
			throw new IllegalArgumentException("Value must be a valid value. Parameter name: longitude");
		
		this.longitude = longitude;
	}
	
	/**
	 * Verify if a longitude has a valid value.
	 *
	 * @param longitude the longitude value.
	 * 
	 * @return return {@code true} only if the longitude has a valid value.
	 */
	public static boolean isValidLongitude(final double longitude) {
		return latitude >= MIN_LONGITUDE && latitude <= MAX_LONGITUDE;
	}


	/**
	 * Return the value of the latitude.
	 *
	 * @return the value of the latitude.
	 */	
	public double getLatitude() {
		return this.latitude;
	}

	/**
	 * Return the value of the longitude.
	 *
	 * @return the value of the longitude.
	 */
	public double getLongitude() {
		return this.longitude;
	}
	
	
	@Override
	public String toString() {
		return "latitude> " + getLatitude() + "\nlongitude> " + getLongitude();
	}
	
	
	private double latitude;
	private double longitude;
}