package com.junhojohn.algorithms.disk;

import java.util.Scanner;

public class FIFODiskSchedulingMain01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input number of disk access point: ");
		int numOfDiskAccessPoint = sc.nextInt();
		System.out.println("Input start disk access point: ");
		int startPoint = sc.nextInt();
		int[] diskAccessPoint = new int[numOfDiskAccessPoint];
		int totalMovement = 0;
		
		for(int i = 0 ; i < numOfDiskAccessPoint ; i ++){
			System.out.println("Input disk access point:");
			diskAccessPoint[i] = sc.nextInt();
			
			if(i == 0){
				if(startPoint < diskAccessPoint[i]){
					totalMovement = totalMovement + (diskAccessPoint[i] - startPoint);
				}else{
					totalMovement = totalMovement + (startPoint - diskAccessPoint[i]);
				}
			}else{
				if(diskAccessPoint[i-1] < diskAccessPoint[i]){
					totalMovement = totalMovement + (diskAccessPoint[i] - diskAccessPoint[i-1]);
				}else{
					totalMovement = totalMovement + (diskAccessPoint[i-1] - diskAccessPoint[i]);
				}
			}
		}
		
		System.out.println("===========================");
		System.out.print("FIFO Disk Scheduling Priority: [");
		for(int i = 0 ; i < numOfDiskAccessPoint ; i++){
			System.out.print(diskAccessPoint[i] + " ");
		}
		System.out.println("]");
		System.out.println("FIFO Disk Scheduling Total Movement:" + totalMovement);
		System.out.println("===========================");
		sc.close();

	}

}

