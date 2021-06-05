package com.eplusing.prospring5.ch3.annotation;

import com.eplusing.prospring5.ch2.decoupled.MessageProvider;
import org.springframework.stereotype.Service;

/**
 * @author eplusing
 * @date 2019/12/29
 */
//@Service("provider")
public class HelloWorldMessageProvider implements MessageProvider {
    @Override
    public String getMessage() {
        return "Hello World!";
    }
}
