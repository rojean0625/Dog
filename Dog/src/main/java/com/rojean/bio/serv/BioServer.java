package com.rojean.bio.serv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class BioServer {

	public static void main(String[] args) throws IOException {
		
		System.out.println("������������");
		ServerSocket serv = new ServerSocket(5555);
		
		
		Socket socket = serv.accept();
		System.out.println("������յ�");
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String v = in.readLine();
		System.out.println("v "+ v);
		while((v = in.readLine()) != null) {
			System.out.println("server:   "+ v);
		}
	}

}
