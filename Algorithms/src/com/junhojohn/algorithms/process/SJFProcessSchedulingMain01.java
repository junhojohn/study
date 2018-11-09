package com.junhojohn.algorithms.process;

import java.util.Scanner;

public class SJFProcessSchedulingMain01 {

	public static void main(String[] args) {
		Scanner sc = null;
		try{
			sc = new Scanner(System.in);
			System.out.println("Input number of processes:");
			int numOfProcess = sc.nextInt();
			int[] processList = new int[numOfProcess];
			int[] arrivalTimeList = new int[numOfProcess];
			int[] executeTimeList = new int[numOfProcess];
			int[] waitTimeList = new int[numOfProcess];
			int[] turnTimeList = new int[numOfProcess];
			int[] completeTimeList = new int[numOfProcess];
			int temp = 0;
			
			// input executeTime, arrivalTime
			for(int i = 0  ; i < numOfProcess; i ++){
				processList[i] = i+1;
				System.out.println("Input process" + processList[i] + "'s arrival time:");
				arrivalTimeList[i] = sc.nextInt();
				System.out.println("Input process" + processList[i] + "'s execute time:");
				executeTimeList[i] = sc.nextInt();
			}
			
			// sort by executeTime
			for(int i = 0 ; i < numOfProcess ; i ++){
				for(int j = 0 ; j < numOfProcess - 1 ; j ++){
					if(executeTimeList[j] > executeTimeList[j+1]){
						// swapping executeTime
						temp = executeTimeList[j];
						executeTimeList[j] = executeTimeList[j+1];
						executeTimeList[j+1] = temp;
						
						// swapping arrivalTime
						temp = arrivalTimeList[j];
						arrivalTimeList[j] = arrivalTimeList[j+1];
						arrivalTimeList[j+1] = temp;
						
						// swapping processList
						temp = processList[j];
						processList[j] = processList[j+1];
						processList[j+1] = temp;
					}
				}
			}
			
			// conduct scheduling
			for(int i = 0 ; i < numOfProcess ; i ++){
				if(i == 0 || completeTimeList[i-1] <= arrivalTimeList[i]){
					waitTimeList[i] = 0;
					completeTimeList[i] = arrivalTimeList[i] + executeTimeList[i];
				}else{
					waitTimeList[i] = completeTimeList[i-1] - arrivalTimeList[i];
					completeTimeList[i] = completeTimeList[i-1] + executeTimeList[i];
				}
				turnTimeList[i] = waitTimeList[i] + executeTimeList[i];
			}
			
			// output turnTime and waitTime of process
			for(int i = 0 ; i < numOfProcess ; i ++){
				System.out.println("============================");
				System.out.println("Process" + processList[i] + "'s turn time:" + turnTimeList[i]);
				System.out.println("Process" + processList[i] + "'s wait time:" + waitTimeList[i]);
				System.out.println("============================");
			}
		}catch(Exception e){
			e.printStackTrace();
		} finally{
			sc.close();
		}
	}

}
