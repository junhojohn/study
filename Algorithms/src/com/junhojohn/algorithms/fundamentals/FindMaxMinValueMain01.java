package com.junhojohn.algorithms.fundamentals;

import java.util.Scanner;

public class FindMaxMinValueMain01 {

	public static void main(String[] args) {
		int numOfScore = 5;
		double [] scoreList = new double[numOfScore];
		double max = 0;
		double min = 100;
		
		Scanner sc = new Scanner(System.in);
		
		try{
			for(int i = 0 ; i < numOfScore ; i ++){
				System.out.println("Please input score : ");
				scoreList[i] = sc.nextDouble();
			}			
			
			for(int i = 0 ; i < numOfScore ; i ++){
				if(scoreList[i] > max){
					max = scoreList[i];
				}
				if(scoreList[i] < min){
					min = scoreList[i];
				}
			}
			System.out.println("max : " + max + ", min : " + min);
			System.out.println("sum of maximum and minimum is " + (min + max));
			System.out.println("average of maximum and minimum is " + (min + max)/2);
			
		}catch(Exception e){
			
		}finally{
			sc.close();
		}

		
	}

}
