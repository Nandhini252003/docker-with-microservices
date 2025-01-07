package com.example.dept_service.exception;

public class DepartmentNotFoundException extends RuntimeException{
	
	public DepartmentNotFoundException(String msg) {
		super(msg);
	}

}
