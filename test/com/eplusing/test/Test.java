package com.eplusing.test;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Test {
	public static void main(String[] a) {

		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		List<String> list = java.util.Arrays.asList(str.split(" "));

		TreeMap<String, String> map = new TreeMap<String, String>();
		for (int i = 0; i < list.size(); i++) {
			if (null == map.get(list.get(i).toLowerCase())) {
				map.put(list.get(i).toLowerCase(), list.get(i));
			}
		}

		StringBuffer sb = new StringBuffer();
		for (Map.Entry<String, String> entry : map.entrySet()) {
			sb.append(entry.getValue()).append(" ");
		}

		String result = sb.toString();
		System.out.println(sb.toString().substring(0, result.length() - 1));
	}
}
