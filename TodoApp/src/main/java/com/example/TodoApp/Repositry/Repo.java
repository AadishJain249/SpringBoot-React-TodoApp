package com.example.TodoApp.Repositry;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.TodoApp.todos.Todo;

public interface Repo extends MongoRepository<Todo,String>
{
	
}
