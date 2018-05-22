package com.rojean.web.c;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import io.netty.util.ReferenceCountUtil;

public class ClientHandler extends ChannelOutboundHandlerAdapter  {
//	
//	@Override
//	 public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
//	        System.out.println("clietn do write." + msg);
//		    ctx.write("hello i am client.");
//		    ctx.flush();
//		    System.out.println("clietn do flush.");
//	        ReferenceCountUtil.release(msg);
//	        promise.setSuccess();
//	 }
//	
//		@Override  
//	    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {  
//	        try {  
//	            //do something msg  
////	            ByteBuf buf = (ByteBuf)msg;  
////	            byte[] data = new byte[buf.readableBytes()];  
////	            buf.readBytes(data);  
////	            String request = new String(data, "utf-8");  
//	            System.out.println("Client: " + " hello im client");  
//	              
//	            //Thread.sleep(1000);  
//	            ctx.writeAndFlush(Unpooled.copiedBuffer("客户端又来咯~".getBytes()));  
//	        } finally {  
//	            ReferenceCountUtil.release(msg);  
//	        }  
//	    }  
	  
	    @Override  
	    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {  
	        cause.printStackTrace();  
	        ctx.close();  
	    }  
}
