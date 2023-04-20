package com.example.TodoApp.todos;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection="TodoList")
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Todo {
	
	
	public Todo(String id, String name, String desc, LocalDate date, Boolean done) {
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.date = date;
		this.done = done;
	}
	
    public static final String SEQUENCE_NAME="Todo-Seq"; // to auto increment documents we need to define this documents specific sequence

	@Id
	String id;
    @NotNull()

	String name;
    @NotNull()
	String desc;
	LocalDate date;
	Boolean done;
	
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDesc() {
		return desc;
	}

	public LocalDate getDate() {
		return date;
	}

	public Boolean isDone() {
		return done;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	@Override
	public String toString() {
		System.out.println();
		return "TodoController [id=" + id + ", name=" + name + ", desc=" + desc + ", date=" + date + ", done=" + done
				+ "]";
	}

}
