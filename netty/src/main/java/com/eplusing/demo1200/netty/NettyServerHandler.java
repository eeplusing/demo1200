package com.eplusing.demo1200.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class NettyServerHandler extends SimpleChannelInboundHandler<ByteBuf> {
    private static final Logger logger = LoggerFactory.getLogger(NettyServerHandler.class);

    private AtomicInteger num = new AtomicInteger(0);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf in) throws Exception {

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
        FileOutputStream fos = new FileOutputStream("D:\\opt\\temp-upload.txt");

        fos.write(bizContentBytes);
        fos.flush();
        fos.close();


        String bizContent = new String(bizContentBytes, "UTF-8");
        //logger.info("bizContent：{}", bizContent);

//187986283
        File targetFile = new File("D:\\opt\\jdk-15.0.2_windows-x64_bin.zip");
        logger.info("目标文件长度：{}", targetFile.length());
        FileInputStream fosTarget = new FileInputStream(targetFile);

        byte[] targetFileBytes = new byte[(int) targetFile.length()];
        fosTarget.read(targetFileBytes);

        String rsp = "0000100187986283aaaaaaaaaa";

        ByteBuf buf = Unpooled.buffer();

        buf.writeBytes(rsp.getBytes("UTF-8"));
        buf.writeBytes(targetFileBytes);


        byte b1 = targetFileBytes[(int) (targetFile.length()) - 1];
        byte b2 = targetFileBytes[(int) (targetFile.length()) - 2];
        byte b3 = targetFileBytes[(int) (targetFile.length()) - 3];

        byte b1000 = targetFileBytes[(int) (targetFile.length()) - 1000];
        byte b100000 = targetFileBytes[(int) (targetFile.length()) - 100000];


        logger.info("标识位" + b1  + ","+ b2  + ","+ b3 + "," + b1000  + ","+ b100000);


        b1 = targetFileBytes[0];
        b2 = targetFileBytes[1];
        b3 = targetFileBytes[50];

        logger.info("client标识位" + b1 + "," + b2 + "," + b3 );

        ctx.writeAndFlush(buf);

        //ctx.close();

    }


    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        logger.info("开始读取客户端请求的内容");
        ctx.flush();
    }


    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        logger.info("接收客户端请求内容成功,第{}此交互", num.incrementAndGet());
        ctx.fireChannelReadComplete();
        ctx.flush();
    }

    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        logger.error("与客户端交互发生异常");
        cause.printStackTrace();
        ctx.close();
    }
}

