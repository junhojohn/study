package com.junhojohn.algorithms.basics;

public class FibonacciProgressionMain02 {

	public static void main(String[] args) {
		int startNum = 1;
		int endNum = 10;
		int sum = 1;
		int total = 0;
		for(int i = startNum; i <= endNum ; i ++){
			if(i%2 == 0){
				// i is even number
				total = total - sum;
			}else{
				// i is odd number
				total = total + sum;
			}
			sum = sum + i;
		}
		System.out.println("result : " + total);
	}

}
