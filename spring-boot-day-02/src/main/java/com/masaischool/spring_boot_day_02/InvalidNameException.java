package com.masaischool.spring_boot_day_02;

public class InvalidNameException extends RuntimeException {
	public InvalidNameException(String message) {
		super(message);
	}
}
