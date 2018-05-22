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
	        //д���ͻ���  
	        String response = "���Ƿ�������Ϣ:888";  
	        //��write��������Բ��ͷ�msg  
	        ctx.writeAndFlush(Unpooled.copiedBuffer(response.getBytes()));//����.addListener(ChannelFutureListener.CLOSE);���ʾд�����ݺ�Ͽ��ͻ��˵�����      
	  
	    }  
	  
	    @Override  
	    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {  
	        cause.printStackTrace();  
	        ctx.close();  
	    }  
	  
	
}