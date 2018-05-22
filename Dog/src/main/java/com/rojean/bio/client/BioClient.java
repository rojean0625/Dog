package com.rojean.bio.client;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class BioClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		 Socket client = new Socket("127.0.0.1", 5555);
		 System.out.println("客户端启动成功");
		
		 OutputStream out = client.getOutputStream();
	        
	       out.write('c');
	}
}
