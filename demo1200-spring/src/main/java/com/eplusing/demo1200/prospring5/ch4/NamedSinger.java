package com.eplusing.demo1200.prospring5.ch4;

import org.springframework.beans.factory.BeanNameAware;

/**
 * @author eplusing
 * @date 2020/2/23
 */
public class NamedSinger implements BeanNameAware {
    private String name;
    @Override
    public void setBeanName(String s) {
        this.name = s;
    }
    public void sing(){
        System.out.println("Singer " + name + "- sing()");
    }

}
