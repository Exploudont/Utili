package concurrent.broadcast;

/**
 * Class that reppresente a concrete broadcast channel.
 *
 * @author Daniele Longobardi
 * @since 19/02/2023
 * @version 1.0.0
 */
public class Broadcast<Data>
				implements BroadcastClient<Data>, 
							BroadcastServer<Data> {
	
	private Data msg;
	private boolean arrived;
	private int waiting;
	
	/**
	 * Constructs a new empty {@code Broadcast}.
	 */
	public Broadcast() {
		arrived = false;
		waiting = 0;
		msg = null;
	}
	
	@Override
	public synchronized void send(Data msg) {
		// bypassed because the server can check if all have receive che message.
		// to check the block must be included in:
		// if(allHaveReceive()) { ... }

		this.msg = msg;
		arrived = true;
		notifyAll();
	}
	
	@Override
	public synchronized boolean allHaveReceive() {
		return waiting!=0 && !arrived;
	}
	
	@Override
	public synchronized Data receive() {
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
	public synchronized void closeConnection() {
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