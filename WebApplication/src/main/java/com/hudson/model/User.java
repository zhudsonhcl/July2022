package com.hudson.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//MODEL->POJO and your business logic
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User{

	private String username;
	private String password;

	
	public boolean validateUserNamePwd()throws SQLException, ClassNotFoundException{
		Connection con = WebConnection.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from user_data where username=? and password=?");
		ps.setString(1, username);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			return true;
		} else {
			return false;
		}
	}
	
	public void addUser() throws SQLException, ClassNotFoundException{
		Connection con = WebConnection.getConnection();
		PreparedStatement ps = con.prepareStatement("insert into user_data values(?,?)");
		ps.setString(1, username);
		ps.setString(2, password);
		int x = ps.executeUpdate();
	}
	
	public void changePassword() throws SQLException, ClassNotFoundException{
		Connection con = WebConnection.getConnection();
		PreparedStatement ps = con.prepareStatement("update user_data set password=? where username=?");
		ps.setString(1, password);
		ps.setString(2, username);
		ps.execute();
	}
	
	public void deleteUser() throws SQLException, ClassNotFoundException{
		Connection con = WebConnection.getConnection();
		PreparedStatement ps = con.prepareStatement("delete from user_data where username=?");
		ps.setString(1, username);
		ps.execute();
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
}
