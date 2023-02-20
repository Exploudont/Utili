package broadcast.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Class that reppresente a concrete broadcast RMI channel.
 *
 * @author Daniele Longobardi
 * @since 20/02/2023
 * @version 1.0.0
 */
public class BroadcastRMI<Data> extends UnicastRemoteObject
				implements BroadcastClientRMI<Data>, 
							BroadcastServerRMI<Data> {
	
	private Data msg;
	private boolean arrived;
	private int waiting;

	/**
	 * Constructs a new empty {@code BroadcastRMI}.
	 *
	 * @throws RemoteException
	 */
	public BroadcastRMI() throws RemoteException {
		super();
		
		arrived = false;
		waiting = 0;
		msg = null;
	}
	
	@Override
	public synchronized void send(Data msg) throws RemoteException {
		if(allHaveReceive()) {
			this.msg = msg;
			arrived = true;
			notifyAll();
		}
	}
	
	@Override
	public synchronized boolean allHaveReceive() throws RemoteException {
		return waiting!=0 && !arrived;
	}
	
	@Override
	public synchronized Data receive() throws RemoteException {
		addWaiter();
			
		try {
			while(!arrived)
				wait();
		}catch(InterruptedException e) {}
			
		removeWaiter();
			
		if(thereAreNoWaiters())
			arrived = false;
		
		return msg;
	}
	
	@Override
	public synchronized void closeConnection() throws RemoteException {
		removeWaiter();
		// if was the last that was waiting
		notifyAll();
	}
	
	/**
	 * Remove a waiter from the broadcast.
	 */
	private synchronized void removeWaiter() {
		waiting--;
	}
	
	/**
	 * Add a waiter to the broadcast.
	 */
	private synchronized void addWaiter() {
		waiting++;
	}
	
	/**
	 * Verify if a waiter was the last.
	 *
	 * @return return true only if there aren't waiters.
	 */
	private synchronized boolean thereAreNoWaiters() {
		return waiting == 0;
	}
}