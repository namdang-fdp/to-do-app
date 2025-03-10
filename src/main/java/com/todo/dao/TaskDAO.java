package com.todo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.todo.model.TaskDTO;
import com.todo.utils.DBUtils;

public class TaskDAO {
	public List<TaskDTO> getAllTasks(int userID) {
		List<TaskDTO> tasks = new ArrayList<TaskDTO>();
		try {
			Connection con = DBUtils.getConnection();
			String sql = "SELECT t.id ,t.title, t.description, t.status, t.dueDate " +
						"FROM tasks t JOIN users u ON t.userID = u.userID " + 
						"WHERE u.userID = ? ";	
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, userID);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				tasks.add(new TaskDTO(rs.getInt("id"), rs.getString("title"), 
						rs.getString("description"),rs.getBoolean("status"), rs.getDate("dueDate")));
			}
			con.close();
		} catch(SQLException e) {
			System.out.println("Something error when executing SQL statement (taskDao) " +  e.getMessage());
			e.printStackTrace();
		}
		return tasks;
		
	}
	public boolean createNewTask(TaskDTO task) {
		try {
			Connection con = DBUtils.getConnection();
			String sql = "INSERT INTO tasks(title, description, status, dueDate) VALUES(?, ?, ?, ?) ";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, task.getTitle());
			stmt.setString(2, task.getDescription());
			stmt.setBoolean(3, false);
			stmt.setDate(4, new java.sql.Date(task.getDueDate().getTime()));
			int rowAffected = stmt.executeUpdate();
			con.close();
			return rowAffected > 0;	
		} catch(SQLException e) {
			System.out.println("Something error when executing SQL statement " + e.getMessage());
			e.printStackTrace();
		}
		return false;
	}
	
	public void deleteTask(String taskId) {
		try {
			int taskDeleteId = Integer.parseInt(taskId);
			Connection con = DBUtils.getConnection();
			String sql = "DELETE FROM tasks WHERE id = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, taskDeleteId);
			stmt.execute();
			con.close();
		} catch (SQLException e) {
			System.out.println("Something error when executing SQL statement " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public TaskDTO getTaskById(int taskId) {
		TaskDTO returnTaskDTO = new TaskDTO();
		try {
			Connection con = DBUtils.getConnection();
			String sql = "SELECT title, description, dueDate FROM tasks WHERE id = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, taskId);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				returnTaskDTO.setTitle(rs.getString("title"));
				returnTaskDTO.setDescription(rs.getString("description"));
				returnTaskDTO.setDueDate(rs.getDate("dueDate"));
			} else {
				System.out.println("There isn't any task with id " + taskId);
				return null;
			}
			con.close();
		} catch(SQLException e) {
			System.out.println("Something error when executing SQL statement " + e.getMessage());
			e.printStackTrace();
		}
		return returnTaskDTO;
	}




}
