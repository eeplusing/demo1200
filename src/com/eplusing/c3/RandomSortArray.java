package com.eplusing.c3;

import java.util.Random;
import java.util.TreeSet;

public class RandomSortArray {

	public static void main(String[] args) {
		TreeSet<Integer> set = new TreeSet<Integer>();
		int count = 0;
		Random ran = new Random();
		while(count < 10) {
			boolean success = set.add(ran.nextInt(100));
			if(success)
				count++;
		}
		
		int size = set.size();
		
		Integer[] arr = new Integer[size];
		set.toArray(arr);
		
		for(Integer value : arr) {
			System.out.print(value + " ");
		}
	}

}
