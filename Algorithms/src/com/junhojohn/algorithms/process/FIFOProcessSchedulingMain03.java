package com.junhojohn.algorithms.process;

import java.util.Scanner;

/**
 * Separate main logic into 4 sub methods for unit testing.
 * @author junhojohn
 *
 */
public class FIFOProcessSchedulingMain03 {
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
		setNumOfProcess(sc.nextInt());
	}
	
	public static void createNewArrays() throws Exception {
		getProcessArray();
		getArrivalTimeArray();
		getExecuteTimeArray();
		getWaitTimeArray();
		getTurnTimeArray();
		getCompleteTimeArray();
	}
	
	public static void inputExecuteTimeAndArrivalTime(Scanner sc) throws Exception {
		for(int i = 0  ; i < getNumOfProcess(); i ++){
			getProcessArray()[i] = i+1;
			System.out.println("Input process" + getProcessArray()[i] + "'s arrival time:");
			getArrivalTimeArray()[i] = sc.nextInt();
			System.out.println("Input process" + getProcessArray()[i] + "'s execute time:");
			getExecuteTimeArray()[i] = sc.nextInt();
		}		
	}
	
	public static void conductAlgorithm() throws Exception {
		int[] completeTimeArray = getCompleteTimeArray();
		int[] arrivalTimeArray = getArrivalTimeArray();
		int[] waitTimeArray = getWaitTimeArray();
		int[] executeTimeArray = getExecuteTimeArray();
		int[] turnTimeArray = getTurnTimeArray();
		
		for(int i = 0 ; i < getNumOfProcess() ; i ++){
			if(i == 0 || completeTimeArray[i-1] <= arrivalTimeArray[i]){
				waitTimeArray[i] = 0;
				completeTimeArray[i] = arrivalTimeArray[i] + executeTimeArray[i];
			}else{
				waitTimeArray[i] = completeTimeArray[i-1] - arrivalTimeArray[i];
				completeTimeArray[i] = completeTimeArray[i-1] + executeTimeArray[i];
			}
			turnTimeArray[i] = waitTimeArray[i] + executeTimeArray[i];
			
		}		
	}

	public static void printAlgorithmResult() throws Exception {
		for(int i = 0 ; i < getNumOfProcess() ; i ++){
			System.out.println("============================");
			System.out.println("Process" + getProcessArray()[i] + "'s turn time:" + getTurnTimeArray()[i]);
			System.out.println("Process" + getProcessArray()[i] + "'s wait time:" + getWaitTimeArray()[i]);
			System.out.println("============================");
		}		
	}

	public static int getNumOfProcess() {
		return numOfProcess;
	}

	public static void setNumOfProcess(int numOfProcess) {
		FIFOProcessSchedulingMain03.numOfProcess = numOfProcess;
	}

	public static int[] getProcessArray() {
		if(processList == null){
			processList = new int[getNumOfProcess()];
		}
		return processList;
	}

	public static int[] getArrivalTimeArray() {
		if(arrivalTimeList == null){
			arrivalTimeList = new int[getNumOfProcess()];
		}
		return arrivalTimeList;
	}

	public static int[] getExecuteTimeArray() {
		if(executeTimeList == null){
			executeTimeList = new int[getNumOfProcess()];
		}
		return executeTimeList;
	}

	public static int[] getWaitTimeArray() {
		if(waitTimeList == null){
			waitTimeList = new int[getNumOfProcess()];
		}
		return waitTimeList;
	}

	public static int[] getTurnTimeArray() {
		if(turnTimeList == null){
			turnTimeList = new int[getNumOfProcess()];
		}
		return turnTimeList;
	}

	public static int[] getCompleteTimeArray() {
		if(completeTimeList == null){
			completeTimeList = new int[getNumOfProcess()];
		}
		return completeTimeList;
	}

}
