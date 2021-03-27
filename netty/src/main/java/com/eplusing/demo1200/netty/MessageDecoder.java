package com.eplusing.demo1200.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MessageDecoder extends ByteToMessageDecoder {

    private static final Logger logger = LoggerFactory.getLogger(MessageDecoder.class);

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf in, List<Object> out) throws Exception {

        if(in.readableBytes() >= 16){
            byte[] hsHeadBytes = new byte[16];
            in.readBytes(hsHeadBytes);
            in.markReaderIndex();

            String hsHead = new String(hsHeadBytes, "UTF-8");
            out.add(hsHead);

        }



       /* int hsBodyLen = Integer.parseInt(hsHead.substring(0,6));

        int bizContentLen = Integer.parseInt(hsHead.substring(6));
*/

       /* int totalLen = hsBodyLen + bizContentLen;

        if(in.readableBytes() < totalLen){
            in.resetReaderIndex();
        }else{
            byte[] hsBodyBytes = new byte[hsBodyLen];
            byte[] bizContentBytes = new byte[bizContentLen];

            in.readBytes(hsBodyBytes);
            in.readBytes(bizContentBytes);

            String hsBody = new String(hsBodyBytes, "UTF-8");
            String bizContent = new String(bizContentBytes, "UTF-8");

            logger.info(hsBody);
            logger.info(bizContent);


        }*/

    }
}
