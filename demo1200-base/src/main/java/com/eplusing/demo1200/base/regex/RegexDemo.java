package com.eplusing.demo1200.base.regex;

import java.util.regex.Pattern;

public class RegexDemo {

    public static void main(String[] args) {

        /**各种字符的unicode编码的范围：
         * 汉字：[0x4e00,0x9fa5]（或十进制[19968,40869]）
         * 数字：[0x30,0x39]（或十进制[48, 57]）
         *小写字母：[0x61,0x7a]（或十进制[97, 122]）
         * 大写字母：[0x41,0x5a]（或十进制[65, 90]）

         public static booleanisLetterDigitOrChinese(String str) {

         String regex = "^[a-z0-9A-Z\u4e00-\u9fa5]+$";

         return str.matches(regex);

         }*/

        String str = "10000000000";

        //判断是否包含数字string regex = "(?i)[0-9]";

        boolean b = Pattern.compile("[0-9]").matcher(str).find();


        //判断是否包含小写字母string regex = "(?i)[a-z]";(?i)指不区分大小写

        boolean b1 = Pattern.compile("(?i)[a-z]").matcher(str).find();


        //判断是否包含大写字母string regex = "(?i)[A-Z]";

        boolean b2 = Pattern.compile("(?i)[A-Z]").matcher(str).find();


        //判断是否包含字母数字string regex = "(?i)[\\w]"或regex="[a-zA-Z_0-9]"

        boolean b3 = Pattern.compile("(?i)[\\w]").matcher(str).find();

        boolean b33 = Pattern.compile("(?i)[\\w]").matcher(str).matches();


        //判断是否包含非字母数字string regex = "(?i)[\\W]";

        boolean b4 = Pattern.compile("[\\W]").matcher(str).find();

        System.out.println("b:" + b + ",b1:" + b1 + ":,b2" + b2 + ",b3:" + b3 + ",b4:" + b4);


        // 1

        // 提取符号个数，\w为字母数字下划线

        String specCharSubStr = Pattern.compile("[\\w]").matcher(str).replaceAll("");

        System.out.println(specCharSubStr.length());


        // \d = [0-9]

        //\D = [^0-9]

        //一个词语字符 \w = [a-zA-Z0-9]

        //一个非词语字符 \W = ^[a-zA-z]

        //空白字符 \s = [\t\n\r\f\x0B]

        //非空白字符 \S

        //量词：？：0或1次; *:0或多次; +：1或多次;

        //判断1-10位的整数

        if (!str.matches("^[1-9][0-9]{0,9}")) {

            System.out.println("error");

        }


    }

}