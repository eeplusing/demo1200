package com.eplusing.demo1200.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Async;

@SpringBootApplication
public class App implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(App.class);
    private static final int port = 1800;

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(App.class);
        app.setWebApplicationType(WebApplicationType.NONE);
        app.run(args);
    }

    @Async
    @Override
    public void run(String... args) throws Exception {
        /*
        Netty boss 线程池是处理 accept事件的，不管线程池多大，只会使用一个线程，
        既然只使用一个线程为什么要用线程池呢？主要是异常的情况下，线程die了，可以再创建一个新线程，
        那什么情况下boss线程池可以使用多个线程呢？那就是当ServerBootstrap bind多个端口时。每个端口都有一个线程eventloop accept事件
        */

        //boss线程的个数，绑定几个端口则在线程池中创建几个线程，本地绑定了4各端口
        EventLoopGroup bossGroup = new NioEventLoopGroup(4);

        //worker线程的个数，在一个应用中，如果cpu计算的时间为Tcpu，io操作的时间为Tio，系统的cpu核数为Ncpu，线程个数为Nthread，
        // 那么理论上线程个数满足Nthread = (1+Tio/Tcpu)*Ncpu，应用的性能达到最优
        EventLoopGroup wokerGroup = new NioEventLoopGroup(16);
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup, wokerGroup);
            serverBootstrap.option(ChannelOption.SO_BACKLOG, 500);
            serverBootstrap.option(ChannelOption.SO_TIMEOUT, 30 * 1000);
            serverBootstrap.channel(NioServerSocketChannel.class);
            serverBootstrap.handler(new LoggingHandler(LogLevel.INFO));
            serverBootstrap.childHandler(new NettyServerInitializer());
      /*      serverBootstrap.bind(8080);
            serverBootstrap.bind(8081);
            serverBootstrap.bind(8082);*/
            ChannelFuture channelFuture = serverBootstrap.bind(port).sync();
            channelFuture.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            wokerGroup.shutdownGracefully();
        }
    }
}
