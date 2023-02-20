package blackboard.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Rappresente the server interface o comunicate using the blackboard via RMI.
 * The server can write informations to the blackboard and clear them.
 *
 * @author Daniele Longobardi
 * @since 20/02/2023
 * @version 1.0.0
 */
public interface BlackboardServerRMI<Data> extends Remote {
	
	/**
	 * Write data to the blackboard via RMI.
	 *
	 * @param data the data that will be written.
	 *
	 * @throws RemoteException
	 */
	public void write(Data data) throws RemoteException;

	/**
	 * Clear (invalidate) the data on the blackboard via RMI.
	 *
	 * @throws RemoteException
	 */
	public void clear() throws RemoteException;
}