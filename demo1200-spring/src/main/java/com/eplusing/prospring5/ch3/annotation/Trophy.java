package com.eplusing.prospring5.ch3.annotation;

import org.springframework.core.annotation.AliasFor;

/**
 * @author eplusing
 * @date 2020/2/18
 */
@Award
public @interface Trophy {
    @AliasFor(annotation = Award.class, attribute = "value")
    String name() default "";
}
