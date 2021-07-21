package com.eplusing.demo1200.base;

import com.sun.org.apache.xpath.internal.operations.String;

public class StringStringBuferStringBuilder {
    public String str;
    public StringBuffer sb;
    public StringBuilder sbd;

    /***
     *
     * 三个类都是final类，都不允许被继承
     * String: string1+string2编译器自动声明一个StringBuider类，然后依次append(str).append(",").append("word")最后toString 给result；
     * StringBuffer是线程安全，可以不需要额外的同步用于多线程中;append空间不足时扩容按2*倍+2，append通过同步方法保证线程安全。
     * StringBuilder是非同步,运行于多线程中就需要使用着单独同步处理，但是速度就比StringBuffer快多了;
     *
     * */


    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();

        sb.append("a");
        sb.toString();
    }
}
