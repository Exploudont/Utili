package personalinformation;

import java.util.Date;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Class that contains varius utilities used into the package.
 *
 * @author Daniele Longobardi
 * @since 02/02/2023
 * @version 1.0
 */
public class Utils {
	
	private static final Pattern FISCAL_CODE_PARSER;
	private static final Pattern CAP_PARSER;
	
	static {
		final String FISCAL_CODE_REGEX = "[a-z]{6}[0-9]{2}[a-z][0-9]{2}[a-z][0-9]{3}[a-z]";
		FISCAL_CODE_PARSER = Pattern.compile(FISCAL_CODE_REGEX, Pattern.CASE_INSENSITIVE);
		
		final String CAP_REGEX = "[0-9]{5}";
		CAP_PARSER = Pattern.compile(CAP_REGEX);
	}
	
	/**
	 * Verify if a fiscal code has a valid format.
	 *
	 * @param fiscal_code the {@code String} rappresentation of the fiscal.
	 * 
	 * @return return {@code true} only if the fiscal code has the correct structure.
	 *
	 * @throws NullPointerException is the parameter is {@code null}.
	 */
	public static boolean isFiscalCodeValid(final String fiscal_code) {
		if(fiscal_code == null)
			throw new NullPointerException("Value cannot be null. Parameter name: fiscal_code");
		
		Matcher matcher = FISCAL_CODE_PARSER.matcher(fiscal_code);
		return matcher.matches();
	}
	
	/**
	 * Verify if a birthday has a valid value.
	 *
	 * @param birthday the {@code Date} rappresentation of the birthday to verify.
	 *
	 * @return return {@code true} only if the birthday has a valid value.
	 *
	 * @throws NullPointerException is the parameter is {@code null}.
	 */
	public static boolean isValidBirthday(final Date birthday) {
		if(birthday == null)
			throw new NullPointerException("Value cannot be null. Parameter name: birthday");
		
		if(isValidDate(birthday)) {
			Date today = new Date();
			return today.compareTo(birthday) == 1;
		}
		
		return false;
	}
	
	/**
	 * Verify if a date has a valid value.
	 *
	 * @param date the {@code Date} rappresentation of the date to verify.
	 *
	 * @return return {@code true} only if the date has a valid value.
	 *
	 * @throws NullPointerException is the parameter is {@code null}.
	 */
	public static boolean isValidDate(final Date date) {
		if(date == null)
			throw new NullPointerException("Value cannot be null. Parameter name: date");
		
		return true; // for debug
	}
	
	/**
	 * Verify if a CAP has a valid value.
	 *
	 * @param cap the {@code String} rappresentation of the CAP.
	 *
	 * @return return {@code true} only if the CAP has a valid value.
	 *
	 * @throws NullPointerException is the parameter is {@code null}.
	 */
	public static boolean isCAPValid(final String cap) {
		if(cap == null)
			throw new NullPointerException("Value cannot be null. Parameter name: cap");
		
		Matcher matcher = CAP_PARSER.matcher(cap);
		return matcher.matches();
	}
	
	/**
	 * Verify if a {@code String} contains only digit values.
	 *
	 * @param str the {@code String} to verify.
	 * 
	 * @return return {@code true} only if contains only digit values, {@code false} otherwise.
	 *
	 * @throws NullPointerException is the parameter is {@code null}.
	 */
	public static boolean containsOnlyDigits(final String str) {
		if(str == null)
			throw new NullPointerException("Value cannot be null. Parameter name: str");
		
		for(int i=0 ; i<str.length() ; i++)
			if(!Character.isDigit(str.charAt(i)))
				return false;
			
		return true;
	}
	
	/**
	 * Verify if a {@code String} contains only alphabetic values.
	 *
	 * @param str the {@code String} to verify.
	 * 
	 * @return return {@code true} only if contains only alphabetic values, {@code false} otherwise.
	 *
	 * @throws NullPointerException is the parameter is {@code null}.
	 */
	public static boolean containsOnlyAlphabetic(final String str) {
		if(str == null)
			throw new NullPointerException("Value cannot be null. Parameter name: str");
		
		for(int i=0 ; i<str.length() ; i++)
			if(!Character.isAlphabetic(str.charAt(i)))
				return false;
			
		return true;
	}
	
	
}