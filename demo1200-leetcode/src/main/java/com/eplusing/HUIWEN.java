package com.eplusing;

public class HUIWEN
{
    public static void main(String[] args) {
        String atr  = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(atr));
    }
    public static boolean isPalindrome(String s) {
        char[] arr= s.toCharArray();

        int i = 0;
        int j = arr.length - 1;
        while(i < j){
            if((arr[i] < '0' || arr[i] > '9')
                    && (arr[i] < 'a' || arr[i] > 'z')
                    && (arr[i] < 'A' || arr[i] > 'Z')){
                i++;
                continue;
            }
            if((arr[j] < '0' || arr[j] > '9')
                    && (arr[j] < 'a' || arr[j] > 'z')
                    && (arr[j] < 'A' || arr[j] > 'Z')){
                j--;
                continue;
            }

            System.out.println("arr[" + i +"]" + arr[i] + "," + "arr[" + j +"]" + arr[j]);

            if((arr[i] == arr[j])
                    ||(arr[i] + 32 == arr[j])
                    ||(arr[i] - 32 == arr[j])){
                i++;
                j--;
                continue;
            }else{
                return false;
            }
        }

        return true;



    }
}
