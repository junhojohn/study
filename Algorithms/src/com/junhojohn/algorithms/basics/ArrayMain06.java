package com.junhojohn.algorithms.basics;

public class ArrayMain06 {

	public static void main(String[] args) {
		int rowNum = 5;
		int colNum = 5;
		int num = 0;
		int [][] array = new int [rowNum][colNum];
		
		for(int i = 0 ; i < rowNum ; i ++){
			for(int j = (colNum-1) ; j >= (colNum-1)-i ; j --){
				array[i][j] = ++num;
			}
		}
		
		for(int i = 0 ; i < rowNum ; i ++){
			for(int j = 0 ; j < colNum ; j ++){
				System.out.print(array[i][j]);
			}
			System.out.println();
		}
	}
}
