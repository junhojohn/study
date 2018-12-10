package com.junhojohn.algorithms.fundamentals;

import java.util.Scanner;

class FindMaximumValueMain01 {

	public static void main(String[] args) {
		int numOfScore = 5;
		int maximumNum = 0;
		int [] scoreList = new int[numOfScore];
		Scanner sc = new Scanner(System.in);;

		try{
			for(int i = 0 ; i < numOfScore ; i ++){
				System.out.println("please input score: ");
				scoreList[i] = sc.nextInt();
			}
			
			for(int i = 0 ; i < numOfScore ; i ++){
				if(scoreList[i] > maximumNum){
					maximumNum = scoreList[i];
				}
			}
			
			System.out.println("maximum number is " + maximumNum);

		}catch(Exception e){
			System.err.println("error occured.");
		}finally{
			sc.close();
		}
	}

}
