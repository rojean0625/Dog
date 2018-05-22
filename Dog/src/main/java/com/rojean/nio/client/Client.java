package com.rojean.nio.client;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.Selector;

public class Client {

	public static void main(String[] args) throws Exception {
		
	}
	
	
	
	void a() throws IOException {
		FileInputStream fis = new FileInputStream("f:/a.txt");
		FileChannel channel = fis.getChannel();
		ByteBuffer bb = ByteBuffer.allocate(1024);
		channel.read(bb);
		byte[] bt = bb.array();
		System.out.println(new String(bt));
		
		
		FileOutputStream fos = new FileOutputStream("f:/b.txt");
		FileChannel c = fos.getChannel();
		ByteBuffer b = ByteBuffer.allocate(1024);
		b = ByteBuffer.wrap("OJBK".getBytes());
		c.write(b);
		// ¶àÂ·¸´ÓÃ
		Selector s;
	}
}
