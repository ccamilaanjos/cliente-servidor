package serverclient;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerClient {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(3001);
		Socket client;
		
		while(true) {
			client = server.accept();
			Scanner serverMessage = new Scanner(client.getInputStream());
			System.out.println(serverMessage.nextLine());;
		}
	}
}
