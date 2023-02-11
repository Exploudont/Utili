package logger;

/**
 * Class that rappresent a Logger getter.
 * Abstract and separate the Logger's creation for the users
 *
 * @author Daniele Longobardi
 * @since 10/02/2023
 * @version 1.0.1
 */
abstract class LoggerFactory {
	
	/**
	 * Return the selected Logger.
	 *
	 * @param type the tapy of the Logger.
	 *
	 * @return return a the required logger.
	 */
	public static Logger getLogger(LoggerType type) {
		
		switch(type)
		{
			case CONSOLE : return new ConsoleLogger();
		}
		
		return new ConsoleLogger();
	}
}