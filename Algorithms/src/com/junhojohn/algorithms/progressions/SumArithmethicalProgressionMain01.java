package com.junhojohn.algorithms.progressions;

public class SumArithmethicalProgressionMain01 {

	public static void main(String[] args) {
		int startNum = 0;
		int endNum = 5;
		int sum = 0;
		for(int i = startNum ; i <= endNum ; i ++){
			sum = sum + i;
		}
		System.out.println("result : " + sum);
	}

}
