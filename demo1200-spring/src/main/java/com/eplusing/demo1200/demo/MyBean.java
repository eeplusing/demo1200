package com.eplusing.demo1200.demo;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Hello world!
 */
//@Component
public class MyBean {
    @Transactional(propagation = Propagation.REQUIRED, value = "dataSourceTransactionManager")
    public void test() {

    }
}
