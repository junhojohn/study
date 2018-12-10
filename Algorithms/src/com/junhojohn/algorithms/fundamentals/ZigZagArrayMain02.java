package com.junhojohn.algorithms.fundamentals;

public class ZigZagArrayMain02 {

	public static void main(String[] args) {
		int rowNum = 5;
		int colNum = 5;
		int num = 0;
		int [][] array = new int [rowNum][colNum];
		
		for(int i = 0 ; i < colNum ; i ++){
			if(i%2 == 0){
				// col is even number.
				for(int j = 0 ; j < rowNum ; j ++){
					array[j][i] =++num;
				}	
			}else{
				// col is odd number.
				for(int j = rowNum-1 ; j >= 0 ; j --){
					array[j][i] = ++num;
				}
			}
		}
		
		for(int i = 0 ; i < rowNum ; i ++){
			for(int j = 0 ; j < colNum ; j ++){
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}

}
