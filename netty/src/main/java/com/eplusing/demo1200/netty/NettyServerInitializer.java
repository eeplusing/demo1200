package com.eplusing.demo1200.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.logging.LoggingHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.InetSocketAddress;

@Component
public class NettyServerInitializer extends ChannelInitializer<SocketChannel> {
    private static final Logger logger = LoggerFactory.getLogger(NettyServerInitializer.class);


    @Autowired
    NettyServerHandler nettyServerHandler;
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        InetSocketAddress insocket = ch.remoteAddress();
        String clientIp = insocket.getAddress().getHostAddress();
        logger.info("获取客户端IP：" + clientIp);


        pipeline.addLast("decoder", new MessageDecoder());
        pipeline.addLast("decoder2", new MessageDecoder2());
        pipeline.addLast("encoder", new MessageEncoder());
        pipeline.addLast("handler", nettyServerHandler);
    }
}
