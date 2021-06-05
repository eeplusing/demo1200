package com.eplusing.prospring5.ch5.introduction;

import org.springframework.aop.support.DefaultIntroductionAdvisor;

/**
 * @author eplusing
 * @date 2020/4/18
 */
public class IsModifiedAdvisor extends DefaultIntroductionAdvisor {
    public IsModifiedAdvisor() {
        super(new IsModifiedMixin());
    }
}
