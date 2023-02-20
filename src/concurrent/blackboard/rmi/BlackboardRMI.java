package blackboard.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Class that reppresente a concrete blackboard RMI channel.
 *
 * @author Daniele Longobardi
 * @since 20/02/2023
 * @version 1.0.0
 */
public class BlackboardRMI<Data> extends UnicastRemoteObject
					implements BlackboardClientRMI<Data>,
								BlackboardServerRMI<Data> {
	
	private Data data;
	private boolean status;
	
	/**
	 * Constructs a new empty {@code BlackboardRMI}.
	 *
	 * @throws RemoteException
	 */
	public BlackboardRMI() throws RemoteException {
		super();
		clear();
	}
	
	/**
	 * Constructs a new {@code BlackboardRMI}.
	 *
	 * @param init_data the initial data written of the blackboard.
	 *
	 * @throws RemoteException
	 */
	public BlackboardRMI(Data init_data) throws RemoteException {
		this();
		
		if(init_data != null) {
			this.status = true;
			this.data = init_data;
		}
	}

	@Override
	public synchronized Data read() throws InterruptedException, RemoteException {
		while(!status)
			wait();
		
		return this.data;
	}
	
	@Override
	public synchronized void write(Data data) throws RemoteException {
		this.data = data;
		this.status = true;
		notifyAll();
	}
	
	@Override
	public synchronized void clear() throws RemoteException {
		this.status = false;
		this.data = null;
	}
	
	/**
	 * Return {@code true} only if there is data available.
	 *
	 * @return {@code true} only if there is data available.
	 */
	private synchronized boolean isDataAvailable() {
		return this.status;
	}
}