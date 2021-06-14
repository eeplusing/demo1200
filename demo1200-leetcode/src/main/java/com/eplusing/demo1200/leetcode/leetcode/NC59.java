package com.eplusing.demo1200.leetcode.leetcode;

public class NC59 {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 9},
                {8, 1, 3, 4},
                {5, 0, 6, 1},
                {8, 8, 4, 0}
        };

        System.out.println(new NC59().minPathSum(matrix));
    }
/**
 *
 * 给定一个 n * m 的矩阵 a，从左上角开始每次只能向右或者向下走，最后到达右下角的位置，路径上所有的数字累加起来就是路径和，输出所有的路径中最小的路径和。
 *[[1,3,5,9],[8,1,3,4],[5,0,6,1],[8,8,4,0]] 12
 * 1≤n,m≤2000
 * 1≤arri,j≤100
 *
 * */
    /**
     * @param matrix int整型二维数组 the matrix
     * @return int整型
     */
    public int minPathSum(int[][] matrix) {
        // write code here
        int r = matrix.length;
        int c = matrix[0].length;
        int[][] dp = new int[r][c];

        dp[0][0] = matrix[0][0];
        //首列
        for (int i = 1; i < r; i++) {
            dp[i][0] = dp[i - 1][0] + matrix[i][0];
        }

        //首行
        for (int j = 1; j < c; j++) {
            dp[0][j] = dp[0][j - 1] + matrix[0][j];
        }

        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                //状态转移
                int left = dp[i][j - 1];
                int down = dp[i - 1][j];
                int min = left < down ? left : down;
                dp[i][j] = min + matrix[i][j];
            }
        }

        return dp[r-1][c-1];
    }

}
