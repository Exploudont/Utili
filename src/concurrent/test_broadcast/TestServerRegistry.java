import broadcast.rmi.BroadcastRMI;
import broadcast.rmi.BroadcastClientRMI;
import broadcast.rmi.BroadcastServerRMI;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;

/*
Una classe mette a disposizione nel Registry sia il BroadcastClientRMI che il BroadcastServerRMI.
Il server che intende usare il BroadcastServerRMI deve connettersi e richiedere il BroadcastServerRMI.
Il client che intende usare il BroadcastClientRMI deve connettersi e richiedere il BroadcastClientRMI.
*/
public class TestServerRegistry {
	
	public static final int PORT = 3939;
	public static final String BROADCAST_CLIENT = "BroadcastClientRMI";
	public static final String BROADCAST_SERVER = "BroadcastServerRMI";
	
	public static void main(String[] args) {
		
		try {
			BroadcastRMI<String> broacast = new BroadcastRMI<String>();
			BroadcastClientRMI<String> client = broacast;
			BroadcastServerRMI<String> server = broacast;
			System.out.println("Creazione Oggetti remoti");
			
			Registry registro = LocateRegistry.createRegistry(PORT);
			System.out.println("Creazione del registry");
			
			registro.rebind(BROADCAST_CLIENT, client);
			registro.rebind(BROADCAST_SERVER, server);			
			System.out.println("Assegnazione del servizio");
			System.out.println("Avvio eseguito correttamente");
			System.out.println("Il servizio e' in esecuzione");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}