package com.junhojohn.algorithms.middles;

import java.util.Scanner;

public class PrimeNumberAlgorithmMain02 {

	public static void main(String[] args) {
		int sum = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Please input number:");
		int number = sc.nextInt();
		for(int i = 2; i <= number; i++){
			for(int j = 2; j <= i ; j++){
				if(i%j == 0){
					if(i == j){
						System.out.println(i + " is prime number.");
						sum += i;
						break;						
					}else{
						System.out.println(i + " is not prime number.");
						break;						
					}
				}
			}
		}
		System.out.println("sum of prime numbers is " + sum);
	}

}
