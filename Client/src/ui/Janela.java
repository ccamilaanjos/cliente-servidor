package ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import clientside.ClientCentral;
import serverclient.ServerClient;

public class Janela{

	private JFrame frame;
	private static JTextField txtNome;
	private static JTextField txtIP;
	private JTextField txtMensagem;
	private static Thread messageReceiverThread;
	private static String nomeUsuario;
	private static String ipServer;
	public static JTextArea txtChat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		messageReceiverThread = new Thread(new ServerClient());
		messageReceiverThread.start();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Janela window = new Janela();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Janela() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 508);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lbNome = new JLabel("Nome:");
		lbNome.setBounds(25, 41, 45, 13);
		frame.getContentPane().add(lbNome);
		
		JLabel lbIP = new JLabel("IP (server):");
		lbIP.setBounds(25, 84, 68, 13);
		frame.getContentPane().add(lbIP);
		
		txtNome = new JTextField();
		txtNome.setBounds(103, 37, 96, 19);
		frame.getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		txtIP = new JTextField();
		txtIP.setBounds(103, 80, 96, 19);
		frame.getContentPane().add(txtIP);
		txtIP.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(52, 338, 332, 93);
		frame.getContentPane().add(scrollPane);
		
		txtChat = new JTextArea();
		txtChat.setText("Criado por:\r\nCamila\r\nLuan\r\nYuri");
		txtChat.setBackground(new Color(255, 255, 255));
		txtChat.setEditable(false);
		scrollPane.setViewportView(txtChat);
		
		txtMensagem = new JTextField();
		txtMensagem.setColumns(10);
		txtMensagem.setBounds(52, 166, 332, 80);
		frame.getContentPane().add(txtMensagem);
		
		JLabel lbEnviarMensagem = new JLabel("Digite sua mensagem:");
		lbEnviarMensagem.setBounds(52, 141, 174, 14);
		frame.getContentPane().add(lbEnviarMensagem);
		
		JButton btnEnviarMensagem = new JButton("Enviar mensagem");
		btnEnviarMensagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String message = txtMensagem.getText();
				try {
					enviarMensagem(message);
					txtMensagem.setText("");
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(btnEnviarMensagem, "ERRO AO ENVIAR A MENSAGEM");
				}
			}
		});
		btnEnviarMensagem.setBounds(148, 257, 146, 35);
		frame.getContentPane().add(btnEnviarMensagem);
		
		JLabel lbChat = new JLabel("Whatsapp");
		lbChat.setBounds(52, 313, 73, 14);
		frame.getContentPane().add(lbChat);
		
		JButton btLogin = new JButton("Login");
		btLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nomeUsuarioAntigo = nomeUsuario;
				String ipServerAntigo = ipServer;
				
				nomeUsuario = txtNome.getText();
				ipServer = txtIP.getText();
				
				try {
					if(!estaLogado(nomeUsuarioAntigo, ipServerAntigo)) {
						enviarNome();
						limparCamposLogin();
						JOptionPane.showMessageDialog(btLogin, "Login feito com sucesso");
					}
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(btLogin, "Erro ao fazer Login");
				}
			}
		});
		btLogin.setBounds(311, 55, 85, 21);
		frame.getContentPane().add(btLogin);
	}
	
	private void enviarNome() throws IOException {
		ClientCentral.client(ipServer, "");
	}
	
	private boolean estaLogado(String nomeUsuarioAntigo, String ipServerAntigo) {
		if(nomeUsuarioAntigo == null || ipServerAntigo == null) {
			return false;
		}
		if(nomeUsuarioAntigo.equalsIgnoreCase(nomeUsuario) && ipServerAntigo.equalsIgnoreCase(ipServer)) {
			return true;
		}
		return false;
	}
	
	private void limparCamposLogin() {
		txtChat.setText("");
		txtNome.setText("");
		txtIP.setText("");
	}
	
	private void enviarMensagem(String mensagem) throws IOException {
		String finalMessage = nomeUsuario + ": " + mensagem;
		ClientCentral.client(ipServer, finalMessage);
	}
}
