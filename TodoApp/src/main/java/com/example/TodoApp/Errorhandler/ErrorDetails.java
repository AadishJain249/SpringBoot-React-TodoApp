package com.example.TodoApp.Errorhandler;

// error model or u can say it is error properties
import java.time.LocalDateTime;

public class ErrorDetails {
	LocalDateTime time;
	String messgae;
	String details;
	
	public ErrorDetails(LocalDateTime time, String messgae, String details) {
		super();
		this.time = time;
		this.messgae = messgae;
		this.details = details;
	}
	public LocalDateTime getTime() {
		return time;
	}
	public String getMessgae() {
		return messgae;
	}
	public String getDetails() {
		return details;
	}
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	public void setMessgae(String messgae) {
		this.messgae = messgae;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	@Override
	public String toString() {
		return "ErrorDetails [time=" + time + ", messgae=" + messgae + ", details=" + details + "]";
	}
	
}
