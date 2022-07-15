package com.eplusing.demo1200.leetcode;

import javax.script.ScriptException;
import java.util.*;

public class Sort {

    public static void main(String[] args) throws ScriptException {

        List<String> listStr = new ArrayList<String>();

        listStr.add("ab");

        listStr.add("aafgdj");

        listStr.add("asghj");

        listStr.add("dcfggj");

        /**参数1.compareTo(参数2)为升序，反之为降序**/

        Collections.sort(listStr, new Comparator< String >() {

            public int compare (String o1, String o2){

                //升序

                return o1.compareTo(o2);

                //降序

                //returno2.compareTo(o1);

            }

        });

        for (String str:
             listStr) {

            System.out.print(str + " ");

        }


        /**2.对数组int[],char[], String[]排序*********************************************/

        String strArr[] ={
            "dasdas", "terdgsg", "hgfh", "ksfsa"
        } ;

        Arrays.sort(strArr);

        for (String str:
             strArr) {

            System.out.print(str + " ");

        }


    }


}