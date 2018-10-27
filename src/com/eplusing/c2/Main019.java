package com.eplusing.c2;

public class Main019 {

	public static void main(String[] args) {
		System.out.println("out");
		System.err.println("err");
		
		int[] arr = new int[] {34, 23, 12, 45, 34, 18, 90, 54, 45};
		quickSort(arr, 0, arr.length - 1);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	
	public static void quickSort(int[] arr, int lowIndex, int highIndex) {
		int lo = lowIndex;
		int hi = highIndex;
		int mid;
		if(highIndex > lowIndex){
			mid = arr[(lowIndex + highIndex) / 2];
			while(lo <= hi) {
				//获取不小于中间值的最小索引
				while((lo < highIndex) && (arr[lo] < mid)) {
					++lo;
				}
				//获取不大于中间值得最大索引
				while((hi > lowIndex) && (arr[hi] > mid)) {
					--hi;
				}
				
				if(lo <= hi) {
					swap(arr, lo, hi);
					++lo;
					--hi;
				}
			}
			
			if(lowIndex < hi) {
				quickSort(arr, lowIndex, hi);
			}
			if(lo < highIndex) {
				quickSort(arr, lo, highIndex);
			}
			
		}
	}


	private static void swap(int[] arr, int lo, int hi) {
		int temp = arr[lo];
		arr[lo] = arr[hi];
		arr[hi] = temp;
	}

}
