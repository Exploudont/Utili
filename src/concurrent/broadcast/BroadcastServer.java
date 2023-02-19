package concurrent.broadcast;

/**
 * Rappresente the server interface to comunicate in broadcast.
 * The server can send new informations using a broadcast channel and check if all clients have receive it.
 *
 * @author Daniele Longobardi
 * @since 19/02/2023
 * @version 1.0.0
 */
public interface BroadcastServer<Data> {
	
	/**
	 * Send and load new datas to the broadcast channel.
	 * The method doesn't check if all clients have receive the information.
	 *
	 * @param msg new data to send to the broadcast.
	 */
	public void send(Data msg);
	
	
	/**
	 * Verify if all waiters have receive the data.
	 *
	 * @return return {@code true} only if all waiters have receive the data.
	 */
	public boolean allHaveReceive();
}