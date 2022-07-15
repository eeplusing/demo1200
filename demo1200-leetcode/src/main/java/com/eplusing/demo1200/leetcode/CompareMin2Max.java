package com.eplusing.demo1200.leetcode;

import java.util.*;

public class CompareMin2Max {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        String[] arr = str.split("\\s");

        List<String> lists = new ArrayList<String>();

        for (int i = 0; i < arr.length; i++) {

            lists.add(arr[i]);

        }

        Comparator<String> com = new Comparator<String>() {

            @Override

            public int compare(String o1, String o2) {

                int num1 = getSum(o1);

                int num2 = getSum(o2);

                if (num1 != num2) {

                    return num1 - num2;

                } else {

                    return Integer.valueOf(o1).compareTo(Integer.valueOf(o2));

                }


            }

        };

        Collections.sort(lists, com);

        StringBuffer sb = new StringBuffer();

        for (String item : lists) {

            sb.append(item + " ");

        }

        System.out.println(sb.deleteCharAt(sb.length() - 1));

    }


    private static int getSum(String str) {

        int res = 0;

        char[] arr = str.toCharArray();

        for (int i = 0; i < arr.length; i++) {

            res += Integer.parseInt(String.valueOf(arr[i]));

        }

        return res;

    }

}