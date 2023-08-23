package serverside;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class ServerCentral {
	private static int PORT = 3000;
	protected static HashMap<String,String> clientes = new HashMap<String,String>();
	
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(PORT);
		System.out.println("Server running on port " + PORT);
		Thread thread;
		
		
		while(true) {
			Socket client = serverSocket.accept();
			System.out.println("Conectou!!!");
			
			String ip = client.getInetAddress().getCanonicalHostName();
			
			ServerCentral.addClientIp(ip);
			Request request = new Request(client);
			thread = new Thread(request);
			thread.start();
			//request.readMessage();
		}
	}
	
	private static void addClientIp(String ip) {
		boolean userInChat = ServerCentral.userInChat(ip);
		if(userInChat) {
			return;
		}
		System.out.println("Entrou pela primeira vez");
		clientes.put(ip, ip);
	}
	
	private static boolean userInChat(String ipUser) {
		for (String ip : ServerCentral.clientes.keySet()) {
			if(ip.equalsIgnoreCase(ipUser)) {
				return true;
			}
		}
		return false;
	}
	
}