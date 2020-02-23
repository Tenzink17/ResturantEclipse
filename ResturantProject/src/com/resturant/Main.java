package com.resturant;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Main {
	
	public static void main(String [] agrs) throws SQLException, JSONException
	{
//		
//		LinkedList<Resturant> list  = ResturantQueries.findResturantByName("McDonalds");
//		
//		JSONArray arr = Resturant.makeJSONArrayObject(list);
//		
//		System.out.println(arr.toString());
		
		List<Resturant> r = Resturant.findResturantClosest(1);
		Collections.sort(r);
		
		for(Resturant d : r)
		{
			System.out.println(d);
		}
	
//		
//	
//		Iterator<Dish> it = m.getListFood().iterator();
//		
//		
//		while(it.hasNext())
//		{
//			Dish d = it.next();
//			System.out.println(d);
//		}
//		
//		Menu.makeJSONObject(m);
//		
//		
//
//		List<Dish> list = new ArrayList<>();
//		
//		JSONArray array = obj.getJSONArray("listFood");
//		
//		for(int i = 0 ; i < array.length() ; i++){
//			Dish dish = new Dish();
//			dish.setFoodPrice((float)array.getJSONObject(i).getDouble("foodPrice"));
//			dish.setFoodName(array.getJSONObject(i).getString("foodName"));
//			dish.setFoodServedAt(array.getJSONObject(i).getString("foodServedAt"));
//			dish.setDetailCalories((float)array.getJSONObject(i).getDouble("detailCalories"));
//			
//			list.add(dish);
//		}
//		
//		for(Dish d: list)
//		{
//			System.out.println(d);
//		}
//		
//		
//		/
//		
//		if(m!=null)
//		{System.out.println("Helo");
//			JSONObject obj = Menu.makeJSONObject(m);
//			System.out.println(obj.toString()+"\n");
//		}
//		
			
//		Connection conn = DBSetup.getDbConnection();
//		String name = "109";
//		String query = "SELECT * FROM Restuarants.Restuarant WHERE resturantLocation = ?";
//		Resturant resturant = new Resturant();
//		PreparedStatement preparedStm = conn.prepareStatement(query);
//		preparedStm.setString(1, name);
//		preparedStm.execute();
//		ResultSet rs = preparedStm.executeQuery();
//		System.out.println("connected to DB");
//		
//		while (rs.next()) {
//
//			int id = rs.getInt("resturantId");
//			resturant.setResturantId(id);
//			
//			String resturantName = rs.getString("resturantName");
//			resturant.setResturantName(resturantName);
//			
//			String location = rs.getString("resturantLocation");
//			resturant.setResturantLocation(location);
//			
//			int franchiseId = rs.getInt("franchiseId");
//			resturant.setFranchiseId(franchiseId);
//		}
//		
//		System.out.println(resturant.toString());
	}

}

