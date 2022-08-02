package com.hudson.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class WebConnection {
	private static WebConnection wc;
	
	private WebConnection() {}
	
	public static WebConnection getInstance() {
		if(wc == null) {
			wc = new WebConnection();
		}
		return wc;
	}
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "root");
		return con;
	}
}
