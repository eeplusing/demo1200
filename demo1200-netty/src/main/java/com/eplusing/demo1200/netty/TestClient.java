package com.eplusing.demo1200.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.example.haproxy.HAProxyHandler;
import io.netty.handler.codec.haproxy.HAProxyCommand;
import io.netty.handler.codec.haproxy.HAProxyMessage;
import io.netty.handler.codec.haproxy.HAProxyProtocolVersion;
import io.netty.handler.codec.haproxy.HAProxyProxiedProtocol;
import io.netty.util.CharsetUtil;

public class TestClient  {
    private static final String HOST = "127.0.0.1";

    public TestClient() {
    }

    public static void main(String[] args) throws Exception {
        NioEventLoopGroup group = new NioEventLoopGroup();

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

    }
}