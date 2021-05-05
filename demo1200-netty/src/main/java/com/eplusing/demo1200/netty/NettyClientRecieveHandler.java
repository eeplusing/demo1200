package com.eplusing.demo1200.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class NettyClientRecieveHandler extends SimpleChannelInboundHandler<ByteBuf> {
    private static final Logger logger = LoggerFactory.getLogger(NettyClientRecieveHandler.class);

    private AtomicInteger num = new AtomicInteger(0);
    @Override
    public void channelRead0(ChannelHandlerContext ctx, ByteBuf in) throws Exception {


        logger.info("可读的数据长度：{}", in.readableBytes());

        byte[] hsHeadBytes = new byte[16];
        in.readBytes(hsHeadBytes);
        String hsHead = new String(hsHeadBytes, "UTF-8");
        logger.info("请求头：{}", hsHead);

        int hsBodyLen = Integer.parseInt(hsHead.substring(0, 6));
        int bizContentLen = Integer.parseInt(hsHead.substring(6));

        byte[] hsBodyBytes = new byte[hsBodyLen];
        in.readBytes(hsBodyBytes);
        String hsBody = new String(hsBodyBytes, "UTF-8");
        logger.info("accessInfo内容：{}", hsBody);

        byte[] bizContentBytes = new byte[bizContentLen];
        in.readBytes(bizContentBytes);

        ctx.close();

    }


    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        logger.info("开始发送客户端请求");

    }


    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        logger.info("接收服务端返回内容成功,第{}此交互", num.incrementAndGet());
        ctx.fireChannelReadComplete();
    }

    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        logger.error("与服务端交互发生异常");
        ctx.close();
    }
}

