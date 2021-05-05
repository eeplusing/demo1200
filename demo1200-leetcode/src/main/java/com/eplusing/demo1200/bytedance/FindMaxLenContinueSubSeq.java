package com.eplusing.demo1200.bytedance;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

public class FindMaxLenContinueSubSeq {
    public static void main(String[] args) {
        int[] arr = {1, 3, 6, 7, 8, 4, 3, 5};

        System.out.println(findMaxSubSeqlen(arr));

        AtomicLong a = new AtomicLong();
        a.incrementAndGet();
    }

    private static int findMaxSubSeqlen(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        Arrays.sort(arr);
        int len = arr.length;

        for (int i = 0; i < len; i++) {
            System.out.print(arr[i] + ",");
        }

        System.out.println();

        int result = 1;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len - 1; j++) {
                if (arr[j] + 1 != arr[j + 1] || (j + 1) == len -1 ) {
                    int tempWidth = j - i;
                    if (result < tempWidth) {
                        result = tempWidth;
                    }
                    break;
                }
            }
        }

        return result;
    }
}
