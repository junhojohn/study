package com.junhojohn.algorithms.vm;

import java.util.ArrayList;
import java.util.List;

public class LFUVirtualMemoryReplacementMain01 {

	public static void main(String[] args) {
		int sizeOfPage 			= 4;
		int indexToBeReplaced 	= 0;
//		List<Integer> inputList = new ArrayList<Integer>();
//		inputList.add(1);
//		inputList.add(2);
//		inputList.add(6);
//		inputList.add(1);
//		inputList.add(4);
//		inputList.add(5);
//		inputList.add(1);
//		inputList.add(2);
//		inputList.add(1); 
//		List<Integer> inputList = new ArrayList<Integer>();
//		inputList.add(1);
//		inputList.add(2);
//		inputList.add(6);
//		inputList.add(1);
//		inputList.add(4);
//		inputList.add(5);
//		inputList.add(1);
//		inputList.add(2);
//		inputList.add(1);
//		inputList.add(4); 
//		inputList.add(5); 
//		inputList.add(6); 
//		inputList.add(4);
//		inputList.add(5);
		List<Integer> inputList = new ArrayList<Integer>();
		inputList.add(2);
		inputList.add(3);
		inputList.add(1);
		inputList.add(3);
		inputList.add(1);
		inputList.add(2);
		inputList.add(4);
		inputList.add(5);
		
		
		List<Integer> pageList = new ArrayList<Integer>();
		
		for(int i = 0 ; i < inputList.size() ; i ++){
			if(pageList.size() == sizeOfPage){
				if(pageList.contains(inputList.get(i))){
					// 교체안함
				}else{
					// 교체
					int lowCnt = 0;
					
					// 중복 제거한 워킹셋 확보
					List<Integer> tempWorkingSet = new ArrayList<Integer>();
					for(int j = 0 ; j < i ; j++){
						if(!tempWorkingSet.contains(inputList.get(j))){
							tempWorkingSet.add(inputList.get(j));
						}
					}
					
					// 워킹셋에서 가장 사용안한 인덱스를 찾는다.
					for(int j = 0 ; j < tempWorkingSet.size() ; j ++){
						int currentCnt = 0;
						for(int k = 0 ; k < i ; k ++){
							if(tempWorkingSet.get(j) == inputList.get(k)){
								// 워킹셋 별 사용 횟수를 카운트하여 현재카운트에 기록한다.
								currentCnt ++;
							}
						}
						
						if(j == 0){
							// 첫번째 워킹셋은 무조건 현재카운트를 무조건 최저카운트로 세팅
							lowCnt = currentCnt;
						}else{
							// 첫번째 워킹셋 이후부터 현재카운트와 최저카운트를 비교
							if(lowCnt > currentCnt){
								// 현재 워킹셋이 가장 최저 카운트이고 페이지 리스트에도 존재한다면,
								if(pageList.indexOf(tempWorkingSet.get(j)) != -1){
									// 교체 인덱스를 얻고, 현재 카운트를 최저카운트로 기록한다.
									indexToBeReplaced = inputList.indexOf(tempWorkingSet.get(j));
									lowCnt = currentCnt;																	
								}
							}
						}
					}
					// 교체인덱스를 갖고 현재 인덱스와 페이지 교체
					pageList.set(pageList.indexOf(inputList.get(indexToBeReplaced)), inputList.get(i));						
				}				
			}else{
				if(pageList.contains(inputList.get(i))){
					// 추가안함
				}else{
					// 추가
					pageList.add(inputList.get(i));
				}
			}
			System.out.print(i + " 번째 입력 후 페이지리스트: [");
			for(Integer pageItem : pageList){
				System.out.print(pageItem);
			}
			System.out.println("]");
		}
		
		
	}
}
