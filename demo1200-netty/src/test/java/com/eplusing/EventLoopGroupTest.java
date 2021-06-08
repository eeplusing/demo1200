package com.eplusing;

import io.netty.channel.nio.NioEventLoop;
import io.netty.util.NettyRuntime;
import io.netty.util.internal.SystemPropertyUtil;

import java.io.IOException;
import java.net.Socket;

public class EventLoopGroupTest {
    public static void main(String[] args) {
        int bossThreadNum = Math.max(1, SystemPropertyUtil.getInt("io.netty.eventLoopThreads", NettyRuntime.availableProcessors() * 2));
        System.out.println(bossThreadNum);

        try {
            for(int i = 0 ; i < 1000000; i++){
                Socket socket = new Socket("127.0.0.1", 1800);
                socket.getPort();

                socket.close();

                System.out.println("第" + i +"个连接");
            }


            System.out.println(1);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void NioEventLoop_Test() {
        NioEventLoop nioEventLoop;//= new NioEventLoop();
    }
}
