package com.eplusing.demo1200.leetcode.huawei;

import java.util.Scanner;

public class SnakeMatrix {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        int pResult[][] = new int[num][num];

        getResult(num, pResult);

    }


    public static void getResult(int num, int pResult[][]) {

        int start = 1;

        int temp;

        for (int i = 0; i < num; i++) {

            temp = i;

            for (int j = 0; j <= i; ) {

                pResult[temp--][j++] = start++;

            }

        }

        printResult(num, pResult);

    }


    public static void printResult(int num, int pResult[][]) {

        for (int i = 0; i < num; i++) {

            for (int j = 0; j < num - i; j++) {

                System.out.print(j == num - 1 - i ? pResult[i][j] + "\r" : pResult[i][j] + "");

            }

        }

    }

}