package serverside;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Request implements Runnable{
	private Socket client;
	
	Request(Socket client){
		this.client = client;
	}
	
	public void readMessage() throws IOException {
		System.out.println("Read - Server");
		
		Scanner scanner;
		scanner = new Scanner(this.client.getInputStream());
		
		String messageFromClient = scanner.nextLine();
		System.out.println("Passou do scanner 2");
		System.out.println(messageFromClient);
//		this.sendMessage();
		//this.client.getInetAddress();
	}
	
//	public void sendMessage() throws IOException {
//		System.out.println("Write - server");
//		PrintWriter writer;
//		writer = new PrintWriter(this.client.getOutputStream(), true);
//		
//		String messageFromServer = "Message received successfully";
//		writer.println(messageFromServer);
//	}
	
	public void resendMessageToAllClients() throws IOException {
		PrintWriter writer;
		Socket toSendMessage;
		
		for (String ip : ServerCentral.clientes.keySet()) {
			toSendMessage = new Socket();
		}
	}

	@Override
	public void run() {
		try {
			this.readMessage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}