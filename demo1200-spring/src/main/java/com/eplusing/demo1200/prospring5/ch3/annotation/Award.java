package com.eplusing.demo1200.prospring5.ch3.annotation;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author eplusing
 * @date 2020/2/18
 */
@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Award {
    @AliasFor("prize")
    String value() default "";

    @AliasFor("value")
    String prize() default "";
}