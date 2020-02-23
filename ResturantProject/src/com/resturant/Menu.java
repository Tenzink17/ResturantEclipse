package com.resturant;

import java.util.LinkedList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

public class Menu {
	
	
	private String resturantName;
	
	private List<Dish> listFood;
	
	private int resturantLocation;
	
	public Menu()
	{
		listFood = new LinkedList<Dish>();
	}
	
	
	public List<Dish> getListFood() {
		return listFood;
	}

	public void setListFood(List<Dish> listFood) {
		this.listFood = listFood;
	}


	public String getResturantName() {
		return resturantName;
	}

	public void setResturantName(String resturantName) {
		this.resturantName = resturantName;
	}

	public int getResturantLocation() {
		return resturantLocation;
	}

	public void setResturantLocation(int resturantLocation) {
		this.resturantLocation = resturantLocation;
	}


	public static JSONObject makeJSONObject(Menu m) {
		// TODO Auto-generated method stub
		JSONObject obj = new JSONObject();
		
		try {
			obj.put("listFood", m.listFood);
			obj.put("resturantLocation", m.resturantLocation);
			obj.put("resturantName", m.resturantName);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return obj;
	}

	@Override
	public String toString() {
		return "Menu [resturantName=" + resturantName + ", listFood=" + listFood + ", resturantLocation="
				+ resturantLocation + "]";
	}
	
	
	
	
	
	
}
