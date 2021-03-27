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

        byte[] hsBodyBytes = new byte[hsBodyLen];
        byte[] bizContentBytes = new byte[bizContentLen];

        socketIn.read(hsBodyBytes);
        socketIn.read(bizContentBytes);

        String hsBody = new String(hsBodyBytes, "UTF-8");
        String bizContentRsp = new String(bizContentBytes, "UTF-8");

        logger.info("收到的回复头：{}",hsBody);
        logger.info("收到的回复文件内容：{}", bizContentRsp);

        FileOutputStream fos = new FileOutputStream("D:\\opt\\jdk-15.0.2_windows-x64_bin_download.zip");

        fos.write(bizContentBytes);
        fos.flush();
        fos.close();

    }
}