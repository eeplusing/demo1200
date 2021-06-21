package com.eplusing.demo1200.leetcode;


import java.util.ArrayList;
import java.util.List;

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
public class Test {
    public static String[][] templateList = {
            {"A", "B", "C"},
            {"W", "B", "C", "E"},
            {"B", "D", "E"},
    };

    /**
     * A->B->C
     * W->B->C->E
     * B->D-E
     */

    String[] match(List<String[]> inputList) {
        if (inputList == null || inputList.size() == 0) {
            return null;
        }
        int len = inputList.size();
        String[] src = new String[len + 1];
        int j = 0;
        for (int i = 0; i < len; i++) {
            src[j++] = inputList.get(i)[0];
            if(i == len - 1){ src[j++] = inputList.get(i)[1];
            }
        }

        for(int m = 0; m < src.length; m++){

        }

        for(int m = 0; m < len; m++){

        }


        return null;
    }


}


