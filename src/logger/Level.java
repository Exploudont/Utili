package logger;

/**
 * An enum that rappresent the level of gravity.
 *
 * @author Daniele Longobardi
 * @since 10/02/2023
 * @version 1.0.1
 */
public enum Level {
	/**
	 * Rappresentation for information content.
	 */
	INFO,
	
	/**
	 * Rappresentation for warning content.
	 */
	WARNING,
	
	/**
	 * Rappresentation for errors content.
	 */
	ERROR,
	
	/**
	 * Rappresentation for fatal error content.
	 */
	FATAL,
	
	/**
	 * Rappresentation for debug content.
	 * Usefull for debugging.
	 */
	DEBUG
}