package com.example.emp_service.exceptions;

public class DataNotExistsException extends RuntimeException{

	public DataNotExistsException(String msg) {
		super(msg);
	}
}
