package com.junhojohn.algorithms.progressions;

public class SumArithmethicalProgressionMain06 {

	public static void main(String[] args) {
		int startNum = 1;
		int endNum = 6;
		double sum = 0;
		
		for(int i = startNum ; i <= endNum ; i ++){
			sum = sum + ((double)i/(i+1));
			System.out.println("result : " + sum);	
		}
		
	}

}
