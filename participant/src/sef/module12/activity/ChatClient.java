package sef.module12.activity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient {

    public static void main(String arg[]) {
        int port = 9999;

        try {
            Socket socket = new Socket(InetAddress.getLocalHost(), port);

            BufferedReader serverIn = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            // editor is listening keyboard and writes to server
            ChatClientEditor editor = new ChatClientEditor(
                    new PrintWriter(socket.getOutputStream(), true));

            Thread thread = new Thread(editor);
            thread.start();

            // reading server
            String line;
            while(true)
                if ((line = serverIn.readLine()) != null) {
                    if (line.equalsIgnoreCase("exit"))
                        break;

                    // print to monitor
                    editor.print(line);
                }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
