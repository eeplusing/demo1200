package com.eplusing.leetcode;

public class LC143 {
	public static void main(String[] a){
		String s = "hinmicwsqhptvaprhlmdnjewwpvidxcmfpyqtxklebfzdwskhgnwrtvnksvorzczrbrmybyeeffhdarmggiaafnkxlapkdodgfqgiommvrtytmkauuauaphzajoloeoujgarwmfrgarzmdbjydfatmztyqgmuxjedlxcaftgflhuqldooiqjxqfvinjcksgqeguglnosavorgrhxcaizsnwabfcnalfgrzmepaypxniegsdisljkzhkcpmprxxxqwjwllxdiklosdrdxfohgwringzefwbytmwgxtjhdxwycpbawphcnbmajmeokhoftlmsexakuyixplxmagoojdospvjbcxhwivqpsqbpqjogwnswtimdlbxcwgeaenwoknde";
		int nRows = 40;
		System.out.println(convert(s, nRows));
	}
	
	
	 public static String convert (String s, int nRows) {
	        if(s == null || s.length() < 3){
	                return s;
	            }
	             
	            char[] arr = s.toCharArray();
	            int len = arr.length;
	            int nCows = (nRows - 1)*(len/(2 * nRows -2)) + len%(2 * nRows -2);
	             
	            char[][] result = new char[nRows][];
	            for(int i = 0; i< nRows; i++ ) {
	                result[i] = new char[nCows];
	            }
	             
	            int m =0;
	            int n =0;
	            boolean down = true;
	            boolean up = false;
	             
	            for(int i = 0; i < len; i++){
	            	
	                if(down){
	                    result[m][n] = arr[i];
	                    if(m == nRows -1){
	                        down = false;
	                        up = true;
	                        
	                    }else{
	                      m++;
	                    }
	                   
	                     
	                }else if(up){
	                    m--;
	                    n++;
	                    result[m][n] = arr[i];
	                    if(m == 0){
	                       down = true;
	                       up = false;
	                       
	                       m++;
	                    }
	                }
	                 
	                 
	            }
	             
	            StringBuffer sb = new StringBuffer();
	             
	            for(int k = 0; k < nRows; k++){
	                 for(int p = 0; p < result[k].length; p++){
	                	 if(result[k][p]!= 0){
	                	 sb.append(String.valueOf(result[k][p]));
	                	 }
	                		 
	                 }
	                
	                //sb.append("\n");

	            }
	             
	            return sb.toString();
	    }
}
