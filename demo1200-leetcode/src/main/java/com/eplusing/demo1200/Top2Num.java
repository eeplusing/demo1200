package com.eplusing.demo1200;

public class Top2Num {
    public static void main(String[] args) {
        int[] arr = {12, 3, 5, 3, 5, 67, 7, 2, 7, 99};

        String findResult = findTop2Num(arr);
        System.out.println(findResult);

    }

    private static String findTop2Num(int[] arr) {
        if (arr.length < 2) {
            return null;
        }

        int top1 = arr[0];
        int top2 = arr[1];

        if (top1 < top2) {
            int temp = top1;
            top1 = top2;
            top2 = temp;
        }

        for (int i = 2; i < arr.length; i++) {
            if (arr[i] <= top2) {
                continue;
            }

            if (arr[i] < top1) {
                top2 = arr[i];
                continue;
            }

            if (arr[i] > top1) {
                top2 = top1;
                top1 = arr[i];
            }

        }

        return top1 + "," + top2;


    }
}
