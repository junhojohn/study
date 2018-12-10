package com.junhojohn.algorithms.fundamentals;

public class ZigZagArrayMain01 {

	public static void main(String[] args) {
		int rowNum = 5;
		int colNum = 5;
		int num = 0;
		int [][] array = new int[rowNum][colNum];
		
		for(int i = 0 ; i < rowNum ; i ++){
			if(i%2 == 0){
				// row is even number.
				for(int j = 0 ; j < colNum ; j++){
					array[i][j] = ++num; 
				}
			}else{
				// row is odd number.
				for(int j = colNum-1 ; j >= 0 ; j--){
					array[i][j] = ++num;
				}
			}
		}
		
		for(int i = 0 ; i < rowNum ; i ++){
			for(int j = 0 ; j < colNum ; j++){
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
		
	}

}
