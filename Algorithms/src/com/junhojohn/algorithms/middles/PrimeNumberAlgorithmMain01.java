package com.junhojohn.algorithms.middles;

import java.util.Scanner;

public class PrimeNumberAlgorithmMain01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please input number to determine prime number:");
		int inputNumber = sc.nextInt();
		
		for(int i = 2; i <= inputNumber ; i ++){
			if(inputNumber % i == 0){
				if(inputNumber == i){
					System.out.println(inputNumber + " is prime number.");
					break;
				}else{
					System.out.println(inputNumber + " is not prime number.");
					break;
				}
			}
		}
	}

}
