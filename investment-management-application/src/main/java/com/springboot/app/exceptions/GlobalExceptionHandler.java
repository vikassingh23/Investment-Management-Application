package com.springboot.app.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	
	@ExceptionHandler({InvalidInputException.class})
	public ResponseEntity<String> handleInvalidArgumentsExceptions(Exception e, WebRequest request) {
		return error(HttpStatus.BAD_REQUEST, e);
	}
	
	@ExceptionHandler(value = {InvestorException.class, FundsException.class})
	public ResponseEntity<String> handleInvestorAndFundsExceptions(Exception e, WebRequest request) {
		return error(HttpStatus.NOT_FOUND, e);
	}
	
	private ResponseEntity<String> error(HttpStatus status, Exception e) {
		return ResponseEntity.status(status).body(e.getMessage());
	}

}
