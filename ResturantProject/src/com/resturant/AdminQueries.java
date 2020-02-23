package com.resturant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.JSONException;
import org.json.JSONObject;

public class AdminQueries {

	public static int createAFranchise(String name)
	{
		int success = 0;
		String query ="Insert into Restuarants.Franchise (franchiseName) values (?)";

		try {
			Class.forName(DBSetup.jdbc_driver);
			try(Connection conn = DriverManager.getConnection(DBSetup.dbUrl,DBSetup.dbUsername,DBSetup.dbPassword))
			{

				PreparedStatement preparedStm = conn.prepareStatement(query);
				preparedStm.setString(1, name);
				success = preparedStm.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return success;
	}

	public static int closeDownAFranchise(String name)
	{
		//	
		//		int success = 0;
		//		String query ="Insert into Restuarants.Franchise (franchiseName) values (?)";
		//		try(Connection conn = DBSetup.getDbConnection())
		//		{
		//			Class.forName(DBSetup.jdbc_driver);
		//			PreparedStatement preparedStm = conn.prepareStatement(query);
		//			preparedStm.setString(1, name);
		//			success = preparedStm.executeUpdate();
		//			
		//		} catch (SQLException | ClassNotFoundException e) {
		//			// TODO Auto-generated catch block
		//			e.printStackTrace();
		//		}
		return 0;

	}


	public static int closeDownAResturant(String location)
	{



		return 0;
	}


	public static JSONObject LogInAsAdmin(String username, String password)
	{
		JSONObject obj = null;
		String query ="SELECT * FROM Admin";
		String dbUserName = null, dbPassword = null;
		try {
			Class.forName(DBSetup.jdbc_driver);
			try(Connection conn = DriverManager.getConnection(DBSetup.dbUrl,DBSetup.dbUsername,DBSetup.dbPassword))
			{
				System.out.println("In db");
				Statement stm = conn.createStatement();
				ResultSet rs = stm.executeQuery(query);
				while(rs.next())
				{
					dbUserName = rs.getString("username");
					dbPassword= rs.getString("password");
				}
				if(dbUserName.equals(username)&&dbPassword.equals(password)) {
					
					obj = new JSONObject();
					try {
						obj.put("username", "********");
						obj.put("password", "**********");
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
								
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return obj;
	
	}
}