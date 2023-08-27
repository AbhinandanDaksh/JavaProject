package com.abhinandan.chatApp.network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import com.abhinandan.chatApp.utils.ConfigReader;
 
public class Server {
	ServerSocket serverSocker ;
	ArrayList<ServerWorker> workers = new ArrayList<>();//contain all the socket
	public Server() throws IOException{
		int Port=Integer.parseInt(ConfigReader.getValue("PORTNO"));
		serverSocker=new ServerSocket(Port);
		System.out.println("Server Stert and wating for the clients to job.......... ");
		handleClientRequest();
		
	}
	//multiple Client Handshaking
	public void handleClientRequest() throws IOException {
		while(true) {
			Socket clientSocket=serverSocker.accept();//handshaking
			//per client per thread 
			ServerWorker serverWorker =new ServerWorker(clientSocket,this);//Creating a new thread
			workers.add(serverWorker);
			serverWorker.start();
			System.out.println("Client connected");
		}
	}
	/* single client
	public Server() throws IOException {
		int Port=Integer.parseInt(ConfigReader.getValue("PORTNO"));
		serverSocker=new ServerSocket(Port);
		System.out.print("Server Started please wait............");
		Socket socket=serverSocker.accept();//handshaking
		System.out.print("Client joins the server");
		InputStream in=socket.getInputStream();//read bytes from the network
		byte arr[]=in.readAllBytes();
		String str=new String(arr);   //bytes convert into string 
		System.out.println("message rec from the client"+str);
		in.close();
		socket.close();
	}
*/
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		new Server();

	}

}
