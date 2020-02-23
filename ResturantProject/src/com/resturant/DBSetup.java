package com.resturant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBSetup {
	

	public static String dbUrl = "jdbc:mysql://aws-database.c44byqktlmyn.us-east-2.rds.amazonaws.com:3306/Restuarants?useSSL=false";
	public static Connection conn;
	public static String dbUsername = "admin";
	public static String dbPassword = "admin123";
	public static String jdbc_driver = "com.mysql.cj.jdbc.Driver";
	
	public static Connection getDbConnection()
	{
		
		String dbUrl = "jdbc:mysql://aws-database.c44byqktlmyn.us-east-2.rds.amazonaws.com:3306/Restuarants?useSSL=false";
	
		String dbUsername = "admin";
		String dbPassword = "admin123";
		
		return getConnection(dbUrl,dbUsername,dbPassword);
	}
	
	private static Connection getConnection(String dbUrl2, String dbUsername2,
			String dbPassword2) {
		// TODO Auto-generated method stub
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(dbUrl2,dbUsername2,dbPassword2);
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	

}

