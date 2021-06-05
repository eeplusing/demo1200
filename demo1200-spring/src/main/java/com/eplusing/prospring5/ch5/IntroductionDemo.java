package com.eplusing.prospring5.ch5;

import com.eplusing.prospring5.ch2.common.Contact;
import com.eplusing.prospring5.ch5.introduction.IsModified;
import com.eplusing.prospring5.ch5.introduction.IsModifiedAdvisor;
import org.springframework.aop.IntroductionAdvisor;
import org.springframework.aop.framework.ProxyFactory;

/**
 * @author eplusing
 * @date 2020/4/18
 */
public class IntroductionDemo {
    public static void main(String[] args) {
        Contact target = new Contact();
        target.setName("eplusing");
        target.setEmail("eplusing@qq.com");
        target.setPhoneNo("0755");

        IntroductionAdvisor advisor = new IsModifiedAdvisor();
        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(target);
        pf.addAdvisor(advisor);
        //强制使用CGLIB代理
        pf.setOptimize(true);
        Contact proxy = (Contact) pf.getProxy();
        IsModified proxyInterface = (IsModified) proxy;

        System.out.println("Is Contact ?:" + (proxy instanceof Contact));
        System.out.println("Is IsModified ?:" + (proxy instanceof IsModified));
        System.out.println("Has been modified ?:" + (proxyInterface.isModified()));

        proxy.setEmail("nplusing@qq.com");
        System.out.println("Has been modified ?:" + (proxyInterface.isModified()));
        proxy.setEmail("eplusing@qq.com");
        System.out.println("Has been modified ?:" + (proxyInterface.isModified()));


    }
}
