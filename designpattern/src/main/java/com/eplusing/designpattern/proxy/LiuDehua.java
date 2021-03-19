package com.eplusing.designpattern.proxy;

public class LiuDehua implements Star{
    public String sing(String name) {
        System.out.println("笨小孩");
        return "唱完了";
    }

    public String dance(String dance) {
        System.out.println("套马杆");

        return "跳完了";
    }
}
