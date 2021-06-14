package com.eplusing.demo1200.prospring5.ch5;

import com.eplusing.demo1200.prospring5.ch2.common.Guitar;
import com.eplusing.demo1200.prospring5.ch2.common.Singer;

/**
 * @author eplusing
 * @date 2020/4/19
 */
public class GrammyGuitarist implements Singer {
    @Override
    public void sing() {
        System.out.println("sing:Gravity is working against me\n And gravity wants to bring me down ");

    }

    public void sing(Guitar guitart) {
        System.out.println("play:" + guitart.play());
    }


    public void rest() {
        System.out.println("zzzzz");
    }

    public void talk() {
        System.out.println("talk");
    }
}
