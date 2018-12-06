package com.junhojohn.algorithms.basics;

public class FibonacciProgressionMain03 {

	public static void main(String[] args) {
		int startNum = 0;
		int endNum = 19;
		int sum = 0;
		int total = 0;
		for(int i = startNum ; i <= endNum ; i ++){
			sum = sum + i;
			total = total + sum;
		}
		System.out.println("result : " + total);
	}
}
