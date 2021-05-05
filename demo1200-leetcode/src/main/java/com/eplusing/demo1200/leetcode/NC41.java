package com.eplusing.demo1200.leetcode;

import java.util.HashMap;
import java.util.Map;

public class NC41 {
    /**
     *
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int maxLength (int[] arr) {

        // write code here
        for(int len = arr.length; len > 0; len--){
            if(hasNoMulti(arr, len)){
                return len;
            }
        }

        return 1;
    }

    public boolean hasNoMulti(int[] arr, int width){
        Map<Integer, Integer> map = null;

        for(int i = 0; i + width <= arr.length; i++){
            boolean findFlag = true;
            map = new HashMap();
            for(int j = 0; j < width; j++){
                if(map.containsKey(arr[i + j])){
                    findFlag = false;
                    break;
                }else{
                    map.put(arr[i + j], 1);
                }

            }

            if(findFlag){
                return findFlag;
            }

        }

        return false;
    }

    public static void main(String[] args) {
       // int[] arr = {2,3,4,5};
        int[] arr = {2,2,3,4,3};

        int maxLen = new NC41().maxLength(arr);

        System.out.println(maxLen);


    }
}
