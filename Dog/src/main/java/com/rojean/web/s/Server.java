package com.rojean.web.s;

import com.rojean.netty.s.ServerHandler;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class Server {
	public static void main(String[] args) throws Exception {  
        //1 ��һ���߳��� �����ڽ���Client�����ӵ�  
        EventLoopGroup bossGroup = new NioEventLoopGroup();  
        //2 �ڶ����߳��� ������ʵ�ʵ�ҵ���������  
        EventLoopGroup workerGroup = new NioEventLoopGroup();  
          
        //3 ����һ��������Bootstrap�����Ƕ����ǵ�Server����һϵ�е�����  
        ServerBootstrap b = new ServerBootstrap();   
        //�����������߳���������  
        b.group(bossGroup, workerGroup)  
        //��Ҫָ��ʹ��NioServerSocketChannel�������͵�ͨ��  
         .channel(NioServerSocketChannel.class)  
        //һ��Ҫʹ�� childHandler ȥ�󶨾���� �¼�������  
         .childHandler(new ChannelInitializer<SocketChannel>() {  
            @Override  
            protected void initChannel(SocketChannel sc) throws Exception {  
                sc.pipeline().addLast(new ServerHandler()); //ServerHandlerΪ�����Զ�����¼�������  
            }  
        })  
         .option(ChannelOption.SO_SNDBUF, 50*1024)   //���÷��ͻ����С  
         .option(ChannelOption.SO_RCVBUF,50*1024);  //��ָ���ܻ����С  
          
        //��ָ���Ķ˿� ���м���  
        ChannelFuture f = b.bind(8765).sync();   
        System.out.println("�����������");  
        //Thread.sleep(1000000);  
        f.channel().closeFuture().sync();  //û����仰�򲻻��ڴ������ȴ��ͻ��˵����ӣ�����ֱ��ִ�к������  
        
        bossGroup.shutdownGracefully();  
        workerGroup.shutdownGracefully();  
           
    }  
      
}
