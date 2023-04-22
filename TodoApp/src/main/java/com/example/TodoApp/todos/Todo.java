package com.example.TodoApp.todos;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection="TodoList")
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Todo implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Todo(String id, String name, String desc,String Aim, Boolean done,String date) {
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.Aim=Aim;
		this.done = done;
		this.date=date;
	}
	@Id
//	@JsonProperty("id")
	String id;
	
    @NotNull()
    @NotBlank(message="Name Should Not Be Empty")
    @Size(min=3,message="Name Should Have At Least 3 Characters")
//	@JsonProperty("name")
	String name;
    
    @NotNull()
    @NotBlank(message="Desc Should Not Be Empty")
    @Size(min = 5,message="Desc Should Have At Least 5 Characters")
//	@JsonProperty("desc")
	String desc;
    
    @NotNull()
    @NotBlank(message="Aim Should Not Be Empty")
    @Size(min = 5,message="Aim Should Have At Least 5 Characters")
//    @JsonProperty("Aim")
	String Aim;
    
//    @JsonProperty("done")
	Boolean done;
	
    @JsonFormat(pattern="yyyy-MM-dd",shape=Shape.STRING)
	String date;
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDesc() {
		return desc;
	}

	public String getAim() {
		return Aim;
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

	public void setAim(String Aim) {
		this.Aim = Aim;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", name=" + name + ", desc=" + desc + ", Aim=" + Aim + ", done=" + done + ", date="
				+ date + "]";
	}
	
	
}
