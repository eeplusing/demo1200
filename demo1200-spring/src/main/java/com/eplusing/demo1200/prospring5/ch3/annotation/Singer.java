package com.eplusing.demo1200.prospring5.ch3.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author eplusing
 * @date 2020/1/5
 */

@Service("singer")
public class Singer {
    @Autowired
    private Inspiration inspirationBean;

    public void sing(){
        System.out.println("..." + inspirationBean.getLyric());
    }
}
