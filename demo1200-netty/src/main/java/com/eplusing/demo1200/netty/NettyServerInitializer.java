package com.eplusing.demo1200.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class NettyServerInitializer extends ChannelInitializer<SocketChannel> {
    private static final Logger logger = LoggerFactory.getLogger(NettyServerInitializer.class);

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {

        logger.info("收到来自客户端IP={}的请求", ch.remoteAddress().getAddress().getHostAddress());

        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast("headDecoder", new HeadDecoder());
        pipeline.addLast("bodyDecoder", new BodyDecoder());
        //pipeline.addLast("encoder", new MessageEncoder());
        pipeline.addLast("handler", new NettyServerHandler());
        //pipeline.addLast("handler", new NettyServerHandlerPooledByteBuf());
    }
}
