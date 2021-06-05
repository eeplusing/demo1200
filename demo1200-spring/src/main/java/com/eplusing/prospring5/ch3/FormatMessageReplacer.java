package com.eplusing.prospring5.ch3;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

/**
 * @author eplusing
 * @date 2020/2/16
 */
public class FormatMessageReplacer implements MethodReplacer {
    @Override
    public Object reimplement(Object o, Method method, Object[] objects) throws Throwable {
        return null;
    }

    private boolean isFormatMessageMethod(Method method){
        if(method.getParameterTypes().length != 1){
            return false;
        }

        if(!"formatMessage".equals(method.getName())){
            return false;
        }

        if(method.getReturnType() != String.class){
            return false;
        }

        if(method.getParameterTypes()[0] != String.class){
            return false;
        }
        return true;
    }
}
