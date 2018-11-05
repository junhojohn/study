package com.junhojohn.algorithms.main;

import java.util.Scanner;

public class FIFOProcessSchedulingMain01 {

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
	
			// input executeTime, arrivalTime
			for(int i = 0  ; i < numOfProcess; i ++){
				processList[i] = i+1;
				System.out.println("Input process" + processList[i] + "'s arrival time:");
				arrivalTimeList[i] = sc.nextInt();
				System.out.println("Input process" + processList[i] + "'s execute time:");
				executeTimeList[i] = sc.nextInt();
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
