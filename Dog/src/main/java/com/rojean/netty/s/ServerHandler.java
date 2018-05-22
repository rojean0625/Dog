package com.rojean.netty.s;


import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class ServerHandler extends SimpleChannelInboundHandler{
	
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception{
		 System.out.println("ServerHandler channelActive");
	 }
	
	@Override
	public void channelRead0(ChannelHandlerContext ctx,Object msg) throws Exception{
		System.out.println("服务端收到: channelRead0");
		ByteBuf buf = (ByteBuf) msg;  
        byte[] data = new byte[buf.readableBytes()];  
        buf.readBytes(data);  
        String request = new String(data, "utf-8");  
        System.out.println("Server: " + request);  
		
        //写给客户端  
        String response = "i am server ,i get you mess.";  
        ctx.writeAndFlush(Unpooled.copiedBuffer(response.getBytes()));
	}
//	
	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception{
		System.out.println("ServerHandler channelReadComplete");
	}
	
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception{
		cause.printStackTrace();
		ctx.close();
	}
}
