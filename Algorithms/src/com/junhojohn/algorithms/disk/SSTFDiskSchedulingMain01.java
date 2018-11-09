package com.junhojohn.algorithms.disk;

import java.util.Scanner;

public class SSTFDiskSchedulingMain01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input number of data: ");
		int numOfDiskAccessPoint = sc.nextInt();
		numOfDiskAccessPoint++;
		System.out.println("Input start disk access point: ");
		int startPoint = sc.nextInt();
		int[] diskAccessPoint = new int[numOfDiskAccessPoint];
		int[] pathMovement = new int[numOfDiskAccessPoint];
		int totalMovement = 0;
		int indexOfCurrentPoint = 0;
		int temp = 0;
		
		// input disk access points
		for(int i = 0 ; i < numOfDiskAccessPoint ; i ++){
			if(i == 0){
				diskAccessPoint[i] = startPoint;
				pathMovement[i] = startPoint;
			}else{
				System.out.println("Input disk access point:");
				diskAccessPoint[i] = sc.nextInt();	
			}
		}
		
		// sort by ascending order
		for(int i = 0 ; i < numOfDiskAccessPoint ; i ++){
			for(int j = 0 ; j < numOfDiskAccessPoint - 1 ; j ++){
				if(diskAccessPoint[j] > diskAccessPoint[j+1]){
					temp = diskAccessPoint[j];
					diskAccessPoint[j] = diskAccessPoint[j+1];
					diskAccessPoint[j+1] = temp;
				}
			}
		}
		
		// find out current index point
		for(int i = 0 ; i < numOfDiskAccessPoint ; i ++){
			if(diskAccessPoint[i] == startPoint){
				indexOfCurrentPoint = i;
			}
		}
		
		if(indexOfCurrentPoint == numOfDiskAccessPoint-1){
			for(int i = numOfDiskAccessPoint-1 ; i > 0 ; i ++){
				totalMovement = totalMovement + (diskAccessPoint[i] - diskAccessPoint[i-1]);
			}
		}else if(indexOfCurrentPoint == 0){
			for(int i = 1 ; i < numOfDiskAccessPoint ; i++){
				totalMovement = totalMovement + (diskAccessPoint[i] - diskAccessPoint[i-1]);
			}
		}else{
			int leftOffset = 0;
			int rightOffset = 0;
			int leftIndex = indexOfCurrentPoint - 1;
			int rightIndex = indexOfCurrentPoint + 1;
			int count = 1;
			
			do{
				// left 인덱스가 -1 이하인 경우
				if(leftIndex < 0){
					rightOffset = diskAccessPoint[rightIndex] - diskAccessPoint[indexOfCurrentPoint]; // 오른쪽 위치의 값 - 현재 위치의 값
					leftOffset = rightOffset + 1;
				}else{
					leftOffset = diskAccessPoint[indexOfCurrentPoint] - diskAccessPoint[leftIndex]; // 현재 위치의 값 - 왼쪽 위치의 값	
				}
				
				// right 인덱스가 배열 크기보다 클 경우
				if(rightIndex >= diskAccessPoint.length){
					leftOffset = diskAccessPoint[indexOfCurrentPoint] - diskAccessPoint[leftIndex]; // 현재 위치의 값 - 왼쪽 위치의 값	
					rightOffset = leftOffset + 1;
				}else{
					rightOffset = diskAccessPoint[rightIndex] - diskAccessPoint[indexOfCurrentPoint]; // 오른쪽 위치의 값 - 현재 위치의 값
				}
				
				if((leftOffset) < rightOffset){
					pathMovement[count] = diskAccessPoint[leftIndex];	// 이동한 경로를 저장
					totalMovement = totalMovement + leftOffset;			// 이동한 경로 계산 결과 저장
					indexOfCurrentPoint = leftIndex;					// 현재 위치를 left로 이동
					leftIndex = leftIndex-1;							// 현재 left 인덱스 -1만큼 이동
					
				}else{
					pathMovement[count] = diskAccessPoint[rightIndex];	// 이동한 경로를 저장
					totalMovement = totalMovement + rightOffset;		// 이동한 경로 계산 결과 저장
					indexOfCurrentPoint = rightIndex;					// 현재 위치를 right로 이동
					rightIndex = rightIndex+1;							// 현재 right 인덱스 +1만큼 이동
				}
				
				++count;
			}while(count < numOfDiskAccessPoint);

		}
		 
		System.out.println("===========================");
		System.out.print("SSTF Disk Scheduling Priority: [");
		for(int i = 0 ; i < numOfDiskAccessPoint ; i++){
			System.out.print(pathMovement[i] + " ");
		}
		System.out.println("]");
		System.out.println("SSTF Disk Scheduling Total Movement:" + totalMovement);
		System.out.println("===========================");
		sc.close();
	}

}
