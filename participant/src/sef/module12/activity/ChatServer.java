package sef.module12.activity;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket client = null;
		PrintWriter out = null;
		int port = 9999;
		
		try {
			serverSocket = new ServerSocket(port, 50, InetAddress.getLocalHost());
			
			System.out.println("ServerSocket created at " + serverSocket.getInetAddress().getHostAddress());
			System.out.println("Waiting for connection");
			
			int i = 0;
			while(true){
				client = serverSocket.accept();
				
				System.out.println("Got a connection from " + client.getInetAddress());

				Thread thread = new Thread(new UserConnection("user_" + i++, client));

				thread.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try{
				if(out != null)
					out.close();
				
				if (client != null)
					client.close();
				
				if (serverSocket != null)
					serverSocket.close();
			} catch(IOException ex){
				ex.printStackTrace();
			}
		}
	}
}
