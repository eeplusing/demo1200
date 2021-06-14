package com.eplusing.demo1200.prospring5.ch3.annotation;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @author eplusing
 * @date 2020/1/13
 */
@Service("injectCollection")
public class CollectionInjection {
    @Resource(name="map")
    private Map<String, Object> map;
    @Resource(name="props")
    private Properties props;
    @Resource(name="set")
    private Set set;
    @Resource(name="list")
    private List list;
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-annotation.xml");
        ctx.refresh();

        CollectionInjection instance = (CollectionInjection) ctx.getBean("injectCollection");

        instance.dispalyInfo();

        ctx.close();
    }

    public void dispalyInfo(){
        System.out.println("Map contents:");
        map.entrySet().stream().forEach(e -> System.out.println(
                "Key:" + e.getKey() + "-Value:" + e.getValue()
        ));

        System.out.println("\nProperties contents:");

        props.entrySet().stream().forEach(e -> System.out.println(
                "Key:" + e.getKey() + "-Value:" + e.getValue()
        ));

        System.out.println("\nSet contents:");
        set.forEach(obj -> System.out.println("Value" + obj));

        System.out.println("List contents");
        list.forEach(obj -> System.out.println("Value:" + obj));

    }


}
