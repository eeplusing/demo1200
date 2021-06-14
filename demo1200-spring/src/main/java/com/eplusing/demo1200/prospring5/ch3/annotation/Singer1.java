package com.eplusing.demo1200.prospring5.ch3.annotation;

import org.springframework.stereotype.Component;

/**
 * @author eplusing
 * @date 2020/1/5
 */

@Component("JohnMayer")
//@Trophy(name = {"grammy", "platinum disk"})
public class Singer1 {
    private String  lyric="We found a message in a bottle we are drinking";
    public void sing(){
        System.out.println(lyric);
    }
}
