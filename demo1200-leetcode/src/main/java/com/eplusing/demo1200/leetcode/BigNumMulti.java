package com.eplusing.demo1200.leetcode;

import java.math.BigInteger;

public class BigNumMulti {
    public static void main(String[] args) {
        String n1 = "1234567891011121314151617181920";
        String n2 = "1234567891011121314151617181920";
        BigInteger bn1 = new BigInteger(n1);
        BigInteger bn2 = new BigInteger(n2);

        System.out.println(bn1.add(bn2));
        System.out.println(bn1.subtract(bn2));
        System.out.println(bn1.multiply(bn2));
        //System.out.println(bn1.divide(bn2));

        BigNumMulti ins = new BigNumMulti();
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 0, 1, 1, 1, 2, 1, 3, 1, 4, 1, 5, 1, 6, 1, 7, 1, 8, 1, 9, 2, 0};
        //arr1 = new int[]{1, 2};
        System.out.println(ins.BigNumMultiply(arr1, arr1));

    }


    public String BigNumMultiply(int[] n1, int[] n2) {
        int[] result = new int[n1.length + n2.length];

        for (int i = 0; i < n1.length; i++) {
            for (int j = 0; j < n2.length; j++) {
                result[i + j + 1] += n1[i] * n2[j];
            }
        }

        for (int k = result.length - 1; k > 0; k--) {
            if (result[k] > 10) {
                int temp = result[k];
                result[k] = temp % 10;
                result[k - 1] += temp / 10;
            }
        }
        String re = "";
        for (int m = 0; m < result.length; m++) {
            if(m == 0 && result[m] == 0){
                continue;
            }
            re += result[m];
        }

        return re;


    }


}
