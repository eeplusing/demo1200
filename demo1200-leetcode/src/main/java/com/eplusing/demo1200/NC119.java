package com.eplusing.demo1200;


import java.util.ArrayList;
import java.util.Arrays;

public class NC119 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList list = new ArrayList();
        if (k > input.length) {
            return list;
        }

        Arrays.sort(input);
        int m = 0;

        for (int i = 0; i < input.length; i++) {
            if (++m <= k) {
                list.add(input[i]);
            }
        }
        return list;
    }
}