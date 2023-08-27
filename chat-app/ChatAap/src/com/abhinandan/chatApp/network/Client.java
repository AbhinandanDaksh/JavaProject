package com.abhinandan.chatApp.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.JTextArea;

import com.abhinandan.chatApp.utils.ConfigReader;

public class Client {
	Socket socket;
	 InputStream in;
	 OutputStream out;
	 ClientWorker worker;
	 JTextArea textArea;
	public Client(JTextArea textArea) throws UnknownHostException, IOException {
		int Port=Integer.parseInt(ConfigReader.getValue("PORTNO"));
		socket =new Socket(ConfigReader.getValue("SERVER_IP"),Port);
		out=socket.getOutputStream();
		in= socket.getInputStream();
		this.textArea=textArea;
		readMessage();
//		System.out.println("Client Comes");
//		System.out.println("enter the message send to the server..........");
//		Scanner scanner =new Scanner(System.in);
//		String message = scanner.nextLine();
//		OutputStream out=socket.getOutputStream();
//		out.write(message.getBytes());
//		System.out.println("message sed to the server ");
//		scanner.close();
//		out.close();
//		socket.close();
	}
	public void sendMessage(String message) throws IOException {
		message= message + "\n";
		out.write(message.getBytes());
	}
	public void readMessage() {
		worker=new ClientWorker(in,textArea);
		worker.start();
	}
	 
//	public static void main(String args[]) throws UnknownHostException, IOException {
//		Client client = new Client();
//		
//	}

}
