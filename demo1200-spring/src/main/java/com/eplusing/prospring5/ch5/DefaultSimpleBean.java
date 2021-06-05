package com.eplusing.prospring5.ch5;

/**
 * @author eplusing
 * @date 2020/3/23
 */
public class DefaultSimpleBean implements SimpleBean {
    private long dummy = 0;

    @Override
    public void advised() {
        dummy = System.currentTimeMillis();
    }

    @Override
    public void unadvised() {
        dummy = System.currentTimeMillis();
    }
}
