package com.eplusing.prospring5.ch4;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.GenericApplicationContext;

/**
 * @author eplusing
 * @date 2020/2/23
 */
public class ShutdownHookBean implements ApplicationContextAware {
    private ApplicationContext ctx;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if(ctx instanceof GenericApplicationContext){
            ((GenericApplicationContext)ctx).registerShutdownHook();
        }
    }
}
