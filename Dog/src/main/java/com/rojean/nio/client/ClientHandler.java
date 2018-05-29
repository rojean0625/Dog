package com.rojean.nio.client;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientHandler {

	
	
	public void doRequest() throws UnknownHostException, IOException {
		Socket socket = new Socket("127.0.0.1",12315);
		OutputStream os = socket.getOutputStream();
		os.write("hello i am rojean client.".getBytes());
		System.out.println("client do request.");
		os.flush();
		os.close();
	}
	
	
	

}
