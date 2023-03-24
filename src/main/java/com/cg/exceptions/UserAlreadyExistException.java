package com.cg.exceptions;

public class UserAlreadyExistException extends RuntimeException {
	public UserAlreadyExistException(String str) {
		super(str);
	}

}
