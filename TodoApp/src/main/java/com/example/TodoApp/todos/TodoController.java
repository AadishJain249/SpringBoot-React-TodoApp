package com.example.TodoApp.todos;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
public class TodoController {
	TodoService service;
	public TodoController(TodoService service) 
	{
		super();
		this.service = service;
	}
	
	// create
	@PostMapping("/add")
	@CrossOrigin(origins = "http://localhost:3000")
	public Todo createTask(@Valid @RequestBody Todo todo)
	{
		return service.addTask(todo);
	}
	// get
	@GetMapping("/getTask")
    @CrossOrigin(origins = "http://localhost:3000")
	public List<Todo> getTask(Todo todo)
	{
		return service.getTask(todo);
	}
	@GetMapping("/getTask/{id}")
	@CrossOrigin(origins = "http://localhost:3000")
	public Todo getTaskById(Todo todo,@PathVariable String id)
	{
		return service.getTakById(todo,id);
	}
	// delete a particular task
	@DeleteMapping("/delete/{id}")
    @CrossOrigin(origins = "http://localhost:3000")

	public Todo deleteTask(@PathVariable String id) throws UserFindException
	{
		 return service.deleteTask(id);
	}
	@PutMapping("/update/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
	public Todo updateTask(@Valid @RequestBody Todo todo,@PathVariable String id) throws UserFindException
	{
		return service.updateTask(todo,id);
	}
}
	