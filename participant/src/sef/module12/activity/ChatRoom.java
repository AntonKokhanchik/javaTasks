package sef.module12.activity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ChatRoom {
	
	public static final ChatRoom CHAT_ROOM = new ChatRoom();
	
	private List<UserConnection> connectedUsers;
	
	private List<String> chatHistory;
	
	private ChatRoom() {
		connectedUsers = new ArrayList<>();
		chatHistory = new LinkedList<>();
	}
	
	public void addUser(UserConnection userConnection) {
		connectedUsers.add(userConnection);

		sendToAll("User " + userConnection.getUserName() + " connected");
	}

	public void removeUser(UserConnection userConnection){
		connectedUsers.remove(userConnection);

		sendToAll("User " + userConnection.getUserName() + " disconnected");
	}
	
	public void addMessage(UserConnection userConnection, String message) {
		if (!connectedUsers.contains(userConnection))
			addUser(userConnection);

		sendToAll(userConnection.getUserName() + ": " + message);
	}

	private void sendToAll(String message){
		chatHistory.add(message);
		System.out.println(message);
		for (UserConnection user : connectedUsers)
			user.sendMessage(message);
	}


}
