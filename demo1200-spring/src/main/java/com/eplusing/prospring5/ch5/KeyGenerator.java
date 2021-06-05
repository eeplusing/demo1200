package com.eplusing.prospring5.ch5;

import java.util.Random;

/**
 * @author eplusing
 * @date 2020/3/21
 */
public class KeyGenerator {
    protected static final long WEAK_KEY = 0xFFFFFFFF00000000L;
    protected static final long STRONG_KEY = 0xAF394DAEC983849L;
    private Random rand = new Random();

    public long getKey() {
        int x = rand.nextInt(3);
        if (x == 1) {
            return WEAK_KEY;
        }
        return STRONG_KEY;
    }
}
