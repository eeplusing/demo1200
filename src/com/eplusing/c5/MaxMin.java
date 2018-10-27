package com.eplusing.c5;

public class MaxMin {
	public static class Result{
		private double max;
		private double min;
		public Result(double max, double min){
			this.max = max;
			this.min = min;
		}
		public double getMax(){
			return max;
		}
		public double getMin(){
			return min;
		}
	}
	
	public static Result geResult(double[] array){
		double max = Double.MIN_VALUE;
		double min = Double.MAX_VALUE;
		for(double d : array){
			if(d > max){
				max = d;
			}
			if(d < min){
				min = d;
			}
		}
		return new Result(max, min);
	}
}
