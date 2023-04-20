package com.example.TodoApp.todos;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {
	TodoService service;
	public TodoController(TodoService service) 
	{
		super();
		this.service = service;
	}
	// create
	@PostMapping("/create")
	public Todo createTask(@RequestBody Todo todo)
	{
		return service.addTask(todo);
	}
	// get
	@GetMapping("/getTask")
	public List<Todo> getTask(Todo todo)
	{
		return service.getTask(todo);
	}
	// delete a particular task
	@DeleteMapping("/delete/{id}")
	public void deleteTask(@PathVariable String id)
	{
		 service.deleteTask(id);
	}
	@PutMapping("/update/{id}")
	public Todo updateTask(@RequestBody Todo todo,@PathVariable String id)
	{
		return service.updateTask(todo,id);
	}
}
	