package com.eplusing.demo1200.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HeBingQuJian {
    /**
     * 编程题1 合并区间
     * <p>
     * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
     * Output: [[1,6],[8,10],[15,18]]
     * <p>
     * 1 <= intervals.length <= 104
     * intervals[i].length == 2
     * 0 <= starti <= endi <= 104
     * RyanLee
     * class Solution {
     * public int[][] merge(int[][] intervals) {
     * <p>
     * }
     * }
     */


    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};

        int[][] result = new HeBingQuJian().merge(intervals);

        System.out.println("11");
    }

    public int[][] merge(int[][] intervals) {
        //记录所有额原始区间
        List<int[]> list = new ArrayList<>(Arrays.asList(intervals));
        boolean flag = true;
       // while (flag) {
            flag = false;
            //两两比较是否有交叉
            for (int i = 0; i < list.size(); i++) {
                for (int j = i + 1; j < list.size(); ) {
                    if (invalid(list.get(i), list.get(j)) || invalid(list.get(j), list.get(i))) {
                        list.get(i)[0] = Math.min(list.get(i)[0], list.get(j)[0]);
                        list.get(i)[1] = Math.max(list.get(i)[1], list.get(j)[1]);
                        flag = true;
                        list.remove(j);
                    } else {
                        j++;
                    }
                }
            }
       // }
        int[][] res = new int[list.size()][2];
        res = list.toArray(res);
        return res;
    }

    //检查是否重合区间
    private boolean invalid(int[] arr1, int[] arr2) {
        return (arr1[1] >= arr2[0] && arr1[1] <= arr2[1]) ||
                (arr1[0] >= arr2[0] && arr1[0] <= arr2[1]);
    }


}
