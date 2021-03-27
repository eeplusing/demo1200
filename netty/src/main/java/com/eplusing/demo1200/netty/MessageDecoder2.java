package com.eplusing.demo1200.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MessageDecoder2 extends ByteToMessageDecoder {

    private static final Logger logger = LoggerFactory.getLogger(MessageDecoder2.class);

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf in, List<Object> out) throws Exception {

        byte[] hsHeadBytes = new byte[16];
        in.readBytes(hsHeadBytes);
        String hsHead = new String(hsHeadBytes, "UTF-8");
        logger.info("握手头协议长度：{}", hsHead);
        int hsBodyLen = Integer.parseInt(hsHead.substring(0,6));
        int bizContentLen = Integer.parseInt(hsHead.substring(6));

        int totalLen = hsBodyLen + bizContentLen;

        logger.info("beforeReset：{}", in.readableBytes());

        in.resetReaderIndex();
        logger.info("afterReset：{}", in.readableBytes());

        if(in.readableBytes() >= totalLen+16){
            channelHandlerContext.pipeline().remove(this);
            return;
        }

    }
}
