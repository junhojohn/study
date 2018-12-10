package com.junhojohn.algorithms.fundamentals;

import java.util.Scanner;

public class FindNearestValueMain01 {

	public static void main(String[] args) {
		int numberCnt = 10;
		int criteriaNumber = 6;
		int nearestNumber = 0;
		int min = numberCnt-1;
		int [] numberList = new int[numberCnt];
		Scanner sc = new Scanner(System.in);
		
		try{
			for(int i = 0 ; i < numberCnt ; i ++){
				System.out.println("Please input number randomly(from 0 to 9) :");
				numberList[i] = sc.nextInt();
			}
			
			for(int i = 0 ; i < numberCnt ; i ++){
				int distance = numberList[i]-criteriaNumber;
				if(distance < 0){
					distance = -distance;
				}
				if(distance < min){
					min = distance;
					nearestNumber = numberList[i];
				}
			}
			
			System.out.println(nearestNumber);
		}catch(Exception e){
			System.err.println("error occured.");
		}finally{
			sc.close();
		}
	}

}
