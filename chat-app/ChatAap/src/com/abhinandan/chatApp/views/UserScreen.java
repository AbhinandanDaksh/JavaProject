package com.abhinandan.chatApp.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.BindException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.abhinandan.chatApp.DB.UserDb;
import com.abhinandan.chatApp.dto.UserDTO;
import com.abhinandan.chatApp.network.Server;
import com.abhinandan.chatApp.utils.UserInfo;

public class UserScreen  extends JFrame{

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private static Server server;

	/**
	 * Launch the application.
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		new UserScreen();
		try {
		server = new Server();
		}catch(BindException ex) {
//			ex.printStackTrace();
		}finally {
			if(server!=null) {
				return;
			}
		}
		
	}
	UserDb userDb=new UserDb();
	private void doLogin()  {
		String userid=textField.getText();
		char[] password=passwordField.getPassword();
		
		UserDTO userDTO =new UserDTO(userid,password);
		try {
			String message="";
			if(userDb.isLogin(userDTO)) {
				message="Welcome "+userid;
				UserInfo.USER_NAME=userid;
				JOptionPane.showMessageDialog(this,message);
				setVisible(false);
				dispose();
				DeshBoard deshboard=new DeshBoard(message);
				deshboard.setVisible(true);
			}
			else {
				message="Invalid Userid and Password";
				JOptionPane.showMessageDialog(this,message);
			}
//			JOptionPane.showMessageDialog(this,message);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void register() {
		String userid=textField.getText();
		char[] password=passwordField.getPassword();
		UserDTO userDTO =new UserDTO(userid,password);
		try {
		int result =userDb.add(userDTO);
		if(result>0) {
			JOptionPane.showMessageDialog(this,"Regster succcessFully");
			//System.out.println("record add");
		}
		else {
			JOptionPane.showMessageDialog(this,"Regster succcessFully");
			//System.out.println("record add");
		}
		
		}
		catch(ClassNotFoundException|SQLException ex){
			System.out.print("db issue...........");
			ex.printStackTrace();
		}
		catch(Exception ex) {
			System.out.print("some issue...........");
			ex.printStackTrace();

		}
		System.out.print("userid"+userid+"password"+password+" "+password.toString());

	}

	/**
	 * Create the application.
	 */
	public UserScreen() {
		setResizable(false);
		setTitle("Login");
		getContentPane().setBackground(new Color(240, 240, 240));
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login\r\n");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 45));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(182, 67, 182, 83);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(292, 197, 189, 26);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel UserIdlbl = new JLabel("UserId");
		UserIdlbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		UserIdlbl.setBounds(95, 195, 97, 23);
		getContentPane().add(UserIdlbl);
		
		JLabel Passwordlbl = new JLabel("Password");
		Passwordlbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		Passwordlbl.setBounds(95, 258, 108, 26);
		getContentPane().add(Passwordlbl);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(292, 262, 189, 26);
		getContentPane().add(passwordField);
		
		JButton RegBT = new JButton("Register");
		RegBT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				register();
			}
		});
		RegBT.setFont(new Font("Tahoma", Font.BOLD, 16));
		RegBT.setBounds(314, 346, 108, 37);
		getContentPane().add(RegBT);
		
		JButton LoginBT = new JButton("Login \r\n");
		LoginBT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doLogin();
			}
		});
		LoginBT.setFont(new Font("Tahoma", Font.BOLD, 16));
		LoginBT.setBounds(160, 346, 108, 37);
		getContentPane().add(LoginBT);
		setBackground(new Color(255, 255, 255));
		setSize(597, 464);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
