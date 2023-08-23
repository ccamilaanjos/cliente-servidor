package serverside;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Request implements Runnable{
	private Socket client;
	private static int CLIENT_PORT = 3001;
	
	Request(Socket client){
		this.client = client;
	}
	
	private String getClientMessage() throws IOException {
		Scanner scanner = new Scanner(this.client.getInputStream());
		String messageFromClient = scanner.nextLine();
		
		return messageFromClient;
	}
		
	private void resendMessageToAllClients() throws IOException {
		PrintWriter writer;
		Socket toSendMessage;
		String message = getClientMessage();
		
		for (String ip : ServerCentral.clientes.keySet()) {
			try {
				toSendMessage = new Socket(ip, CLIENT_PORT);
				writer = new PrintWriter(toSendMessage.getOutputStream(), true);
				writer.println(message);
			} catch (Exception e) {
				ServerCentral.clientes.remove(ip);
			}
		}
	}

	@Override
	public void run() {
		String ip = client.getInetAddress().getCanonicalHostName();
		ServerCentral.clientes.put(ip, ip);
		try {
			this.resendMessageToAllClients();
		} catch (IOException e) {
			System.out.println("ERRO AO ENVIAR MENSAGEM PARA OS CLIENTES");
		}
	}
}