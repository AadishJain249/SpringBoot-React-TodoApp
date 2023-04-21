package com.example.TodoApp.Errorhandler;

import java.net.http.HttpHeaders;
import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.example.TodoApp.todos.UserFindException;

@ControllerAdvice
public class ErrorController {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> CustomError(Exception ex,WebRequest request)
	{
		ErrorDetails error=new ErrorDetails(LocalDateTime.now(), ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<ErrorDetails>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(UserFindException.class) // tell the application to use this for whole error exception
	public ResponseEntity<ErrorDetails> UserFindExceptionHandler(Exception ex,WebRequest request)
	{
		ErrorDetails error=new ErrorDetails(LocalDateTime.now(), ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<ErrorDetails>(error,HttpStatus.NOT_FOUND);
	}	

}
