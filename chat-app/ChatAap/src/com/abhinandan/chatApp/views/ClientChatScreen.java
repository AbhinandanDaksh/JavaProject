package com.abhinandan.chatApp.views;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.abhinandan.chatApp.network.Client;
import com.abhinandan.chatApp.utils.UserInfo;

public class ClientChatScreen extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
//	private final JTextField textField = new JTextField();
	private JTextArea textArea;
	private Client client ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
					try {
						new ClientChatScreen();
						
					} catch (UnknownHostException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

	}
	private void Send(){
		String message = textField.getText();
		try {
			client.sendMessage(UserInfo.USER_NAME+" - "+message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws UnknownHostException 
a	 */
	public ClientChatScreen() throws UnknownHostException, IOException {
		textArea = new JTextArea();
		client= new Client(textArea);
		setTitle("Client Chat");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 577, 477);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		textArea = new JTextArea();
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 6, 545, 389);
		contentPane.add(scrollPane);
		
		
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textArea.setBounds(20, 24, 500, 354);
		scrollPane.setViewportView(textArea);
		
		textField =new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setBounds(10, 405, 462, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		client= new Client(textArea);
		
		JButton Send = new JButton("SEND");
		Send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Send();
			}
		});
		Send.setBounds(482, 405, 73, 27);
		contentPane.add(Send);
		
//		contentPane.add(textArea);
//		textArea.setColumns(10);
		
		setVisible(true);
		
//		scrollPane.getViewport().add(textArea);
		
	}
}
