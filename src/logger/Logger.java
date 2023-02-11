package logger;

/**
 * An object that can print logs.
 *
 * @author Daniele Longobardi
 * @since 10/02/2023
 * @version 1.0.0
 */
public interface Logger {
	
	/**
	 * Print a log.
	 *
	 * @param level the level (gravity) of the log.
	 * @param msg the {@code String} message.
	 */
	void log(Level level, String msg);
}