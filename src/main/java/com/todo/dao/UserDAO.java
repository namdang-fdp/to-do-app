package com.todo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.todo.model.UserDTO;
import com.todo.utils.DBUtils;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class UserDAO {	
	public boolean createUser(UserDTO user) {	
		Connection con = DBUtils.getConnection();
		String username = user.getUsername();
		boolean cont = checkUsername(username);
		if(cont == true) {
			try {
				String sql = "INSERT INTO users(username, pass, email) VALUES (?,?,?) ";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, user.getUsername());
				byte[] passwordBytes = user.getPassword().getBytes();
				byte[] hashedPassword = BCrypt.withDefaults().hash(12, passwordBytes);
				String hashedPasswordString = new String(hashedPassword);
				//System.out.println(hashedPasswordString);
				stmt.setString(2, hashedPasswordString);
				stmt.setString(3, user.getEmail());
				int rowEffect = stmt.executeUpdate();
				con.close();
				return rowEffect > 0;
			} catch(SQLException e) {
				System.out.println("Something error when connecting to the database. " + e.getMessage());
				e.printStackTrace();
			}
		}
		return false;
	}
	public boolean checkUsername(String username) {
		Connection con = DBUtils.getConnection();
		try {
			String sql = "SELECT username FROM users ";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				if(rs.getString("username").equals(username)) {
					return false;
				}
			}
			con.close();
		} catch(Exception e) {
			System.out.println("Something error when connecting to the database. " + e.getMessage());
			e.printStackTrace();
		}
		return true;
	}
	public int userLogin(UserDTO user) {
		Connection con = DBUtils.getConnection();
		try {
			
			String sql = "SELECT userID, username, pass FROM users WHERE username = ? ";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, user.getUsername());
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				String storedHash = rs.getString("pass");
	            
	            boolean passwordMatches = BCrypt.verifyer()
	                .verify(user.getPassword().getBytes(), storedHash.getBytes())
	                .verified;

				if(passwordMatches && rs.getString("username").equals(user.getUsername())) {
					return rs.getInt("userID");
				}
			}
		} catch(SQLException e) {
			System.out.println("Something error when connecting to the database. (UserDao) " + e.getMessage());
			e.printStackTrace();
		}
		return 0;
	}
}
