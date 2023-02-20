package blackboard.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Rappresente the client interface o comunicate using the blackboard via RMI.
 * The client can read informations to the blackboard.
 *
 * @author Daniele Longobardi
 * @since 20/02/2023
 * @version 1.0.0
 */
public interface BlackboardClientRMI<Data> extends Remote {
	
	/**
	 * Read data from the blackboard via RMI.
	 *
	 * @return return the readed datas.
	 *
	 * @throws InterruptedException
	 * @throws RemoteException
	 */
	public Data read() throws InterruptedException, RemoteException;
}