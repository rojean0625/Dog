package com.rojean.netty.s;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

public class ServerChannelIni extends ChannelInitializer<SocketChannel> {

	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		System.out.println("≥ı ºªØ server iniChannel.");
		ch.pipeline().addLast(new ServerHandler());
	}

}
