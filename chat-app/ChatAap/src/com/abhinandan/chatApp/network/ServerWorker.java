package com.abhinandan.chatApp.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

//thread == worker
//worker need a job to perform
//for job u give runnable
//once job is created via runnable so write the job logic inside a run function
//Assign the job to a thread 
//public class ServerWorker implements Runnable {
//
//	@Override
//	public void run() {
//		// TODO Auto-generated method stub
////		job to perform
////		logic
//		for( int i=1;i<=5;i++) {
//			System.out.println("run i is"+i+" "+Thread.currentThread());
//		}
//	}
//	public static void main(String[] args) {
//		ServerWorker job = new ServerWorker();
////		Assign the to a thread
//		Thread worker=new Thread(job);
//		worker.start();//internally it call run()
//		for(int j=1;j<=5;j++) {
//			System.out.println("main"+j+" "+Thread.currentThread());
//		}
//	}
//
//}
public class ServerWorker extends Thread{
	private Socket clientSocket;
	private InputStream in;
	private OutputStream out;
	private Server server;
	public ServerWorker(Socket clientSocket,Server server) throws IOException{
		this.server= server;
		this.clientSocket=clientSocket;
		in=clientSocket.getInputStream();//read 
		out=clientSocket.getOutputStream();//write
		System.out.println("new client --- in ServerWorker");
		}
	@Override
	public void run() {
		//read data from the client and broadCast the data to all
		BufferedReader br= new BufferedReader(new InputStreamReader(in));
		String line;
		try {
		while(true){
			
				line=br.readLine();//\n
				System.out.println("message comes........"+line);
				if(line.equalsIgnoreCase("quit")) {
					break;//client chat end 
				}
				//out.write(line.getBytes());//client send
//				Broadcast to all client
				for(ServerWorker serverWorker : server.workers) {
					
					line =line+"\n";
					serverWorker.out.write(line.getBytes());
				}
			} 
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		finally {
			try {
			if(br!=null) {
				br.close();
			}
			if(in!=null) {				
				in.close();
			}
			if(out!=null) {
				out.close();
			}
			if(clientSocket!=null) {
				clientSocket.close();
			}
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}