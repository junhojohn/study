package com.junhojohn.algorithms.process;

import java.util.Scanner;

/**
 * Separate main logic into 4 sub methods for unit testing.
 * @author junhojohn
 *
 */
public class FIFOProcessSchedulingMain02 {
	private static int numOfProcess 		= 0;
	private static int[] processList 		= null;
	private static int[] arrivalTimeList 	= null; 
	private static int[] executeTimeList 	= null;
	private static int[] waitTimeList 		= null;
	private static int[] turnTimeList 		= null;
	private static int[] completeTimeList 	= null;
	
	public static void main(String[] args) {
		Scanner sc = null;
		try{
			inputNumOfProcess(sc);
			createNewArrays();
			inputExecuteTimeAndArrivalTime(sc);
			conductAlgorithm();
			printAlgorithmResult();
		}catch(Exception e){
			e.printStackTrace();
		} finally{
			sc.close();
		}
	}

	public static void inputNumOfProcess(Scanner sc) throws Exception {
		sc = new Scanner(System.in);
		System.out.println("Input number of processes:");
		numOfProcess = sc.nextInt();
	}
	
	public static void createNewArrays() throws Exception {
		processList = new int[numOfProcess];
		arrivalTimeList = new int[numOfProcess];
		executeTimeList = new int[numOfProcess];
		waitTimeList = new int[numOfProcess];
		turnTimeList = new int[numOfProcess];
		completeTimeList = new int[numOfProcess];			
	}
	
	public static void inputExecuteTimeAndArrivalTime(Scanner sc) throws Exception {
		for(int i = 0  ; i < numOfProcess; i ++){
			processList[i] = i+1;
			System.out.println("Input process" + processList[i] + "'s arrival time:");
			arrivalTimeList[i] = sc.nextInt();
			System.out.println("Input process" + processList[i] + "'s execute time:");
			executeTimeList[i] = sc.nextInt();
		}		
	}
	
	public static void conductAlgorithm() throws Exception {
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
	}

	public static void printAlgorithmResult() throws Exception {
		for(int i = 0 ; i < numOfProcess ; i ++){
			System.out.println("============================");
			System.out.println("Process" + processList[i] + "'s turn time:" + turnTimeList[i]);
			System.out.println("Process" + processList[i] + "'s wait time:" + waitTimeList[i]);
			System.out.println("============================");
		}		
	}

	public static int getNumOfProcess() {
		return numOfProcess;
	}

	public static void setNumOfProcess(int numOfProcess) {
		FIFOProcessSchedulingMain02.numOfProcess = numOfProcess;
	}

	public static int[] getProcessList() {
		if(processList == null){
			processList = new int[getNumOfProcess()];
		}
		return processList;
	}

	public static int[] getArrivalTimeList() {
		if(arrivalTimeList == null){
			arrivalTimeList = new int[getNumOfProcess()];
		}
		return arrivalTimeList;
	}

	public static int[] getExecuteTimeList() {
		if(executeTimeList == null){
			executeTimeList = new int[getNumOfProcess()];
		}
		return executeTimeList;
	}

	public static int[] getWaitTimeList() {
		if(waitTimeList == null){
			waitTimeList = new int[getNumOfProcess()];
		}
		return waitTimeList;
	}

	public static int[] getTurnTimeList() {
		if(turnTimeList == null){
			turnTimeList = new int[getNumOfProcess()];
		}
		return turnTimeList;
	}

	public static int[] getCompleteTimeList() {
		if(completeTimeList == null){
			completeTimeList = new int[getNumOfProcess()];
		}
		return completeTimeList;
	}

}
