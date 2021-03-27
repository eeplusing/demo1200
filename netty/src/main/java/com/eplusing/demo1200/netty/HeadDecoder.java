package com.eplusing.demo1200.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HeadDecoder extends ByteToMessageDecoder {

    private static final Logger logger = LoggerFactory.getLogger(HeadDecoder.class);

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf in, List<Object> out) throws Exception {
        if(in.readableBytes() >= 16){
            channelHandlerContext.pipeline().remove(this);
        }
    }
}
