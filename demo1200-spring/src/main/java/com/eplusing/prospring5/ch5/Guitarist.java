package com.eplusing.prospring5.ch5;


import com.eplusing.prospring5.ch2.common.Singer;

/**
 * @author eplusing
 * @date 2020/3/21
 */
public class Guitarist implements Singer {
    private String lyric = "You're gonna live forver in me";

    @Override
    public void sing() {
        System.out.println(lyric);
    }

    public void sing2() {
        System.out.println("sing2()" + lyric);
    }

    public void rest() {
        System.out.println("rest");
    }
}
