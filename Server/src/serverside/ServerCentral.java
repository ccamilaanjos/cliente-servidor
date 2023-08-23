package serverside;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class ServerCentral {
	private static int PORT = 3000;
	protected static HashMap<String, String> clientes = new HashMap<String, String>();
	
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(PORT);
		System.out.println("Server running on port " + PORT);
		Thread thread;
		
		
		while(true) {
			Socket client = serverSocket.accept();
			Request request = new Request(client);
			
			thread = new Thread(request);
			thread.start();
		}
	}
	
}