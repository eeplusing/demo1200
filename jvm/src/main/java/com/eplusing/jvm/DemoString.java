package com.eplusing.jvm;

/**
 * @author eplusing
 * @date 2021/1/5
 */
public class DemoString {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    private static void test4() {
        String str1 ="ab";
        String str2 = "abc";
        String str3 = str1 + "c";

        //String对象+使用的是StringBuilder.append方法通过toString()实现的
        //str2与str3指向不同的内部地址
        /**
         * The Java language provides special support for the string
         * concatenation operator (&nbsp;+&nbsp;), and for conversion of
         * other objects to strings. String concatenation is implemented
         * through the {@code StringBuilder}(or {@code StringBuffer})
         * class and its {@code append} method.
         * String conversions are implemented through the method
         * {@code toString}, defined by {@code Object} and
         * inherited by all classes in Java. For additional information on
         * string concatenation and conversion, see Gosling, Joy, and Steele,
         * */
        System.out.println(str2 == str3);
        System.out.println(str2.equals(str3));
    }

    private static void test3() {
        String str1 ="a" + "b" + "c";
        String str2 = "abc";

        //"a" + "b" + "c"拼接后，常量池会创建"abc"字符串常量对象
        //创建str2时会直接指向常量"abc"的地址，所以str1==str2
        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));
    }
    private static void test2() {
        String str1 = new String("abc");
        String str2 = "abc";

        //new String("abc")在堆内存中，是常量池中"abc"的copy副本
        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));
    }

    private static void test1() {


        String str1 = "abc";
        String str2 = "abc";

        //str1、str2指向的常量池中相同的地址
        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));
    }


}
