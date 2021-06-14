package com.eplusing.demo1200.prospring5.ch3;

/**
 * @author eplusing
 * @date 2020/2/16
 */
public class ReplacementTarget {
    public String formatMessage(String msg){
        return "<h1>" + msg + "</h1>";
    }

    public String formatMessage(Object msg){
        return "<h1>" + msg + "</h1>";
    }
}
