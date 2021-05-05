package com.eplusing.demo1200.designpattern.proxy.jdkproxy;

/**
 * JDK��̬���������Ҳ����Щ����һ�仰��
 * ��̬�������Ҫ����һ����װ��������ڴ���Ķ����Ƕ�̬�ģ����Խж�̬����
 * ����������Ҫ��ǿ�������ǿ����Ҫ����������Ա��������ģ���˴����಻��ֱ�Ӱ������������
 * ����һ��InvocationHandler����InvocationHandler�������������
 * ������ַ��������������󣬷ַ�ǰ�����������ǿ����ԭ����Կ�����JDK��̬�����ǡ����󡱵Ĵ���
 *
 * **/


public class JdkProxyTest {
    public static void main(String[] args) {
        LiuDehua liuDehua = new LiuDehua();

        System.out.println(liuDehua.dance(""));
        System.out.println(liuDehua.sing(""));

        StarProxy startProxy = new StarProxy();
        startProxy.setTarget(liuDehua);

        Object liudeihuaProxy = startProxy.createProxyObject();

        Star star = (Star) liudeihuaProxy;
        System.out.println(star.sing(""));
        System.out.println(star.dance(""));


    }
}
