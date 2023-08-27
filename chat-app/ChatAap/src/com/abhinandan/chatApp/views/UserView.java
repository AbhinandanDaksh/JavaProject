package com.abhinandan.chatApp.views;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class UserView extends JFrame{
	int counter;
	public UserView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		setSize(400,400);
//		setLocation(500,250);
		setTitle("login");
		setLocationRelativeTo(null);
		JLabel welcome =new JLabel("welcome");
		welcome.setFont(new Font("Arial",Font.BOLD,40));
		Container container=this.getContentPane();
		container.setLayout(null);
		welcome.setBounds(150,70,200,60);
		
		container.add(welcome);
		JButton button=new JButton("Login");
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				counter++;
				welcome.setText("count"+counter);
			}
		});
		button.setBounds(100,300,200,50);
		container.add(button);
		setVisible(true);
		
	}
	public static void main(String args[]) { 
	 UserView userview=new UserView();
	 
	}
}