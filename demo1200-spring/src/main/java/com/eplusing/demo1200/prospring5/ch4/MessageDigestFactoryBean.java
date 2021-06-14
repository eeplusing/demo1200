package com.eplusing.demo1200.prospring5.ch4;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

import java.security.MessageDigest;

/**
 * @author eplusing
 * @date 2020/2/23
 */
public class MessageDigestFactoryBean implements FactoryBean<MessageDigest>, InitializingBean {


    private String algorithmName = "MD5";
    private MessageDigest messageDigest = null;
    @Override
    public void afterPropertiesSet() throws Exception {
        messageDigest = MessageDigest.getInstance(algorithmName);
    }

    @Override
    public MessageDigest getObject() throws Exception {
        return messageDigest;
    }

    @Override
    public Class<?> getObjectType() {
        return MessageDigest.class;
    }

    @Override
    public boolean isSingleton(){
        return true;
    }

    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }
}
