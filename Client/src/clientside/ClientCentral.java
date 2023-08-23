package clientside;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientCentral {
	private static int PORT = 3000;

	public static void client(String ip, String message) throws IOException {
		Socket client = new Socket(ip, PORT);

//		PrintWriter writer;
//		Scanner scanner;
//		writer = new PrintWriter(client.getOutputStream(), true);
//		scanner = new Scanner(client.getInputStream());

		System.out.println("Cliente funcionando");
//		while (true) {
//		writer.println("AAAAAAAAAA");
			// Response response = new Response(client);
		sendMessage(client, message);
	}
	
	public static void sendMessage(Socket client, String messageToServer) throws IOException {
		PrintWriter writer;
		writer = new PrintWriter(client.getOutputStream(), true);
		
		writer.println(messageToServer);
		
	}
}