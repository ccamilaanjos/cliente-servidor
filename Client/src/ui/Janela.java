package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Janela {

	private JFrame frame;
	private JTextField txtNome;
	private JTextField txtIP;
	private JTextField txtMensagem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		
		JButton btLogin = new JButton("Login");
		btLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btLogin.setBounds(311, 55, 85, 21);
		frame.getContentPane().add(btLogin);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(52, 338, 332, 93);
		frame.getContentPane().add(scrollPane);
		
		JTextPane txtChat = new JTextPane();
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
			}
		});
		btnEnviarMensagem.setBounds(148, 257, 146, 35);
		frame.getContentPane().add(btnEnviarMensagem);
		
		JLabel lbChat = new JLabel("Whatsapp");
		lbChat.setBounds(52, 313, 73, 14);
		frame.getContentPane().add(lbChat);
	}
}
