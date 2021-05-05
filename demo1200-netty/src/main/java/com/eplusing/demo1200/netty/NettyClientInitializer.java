package com.eplusing.demo1200.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NettyClientInitializer extends ChannelInitializer<SocketChannel> {
    private static final Logger logger = LoggerFactory.getLogger(NettyClientInitializer.class);

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        /*pipeline.addLast("sendHandler", new NettyClientSendHandler());*/
        pipeline.addLast("headDecoder", new HeadDecoder());
        pipeline.addLast("bodyDecoder", new BodyDecoder());
        pipeline.addLast("recieveHandler", new NettyClientRecieveHandler());
    }

}

