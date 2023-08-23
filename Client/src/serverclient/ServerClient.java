package serverclient;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import ui.Janela;

public class ServerClient implements Runnable{
	private static int PORT = 3001;

	public static void messageReceiver() throws IOException {
		ServerSocket server = new ServerSocket(PORT);
		Socket client;

		while (true) {
			client = server.accept();
			addMessage(client);
		}
	}
	
	private static void addMessage(Socket client) throws IOException {
		Scanner serverMessage = new Scanner(client.getInputStream());
		String message = serverMessage.nextLine();
		Janela.txtChat.append(message + "\n");;
	}

	@Override
	public void run() {
		try {
			messageReceiver();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
