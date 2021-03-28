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

import java.io.*;
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


        //865585638
        File targetFile = new File("D:\\opt\\ideaIU-2020.3.2.win.zip");
        logger.info("目标文件长度：{}", targetFile.length());
        FileInputStream fosTarget = new FileInputStream(targetFile);

        //大于10M的文件需要分次读取
        int blockSize = 10 * 1024 * 1024;

        if (Integer.MAX_VALUE < targetFile.length()) { //超过最大传输大小
            String rsp = "0000100865585638bbbbbbbbbb";
            ByteBuf buf = Unpooled.buffer();
            buf.writeBytes(rsp.getBytes("UTF-8"));
            ctx.writeAndFlush(buf);
        } else {
            String rsp = "0000100865585638aaaaaaaaaa";
            ByteBuf buf = Unpooled.buffer();
            buf.writeBytes(rsp.getBytes("UTF-8"));
            ctx.writeAndFlush(buf);

            int targetFileLen = (int) targetFile.length();
            if (targetFileLen > blockSize) {
                int num = targetFileLen / blockSize;
                int lastSize = targetFileLen % blockSize;

                byte[] block = new byte[blockSize];

                while (num-- > 0) {
                    logger.info("还剩{}块", num);
                    block = readFixLength(fosTarget, blockSize);
                    buf = Unpooled.buffer(blockSize);
                    buf.writeBytes(block);
                    ctx.writeAndFlush(buf);
                }

                if (lastSize > 0) {
                    logger.info("最后一块");

                    byte[] lastBlock = new byte[lastSize];
                    lastBlock = readFixLength(fosTarget, lastSize);
                    buf = Unpooled.buffer(lastSize);
                    buf.writeBytes(lastBlock);
                    ctx.writeAndFlush(buf);
                }


            } else {

                byte[] targetFileBytes = new byte[targetFileLen];
                targetFileBytes = readFixLength(fosTarget, targetFileLen);
                buf = Unpooled.buffer();
                buf.writeBytes(targetFileBytes);
                ctx.writeAndFlush(buf);

            }




        }



    }



    private byte[] readFixLength(InputStream in, int fixLength) throws IOException {
        byte[] result = new byte[fixLength];
        int getLen = 0;
        int retLen = 0;
        while (getLen < fixLength) {
            retLen = in.read(result, getLen, fixLength - getLen);
            if (retLen == -1) {
                break;
            }
            getLen += retLen;
        }

    /*    if (getLen != fixLength) {
            byte[] actualRecivedBytes = new byte[getLen];
            System.arraycopy(result, 0, actualRecivedBytes, 0, getLen);
            return actualRecivedBytes;
        }*/
        return result;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        logger.info("开始读取客户端请求的内容");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        logger.info("与客户端交互完成，断开与客户端的连接");
        ctx.flush();
        ctx.close();
    }


    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        logger.info("第{}此交互,接收客户端指令成功,", num.incrementAndGet());
        ctx.fireChannelReadComplete();
        ctx.flush();
    }

    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        logger.error("与客户端交互发生异常");
        cause.printStackTrace();
        ctx.close();
    }
}

