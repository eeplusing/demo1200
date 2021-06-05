package com.eplusing.prospring5.ch4.config;

import com.eplusing.prospring5.ch4.MessageDigestFactoryBean;
import com.eplusing.prospring5.ch4.MessageDigester;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericApplicationContext;

/**
 * @author eplusing
 * @date 2020/2/23
 */
public class MessageDigesterConfigDemo {
    @Configuration
    static class MessageDigestConfig{
        @Bean
        public MessageDigestFactoryBean shaDigest(){
            MessageDigestFactoryBean factoryOne = new MessageDigestFactoryBean();
            factoryOne.setAlgorithmName("SHA1");
            return factoryOne;
        }

        @Bean
        public MessageDigestFactoryBean defaultDigest(){
            return new MessageDigestFactoryBean();
        }

        @Bean
        MessageDigester digester() throws Exception{
            MessageDigester messageDigester = new MessageDigester();
            messageDigester.setDigest1(shaDigest().getObject());
            messageDigester.setDigest2(defaultDigest().getObject());
            return messageDigester;
        }
    }

    public static void main(String[] args) {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(MessageDigestConfig.class);
        MessageDigester digester = (MessageDigester)ctx.getBean("digester");
        digester.digest("hello world");

        ctx.close();
    }
}
