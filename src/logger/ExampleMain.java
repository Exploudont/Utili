package logger;

class ExampleMain {
	
	public static void main(String[] args) {
		// Abstract Factory design pattern.
		Logger logger = LoggerFactory.getLogger(LoggerType.CONSOLE);
		logger.log(Level.ERROR, "test");
	}
}