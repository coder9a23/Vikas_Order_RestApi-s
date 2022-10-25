package com.glearning.order.exception;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@RequestMapping
@Controller
public class GlobalExceptionHeldler {

	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Error handleInvalidOrderId(IllegalArgumentException exception) {
		return new Error(100,exception.getMessage());
	}
}
@AllArgsConstructor
@Getter
class Error{
	private int Id; 
	private String message;
		
}
