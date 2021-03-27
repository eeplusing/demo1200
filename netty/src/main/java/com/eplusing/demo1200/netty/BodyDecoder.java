package com.eplusing.demo1200.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class BodyDecoder extends ByteToMessageDecoder {
    private static final Logger logger = LoggerFactory.getLogger(BodyDecoder.class);

    /**
     * 获取前16位长度占位值+accessInfo信息+业务数据内容
     * 第一块：0-5共6位，存放accessInfo的长度
     * 第二块：6-15，存放业务数据的长度
     * 第三块：accessInfo信息
     * 第四块：业务数据
     */
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf in, List<Object> out) throws Exception {
        byte[] hsHeadBytes = new byte[16];
        in.readBytes(hsHeadBytes);
        String hsHead = new String(hsHeadBytes, "UTF-8");
        //logger.info("握手头协议长度：{}", hsHead);

        int hsBodyLen = Integer.parseInt(hsHead.substring(0, 6));
        int bizContentLen = Integer.parseInt(hsHead.substring(6));
        int totalLen = hsBodyLen + bizContentLen;
        in.resetReaderIndex();
        if (in.readableBytes() >= totalLen + 16) {
            channelHandlerContext.pipeline().remove(this);
            logger.info("所有请求内容已接收至缓冲ByteBuf，总长度：{}，开始读取所有请求内容", in.readableBytes());
            return;
        }
    }
}
