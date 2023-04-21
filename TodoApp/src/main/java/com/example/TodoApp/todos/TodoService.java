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
	public Todo updateTask(Todo todo,String id) throws UserFindException
	{
		String getid=todo.getId(); // task id and params id 
		if(!getid.equals(id))
		{
			throw new UserFindException("NotFound");
		}
		Todo ExistTask =repos.findById(id).get();
		ExistTask.setDesc(todo.getDesc());
		ExistTask.setName(todo.getName());
		ExistTask.setDate(todo.getDate());
		ExistTask.setDone(todo.isDone());
		repos.save(ExistTask);
		return ExistTask;
	}
	
	// delete
	public Todo deleteTask(String id) throws UserFindException
	{
		Todo userfind=repos.findById(id).get();
		System.out.println(userfind);	
		if(userfind==null)
		{
			throw new UserFindException("notfound");
		}
		repos.deleteById(id);
		return userfind;
	}
	
}

