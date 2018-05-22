package com.rojean.netty.s;

import java.net.InetSocketAddress;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class NettyService {

	public static void main(String[] args) {

		
		NettyService service = new NettyService();
		service.start();
	}
	
	public void start() {
		// 1
		EventLoopGroup group = new NioEventLoopGroup();
		try {
		// 2
		ServerBootstrap bootStrap = new ServerBootstrap();
		bootStrap.group(group)
		.channel(NioServerSocketChannel.class)
		.localAddress(new InetSocketAddress(8765))
		.childHandler(new ServerChannelIni());
		
		System.out.println("服务端已启动  监听：8765");
		ChannelFuture future = bootStrap.bind().sync();
		System.out.println("listenling..");
		
		
		future.channel().closeFuture().sync();
		}catch (Exception e){
			System.out.println("server exception : " + e + e.getMessage());
		}finally {
			group.shutdownGracefully();
			System.out.println("close server");
		}
	}

}
