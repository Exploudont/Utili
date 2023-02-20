import broadcast.rmi.BroadcastClientRMI;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;

public class TestClient {
	public static final int PORT = 3939;
	public static final String BROADCAST_CLIENT = "BroadcastClientRMI";
	
	public static void main(String[] args) {
		try {
			Registry registro = LocateRegistry.getRegistry(PORT);
			
			BroadcastClientRMI<String> b = (BroadcastClientRMI<String>) registro.lookup(BROADCAST_CLIENT);
			
			while(true) {
				String msg = b.receive();
				System.out.println("Client receive> " + msg);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}