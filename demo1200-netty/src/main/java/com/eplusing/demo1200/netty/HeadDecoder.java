package com.eplusing.demo1200.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
public class HeadDecoder extends ByteToMessageDecoder {
    private static final Logger logger = LoggerFactory.getLogger(HeadDecoder.class);

    /**
     * 获取前16位长度占位值
     * 16位由两块组成
     * 第一块：0-5共6位，存放accessInfo信息的长度
     * 第二块：6-15，存放业务数据的长度
     * */
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf in, List<Object> out) throws Exception {
        if(in.readableBytes() >= 16){
            logger.info("接收前16位报文头至缓冲区ByteBuf成功");
            channelHandlerContext.pipeline().remove(this);
        }
    }
}
