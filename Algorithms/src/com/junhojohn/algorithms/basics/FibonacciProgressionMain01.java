package com.junhojohn.algorithms.basics;

public class FibonacciProgressionMain01 {

	public static void main(String[] args) {
		int startNum = 1;
		int endNum = 10;
		int sum = 1;
		int total = 0;
		
		for(int i = startNum ; i <= endNum ; i ++){
			total = total + sum;
			sum = sum + i;
		}
		System.out.println("result : " + total);
	}

}
