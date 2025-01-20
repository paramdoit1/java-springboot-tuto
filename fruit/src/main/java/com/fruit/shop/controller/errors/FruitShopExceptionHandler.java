package com.fruit.shop.controller.errors;

import java.util.NoSuchElementException;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice()
public class FruitShopExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(NoSuchElementException.class)
	ResponseEntity<Object> handleNoResourceFoundException(NoSuchElementException ex){
		ErrorResponse response = new ErrorResponse();
		response.setStatus(HttpStatus.NOT_FOUND);
		response.setMessage("The data does not exists for request: ");
		return buildResponseEntity(response);
	}
	
	private ResponseEntity<Object> buildResponseEntity(ErrorResponse response){
		return new ResponseEntity<Object>(response.getMessage(), response.getStatus());	
	}

}
