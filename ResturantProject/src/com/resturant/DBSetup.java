package com.resturant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBSetup {
	

	public static String dbUrl = "jdbc:mysql://aws-database.c44byqktlmyn.us-east-2.rds.amazonaws.com:3306/Restuarants?useSSL=false";
	public static Connection conn;
	public static String dbUsername = "";				// uninitialized variable
	public static String dbPassword = "";				// uninitialized variable
	public static String jdbc_driver = "com.mysql.cj.jdbc.Driver";
	
	
}

