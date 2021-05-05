package com.eplusing.demo1200.leetcode;

public class NC105 {

    public static void main(String[] args) {
        NC105 ins = new NC105();
        int[] arr = {1,2,4,4,5};

        System.out.println(ins.search(arr, 3));
    }

    public int search(int[] nums, int target) {
        // write code here
        int len = nums.length;
        int hight = len - 1;
        int low = 0;
        int result = -1;
        while (hight >= low) {
            int mid = (hight + low) / 2;
            int midNum = nums[mid];
            if (midNum == target) {
                return mid;
            }
            if (target > midNum) {
                low = mid + 1;
            }

            if (target < midNum) {
                hight = mid -1;
            }
        }

        return result;

    }
}
