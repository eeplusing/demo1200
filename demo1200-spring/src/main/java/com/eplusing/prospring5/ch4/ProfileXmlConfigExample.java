package com.eplusing.prospring5.ch4;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

/**
 * @author eplusing
 * @date 2020/3/2
 */
public class ProfileXmlConfigExample {

    //执行方法添加环境变量 --Dspring.profiles.active="kindergarten"
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/*-config.xml");
        ctx.refresh();
        //下面这行不生效
        // ctx.getEnvironment().setActiveProfiles("highshcool");
        System.out.println(ctx.getEnvironment().getActiveProfiles());
        FoodProviderService foodProviderService = ctx.getBean("foodProviderService", FoodProviderService.class);

        List<Food> lunchSet = foodProviderService.provideLunchSet();
        for (Food food : lunchSet) {
            System.out.println("Food:" + food.getName());
        }
/*
        ctx.getEnvironment().setActiveProfiles("highschool");
        foodProviderService = ctx.getBean("foodProviderService", FoodProviderService.class);
        lunchSet = foodProviderService.provideLunchSet();
        for (Food food : lunchSet) {
            System.out.println("Food:" + food.getName());
        }*/
    }

}
