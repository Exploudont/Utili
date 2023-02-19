package concurrent.blackboard;

/**
 * Rappresente the server interface o comunicate using the blackboard.
 * The server can write informations to the blackboard and clear them.
 *
 * @author Daniele Longobardi
 * @since 19/02/2023
 * @version 1.0.0
 */
public interface BlackboardServer<Data> {
	
	/**
	 * Write data to the blackboard.
	 *
	 * @param data the data that will be written.
	 */
	public void write(Data data);

	/**
	 * Clear (invalidate) the data on the blackboard.
	 */
	public void clear();
}