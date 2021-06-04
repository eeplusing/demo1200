package com.eplusing.demo1200.leetcode;

public class BigNumSum {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        StringBuffer a = new StringBuffer("1");
        StringBuffer b = new StringBuffer("999");

        char[] arrA = a.reverse().toString().toCharArray();
        char[] arrB = b.reverse().toString().toCharArray();

        int aLen = arrA.length;
        int bLen = arrB.length;
        int maxLen = aLen > bLen? aLen:bLen;
        String result = "";

        int nextStep = 0;
        int tempA = 0;
        int tempB = 0;
        for(int i = 0 ; i < maxLen; i++){
            tempA = 0;
            tempB = 0;
            if(i < aLen){
                tempA = Integer.parseInt(String.valueOf(arrA[i]));
            }
            if(i < bLen){
                 tempB = Integer.parseInt(String.valueOf(arrB[i]));
            }
            int sum =(tempA + tempB + nextStep)%10;
            nextStep = (tempA + tempB + nextStep)/10;
            result += sum;
            if(i == maxLen - 1 && nextStep > 0){
                result += nextStep;
            }
        }

        System.out.println(new StringBuffer(result).reverse().toString());

    }
}