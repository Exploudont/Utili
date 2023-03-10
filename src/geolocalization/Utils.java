package geolocalization;

/**
 * Class that contains varius utilities used into the package.
 *
 * @author Daniele Longobardi
 * @since 10/02/2023
 * @version 1.0.0
 */
public class Utils {
	
	private final double MIN_LATITUDE = 0;
	private final double MAX_LATITUDE = 90;
	
	private final double MIN_LONGITUDE = 0;
	private final double MAX_LONGITUDE = 180;
	
	/**
	 * Verify if a latitude has a valid value.
	 *
	 * @param latitude the latitude value.
	 * 
	 * @return return {@code true} only if the latitude has a valid value.
	 */
	public static boolean isValidLatitude(final double latitude) {
		return latitude >= MIN_LATITUDE && latitude <= MAX_LATITUDE;
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
}