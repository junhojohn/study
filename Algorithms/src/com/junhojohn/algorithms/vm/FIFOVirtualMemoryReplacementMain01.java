package com.junhojohn.algorithms.vm;

public class FIFOVirtualMemoryReplacementMain01 {

	public static void main(String[] args) {
		
		int sizeOfPage 			= 4;
		int numOfProcess 		= 9;
		int pageCount 			= 0;
		int currentPageIndex 	= 0;
		int indexToBeRemoved 	= 0;
//		int inputArray[] = new int[] {2,3,4,2,1,3,7,5,4,3};
		int inputArray[] = new int[] {1,2,6,1,4,5,1,2,1};
		int pageArray[] = new int []{0,0,0,0};
		boolean isReplaceable = false;
		boolean isPageHit = false;

		for(int i = 0 ; i < inputArray.length ; i ++){
			for(int k = 0 ; k < pageArray.length ; k ++){
				// Page Hit 여부
				if(inputArray[i] == pageArray[k]){
					currentPageIndex = k;
					indexToBeRemoved = i;
					isPageHit = true;
					break;
				}else{
					// Page Full 여부
					if(pageCount == sizeOfPage){
						for(int j = 0 ; j < pageArray.length ; j ++){
							if(inputArray[indexToBeRemoved] == pageArray[j]){
								currentPageIndex = j;
								indexToBeRemoved++;
								isReplaceable = true;
								break;
							}
						}
					}else{
						isReplaceable = false;
						isPageHit = false;
//						pageCount++;
					}
				}
			}
			for(int k = 0 ; k < pageArray.length ; k ++){
				if(isPageHit){
					pageArray[currentPageIndex] = inputArray[i];
					break;
				}else{
					if(isReplaceable){
						pageArray[currentPageIndex] = inputArray[i];
						break;
					}else{
						pageCount++;
						indexToBeRemoved++;
						currentPageIndex = k;
						pageArray[k] = inputArray[i];
						break;
					}
				}
			}

			for(int k = 0 ; k < pageArray.length ; k++){
				System.out.print(pageArray[k]);
			}
			System.out.print("\n");
		}
		
	}

}
