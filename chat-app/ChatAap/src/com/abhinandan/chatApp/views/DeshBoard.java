package com.abhinandan.chatApp.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;

public class DeshBoard extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	

	/**
	 * Create the frame.
	 */
	public DeshBoard(String message) {
		
//		JLabel lblNewLabel = new JLabel("");
//		lblNewLabel.setIcon(new ImageIcon(DeshBoard.class.getResource("/Images/image2.jpg")));
//		getContentPane().add(lblNewLabel, BorderLayout.CENTER);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1231, 675);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu ChatMenu = new JMenu("Chat");
		ChatMenu.setBackground(new Color(255, 255, 255));
		menuBar.add(ChatMenu);
		
		JMenuItem StartChat = new JMenuItem("Star chat");
		StartChat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
//					System.out.println("In the DashBoard Screen");
//					setVisible(false);
//					dispose();
//					ClientChatScreen clientChatScreen = 
							new ClientChatScreen();
//					clientChatScreen.setVisible(true);
					
				} catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		ChatMenu.add(StartChat);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0,0));
		setContentPane(contentPane);
		setTitle(message);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.WHITE); 
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(DeshBoard.class.getResource("/Images/image2.jpg")));
		contentPane.add(lblNewLabel);
	}

}
