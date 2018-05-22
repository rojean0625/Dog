package com.rojean.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class HelloWorldClientHandler extends ChannelInboundHandlerAdapter{
	 @Override  
     public void channelActive(ChannelHandlerContext ctx) {  
         System.out.println("HelloWorld �ͻ��� Active");  
     }  
   
     @Override  
     public void channelRead(ChannelHandlerContext ctx, Object msg) {  
        System.out.println("HelloWorld �ͻ��� read Message:"+msg);  
     }  
   
   
    @Override  
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {  
        cause.printStackTrace();  
        ctx.close();  
     }  
}
