package com.rojean.netty.c;

import java.net.InetSocketAddress;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class NettyClient {

	public static void main(String[] args) {
		NettyClient client = new NettyClient();
		client.start();
	}

	
	public void start() {
		//1
				EventLoopGroup group = new NioEventLoopGroup();
				
				try {
					Bootstrap bootStrap = new Bootstrap();
					bootStrap.group(group)
					  .channel(NioSocketChannel.class)
					  .remoteAddress(new InetSocketAddress("127.0.0.1", 8765))
					  .handler(new ClientChannelIni());
					
					System.out.println("客户端已启动  目标：12151");
					ChannelFuture future = bootStrap.connect().sync();
					System.out.println("connection success");
					//future.channel().writeAndFlush(Unpooled.copiedBuffer("i am client 666".getBytes()));
					future.channel().closeFuture().sync();
				}catch(Exception e) {
					System.out.println("client exception : " + e + e.getMessage());
				}finally {
					group.shutdownGracefully();
					System.out.println("close client");
				}
	}
}
