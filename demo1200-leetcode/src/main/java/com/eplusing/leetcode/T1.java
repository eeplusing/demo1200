package com.eplusing.leetcode;

import java.util.Scanner;

public class T1 {

    /**
     * 作为程序员的小Q，他的数列和其他人的不太一样，他有个数。
     * 老板问了小Q一共 m次，每次给出一个整数, 要求小Q把这些数每分为一组，然后把每组进行翻转，小Q想知道每次操作后整个序列中的逆序对个数是多少呢？
     * <p>
     * 例如:
     * 对于序列1 3 4 2，逆序对有(4, 2),(3, 2),总数量为2。
     * 翻转之后为2 4 3 1，逆序对有(2, 1),(4, 3), (4, 1), (3, 1),总数量为4。
     * <p>
     * 第一行一个数
     * 第二行个数，表示初始的序列()
     * 第三行一个数
     * 第四行m个数表示
     * <p>
     * m行每行一个数表示答案。
     **/
    public static void main(String[] a) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int len = (int) Math.pow(2, n);
        int[] input = new int[len];
        int i = 0;
        while (i < len) {
            input[i++] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] q = new int[m];
        int j = 0;
        while (j < m) {
            q[j++] = sc.nextInt();
        }

        for (int k = 0; k < m; k++) {
            int size = q[m];
            //反转
            for (int x = 0; x < len; x += size) {
                for (int xx = 0; xx < size; xx++) {
                    int temp = input[x + xx];
                    input[x + xx] = input[x + size - 1 - xx];
                    input[x + size - 1 - xx] = temp;
                }
            }

            //求逆序数
            int result = 0;
            for (int y = 0; y < len - 1; y++) {
                for (int yy = y + 1; yy < len; yy++) {
                    if (input[y] > input[yy]) {
                        result++;
                    }
                }
            }

            System.out.println(result);


        }


    }


}
