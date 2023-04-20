package com.example.TodoApp.todos;
import java.util.List;
import java.util.UUID;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import com.example.TodoApp.Repositry.Repo;

@Service
public class TodoService {
	
	Repo repos;
	
	public TodoService(Repo repos) {
		super();
		this.repos = repos;
	}
	
	// adding task
	public Todo addTask(Todo todo)
	{
		todo.setId(UUID.randomUUID().toString().split("-")[0]);
		return repos.save(todo);
	}
	
	// get all task
	public List<Todo> getTask(Todo todo)
	{
		return repos.findAll();
	}
	
	// update the task
	public Todo updateTask(Todo todo,String id)
	{
		Todo ExistTask =repos.findById(id).get();
		ExistTask.setDesc(todo.getDesc());
		ExistTask.setName(todo.getName());
		ExistTask.setDate(todo.getDate());
		ExistTask.setDone(todo.isDone());
		repos.save(ExistTask);
		return ExistTask;
	}
	
	// delete
	public void deleteTask(String id)
	{
		repos.deleteById(id);
	}
	
}

