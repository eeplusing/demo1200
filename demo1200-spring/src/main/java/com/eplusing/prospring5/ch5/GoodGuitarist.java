package com.eplusing.prospring5.ch5;

import com.eplusing.prospring5.ch2.common.Singer;

/**
 * @author eplusing
 * @date 2020/3/22
 */
public class GoodGuitarist implements Singer {
    @Override
    public void sing() {
        System.out.println("GoodGuitarist sing");
    }
}
