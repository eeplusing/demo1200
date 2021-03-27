package com.eplusing.demo1200.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;

public final class NettyClient {
    private static final Logger logger = LoggerFactory.getLogger(NettyClient.class);

    static final String HOST = System.getProperty("host", "127.0.0.1");
    static final int PORT = Integer.parseInt(System.getProperty("port", "1800"));

    public NettyClient() {

    }

    public static void main(String[] args) throws Exception {
        NioEventLoopGroup group = new NioEventLoopGroup();


/*
        try {
            Bootstrap b = new Bootstrap();
            ((Bootstrap)((Bootstrap)b.group(group)).channel(NioSocketChannel.class)).handler(new HAProxyHandler());
            Channel ch = b.connect(HOST, 1800).sync().channel();
            HAProxyMessage message = new HAProxyMessage(HAProxyProtocolVersion.V2, HAProxyCommand.PROXY, HAProxyProxiedProtocol.TCP4, "127.0.0.1", "127.0.0.2", 8000, 9000);
            ch.writeAndFlush(message).sync();
            ch.writeAndFlush(Unpooled.copiedBuffer("Hello World!", CharsetUtil.US_ASCII)).sync();
            ch.writeAndFlush(Unpooled.copiedBuffer("Bye now!", CharsetUtil.US_ASCII)).sync();
            ch.close().sync();
        } finally {
            group.shutdownGracefully();
        }

*/


        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
            bootstrap.group(group);
            bootstrap.channel(NioSocketChannel.class);
            bootstrap.handler(new NettyClientInitializer());
            ChannelFuture channelFuture = bootstrap.connect(HOST, PORT).sync();



            File srcFile = new File("D:\\opt\\temp.txt");
            FileInputStream fin = new FileInputStream(srcFile);

            byte[] bizContent = new byte[(int) srcFile.length()];
            logger.info("文件大小：" + srcFile.length());
            fin.read(bizContent);

            String hsBodyReq = "abcdefghij";

            String bizContentLenReq = "0000002830";

            String handshake = "000010" + bizContentLenReq + hsBodyReq;

            ByteBuf buf = Unpooled.buffer();

            buf.writeBytes(handshake.getBytes("UTF-8"));
            buf.writeBytes(bizContent);

            channelFuture.channel().writeAndFlush(buf);




            // Channel channel = bootstrap.connect(HOST, PORT).sync().channel();

            // channel.close().sync();


          /*  ByteBuf buf = Unpooled.buffer();

            ChannelHandlerContext ctx = future*/

            //future.channel().closeFuture().sync();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }

    }
}
