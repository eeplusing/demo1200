package com.eplusing.demo1200.leetcode.leetcode;

/**
 * Hello world!
 *
 */
public class LC144 
{
    public static void main( String[] args )
    {
        String str = "bb";
        
        System.out.println(longestPalindrome(str));
    }
    
    
    /**
    *
    * @param s string字符串
    * @return string字符串
    */
   public static String longestPalindrome (String s) {
      if(s == null || s.length() == 1){
          return s;
      }
       
       
       char[] arr = s.toCharArray();
        int len = arr.length;
       int width = 0;
       int left = 0;
       for(int i = 0; i < len; i++){
            
           for(int j = 0; j < len; j++){
              if(isPalin(i, j, arr)){
                  if((j-i) > width){
                      width = j - i;
                      left = i;
                  }
              }
           }
       }
       
       
       
 
       return s.substring(left, left + width + 1);
   }
   
   public static boolean isPalin(int s, int e, char[] arr){
       while(s < e){
           if(arr[s] != arr[e]){
               return false;
           }
           s++;
           e--;
       }
       
       return true;
       
   }
}
