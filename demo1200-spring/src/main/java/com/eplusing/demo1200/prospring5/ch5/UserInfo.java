package com.eplusing.demo1200.prospring5.ch5;

/**
 * @author eplusing
 * @date 2020/3/21
 */
public class UserInfo {
    private String userName;
    private String password;

    public UserInfo(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
