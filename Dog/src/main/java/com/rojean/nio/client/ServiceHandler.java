package com.rojean.nio.client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class ServiceHandler {

	private Selector selector;
	
	public void doListenling() throws IOException {
		
		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		System.out.println("ServiceHandler Listening... 12315");
		serverSocketChannel.configureBlocking(false);
		
		ServerSocket socket = serverSocketChannel.socket();
		socket.bind(new InetSocketAddress(12315));
		
		selector = Selector.open();
		serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

		while(true) {
			int i = selector.select();
			if(i == 0) {
				continue;
			}
			
			
			Iterator<SelectionKey> it = selector.selectedKeys().iterator();
			while(it.hasNext()) {
				SelectionKey selectionKey = it.next();
				it.remove();
				if(selectionKey.isAcceptable()) {
					doAccept(selectionKey);
				}else if(selectionKey.isReadable()) {
					doRead(selectionKey);
				}else if(selectionKey.isWritable()) {
					System.out.println("selectionKey.isWritable()");
				}
			}
		}
	}
	
	private void doAccept(SelectionKey sk) throws IOException {
		ServerSocketChannel channel = (ServerSocketChannel )sk.channel();
		SocketChannel socketChannel = channel.accept();
		socketChannel.configureBlocking(false);
		SelectionKey key = socketChannel.register(selector,SelectionKey.OP_READ);
		System.out.println("doAccept.");
	}
	
	private void doRead(SelectionKey key) {
		System.out.println("doRead");
		SocketChannel socketChannel = (SocketChannel)key.channel();
		ByteBuffer bb = ByteBuffer.allocate(8192);
		int len;
		try {
			len = socketChannel.read(bb);
			if(len < 0) {
				//disconnect(key);
				return;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		bb.flip();
		System.out.println(bb.toString());
		key.cancel();
	}
	
	private void disconnect(SelectionKey key) {
		key.cancel();
	}
}
