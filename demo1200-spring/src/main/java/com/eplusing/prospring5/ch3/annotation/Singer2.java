package com.eplusing.prospring5.ch3.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author eplusing
 * @date 2020/1/5
 */

@Component("nonSingleton")
@Scope("prototype")
public class Singer2 {
    private String  name="unknown";
    public Singer2(@Value("John Mayer") String name){
        this.name =name;
    }

    @Override
    public String toString() {
        return name;
    }
}
