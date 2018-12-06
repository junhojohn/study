package com.junhojohn.algorithms.basics;

public class MultipleMain01 {

	public static void main(String[] args) {
		int startNum = 1;
		int endNum = 100;
		int cnt = 0;
		int sum = 0;
		for(int i = startNum ; i <= endNum ; i ++){
			if(i%5 == 0){
				// i is multiple of 5.
				sum = sum + i;
				cnt++;
			}
		}
		
		System.out.println("sum of multiple of 5 : " + sum);
		System.out.println("number of multiple of 5 : " + cnt);
	}

}
