package com.junhojohn.algorithms.basics;

public class DataSwappingMain01 {

	public static void main(String[] args) {
		int startNum = 1;
		int endNum = 10;
		int temp = 0;
		int [] array = new int[endNum];
		
		for(int i = startNum ; i <= endNum ; i ++){
			array[i-1] = i;
		}
		
		for(int i = startNum ; i <= endNum ; i ++){
			if(i%2 != 0){
				// i is odd number
				temp = array[i-1];
				array[i-1] = array[i];
				array[i] = temp;
			}
		}
		for(int i = startNum ; i <= endNum ; i ++){
			System.out.print(array[i-1] + " ");
		}
	}

}
