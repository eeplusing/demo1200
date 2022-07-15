package com.eplusing.demo1200.leetcode;

import java.util.*;


public class DeleteMinTimesChar {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String str = in.nextLine();


        String result = handle(str);

        System.out.print(result);

        in.close();

    }


    private static String handle(String str) {

        char[] lists = str.toCharArray();

        TreeSet set = new TreeSet();


        for (int i = 0; i < lists.length; i++) {

            set.add(lists[i]);

        }

        Arrays.sort(lists);

        StringBuffer sb = new StringBuffer(str);

        int mintimes = str.length();

        String minStr = str;

        ArrayList<String> minList = new ArrayList<String>();

        Iterator its = set.iterator();

        while (its.hasNext()) {

            String next = String.valueOf(its.next());

            int start = sb.indexOf(next);

            int end = sb.lastIndexOf(next);

            int temp = end - start + 1;


            if (temp < mintimes) {

                mintimes = temp;

                minStr = next;

                minList.add(next);

            } else if (temp == mintimes) {

                minList.add(next);

            }

        }


        int index = 0;

        for (int i = 0; i < minList.size(); i++) {

            if (minStr.equals(minList.get(i)))

                index = i;

            break;

        }

        for (int i = index; i < minList.size(); i++) {

            str = str.replace(minList.get(i), "");

        }

        return str;

    }


}