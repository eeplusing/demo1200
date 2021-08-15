package com.eplusing.demo1200.leetcode.shopee;

public class JInTrans {
    public static void main(String[] args) {
        int n = 16;
        int temp = 0;
        String result = "";

        while (true) {
            if ((n / 2) == 0) {
                break;
            }
            temp = n / 2;
            result += n % 2;
            n = n / 2;
        }
        result += temp;

        result = new StringBuffer(result).reverse().toString();
        System.out.println(result);

        n = 16;
        System.out.println(Integer.toBinaryString(n));
        System.out.println(Integer.toHexString(n));
        System.out.println(Integer.toOctalString(n));
        System.out.println(Integer.toOctalString(n));

        System.out.println(Integer.parseUnsignedInt("10000", 2));
        System.out.println(Integer.parseUnsignedInt("10000", 3));
        System.out.println(Integer.parseUnsignedInt("10000", 4));
        System.out.println(Integer.parseUnsignedInt("10000", 8));
        System.out.println(Integer.parseUnsignedInt("10000", 16));
    }
}
