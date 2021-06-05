package com.eplusing.prospring5.ch3.annotation.mixed;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author eplusing
 * @date 2019/12/31
 */
@ImportResource(locations = {"classpath:spring/app-context-xml.xml"})
//@Configuration
public class HelloWorldConfiguration {
}
