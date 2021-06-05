package com.eplusing.prospring5.ch5;

import com.eplusing.prospring5.ch2.common.Guitar;
import com.eplusing.prospring5.ch2.common.Singer;

/**
 * @author eplusing
 * @date 2020/3/22
 */
public class GammyGuitarist implements Singer {
    @Override
    public void sing() {
        System.out.println("GammyGuitarist");
    }

    public void sing(Guitar guitar) {
        System.out.println("Play: " + guitar.play());
    }

    public void rest() {
        System.out.println("rest");
    }

    public void talk() {
        System.out.println("talk");
    }
}
