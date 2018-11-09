package com.junhojohn.algorithms.process;

import java.util.Scanner;

public class RRProcessSchedulingMain01 {

	public static void main(String[] args) {
		Scanner sc = null;
		try{
			sc = new Scanner(System.in);
			System.out.println("Input number of processes:");
			int numOfProcess = sc.nextInt();
			System.out.println("Input time quantum:");
			int timeQuantum = sc.nextInt();
			int[] processList = new int[numOfProcess];
			int[] arrivalTimeList = new int[numOfProcess];
			int[] executeTimeList = new int[numOfProcess];
			int[] waitTimeList = new int[numOfProcess];
			int[] totalWaitTimeList = new int[numOfProcess];
			int[] turnTimeList = new int[numOfProcess];
			int[] completeTimeList = new int[numOfProcess];
			int[] remainTimeList = new int[numOfProcess];
			int temp = 0;
			
			// input executeTime, arrivalTime
			for(int i = 0  ; i < numOfProcess; i ++){
				processList[i] = i+1;
				System.out.println("Input process" + processList[i] + "'s arrival time:");
				arrivalTimeList[i] = sc.nextInt();
				System.out.println("Input process" + processList[i] + "'s execute time:");
				executeTimeList[i] = sc.nextInt();
			}
			
			// find maximum execute time
			for(int i = 0 ; i < numOfProcess ; i ++){
				for(int j = 0 ; j < numOfProcess-1 ; j ++){
					if(executeTimeList[j] <= executeTimeList[j+1]){
						temp = executeTimeList[j+1];
					}else{
						temp = executeTimeList[j];
					}
				}
			}
			
			// caculate number of round robin
			int numOfRound = temp / timeQuantum ;
			if(temp % timeQuantum != 0){
				numOfRound++;
			}

			// conduct scheduling
			for(int i = 0 ; i < numOfRound ; i ++){
				for(int j = 0 ; j < numOfProcess ; j ++){
					if(executeTimeList[j] == 0){
						if(j != 0){
							completeTimeList[j] = completeTimeList[j-1];	
							waitTimeList[j] = waitTimeList[j-1];
						}
						continue;
					}
					if(executeTimeList[j] >= timeQuantum){
						remainTimeList[j] = executeTimeList[j] - timeQuantum;
						executeTimeList[j] = timeQuantum; 
					}else{
						remainTimeList[j] = 0;
					}

					if(j == 0 || (completeTimeList[j-1] <= arrivalTimeList[j])){
						waitTimeList[j] = 0;
						completeTimeList[j] = completeTimeList[j] + arrivalTimeList[j] + executeTimeList[j];
					}else{
						waitTimeList[j] = completeTimeList[j-1] - arrivalTimeList[j];
						completeTimeList[j] = completeTimeList[j] + completeTimeList[j-1] + executeTimeList[j];
					}
					turnTimeList[j] = turnTimeList[j] + waitTimeList[j] + executeTimeList[j];
					totalWaitTimeList[j] += waitTimeList[j];
					
					if(remainTimeList[j] > 0 ){
						executeTimeList[j] = remainTimeList[j];
					}else{
						executeTimeList[j] = 0;
					}
				}
				for(int j = 0 ; j < numOfProcess ; j ++){
					completeTimeList[j] = 0;
					waitTimeList[j] = 0;
				}
			}
			
			// output turnTime and waitTime of process
			for(int i = 0 ; i < numOfProcess ; i ++){
				System.out.println("============================");
				System.out.println("Process" + processList[i] + "'s turn time:" + turnTimeList[i]);
				System.out.println("Process" + processList[i] + "'s wait time:" + totalWaitTimeList[i]);
				System.out.println("============================");
			}
		}catch(Exception e){
			e.printStackTrace();
		} finally{
			sc.close();
		}
	}

}
