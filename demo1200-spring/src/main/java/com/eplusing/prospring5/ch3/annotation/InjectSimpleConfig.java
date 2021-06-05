package com.eplusing.prospring5.ch3.annotation;

import org.springframework.stereotype.Component;

/**
 * @author eplusing
 * @date 2020/1/7
 */
@Component("injectSimpleConfig")
public class InjectSimpleConfig {
    private String name ="xuanxuan";
    private int age = 5;
    private float height = 1.89f;
    private boolean programmer = false;
    private Long ageInSeconds = 1_241_245_123L;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public boolean isProgrammer() {
        return programmer;
    }

    public void setProgrammer(boolean programmer) {
        this.programmer = programmer;
    }

    public Long getAgeInSeconds() {
        return ageInSeconds;
    }

    public void setAgeInSeconds(Long ageInSeconds) {
        this.ageInSeconds = ageInSeconds;
    }
}
