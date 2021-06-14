package com.eplusing.demo1200.leetcode.leetcode;

import java.util.Stack;

public class NC52 {
    public static void main(String[] args) {

    }

    public boolean isValid (String s) {
        if(s == null || s.length()%2 != 0){
            return false;
        }
        // write code here
        Stack<Character> stack = new Stack();

        char[] arr = s.toCharArray();

        for(int i = 0; i < arr.length; i++){
            if(arr[i] == '('){
                stack.push(arr[i]);
            }
            if(arr[i] == '['){
                stack.push(arr[i]);
            }
            if(arr[i] == '{'){
                stack.push(arr[i]);
            }

            if(arr[i] == ')'){
                if(!stack.isEmpty() && stack.peek() == '('){

                }
                stack.push(arr[i]);
            }


        }




        return false;
    }
}
