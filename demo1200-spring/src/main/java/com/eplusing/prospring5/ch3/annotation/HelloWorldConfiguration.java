package com.eplusing.prospring5.ch3.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author eplusing
 * @date 2019/12/31
 */
@ComponentScan(basePackages = {"com.eplusing.prospring5.ch3.annotation"})
@Configuration
public class HelloWorldConfiguration {
}
