package clientside;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientCentral {
	private static int PORT = 3000;

	public static void client(String ipServer, String message) throws IOException {
		Socket client = new Socket(ipServer, PORT);
		System.out.println("Cliente funcionando");

		sendMessage(client, message);
	}
	
	public static void sendMessage(Socket client, String messageToServer) throws IOException {
		PrintWriter writer;
		writer = new PrintWriter(client.getOutputStream(), true);
		
		writer.println(messageToServer);
		
	}
}