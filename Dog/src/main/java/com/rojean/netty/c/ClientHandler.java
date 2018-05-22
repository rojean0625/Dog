package com.rojean.netty.c;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class ClientHandler extends SimpleChannelInboundHandler {

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception{
		 System.out.println("ClientHandler channelActive");
		 ctx.writeAndFlush(Unpooled.copiedBuffer("i am client 666".getBytes()));
	 }
	
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
		System.out.println("客户端收到: channelRead0");
		ByteBuf buf = (ByteBuf) msg;  
        byte[] data = new byte[buf.readableBytes()];  
        buf.readBytes(data);  
        String request = new String(data, "utf-8");  
        System.out.println("Client: " + request); 
	}

	
	
	
//	@Override
//	 public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
//	        System.out.println("clietn do write." + msg);
//	        ctx.writeAndFlush(Unpooled.copiedBuffer("i am client 666".getBytes()));
//		    System.out.println("clietn do flush.");
//	       
		    //ReferenceCountUtil.release(msg);
	        //promise.setSuccess();
	// }
//	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx,Throwable caust) {
		caust.printStackTrace();
		ctx.close();
	}

	
}
