package com.resturant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ResturantQueries {

	public ResturantQueries() {
		// TODO Auto-generated constructor stub
	}

	public static List<Resturant> findResturantByName(String name)
	{

		List<Resturant> resturantList = null;
		String query = "SELECT * FROM Restuarant WHERE resturantName = ?";


		try {
			Class.forName(DBSetup.jdbc_driver);
			try(Connection conn = DriverManager.getConnection(DBSetup.dbUrl,DBSetup.dbUsername,DBSetup.dbPassword)){
				PreparedStatement preparedStm = conn.prepareStatement(query);
				preparedStm.setString(1, name);
				preparedStm.execute();
				resturantList = new LinkedList<Resturant>();
				ResultSet rs = preparedStm.executeQuery();
				while (rs.next()) {
					Resturant resturant = new Resturant();
					int id = rs.getInt("resturantId");
					resturant.setResturantId(id);

					String resturantName = rs.getString("resturantName");
					resturant.setResturantName(resturantName);

					int location = rs.getInt("resturantLocation");
					resturant.setResturantLocation(location);

					int franchiseId = rs.getInt("franchiseId");
					resturant.setFranchiseId(franchiseId);

					resturantList.add(resturant);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return resturantList;
	}

	public static Resturant findResturantByLocation(String location)
	{
		Resturant resturant = new Resturant();
		String query = "SELECT * FROM Restuarant WHERE resturantLocation = ?";

		try {
			Class.forName(DBSetup.jdbc_driver);
			try(Connection conn = DriverManager.getConnection(DBSetup.dbUrl,DBSetup.dbUsername,DBSetup.dbPassword)){
				PreparedStatement preparedStm = conn.prepareStatement(query);
				preparedStm.setString(1, location);
				preparedStm.execute();
				ResultSet rs = preparedStm.executeQuery();
				while (rs.next()) {
					int id = rs.getInt("resturantId");
					resturant.setResturantId(id);

					String resturantName = rs.getString("resturantName");
					resturant.setResturantName(resturantName);

					int reslocation = rs.getInt("resturantLocation");
					resturant.setResturantLocation(reslocation);

					int franchiseId = rs.getInt("franchiseId");
					resturant.setFranchiseId(franchiseId);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return resturant;
	}
	
	public static Resturant findResturantClosestToTheLocation(String location)
	{
		Resturant resturant = new Resturant();
		String query = "SELECT * FROM Restuarant WHERE resturantLocation = ?";

		try {
			Class.forName(DBSetup.jdbc_driver);
			try(Connection conn = DriverManager.getConnection(DBSetup.dbUrl,DBSetup.dbUsername,DBSetup.dbPassword)){
				PreparedStatement preparedStm = conn.prepareStatement(query);
				preparedStm.setString(1, location);
				preparedStm.execute();
				ResultSet rs = preparedStm.executeQuery();
				while (rs.next()) {
					int id = rs.getInt("resturantId");
					resturant.setResturantId(id);

					String resturantName = rs.getString("resturantName");
					resturant.setResturantName(resturantName);

					int reslocation = rs.getInt("resturantLocation");
					resturant.setResturantLocation(reslocation);

					int franchiseId = rs.getInt("franchiseId");
					resturant.setFranchiseId(franchiseId);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return resturant;
	}
	
	

	public static List<Resturant> findAllResturant() {
		
		// TODO Auto-generated method stub
		List<Resturant> list = null;
		String query = "SELECT * FROM Restuarant";
		
		try {
			Class.forName(DBSetup.jdbc_driver);
			try(Connection conn = DriverManager.getConnection(DBSetup.dbUrl,DBSetup.dbUsername,DBSetup.dbPassword)){
				PreparedStatement preparedStm = conn.prepareStatement(query);
				preparedStm.execute();
				list = new LinkedList<Resturant>();
				ResultSet rs = preparedStm.executeQuery();
				while (rs.next()) {
					int id = rs.getInt("resturantId");

					String resturantName = rs.getString("resturantName");

					int reslocation = rs.getInt("resturantLocation");

					int franchiseId = rs.getInt("franchiseId");
					
					list.add(new Resturant(id, resturantName, reslocation, franchiseId));
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return list;
	}
}
