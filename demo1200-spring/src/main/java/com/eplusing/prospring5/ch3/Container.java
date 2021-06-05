package com.eplusing.prospring5.ch3;

/**
 * @author eplusing
 * @date 2019/12/30
 */
public interface Container {
    Object getDependency(String key);
}
