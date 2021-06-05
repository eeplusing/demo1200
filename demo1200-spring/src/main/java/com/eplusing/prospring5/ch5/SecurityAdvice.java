package com.eplusing.prospring5.ch5;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author eplusing
 * @date 2020/3/21
 */
public class SecurityAdvice implements MethodBeforeAdvice {
    private SecurityManager securityManager;

    public SecurityAdvice() {
        this.securityManager = new SecurityManager();
    }

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        UserInfo user = securityManager.getLoggedOnUser();
        if (user == null) {
            System.out.println("No user authenticated");
            throw new SecurityException("you must login before attemping to invoke the method: "
                    + method.getName());
        } else if ("xuanxuan".equals(user.getUserName())) {
            System.out.println("Logged in user is  xuanxuan - OKAY");
        } else {
            System.out.println("Logged in user is " + user.getUserName() +
                    " is not allowd access to method " + method.getName());
        }
    }
}
