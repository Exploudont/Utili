package broadcast.rmi;

import java.rmi.RemoteException;
import java.rmi.Remote;

/**
 * Rappresente the client interface to comunicate in broadcast via RMI.
 * The client can receive informations using a broadcast channel.
 * The client has a sort of connection with the broadcast channel; client can close the connection and doesn't receive other informations.
 *
 * @author Daniele Longobardi
 * @since 20/02/2023
 * @version 1.0.0
 */
public interface BroadcastClientRMI<Data> extends Remote {

	/**
	 * Receive datas form broadcast server.
	 *
	 * @return return datas from broadcast server.
	 *
	 * @throws RemoteException
	 */
	public Data receive() throws RemoteException;

	/**
	 * Close the connection to the broadcast.
	 *
	 * @throws RemoteException
	 */
	public void closeConnection() throws RemoteException;
}