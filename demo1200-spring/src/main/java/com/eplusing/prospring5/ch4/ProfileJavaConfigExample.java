package com.eplusing.prospring5.ch4;

import com.eplusing.prospring5.ch4.config.HighschoolConfig;
import com.eplusing.prospring5.ch4.config.KindergartenConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.List;

/**
 * @author eplusing
 * @date 2020/3/2
 */
public class ProfileJavaConfigExample {

    //执行方法添加环境变量 --Dspring.profiles.active="kindergarten"
    public static void main(String[] args) {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(KindergartenConfig.class, HighschoolConfig.class);
        //下面这行不生效
        ctx.getEnvironment().setActiveProfiles("highschool");
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
