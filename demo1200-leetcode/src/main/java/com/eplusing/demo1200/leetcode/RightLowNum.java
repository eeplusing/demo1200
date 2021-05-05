package com.eplusing.demo1200.leetcode;

import java.sql.SQLOutput;
import java.util.Scanner;

public class RightLowNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }
        int[] re = new int[n];
        for(int i = 0; i< n -1; i++){
            for(int j = 1; j < n;j++){
                if(arr[i] > arr[j]){
                    re[i] = re[i] + 1;
                }
            }
        }

        for(int i = 0; i< n ; i++){
            System.out.println(re[i] + " ");
        }



    }
}
