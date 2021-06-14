package com.eplusing.demo1200.prospring5.ch5;

import org.springframework.aop.framework.ProxyFactory;

/**
 * @author eplusing
 * @date 2020/3/21
 */
public class SecurityDemo {
    public static void main(String[] args) {
        SecurityManager mgr = new SecurityManager();

        SecureBean bean = getSecureBean();

        mgr.login("xuanxuan", "pwd");
        bean.writeSecureMessage();
        mgr.logout();

        try {
            mgr.login("invalid user", "pwd");
            bean.writeSecureMessage();
            mgr.logout();
        } catch (SecurityException ex) {
            System.out.println("Exception Caught: " + ex.getMessage());
        }

        try {
            bean.writeSecureMessage();
            mgr.logout();
        } catch (SecurityException ex) {
            System.out.println("Exception Caught: " + ex.getMessage());
        }


    }

    private static SecureBean getSecureBean() {
        SecureBean secureBean = new SecureBean();

        SecurityAdvice securityAdvice = new SecurityAdvice();

        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(secureBean);
        pf.addAdvice(securityAdvice);

        SecureBean proxy = (SecureBean) pf.getProxy();
        return proxy;
    }
}
