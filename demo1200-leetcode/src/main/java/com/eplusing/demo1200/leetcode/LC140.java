package com.eplusing.demo1200.leetcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LC140 {
	public String longestCommonPrefix (String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        for (int i = 0; i < strs.length; i++) {
            if (strs[i] == null || strs[i].length() == 0) {
                return "";
            }
        }
        // write code here
        boolean flag = false;
        int j = 0;
        while (true) {
            for (int i = 0; i < strs.length; i++) {
                if (strs[i].length() == j || strs[i].charAt(j) != strs[0].charAt(j)) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }

            j++;
        }

        if (strs[0].length() == j) {
            return strs[0];
        } else {
            return strs[0].substring(0, j);
        }

    }
        
}
