package com.rojean.web.s;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class ServerHandle  extends ChannelInboundHandlerAdapter{
	 @Override  
	    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {  
	      
	        ByteBuf buf = (ByteBuf) msg;  
	        byte[] data = new byte[buf.readableBytes()];  
	        buf.readBytes(data);  
	        String request = new String(data, "utf-8");  
	        System.out.println("Server: " + request);  
	        //写给客户端  
	        String response = "我是反馈的信息:888";  
	        //有write操作则可以不释放msg  
	        ctx.writeAndFlush(Unpooled.copiedBuffer(response.getBytes()));//加上.addListener(ChannelFutureListener.CLOSE);则表示写回数据后断开客户端的链接      
	  
	    }  
	  
	    @Override  
	    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {  
	        cause.printStackTrace();  
	        ctx.close();  
	    }  
	  
	
}
