package com.eplusing;

import java.util.Arrays;
import java.util.Collections;

public class NC140 {
    public static void main(String[] args) {
        int[] arr = {5, 2, 3, 1, 4};

        //new NC140().bubbleSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");

        }
        System.out.println();

        new NC140().insertSort(arr);

        //new NC140().selectSort(arr);

        //快速排序
        //Arrays.sort(arr);


        //Collections.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }

    }


    //插入
    public int[] insertSort(int[] arr) {
        int len = arr.length;

        int i = 0;
        int j = 0;
        for (i = 1; i < len; i++) {
            int temp = arr[i];
            for (j = i - 1; j >= 0; j--) {
                if (arr[j] > temp) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }

            arr[j + 1] = temp;
        }

        return arr;

    }


    //选择
    public int[] selectSort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int minIndex = i;
            //找到最小的数
            for (int j = i + 1; j < len; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }

        return arr;

    }

    //冒泡
    public int[] bubbleSort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        return arr;

    }


}
