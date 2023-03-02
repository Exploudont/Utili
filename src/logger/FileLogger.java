package logger;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;

/**
 * Class that rappresent a Logger that comunicate using file.
 *
 * @author Daniele Longobardi
 * @since 10/02/2023
 * @version 1.0.1
 */
class FileLogger implements Logger {
	
	/**
	 * The default log file.
	 */
	private static final String DEFAULT_LOG_FILE_PATH = "logs.log";

	/**
	 * Create a new {@code FileLogger} specifying it's attributes.
	 *
	 * @param log_file the file where logs are directed.
	 * @param append if setted to {@code true} append new logs to existing logs.
	 *
	 * @throw IOException If the file connection stream can not be created.
	 */
	protected FileLogger(File log_file, boolean append) throws IOException {
		out = new BufferedWriter(new FileWriter(log_file, append));
	}

	/**
	 * Create a new {@code FileLogger} specifying it's attributes.
	 * If the file existing new logs over write existing.
	 *
	 * @param log_file the file where logs are directed.
	 *
	 * @throw IOException If the file connection stream can not be created.
	 */
	protected FileLogger(File log_file) throws IOException {
		this(log_file, false);
	}

	/**
	 * Create a new {@code FileLogger} specifying it's attributes.
	 * If the file existing new logs over write existing.
	 *
	 * @param log_file the file where logs are directed.
	 *
	 * @throw IOException If the file connection stream can not be created.
	 */
	protected FileLogger(String log_file_path) throws IOException {
		this(new File(log_file_path), false);
	}

	/**
	 * Create a new {@code FileLogger} specifying it's attributes.
	 * Use the default file for logs.
	 * If the file existing new logs over write existing.
	 *
	 * @throw IOException If the file connection stream can not be created.
	 */	
	public FileLogger() throws IOException {
		this(DEFAULT_LOG_FILE_PATH);
	}

	@Override
	public void log(Level level, String msg) {

		String formatted_message = "[" + level + "] " + msg;

		try {
			out.write(formatted_message);
			out.flush();
		} catch(IOException e) {
			System.err.println("Can not print the log");
		}
	}
	
	private BufferedWriter out;
}