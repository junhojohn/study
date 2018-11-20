package com.junhojohn.algorithms.vm;

import java.util.ArrayList;
import java.util.List;

public class FIFOVirtualMemoryReplacementMain02 {

	public static void main(String[] args) {
		
		int sizeOfPage 			= 3;
		int indexToBeReplaced 	= 0;
//		int inputArray[] = new int[] {1,2,6,1,4,5,1,2,1};
		int inputArray[] = new int[] {7,0,1,2,0,3,0,4,2,3,0,3,2,1,2,0,1,7,0,1};
		List<Integer> page = new ArrayList<Integer>();

		for(int i = 0 ; i < inputArray.length ; i ++){
			if(page.size() == sizeOfPage){
				if(page.contains(inputArray[i])){
					// TODO 교체하지 않음.
				}else{
					// TODO 교체
					// TODO indexToBeReplaced ++
					page.set(page.indexOf(inputArray[indexToBeReplaced]), inputArray[i]);
					indexToBeReplaced++;
				}
			}else{
				if(page.contains(inputArray[i])){
					// TODO 추가하지 않음.
				}else{
					// TODO 추가
					page.add(inputArray[i]);
				}
			}
			System.out.print(i + " 번째 입력 후 페이지리스트: [");
			for(Integer pageItem : page){
				System.out.print(pageItem);
			}
			System.out.println("]");
		}

	}

}
