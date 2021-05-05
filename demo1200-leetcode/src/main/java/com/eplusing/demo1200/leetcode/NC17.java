package com.eplusing.demo1200.leetcode;

public class NC17 {
    public int getLongestPalindrome(String A, int n) {
        // write code here
        if (A == null) {
            return 0;
        }
        if (A.length() < 2 || n < 2) {
            return 1;
        }
        char[] arr = A.toCharArray();
        int left = 0;
        int right = 0;
        int max = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                left = i;
                right = j;

                //是回文
                boolean flag = true;
                while (left < right) {
                    if (arr[left] == arr[right]) {
                        left++;
                        right--;
                        continue;
                    } else {
                        flag = false;
                        break;
                    }

                }

                if (flag) {
                    max = j - i + 1 > max ? j - i + 1 : max;
                }
            }

        }

        return max;

    }

    public static void main(String[] args) {
        // int[] arr = {2,3,4,5};
        String str = "baabccc";

        int maxLen = new NC17().getLongestPalindrome(str, 7);

        System.out.println(maxLen);


    }
}
