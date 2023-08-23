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

public class Janela {

	private JFrame frame;
	private JTextField txtNome;
	private JTextField txtIP;

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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lbNome = new JLabel("Nome:");
		lbNome.setBounds(25, 41, 45, 13);
		frame.getContentPane().add(lbNome);
		
		JLabel lbIP = new JLabel("IP:");
		lbIP.setBounds(25, 123, 45, 13);
		frame.getContentPane().add(lbIP);
		
		txtNome = new JTextField();
		txtNome.setBounds(80, 38, 96, 19);
		frame.getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		txtIP = new JTextField();
		txtIP.setBounds(80, 120, 96, 19);
		frame.getContentPane().add(txtIP);
		txtIP.setColumns(10);
		
		JButton btEnviar = new JButton("Enviar");
		btEnviar.setBounds(303, 80, 85, 21);
		frame.getContentPane().add(btEnviar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(352, 189, 2, 2);
		frame.getContentPane().add(scrollPane);
	}
}
