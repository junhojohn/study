package com.junhojohn.algorithms.disk;

import java.util.Scanner;

public class SCANDiskSchedulingMain01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input number of data: ");
		int numOfDiskAccessPoint = sc.nextInt();
		numOfDiskAccessPoint+=2;
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
			}else if(i == 1){
				pathMovement[i] = 0;
			}else{
				System.out.println("Input disk access point:");
				diskAccessPoint[i] = sc.nextInt();	
			}
		}
		
		// sort by ascending order
		for(int i = 0 ; i < diskAccessPoint.length ; i ++){
			for(int j = 0 ; j < diskAccessPoint.length-1 ; j ++){
				if(diskAccessPoint[j] > diskAccessPoint[j+1]){
					temp = diskAccessPoint[j]; 
					diskAccessPoint[j] = diskAccessPoint[j+1];
					diskAccessPoint[j+1] = temp;
				}
			}
		}

		// find out current index point
		for(int i = 0 ; i  < diskAccessPoint.length ; i ++){
			if(diskAccessPoint[i] == startPoint){
				indexOfCurrentPoint = i ;
			}
		}
		
		// SCAN Disk Algorithm
		for(int i = indexOfCurrentPoint ; i >= 0 ; i --){
			pathMovement[indexOfCurrentPoint-i] = diskAccessPoint[i];
		}
		for(int i = indexOfCurrentPoint ; i < diskAccessPoint.length-1 ; i++){
			pathMovement[i+1] = diskAccessPoint[i+1];
		}
		for(int i = 0 ; i < pathMovement.length-1 ; i ++){
			if(i < indexOfCurrentPoint){
				totalMovement = totalMovement + (pathMovement[i] - pathMovement[i+1]);				
			}else{
				totalMovement = totalMovement + (pathMovement[i+1] - pathMovement[i]);
			}

		}
		
		// print output
		System.out.println("===========================");
		System.out.print("SCAN Disk Scheduling Priority: [");
		for(int i = 0 ; i < pathMovement.length ; i++){
			System.out.print(pathMovement[i] + " ");
		}
		System.out.println("]");
		System.out.println("SCAN Disk Scheduling Total Movement:" + totalMovement);
		System.out.println("===========================");
		sc.close();
	}

}
