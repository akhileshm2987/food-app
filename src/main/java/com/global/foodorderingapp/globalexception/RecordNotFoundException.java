package com.global.foodorderingapp.globalexception;

public class RecordNotFoundException extends RuntimeException {

	public RecordNotFoundException(String msg) {
		super(msg);
	}
}
