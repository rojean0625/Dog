package com.rojean.serv;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class HelloWorldServerHandler extends ChannelInboundHandlerAdapter{

	 @Override  
	    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {  
	        System.out.println("服务端读.."+ctx.channel().remoteAddress()+"->Server :"+ msg.toString());  
	        ctx.write("服务端返回"+msg);  
	        ctx.flush();  
	    }  
	      
	    @Override  
	    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {  
	        cause.printStackTrace();  
	        ctx.close();  
	    }  
}
