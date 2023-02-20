import broadcast.rmi.BroadcastServerRMI;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;

public class TestServer {
	public static final int PORT = 3939;
	public static final String BROADCAST_SERVER = "BroadcastServerRMI";
	
	public static void main(String[] args) {
		try {
			Registry registro = LocateRegistry.getRegistry(PORT);
			
			BroadcastServerRMI<String> b = (BroadcastServerRMI<String>) registro.lookup(BROADCAST_SERVER);
			
			for(int i=0 ; i<10 ; i++) {
				String msg = "msg n"+(i+1);
				b.send(msg);
				System.out.println("Server> " + msg);
				Thread.sleep(1000);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}