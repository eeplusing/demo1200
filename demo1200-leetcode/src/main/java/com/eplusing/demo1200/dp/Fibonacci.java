package com.eplusing.demo1200.dp;

public class Fibonacci {

    public static void main(String[] args) {
        int[] dp = new int[30001];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < 3000; i++) {
            dp[i] = dp[i - 1] + dp[i-2];
        }

        System.out.println(dp[2000]);
        System.out.println(new Fibonacci().exchangeCoins(2000));
    }


    public int exchangeCoins(int n) {
        //n小于3的情况直接写死
        if (n <= 3) {
            return n;
        }
        //n大于等于4时，按照上述的思路构建数组，为了简化计算，将数组的前4列直接初始化。
        int[][] data = new int[4][n + 1];
        data[1][3] = 1;
        data[2][2] = 1;
        data[2][3] = 1;
        data[3][1] = 1;
        data[3][2] = 2;
        data[3][3] = 3;
        //以列为顺序，按照上述公式遍历
        for (int j = 4; j < n + 1; j++) {
            data[1][j] = data[1][j - 3];
            data[2][j] = data[2][j - 2] + data[1][j - 3];
            data[3][j] = data[3][j - 1] + data[2][j - 2] + data[1][j - 3];
        }
        return data[3][n];
    }

}
