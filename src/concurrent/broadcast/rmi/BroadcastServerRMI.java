package broadcast.rmi;

import java.rmi.RemoteException;
import java.rmi.Remote;

/**
 * Rappresente the server interface to comunicate in broadcast via RMI.
 * The server can send new informations using a broadcast channel and check if all clients have receive it.
 *
 * @author Daniele Longobardi
 * @since 20/02/2023
 * @version 1.0.0
 */
public interface BroadcastServerRMI<Data> extends Remote {
	
	/**
	 * Send and load new datas to the broadcast channel.
	 *
	 * @param msg new data to send to the broadcast.
	 *
	 * @throws RemoteException
	 */
	public void send(Data msg) throws RemoteException;
	
	
	/**
	 * Verify if all waiters have receive the data.
	 *
	 * @return return {@code true} only if all waiters have receive the data.
	 *
	 * @throws RemoteException
	 */
	public boolean allHaveReceive() throws RemoteException;
}