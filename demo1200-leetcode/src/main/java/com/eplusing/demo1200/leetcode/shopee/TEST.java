package com.eplusing.demo1200.leetcode.shopee;

import java.util.Arrays;
import java.util.Scanner;

public class TEST {
    /**
     * hopee正在举办算法比赛。比赛有 n 个人参加（其中 n 为2的幂），
     * 每个参赛者根据资格赛和预赛、复赛的成绩，会有不同的积分。
     * 比赛采取锦标赛赛制，分轮次进行，设某一轮有 m 个人参加，
     * 那么参赛者会被分为 m/2 组，每组恰好 2 人，m/2 组的人分别厮杀。
     * 我们假定积分高的人肯定获胜，若积分一样，则随机产生获胜者。
     * 获胜者获得参加下一轮的资格，输的人被淘汰。
     * 重复这个过程，直至决出冠军。现在请问，参赛者小王最多可以活到第几轮（初始为第0轮）？
     * 输入描述:
     * <p>
     * 第一行一个整数 n (1≤n≤ 2^20)，表示参加比赛的总人数。
     * <p>
     * 接下来 n 个数字（数字范围：-1000000…1000000），表示每个参赛者的积分。
     * <p>
     * 小王是第一个参赛者。
     * <p>
     * 示例输入如下：
     * 4
     * <p>
     * 4 1 2 3
     * <p>
     * 示例输出如下：
     * <p>
     * 2
     */


    public static void main(String[] args) {
        /*读入数据*/
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }
        int xwScore = scores[0];

        /*计算比分数不高于小王的人数*/
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (xwScore >= scores[i]) {
                count++;
            }
        }

        //小王分数最低0轮都活不过
        if (count == 0) {
            System.out.println(0);
            return;
        }

        //加上小王自身
        count++;
        int turnNum = (int) (Math.log(count) / Math.log(2));
        System.out.println((int)Math.pow((double) count, 1.0/2.0));
        System.out.println(turnNum);
    }


    public boolean process(int[] sucess, int xw) {
        boolean result = false;
        int len = sucess.length;
        int[] tempSuccess = new int[len / 2];
        for (int j = 0; j < len; j++) {
            if (sucess[j] <= xw) {
                result = true;
            }
        }

        return result;
    }


}
