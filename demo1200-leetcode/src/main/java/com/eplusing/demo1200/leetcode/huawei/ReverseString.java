package com.eplusing.demo1200.leetcode.huawei;

import java.util.*;

public class ReverseString {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String str = in.nextLine();

        int multi = 1;

        String reverse = new StringBuffer(str).reverse().toString();

        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == '0') {

                multi = 0;

                break;

            }

            multi *= Integer.parseInt(String.valueOf(str.charAt(i)));

        }

        System.out.println(reverse + " " + multi);

    }

}