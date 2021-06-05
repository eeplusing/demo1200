package com.eplusing.prospring5.ch5;

/**
 * @author eplusing
 * @date 2020/3/21
 */
public class SecurityManager {
    private static ThreadLocal<UserInfo> threadLocal = new ThreadLocal<>();

    public void login(String name, String password) {
        threadLocal.set(new UserInfo(name, password));
    }

    public void logout() {
        threadLocal.set(null);
    }

    public UserInfo getLoggedOnUser() {
        return threadLocal.get();
    }
}
