package sef.module12.activity;

import java.io.*;

public class ChatClientEditor implements Runnable {
	private PrintWriter out;
	
	public ChatClientEditor(PrintWriter out) {
		this.out = out;
	}

	@Override
	public void run() { readKeyboard(); }

	private void readKeyboard(){
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;

		while(true) {
			try {
				line = in.readLine();

				out.println(line);

				if (line.equalsIgnoreCase("exit"))
					break;
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void print(String text){
		System.out.println(text);
	}

}
