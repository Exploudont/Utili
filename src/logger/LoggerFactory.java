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
	
	private static final Logger console_logger;
	private static final Logger file_logger;
	
	static {
		console_logger = new ConsoleLogger();
		
		Logger tmp_logger = null;
		try {
			tmp_logger = new FileLogger();
		} catch(Exception e) { System.exit(1); }
		file_logger = tmp_logger;
	}
	
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
			case CONSOLE : return console_logger;
			case FILE : return file_logger;
		}
		
		return console_logger;
	}
}