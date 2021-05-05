package com.eplusing.demo1200.leetcode;

public class NC19 {
    public static void main(String[] args) {
        int[] arr = {1, -2, 3, 5, -2, 6, -1};
        System.out.println(new NC19().maxsumofSubarray(arr));
    }

    public int maxsumofSubarray (int[] arr) {
        // write code here
        //1, -2, 3, 5, -2, 6, -1
        int len = arr.length;
        int cur = 0;
        int max = 0;
        for(int i = 0; i< len; i++){
            cur += arr[i];
            if(cur > 0){
                max = cur > max ? cur : max;
            }else{
                cur = 0;
            }

        }

        return max;
    }
}
