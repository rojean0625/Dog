package com.rojean.netty.c;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

public class ClientChannelIni extends ChannelInitializer<SocketChannel> {

	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		System.out.println("��ʼ��Client  iniChannel");
		ch.pipeline().addLast(new ClientHandler());
	}

}
