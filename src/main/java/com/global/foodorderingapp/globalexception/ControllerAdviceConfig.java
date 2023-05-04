package com.global.foodorderingapp.globalexception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class ControllerAdviceConfig {

	@ExceptionHandler(value = RecordNotFoundException.class)
	public ResponseEntity<ItemError> handle() {
		ItemError error = new ItemError(400, "given id not available");
		return new ResponseEntity<ItemError>(error, HttpStatus.NOT_FOUND);
	}

}
