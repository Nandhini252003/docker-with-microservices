package com.example.dept_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExeptionHandler {
	

	@ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity<String> handleDataNotFoundException(DepartmentNotFoundException ex) {
       
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

}
