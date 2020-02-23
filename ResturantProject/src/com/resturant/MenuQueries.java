package com.resturant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MenuQueries {
	
	public static Menu findAllMenuByResturant(String name)
	{
		Menu menu = null;            // breakfast & lunch & dinner;
		
		String query = "SELECT rm.menuId, rm.resturantId, r.resturantLocation, r.resturantName, rm.food, rm.foodPrice, rm.foodServedAt, rm.detailCalories\r\n" + 
				"FROM ResturantMenu rm\r\n" + 
				"join Restuarant r on rm.resturantId = r.resturantId\r\n" + 
				"where r.resturantName = ?";

		try {
			Class.forName(DBSetup.jdbc_driver);
			
			try(Connection conn = DriverManager.getConnection(DBSetup.dbUrl,DBSetup.dbUsername,DBSetup.dbPassword)){
				menu = new Menu();
				PreparedStatement preparedStm = conn.prepareStatement(query);
				preparedStm.setString(1, name);
				preparedStm.execute();
				ResultSet rs = preparedStm.executeQuery();
				List<Dish> list = menu.getListFood();
				menu.setResturantName(name);
				int location = 0;
				int i = 0;
				while (rs.next()) {
					if(i==0)
					{
						location = rs.getInt("resturantLocation");
						i++;
					}
					String food = rs.getString("food");
					float foodPrice = rs.getFloat("foodPrice");
					float detailCalories = rs.getFloat("detailCalories");
					String foodServedAt = rs.getString("foodServedAt");
					
					list.add(new Dish(food,foodPrice,detailCalories,foodServedAt));
				}
				menu.setResturantLocation(location);

			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return menu;
	}
	
	
	
	public static Menu findAllMenuByLocation(int location)
	{
		Menu menu = null;            // breakfast & lunch & dinner;
		
		String query = "SELECT rm.menuId, rm.resturantId, r.resturantName, rm.food, rm.foodPrice, rm.foodServedAt, rm.detailCalories\r\n" + 
				"FROM ResturantMenu rm\r\n" + 
				"join Restuarant r on rm.resturantId = r.resturantId\r\n" + 
				"where r.resturantLocation = ?";
		try {
			Class.forName(DBSetup.jdbc_driver);
			try(Connection conn = DriverManager.getConnection(DBSetup.dbUrl,DBSetup.dbUsername,DBSetup.dbPassword)){
				menu = new Menu();
				PreparedStatement preparedStm = conn.prepareStatement(query);
				preparedStm.setInt(1, location);
				preparedStm.execute();
				ResultSet rs = preparedStm.executeQuery();
				List<Dish> list = menu.getListFood();
				String name ="";
				int i = 0;
				while (rs.next()) 
				{
					if(i ==0)
					{
						name = rs.getString("resturantName");
						++i;
					}
					
					String food = rs.getString("food");
					float foodPrice = rs.getFloat("foodPrice");
					float detailCalories = rs.getFloat("detaulCalories");
					String foodServedAt = rs.getString("foodServedAt");	
					list.add(new Dish(food,foodPrice,detailCalories,foodServedAt));
				}
				menu.setResturantLocation(location);
				menu.setResturantName(name);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return menu;
	}
	
	public static Menu findMenuServedAt(String resturantName, String servedAt )
	{
		Menu menu = null;            // breakfast or lunch or dinner;
		
		String query = "SELECT rm.menuId, rm.resturantId, r.resturantLocation, r.resturantName, rm.food, rm.foodPrice, rm.foodServedAt, rm.detailCalories  \r\n" + 
				"FROM ResturantMenu rm \r\n" + 
				"join Restuarant r on rm.resturantId = r.resturantId\r\n" + 
				"where r.resturantName = ? && rm.foodServedAt = ?";
		try {
			Class.forName(DBSetup.jdbc_driver);
			try(Connection conn = DriverManager.getConnection(DBSetup.dbUrl,DBSetup.dbUsername,DBSetup.dbPassword)){
				menu = new Menu();
				PreparedStatement preparedStm = conn.prepareStatement(query);
				preparedStm.setString(1, resturantName);
				preparedStm.setString(2, servedAt);
				preparedStm.execute();
				ResultSet rs = preparedStm.executeQuery();
				List<Dish> list = menu.getListFood();
				int location = 0;
				int i = 0;
				while (rs.next()) 
				{
					if(i==0)
					{
						location = rs.getInt("resturantLocation");
						++i;
					}
					String food = rs.getString("food");
					float foodPrice = rs.getFloat("foodPrice");
					float detailCalories = rs.getFloat("detailCalories");
					String foodServedAt = rs.getString("foodServedAt");	
					list.add(new Dish(food,foodPrice,detailCalories,foodServedAt));
				}
				menu.setResturantName(resturantName);
				menu.setResturantLocation(location);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return menu;
	}
	
	public static Menu findMenuByResturantNameAndByCalories(String name, float calories)
	{
		Menu menu = null;          
		
		String query = "SELECT rm.menuId, rm.resturantId, r.resturantName, r.resturantLocation, rm.food, rm.foodPrice, rm.foodServedAt, rm.detailCalories  \r\n" + 
				"FROM ResturantMenu rm \r\n" + 
				"join Restuarant r on rm.resturantId = r.resturantId\r\n" + 
				"where r.resturantName = ? && rm.detailCalories <= ?";
		try {
			Class.forName(DBSetup.jdbc_driver);
			try(Connection conn = DriverManager.getConnection(DBSetup.dbUrl,DBSetup.dbUsername,DBSetup.dbPassword)){
				menu = new Menu();
				PreparedStatement preparedStm = conn.prepareStatement(query);
				preparedStm.setString(1, name);
				preparedStm.setFloat(2, calories);
				preparedStm.execute();
				ResultSet rs = preparedStm.executeQuery();
				int location = 0;
				int i = 0;
				List<Dish> list = menu.getListFood();
				while (rs.next()) 
				{
					if(i==0)
					{
						location = rs.getInt("resturantLocation");
						++i;
					}
					String food = rs.getString("food");
					float foodPrice = rs.getFloat("foodPrice");
					float detailCalories = rs.getFloat("detailCalories");
					String foodServedAt = rs.getString("foodServedAt");	
					list.add(new Dish(food,foodPrice,detailCalories,foodServedAt));
				}
				menu.setResturantName(name);
				menu.setResturantLocation(location);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return menu;
	}
	
	public static Menu findMenuByLocationAndByCalories(int location, float calories)
	{
		Menu menu = null;          
		
		String query = "SELECT rm.menuId, rm.resturantId, r.resturantlocation, r.resturantName, rm.food, rm.foodPrice, rm.foodServedAt, rm.detailCalories  \r\n" + 
				"FROM ResturantMenu rm \r\n" + 
				"join Restuarant r on rm.resturantId = r.resturantId\r\n" + 
				"where r.resturantLocation = ? && rm.detailCalories <= ?";
		try {
			Class.forName(DBSetup.jdbc_driver);
			
			try(Connection conn = DriverManager.getConnection(DBSetup.dbUrl,DBSetup.dbUsername,DBSetup.dbPassword)){
				menu = new Menu();
				PreparedStatement preparedStm = conn.prepareStatement(query);
				preparedStm.setInt(1, location);
				preparedStm.setFloat(2, calories);
				preparedStm.execute();
				ResultSet rs = preparedStm.executeQuery();
				List<Dish> list = menu.getListFood();
				String name = "";
				int i = 0;
				while (rs.next()) 
				{
					if(i==0)
					{
						name = rs.getString("resturantName");
						++i;
					}
					String food = rs.getString("food");
					float foodPrice = rs.getFloat("foodPrice");
					float detailCalories = rs.getFloat("detailCalories");
					String foodServedAt = rs.getString("foodServedAt");	
					list.add(new Dish(food,foodPrice,detailCalories,foodServedAt));
					
				}
				menu.setResturantName(name);
				menu.setResturantLocation(location);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return menu;
	}
}
