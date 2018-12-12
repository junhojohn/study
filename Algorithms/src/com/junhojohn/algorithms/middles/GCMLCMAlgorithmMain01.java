package com.junhojohn.algorithms.middles;

import java.util.Scanner;

public class GCMLCMAlgorithmMain01 {

	public static void main(String[] args) {
		int bigNumber = 0;
		int smallNumber = 0;
		int gcm = 0;
		int lcm = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Please input number1 to get GCM :");
		int number1 = sc.nextInt();
		System.out.println("Please input number2 to get GCM :");
		int number2 = sc.nextInt();
		
		if(number1 == number2){
			bigNumber = number1;
			smallNumber = number2;
		}else if(number1 > number2){
			bigNumber = number1;
			smallNumber = number2;
		}else{
			bigNumber = number2;
			smallNumber = number1;
		}
		
			
		while(bigNumber%smallNumber != 0){
			int rest = bigNumber%smallNumber;
			bigNumber = smallNumber;
			smallNumber = rest;
		}
		gcm = smallNumber;
		lcm = (number1 * number2)/gcm;
		
		System.out.println(number1 + "&" + number2 + " GCM is " + gcm);
		System.out.println(number1 + "&" + number2 + " LCM is " + lcm);
	}

}
