package com.eplusing.prospring5.ch5;

import org.springframework.aop.framework.ProxyFactory;

/**
 * @author eplusing
 * @date 2020/3/21
 */
public class ProfilingDemo {
    public static void main(String[] args) {
        WorkBean bean = getWorkBean();

        bean.doSomeWork(10000);
    }

    private static WorkBean getWorkBean() {
        WorkBean workBean = new WorkBean();
        ProfilingInterceptor profilingInterceptor = new ProfilingInterceptor();
        ProxyFactory factory = new ProxyFactory();

        factory.setTarget(workBean);
        factory.addAdvice(profilingInterceptor);

        WorkBean proxy = (WorkBean) factory.getProxy();

        return proxy;
    }
}
