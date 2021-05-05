package com.eplusing.demo1200.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class NettyClientSendHandler extends ChannelOutboundHandlerAdapter {
    private static final Logger logger = LoggerFactory.getLogger(NettyClientSendHandler.class);



    private AtomicInteger num = new AtomicInteger(0);

    @Override
    public void write(ChannelHandlerContext ctx, Object o, ChannelPromise promise) throws Exception {



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
        ctx.writeAndFlush(buf);

        ctx.pipeline().remove(this);
/*
        ChannelFuture f = ctx.writeAndFlush(message);


        ctx.write(msg, promise);*/
    }

    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        logger.error("与服务端交互发生异常");
        ctx.close();
    }
}

