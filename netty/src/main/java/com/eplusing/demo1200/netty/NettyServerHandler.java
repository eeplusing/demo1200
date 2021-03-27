package com.eplusing.demo1200.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

@Component
@ChannelHandler.Sharable
public class NettyServerHandler extends SimpleChannelInboundHandler<ByteBuf> {
    private static final Logger logger = LoggerFactory.getLogger(NettyServerHandler.class);

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ByteBuf in) throws Exception {
        logger.info("开始读取内容");

        logger.info("可读的数据长度：{}", in.readableBytes());

        byte[] hsHeadBytes = new byte[16];
        in.readBytes(hsHeadBytes);
        String hsHead = new String(hsHeadBytes, "UTF-8");
        logger.info("握手头协议长度：{}", hsHead);

        int hsBodyLen = Integer.parseInt(hsHead.substring(0,6));
        int bizContentLen = Integer.parseInt(hsHead.substring(6));


        byte[] hsBodyBytes = new byte[hsBodyLen];
        in.readBytes(hsBodyBytes);
        String hsBody = new String(hsBodyBytes, "UTF-8");
        logger.info("握手内容长度：{}", hsBody);


        byte[] bizContentBytes = new byte[bizContentLen];
        in.readBytes(bizContentBytes);
        String bizContent = new String(bizContentBytes, "UTF-8");
        logger.info("文件内容：{}", bizContent);

        String rsp = "0000100000000010aaaaaaaaaabbbbbbbbbb";



        channelHandlerContext.writeAndFlush(rsp.getBytes("UTF-8"));





    }


    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.err.printf("Factorial of %,d is: %,d%n");
    }

    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

}

