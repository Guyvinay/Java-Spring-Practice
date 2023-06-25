package com.masai;

import org.springframework.stereotype.Service;

@Service
public class Calculator {

	public int addition(int a , int b) {
		return a+b;
	}
	public int subtraction(int a , int b) {
		return a-b;
	}
	public int multiplication(int a , int b) {
		return a*b;
	}
	
	public int division(int a , int b) {
		return a/b;
	}
	
}
