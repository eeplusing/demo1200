package org.leetcode;

<<<<<<< HEAD
import com.eplusing.demo1200.NC140Sort;
=======
import com.eplusing.NC140Sort;
>>>>>>> 765f0f4ca7a11b3ceea1cb42ef0d40d1ca630a9f
import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class AppTest
        extends TestCase {
    public static void main(String[] args) {
        int[] arr = {5, 2, 3, 1, 4, 1000, 2, 300, 34, 2, 1, 1, 0};

        //new NC140().bubbleSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");

        }
        System.out.println();

        new NC140Sort().quickSort(arr, 0, arr.length - 1);
        //arr = new NC140().mergeSort(arr);
        //new NC140().shellSort(arr);
        //new NC140().insertSort(arr);

        //new NC140().selectSort(arr);

        //快速排序
        //Arrays.sort(arr);


        //Collections.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }

    }


    //快速排序
    public int[] quickSort(int[] arr, int start, int end) {
        int base = arr[0];
        int i = start;
        int j = end;
        while(i < j){
            while(i < j && arr[j] > base){
                j--;
            }

            while(i < j && arr[i] < base){
                i++;
            }

            if(arr[i]== arr[j]){
                i++;
            }else{
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        if(i-1 > start){
            quickSort(arr, start, i-1);
        }
        if(j - 1 < end){
            quickSort(arr, j-1, end);
        }

        return arr;
    }

}
