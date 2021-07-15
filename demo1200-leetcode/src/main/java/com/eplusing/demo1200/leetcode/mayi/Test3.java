package com.eplusing.demo1200.leetcode.mayi;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/****
 *
 * 1.
 * 有以下数据流动模版，每一个节点有名称，例如A,B,C等，其中的箭头表示一次实际数据的变化，
 *
 * A->B->C
 * W->B->C->E
 * B->D-E
 *
 * 现实有很多实际数据产生，按照模版进行运行，我们有一个采集器，每次都能采集到这样的
 * 片段数据：
 * 第一组：
 * {经过节点A，方向是from}
 * {经过节点B，方向是to}
 *
 * 第二组：
 * {经过节点B，方向是from}
 * {经过节点C，方向是to}
 *
 * 希望你根据这些输入集合，输出最大匹配度的数据流动模版
 * A->B->C
 * */
public class Test3 {
    public static void main(String[] args) {
        List<String> input = new ArrayList<>();
        input.add("A->B");
        input.add("B->C");
        System.out.println(match(input));
    }


    /**
     * A->B->C
     * W->B->C->E
     * B->D-E
     */

    static String match(List<String> input) {
        //TODO 将输入中的重复节点去除
        String pattern = "";

        for (int j = 0; j < input.size(); j++) {
            String str1 = input.get(j).split("->")[0];
            String str2 = input.get(j).split("->")[1];
            pattern += str1;
            if (j == input.size() - 1) {
                pattern += str2;
            }
        }


        List<String> templateList = new ArrayList<>();
        templateList.add("ABC");
        templateList.add("WBCE");
        templateList.add("BDE");

        int index = 0;
        for (int i = 0; i < templateList.size(); i++) {
            pattern = pattern + "*";
            boolean isMatch = Pattern.matches(pattern, templateList.get(i));
            if (isMatch) {
                index = i;
                break;
            }
        }

        return templateList.get(index);
    }


}


