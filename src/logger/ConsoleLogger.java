package logger;

/**
 * Class that rappresent a Logger that comunicate using the console.
 *
 * @author Daniele Longobardi
 * @since 10/02/2023
 * @version 1.0.1
 */
class ConsoleLogger implements Logger {

	@Override
	public void log(Level level, String msg) {
		
		String formatted_message = "[" + level + "] " + msg;
		
		if(level == Level.INFO || level == Level.WARNING)
			System.out.println(formatted_message);
		else
			System.err.println(formatted_message);
	}
}