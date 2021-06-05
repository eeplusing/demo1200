package com.eplusing.prospring5.ch3.xml;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @author eplusing
 * @date 2020/1/13
 */
public class CollectionInjection {
    private Map<String, Object> map;
    private Properties props;
    private Set set;
    private List list;
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-xml.xml");
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

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public void setProps(Properties props) {
        this.props = props;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    public void setList(List list) {
        this.list = list;
    }
}
