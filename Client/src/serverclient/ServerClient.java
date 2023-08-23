package serverclient;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerClient {
	private static int PORT = 3001;

	public static void messageReceiver() throws IOException {
		ServerSocket server = new ServerSocket(PORT);
		Socket client;

		while (true) {
			client = server.accept();
			Scanner serverMessage = new Scanner(client.getInputStream());
			addMessage(serverMessage);
		}
	}
	
	private static void addMessage(Scanner message) {
		System.out.println(message.nextLine());
	}
}
