package com.junhojohn.algorithms.fundamentals;

import java.util.Scanner;

public class DivisorValueMain01 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please input number to get as divisor : ");
		int divisorNumber = sc.nextInt();
		
		for(int i = 1; i <= divisorNumber ; i ++){
			if(divisorNumber%i == 0){
				// i is divisor member.
				System.out.println(i);
			}
		}
	}

}
