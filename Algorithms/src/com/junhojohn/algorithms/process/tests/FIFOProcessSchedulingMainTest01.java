package com.junhojohn.algorithms.process.tests;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import com.junhojohn.algorithms.process.FIFOProcessSchedulingMain03;

public class FIFOProcessSchedulingMainTest01 {

	static FIFOProcessSchedulingMain03 fifo03 = null;
	static int[] testExecuteTime = null;
	static int[] testArrivalTime = null;
	static int[] answerWaitTime = null;
	static int[] answerTurnTime = null;

	@BeforeClass
	public static void testBefore01(){
		fifo03 = new FIFOProcessSchedulingMain03();
		fifo03.setNumOfProcess(3);
		testExecuteTime = new int[]{9,7,20};
		testArrivalTime = new int[]{3,5,10};
		answerWaitTime = new int[]{0,7,9};
		answerTurnTime = new int[]{9,14,29};
	}
	
	@Test
	public void testAlgorithm01() {
		try {
			fifo03.createNewArrays();
			for(int i = 0  ; i < fifo03.getNumOfProcess(); i ++){
				fifo03.getArrivalTimeArray()[i] = testArrivalTime[i];
				fifo03.getExecuteTimeArray()[i] = testExecuteTime[i];
			}
			fifo03.conductAlgorithm();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterClass
	public static void testResult01(){
		assertArrayEquals(answerWaitTime, fifo03.getWaitTimeArray());
		assertArrayEquals(answerTurnTime, fifo03.getTurnTimeArray());
	}

}
