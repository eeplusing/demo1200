package com.eplusing.demo1200.leetcode.leetcode;

public class NC140Sort {
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
        int i = start;
        int j = end;
        int pivot = arr[start];
        while (i < j) {
            //找到小于等于基准的数1
            while (i < j && arr[j] > pivot) {
                j--;
            }

            //找到大于等于基准的数2
            while (i < j && arr[i] < pivot) {
                i++;
            }
            //如果这两个数1和数2相等相等则不交换,继续往右扫描，这样可以保证排序稳定
            if (arr[i] == arr[j] && i < j) {
                i++;
            } else {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        if (i - 1 > start) {
            arr = quickSort(arr, start, i - 1);
        }
        if (j + 1 < end) {
            arr = quickSort(arr, j + 1, end);
        }

        return arr;
    }


    //归并排序
    public int[] mergeSort(int[] arr) {
        int len = arr.length;
        if (len < 2) {
            return arr;
        }

        int mid = len / 2;

        int[] leftArr = new int[mid];
        int[] rightArr = new int[len - mid];
        for (int i = 0; i < len; i++) {
            if (i < mid) {
                leftArr[i] = arr[i];
            } else {
                rightArr[i - mid] = arr[i];
            }
        }
        int[] result = merge(mergeSort(leftArr), mergeSort(rightArr));

        arr = result;
        return result;
    }

    int[] merge(int[] leftArr, int[] rightArr) {
        int[] result = new int[leftArr.length + rightArr.length];
        int index = 0;
        int leftIndex = 0;
        int rightIndex = 0;

        for (; index < result.length; index++) {
            //左边序列已被选择完
            if (leftIndex == leftArr.length) {
                result[index] = rightArr[rightIndex];
                rightIndex++;
                continue;
            }

            //右边序列已被选择完
            if (rightIndex == rightArr.length) {
                result[index] = leftArr[leftIndex];
                leftIndex++;
                continue;
            }

            //哪边的小选择哪边的
            if (leftArr[leftIndex] <= rightArr[rightIndex]) {
                result[index] = leftArr[leftIndex];
                leftIndex++;
                continue;
            } else {
                result[index] = rightArr[rightIndex];
                rightIndex++;
            }
        }

        return result;
    }


    //希尔排序
    public int[] shellSort(int[] arr) {
        int len = arr.length;

        int gap = len / 2;
        while (gap > 0) {
            int i = 0;
            int j = 0;
            for (i = gap; i < len; i++) {
                int temp = arr[i];
                //发现比当前数小就往后移动
                for (j = i - gap; j >= 0; j = j - gap) {
                    if (arr[j] > temp) {
                        arr[j + gap] = arr[j];
                    } else {
                        break;
                    }
                }

                arr[j + gap] = temp;
            }


            gap = gap / 2;
        }


        return arr;

    }


    //插入
    public int[] insertSort(int[] arr) {
        int len = arr.length;

        int i = 0;
        int j = 0;
        for (i = 1; i < len; i++) {
            int temp = arr[i];
            //发现比当前数小就往后移动
            for (j = i - 1; j >= 0; j--) {
                if (arr[j] > temp) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }

            arr[j + 1] = temp;
        }

        return arr;

    }


    //选择
    public int[] selectSort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int minIndex = i;
            //找到最小的数
            for (int j = i + 1; j < len; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }

        return arr;

    }

    //冒泡
    public int[] bubbleSort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        return arr;

    }


}
