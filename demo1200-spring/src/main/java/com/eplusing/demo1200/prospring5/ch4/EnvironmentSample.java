package com.eplusing.demo1200.prospring5.ch4;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;

import java.util.HashMap;
import java.util.Map;

/**
 * @author eplusing
 * @date 2020/3/2
 */
public class EnvironmentSample {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();

        ctx.refresh();

        ConfigurableEnvironment env = ctx.getEnvironment();
        MutablePropertySources propertySources = env.getPropertySources();

        Map<String, Object> appMap = new HashMap<>();
        appMap.put("user.home", "application_home");
        //propertySources.addLast(new MapPropertySource("prospring5 MAP", appMap));
        propertySources.addFirst(new MapPropertySource("prospring5 MAP", appMap));

        System.out.println("系统属性：");
        System.out.println("user.home:" + System.getProperty("user.home"));
        System.out.println("JAVA_HOME:" + System.getProperty("JAVA_HOME"));

        System.out.println("环境变量属性：");
        System.out.println("user.home:" + env.getProperty("user.home"));
        System.out.println("JAVA_HOME:" + env.getProperty("JAVA_HOME"));
    }
}
