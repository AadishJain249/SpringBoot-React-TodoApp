package com.example.TodoApp.todos;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class UserFindException extends Exception{
	public UserFindException(String message)
	{
		super(message);
	}

}
