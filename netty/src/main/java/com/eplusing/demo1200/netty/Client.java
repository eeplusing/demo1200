package com.eplusing.demo1200.netty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.Socket;

public class Client {
    private static final Logger logger = LoggerFactory.getLogger(Client.class);

    public static void main(String[] args) throws IOException {
        File srcFile = new File("D:\\opt\\temp.txt");
        FileInputStream fin = new FileInputStream(srcFile);

        byte[] bizContent = new byte[(int) srcFile.length()];
        logger.info("文件大小：" + srcFile.length());
        fin.read(bizContent);

        Socket socket = new Socket("127.0.0.1", 1800);

        InputStream socketIn = socket.getInputStream();
        OutputStream socketOut = socket.getOutputStream();

        String hsBodyReq = "abcdefghij";

        String bizContentLenReq = "0000002830";

        String handshake = "000010" + bizContentLenReq + hsBodyReq;

        socketOut.write(handshake.getBytes("UTF-8"));
        socketOut.flush();

        socketOut.write(bizContent);
        socketOut.flush();

        byte[] hsHeadBytes = new byte[16];
        socketIn.read(hsHeadBytes);
        String hsHead = new String(hsHeadBytes, "UTF-8");
        int hsBodyLen = Integer.parseInt(hsHead.substring(0, 6));
        int bizContentLen = Integer.parseInt(hsHead.substring(6));

        int totalLen = hsBodyLen + bizContentLen;

        logger.info("服务端回复总长度：{}", totalLen);

        byte[] hsBodyBytes = new byte[hsBodyLen];

        hsBodyBytes = readFixLength(socketIn, hsBodyLen);

        String hsBody = new String(hsBodyBytes, "UTF-8");
        //String bizContentRsp = new String(bizContentBytes, "UTF-8");

        logger.info("收到的回复头：{}", hsBody);
        //logger.info("收到的回复文件内容：{}", bizContentRsp);


        byte[] bizContentBytes = null;
        FileOutputStream fos = new FileOutputStream("D:\\opt\\ideaIU-2020.3.2.win-download.zip");

        //大于10M的文件需要分次读取
        int blockSize = 10 * 1024 * 1024;

        if (bizContentLen > blockSize) {

            int num = bizContentLen / blockSize;
            int lastSize = bizContentLen % blockSize;

            byte[] block = new byte[blockSize];

            while (num-- > 0) {
                logger.info("还剩{}块", num);
                block = readFixLength(socketIn, blockSize);
                fos.write(block);
                fos.flush();
            }

            if (lastSize > 0) {
                logger.info("最后一块");

                byte[] lastBlock = new byte[lastSize];
                lastBlock = readFixLength(socketIn, lastSize);
                fos.write(lastBlock);
                fos.flush();
            }


        } else {
            bizContentBytes = new byte[bizContentLen];
            bizContentBytes = readFixLength(socketIn, bizContentLen);
            fos.write(bizContentBytes);
            fos.flush();
        }

        fos.close();

        socketOut.close();
        socketIn.close();
        socket.close();

    }


    private static byte[] readFixLength(InputStream in, int fixLength) throws IOException {
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

}
