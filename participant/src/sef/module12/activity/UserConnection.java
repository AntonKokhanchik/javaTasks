package sef.module12.activity;

import java.io.*;
import java.net.Socket;

public class UserConnection implements Runnable {
	
	private String userName;
	private BufferedReader in;
	private PrintWriter out;
	
	public UserConnection(String userName, Socket socket) throws IOException {
		this.userName = userName;
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new PrintWriter(socket.getOutputStream(), true);
	}

	@Override
	public void run() {
		listenClient();
	}
	
	public void listenClient() {
		try {
			ChatRoom.CHAT_ROOM.addUser(this);

			String line="";
			while (true) {
				if ((line = in.readLine()) != null) {
					if (line.equalsIgnoreCase("exit"))
						break;

					ChatRoom.CHAT_ROOM.addMessage(this, line);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			ChatRoom.CHAT_ROOM.removeUser(this);
		}
	}

	public String getUserName() {
		return userName;
	}

	public void sendMessage(String message) {
		out.println(message);
	}
}
