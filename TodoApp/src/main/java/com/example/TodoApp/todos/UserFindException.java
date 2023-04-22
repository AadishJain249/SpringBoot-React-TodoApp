package com.example.TodoApp.todos;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class UserFindException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserFindException(String message)
	{
		super(message);
	}

}
