package com.junhojohn.algorithms.process.tests;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import com.junhojohn.algorithms.process.FIFOProcessSchedulingMain03;

public class FIFOProcessSchedulingMainTest03 {

	static FIFOProcessSchedulingMain03 fifo03 = null;
	static int[] testExecuteTime = null;
	static int[] testArrivalTime = null;
	static int[] answerWaitTime = null;
	static int[] answerTurnTime = null;

	@BeforeClass
	public static void testBefore03(){
		fifo03 = new FIFOProcessSchedulingMain03();
		fifo03.setNumOfProcess(4);
		testExecuteTime = new int[]{1,8,12,20};
		testArrivalTime = new int[]{4,2,7,5};
		answerWaitTime = new int[]{0,3,6,20};
		answerTurnTime = new int[]{1,11,18,40};
	}
	
	@Test
	public void testAlgorithm03() {
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
	public static void testResult03(){
		assertArrayEquals(answerWaitTime, fifo03.getWaitTimeArray());
		assertArrayEquals(answerTurnTime, fifo03.getTurnTimeArray());
	}

}
