package com.cg.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class TransactionExceptionController {
	@ExceptionHandler(value=TransactionNotFoundException.class)
	public ResponseEntity<Object> exceptionHandler(Exception ex)
	{
		return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}

}
