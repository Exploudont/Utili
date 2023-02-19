package concurrent.blackboard;

/**
 * Class that reppresente a concrete blackboard channel.
 *
 * @author Daniele Longobardi
 * @since 19/02/2023
 * @version 1.0.0
 */
public class Blackboard<Data>
					implements BlackboardClient<Data>,
								BlackboardServer<Data> {
	
	private Data data;
	private boolean status;
	
	/**
	 * Constructs a new {@code Blackboard}.
	 *
	 * @param init_data the initial data written of the blackboard.
	 */
	public Blackboard(Data init_data) {
		this();
		
		if(init_data != null) {
			this.status = true;
			this.data = init_data;
		}
	}

	/**
	 * Constructs a new empty {@code Blackboard}.
	 */
	public Blackboard() {
		clear();
	}

	@Override
	public synchronized Data read() throws InterruptedException {
		while(!status)
			wait();
		
		return this.data;
	}
	
	@Override
	public synchronized void write(Data data) {
		this.data = data;
		this.status = true;
		notifyAll();
	}
	
	@Override
	public synchronized void clear() {
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