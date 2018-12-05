package com.junhojohn.algorithms.progressions;

public class SumArithmethicalProgressionMain07 {

	public static void main(String[] args) {
		int startNum = 1;
		int endNum = 50;
		double sum = 0;
		for(int i = startNum ; i <= endNum ; i ++){
			if(i%2 == 0){
				// i is even number
				sum = sum - ((double)i/(i+1));
			}else{
				// i is odd number
				sum = sum + ((double)i/(i+1));
			}
		}
		System.out.println("result : " + sum);
	}

}
