package com.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConfig {

	public static Connection getConnection() throws Exception {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students",
	                "root", "root");
			return con;
		}catch (Exception e) {
		   e.printStackTrace();
		   throw e;
		   //throw new RuntimeException("connection couldn't be established.");
		}
		
	}
}
