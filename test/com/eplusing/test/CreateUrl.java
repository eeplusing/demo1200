package com.eplusing.test;

public class CreateUrl {
	public static void main(String[] a) {
		//
		
		String url1 = "https://13.cdn-vod.huaweicloud.com/asset/b51305b90ec35c2fe3225ffe03c58f4e/play_video/0a7c3bc391ca574dabab647e070f6505_1_1280X720_0_0_";
		
		
		
		
		int start = 0;
		int end = 315;
		String endFlag = ".ts?MediaCloudHlsTs=1&MediaCloudSessionID=158107284_1427887076";
		
		for(int i = start; i <= end; i++){
			String targetUrl = url1 + i + endFlag;
			System.out.println(targetUrl);
		}
		
		
		
	}
}
