package com.junhojohn.algorithms.fundamentals;

public class FibonacciProgressionMain01 {

	public static void main(String[] args) {
		int firstNum = 1;
		int secondNum = 1;
		
		int sum = firstNum + secondNum;
		int total = 0;
		
		for(int i = 0 ; i < 5 ; i ++){
			sum = firstNum + secondNum;
			firstNum = secondNum;
			secondNum = sum;
			total = sum + total;
		}
	}

}
