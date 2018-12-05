package com.junhojohn.algorithms.progressions;

public class SumArithmethicalProgressionMain02 {

	public static void main(String[] args) {
		int startNum = 1;
		int endNum = 100;
		int sum = 0;
		for(int i = startNum ; i <= endNum ; i ++){
			if(i%2 == 0){
				sum = sum + i;
			}
		}
		System.out.println("result : " + sum);
	}

}
