package com.junhojohn.algorithms.vm;

import java.util.ArrayList;
import java.util.List;

public class LRUVirtualMemoryReplacementMain01 {

	public static void main(String[] args) {
		int sizeOfPage 						= 3;
		List<Integer> pageList 				= new ArrayList<Integer>();
		List<Integer> inputList 			= new ArrayList<Integer>();
//		inputList.add(2);
//		inputList.add(3);
//		inputList.add(1);
//		inputList.add(3);
//		inputList.add(1);
//		inputList.add(2);
//		inputList.add(4);
//		inputList.add(5);

		inputList.add(0);
		inputList.add(1);
		inputList.add(2);
		inputList.add(3);
		inputList.add(4);
		inputList.add(1);
		inputList.add(3);
		inputList.add(2);
		inputList.add(3);
		inputList.add(4);
		
		for(int i = 0 ; i < inputList.size() ; i ++){
			if(pageList.size() == sizeOfPage){
				if(pageList.contains(inputList.get(i))){
					// 교체는 안함.
				}else{
					// 교체함.
					List<Integer> stack = new ArrayList<Integer>();
					
					// Step1. (i-1)~0번째 까지, Stack에, 참조한 리스트를 제외하고, 중복되지 않게, 순서대로 추가함.
					for(int j = i-1 ; j >= 0 ; j --){
						if(!stack.contains(inputList.get(j))){
							stack.add(inputList.get(j));
						}
						if(stack.size() == sizeOfPage){
							break;
						}
					}
					pageList.set(pageList.indexOf(stack.get(stack.size()-1)), inputList.get(i));							
				}				
			}else{
				if(pageList.contains(inputList.get(i))){
					// 추가는 안함.
				}else{
					// 추가함.
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
