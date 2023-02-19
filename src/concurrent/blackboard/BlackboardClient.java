package concurrent.blackboard;


/**
 * Rappresente the client interface o comunicate using the blackboard.
 * The client can read informations to the blackboard.
 *
 * @author Daniele Longobardi
 * @since 19/02/2023
 * @version 1.0.0
 */
public interface BlackboardClient<Data> {
	
	/**
	 * Read data from the blackboard.
	 *
	 * @return return the readed datas.
	 *
	 * @throws InterruptedException
	 */
	public Data read() throws InterruptedException;
}