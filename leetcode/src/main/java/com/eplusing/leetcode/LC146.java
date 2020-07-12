package com.eplusing.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC146 {
	public static void main(String[] a){
		String s = "wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco";
		//s= "abcabcbb";
        int len = lengthOfLongestSubstring(s);
		System.out.print("result len:" + len);

	}
	
	
public static int lengthOfLongestSubstring (String s) {
        
        if(null == s || s.length() == 0){
            return 0;
        }
         
        if(s.length() == 1){
            return 1;
        }
         
        int width = 0;
        int start = 0;
        char[] arr = s.toCharArray();
        int len = arr.length;
        
        Map <Character, Integer> map = new HashMap<>();
        
        
        for(int i = 0; i < len; i++){
        	//wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco
        	char c = arr[i];
        	
        	start = Math.max(start, (map.containsKey(c) ? map.get(c) + 1 : 0));
        	
        	width = Math.max(width, i-start + 1);
        	
        	System.out.println("i:" + i + ",start:" + start + ",width:" + width);
        	
        	map.put(c, i);
            
       
        }
         
        
        return width;
    }

}
