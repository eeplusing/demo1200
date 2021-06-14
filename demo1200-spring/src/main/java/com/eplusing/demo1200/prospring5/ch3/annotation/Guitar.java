package com.eplusing.demo1200.prospring5.ch3.annotation;

import org.springframework.stereotype.Component;

/**
 * @author eplusing
 * @date 2020/2/18
 */
@Component("gopher")
public class Guitar {
    public void sing() {
        System.out.println("annotation rn af af ad");
    }
}
