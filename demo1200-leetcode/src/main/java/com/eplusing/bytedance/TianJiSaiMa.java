package com.eplusing.bytedance;

import java.util.Arrays;

public class TianJiSaiMa {
    public static void main(String[] args) {
        int[] A = {92, 83, 71};
        int[] B = {95, 87, 74};

        int score = process(A, B);
        System.out.println(score);
    }

    /**
     * 先给两组数据排序。
     * （1）A组最快>B组最快：让他俩比赛，A组积分+1
     * （2）A组最快<B组最快：让A组最慢与B组最快比，积分-1
     * （3）A组最快=B组最快：再分类讨论：
     * （a）A组最慢>B组最慢：他俩比赛,积分+1
     * （b）其他情况：A组最慢与B最快比，
     * （b1）A最慢=B最快：他俩比，积分不变
     * （b2）A最慢<B最快，他俩比，积分-1
     */

    private static int process(int[] A, int[] B) {
        int result = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int len = A.length;
        int aS = 0;
        int aE = len - 1;
        int bS = 0;
        int bE = len - 1;

        while (aS <= aE && bS <= bE) {
            if (A[aE] > B[bE]) {
                result++;
                aE--;
                bE--;
            } else if (A[aE] < B[bE]) {
                result--;
                aS++;
                bE--;
            } else { //最快马都相同
                //A最慢比B最慢
                if (A[aS] < B[bS]) {
                    result++;
                    aS++;
                    bS++;
                } else {
                    //A最慢比B最快
                    if(A[aS] == B[bE]){
                        aS++;
                        bE--;
                    }else{
                        result--;
                        aS++;
                        bE--;
                    }

                }
            }
        }


        return result;
    }

}
