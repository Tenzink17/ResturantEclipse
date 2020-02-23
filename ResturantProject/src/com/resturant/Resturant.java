package com.resturant;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Resturant implements Comparable<Resturant> {
	
	private int resturantId;
	
	private String resturantName;
	
	private int resturantLocation;
	
	private int franchiseId;
	
	private int distance = 0;
	
	public Resturant() {
		// TODO Auto-generated constructor stub
	}

	public Resturant(int resturantId, String resturantName, int resturantLocation, int franchiseId) {
		super();
		this.resturantId = resturantId;
		this.resturantName = resturantName;
		this.resturantLocation = resturantLocation;
		this.franchiseId = franchiseId;
	}

	public int getResturantId() {
		return resturantId;
	}

	public void setResturantId(int resturantId) {
		this.resturantId = resturantId;
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

	public int getFranchiseId() {
		return franchiseId;
	}

	public void setFranchiseId(int franchiseId) {
		this.franchiseId = franchiseId;
	}
	
	public static JSONObject makeJSONObject(Resturant resturant) {
		
		JSONObject obj = new JSONObject();
		
		try {
			obj.put("franchiseId", resturant.franchiseId);
			obj.put("resturantName", resturant.resturantName);
			obj.put("resturantId", resturant.resturantId);
			obj.put("resturantLocation", resturant.resturantLocation);
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	public static JSONArray makeJSONArrayObject(List<Resturant> linkedlist) {
		// TODO Auto-generated method stub		
		Iterator<Resturant> it = linkedlist.iterator();
		JSONArray arr = new JSONArray();

		while(it.hasNext())
		{
			Resturant res  = it.next();
			JSONObject obj = new JSONObject();
			try {
				obj.put("resturantId", res.getResturantId());
				obj.put("resturantName", res.getResturantName());
				obj.put("resturantLocation", res.getResturantLocation());
				obj.put("franchiseId", res.getFranchiseId());
				obj.put("distance",res.distance);
				arr.put(obj);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return arr;
	}

	
	@Override
	public String toString() {
		return "Resturant [resturantId=" + resturantId + ", resturantName=" + resturantName + ", resturantLocation="
				+ resturantLocation + ", franchiseId=" + franchiseId + ", distance=" + distance + "]";
	}

	public static List<Resturant> findResturantClosest(int location)
	{
		List<Resturant> listOfClosestResturant = ResturantQueries.findAllResturant();
		
		for(int i = 0; i<listOfClosestResturant.size(); i++)
		{
			int k = listOfClosestResturant.get(i).resturantLocation;
			listOfClosestResturant.get(i).distance = Math.abs(location-k);
		}
		Collections.sort(listOfClosestResturant);
		return listOfClosestResturant;
	}

	@Override
	public int compareTo(Resturant r)
	{
			if(distance < r.distance)
				return -1;
			if(distance == r.distance)
				return 0;
			return 1;
	}
	
	


	
	
}
