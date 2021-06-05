package com.eplusing.prospring5.ch3.xml;

import com.eplusing.prospring5.ch3.ContentHolder;

/**
 * @author eplusing
 * @date 2020/1/13
 */
public class LyricHolder implements ContentHolder {
    private String value ="you be a dj,I'll be the driver";

    @Override
    public String toString() {
        return "LyricHolder{"  + value + "}";
    }
}
