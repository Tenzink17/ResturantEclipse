package com.resturant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class FranchiseQueries {


	public static LinkedList<Franchise>getAllFranchise()
	{
		LinkedList<Franchise> franchiseList = new LinkedList<>();
		String query ="SELECT * FROM Franchise";

		try {
			Class.forName(DBSetup.jdbc_driver);
			try(Connection conn = DriverManager.getConnection(DBSetup.dbUrl,DBSetup.dbUsername,DBSetup.dbPassword))
			{
				System.out.println("In db");
				Statement stm = conn.createStatement();
				ResultSet rs = stm.executeQuery(query);
				while(rs.next())
				{
					int id = rs.getInt("franchiseId");
					String name = rs.getString("franchiseName");
//					Franchise fr = new Franchise(id,name);
//					franchiseList.add(fr);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return franchiseList;
	}
	
	public static Franchise findFrachiseByName(String name)
	{
		Franchise fr = null;
		String query ="SELECT * FROM Franchise";

		try {
			Class.forName(DBSetup.jdbc_driver);
			try(Connection conn = DriverManager.getConnection(DBSetup.dbUrl,DBSetup.dbUsername,DBSetup.dbPassword))
			{
				System.out.println("In db");
				Statement stm = conn.createStatement();
				ResultSet rs = stm.executeQuery(query);
				while(rs.next())
				{
					int id = rs.getInt("franchiseId");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return fr;
	}
	
	
	
	
	
}
