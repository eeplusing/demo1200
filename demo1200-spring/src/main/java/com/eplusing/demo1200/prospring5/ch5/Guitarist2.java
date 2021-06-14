package com.eplusing.demo1200.prospring5.ch5;


import com.eplusing.demo1200.prospring5.ch2.common.Singer;

/**
 * @author eplusing
 * @date 2020/3/21
 */
public class Guitarist2 implements Singer {
    private String lyric = "You're gonna live forver in me";

    @AdviceRequired
    @Override
    public void sing() {
        System.out.println(lyric);
    }

    public void sing2() {
        System.out.println("sing2()" + lyric);
    }

    @AdviceRequired
    public void rest() {
        System.out.println("rest");
    }
}
