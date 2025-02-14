package com.todo.model;

import java.util.Date;

public class TaskDTO {
	private int id;
	private String title;
	private String description;
	private boolean status;
	private Date dueDate;
	
	public TaskDTO() {}
	public TaskDTO(int id, String title, boolean status) {
		this.id = id;
		this.title = title;
		this.status = status;
	}
	public TaskDTO(int id, String title, String description, boolean status, Date duedate) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.status = status; 
		this.dueDate = duedate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
}
