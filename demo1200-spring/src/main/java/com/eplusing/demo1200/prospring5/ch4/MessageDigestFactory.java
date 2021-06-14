package com.eplusing.demo1200.prospring5.ch4;

import java.security.MessageDigest;

/**
 * @author eplusing
 * @date 2020/2/23
 */
public class MessageDigestFactory {
    private String algorithmName = "MD5";

    public MessageDigest createInstance() throws Exception{
        return MessageDigest.getInstance(algorithmName);
    }

    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }
}
