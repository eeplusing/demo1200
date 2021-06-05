package com.eplusing.prospring5.ch3.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

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
