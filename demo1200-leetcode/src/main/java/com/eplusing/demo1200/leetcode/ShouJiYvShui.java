package com.eplusing.demo1200.leetcode;

public class ShouJiYvShui {

    /***
     *
     *
     * 给定一个非负整数数组，代表柱子的高度，这些柱子代表一个容器，请算出能够容纳水的量
     *
     *
     *
     * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
     * Output: 6
     * Explanation: The above elevation map (black section)
     * is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
     * In this case,
     * 6 units of rain water (blue section) are being trapped.
     *
     * */

    //https://blog.csdn.net/weixin_42018258/article/details/80626637
    public static void main(String[] args) {

        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] height1 = {0, 1, 1, 2, 2, 2, 2, 4, 3, 3, 2, 2};

        ShouJiYvShui main4 = new ShouJiYvShui();

        System.out.println(main4.collectWater(height));
        System.out.println(main4.collectWater(height1));


    }


    /**
     * 收集雨水
     */
    public int collectWater(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        if (height.length == 1) {
            return height[0];
        }

        int result = 0;
        int length = height.length;
        int maxHightIndex = 0;

        //左边
        for (int i = 0; i < length - 1; ) {
            boolean findFlag = false;
            int j = i + 1;
            while (j < length) {
                if (height[j] >= height[i]) {
                    int temp = height[i] * (j - i - 1);
                    result += temp;
                    findFlag = true;
                    break;
                }
                j++;
            }
            if (findFlag && j < length) {
                if (j > i) {
                    for (int k = i + 1; k < j; k++) {
                        result -= height[k];
                    }
                }
                i = j;
            } else if (j < length) {
                i++;
            } else {
                maxHightIndex = i;
                break;
            }
        }

        //右边
        for (int i = length - 1; i > maxHightIndex; ) {
            boolean findFlag = false;
            int j = i - 1;
            while (j > 0) {
                if (height[j] >= height[i]) {
                    result += height[i] * (i - j - 1);
                    findFlag = true;

                    break;
                }
                j--;
            }
            if (findFlag && j > maxHightIndex) {
                if (j < i) {
                    for (int k = i - 1; k > j; k--) {
                        result -= height[k];
                    }
                }
                i = j;
            } else if (j > maxHightIndex) {
                i--;
            } else {
                break;
            }
        }
        return result;
    }
}
