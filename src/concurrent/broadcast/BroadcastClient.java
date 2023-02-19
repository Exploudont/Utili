package concurrent.broadcast;

/**
 * Rappresente the client interface to comunicate in broadcast.
 * The client can receive informations using a broadcast channel.
 * The client has a sort of connection with the broadcast channel; client can close the connection and doesn't receive other informations.
 *
 * @author Daniele Longobardi
 * @since 19/02/2023
 * @version 1.0.0
 */
public interface BroadcastClient<Data> {
	
	/**
	 * Receive datas form broadcast server.
	 *
	 * @return return datas from broadcast server.
	 */
	public Data receive();
	
	/**
	 * Close the connection to the broadcast.
	 */
	public void closeConnection();
}