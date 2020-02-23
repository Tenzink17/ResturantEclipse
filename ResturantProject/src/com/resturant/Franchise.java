package com.resturant;

import java.util.LinkedList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

public class Franchise {
	private int franchiseId;
	
	private String franchiseName;
	
	private List<Resturant> listOfResturant;

	public Franchise()
	{
		listOfResturant = new LinkedList<>();
	}
	public Franchise(int franchiseId, String franchiseName, List<Resturant> list) {
		super();
		this.franchiseId = franchiseId;
		this.franchiseName = franchiseName;
		this.listOfResturant = list;
	}

	public int getFranchiseId() {
		return franchiseId;
	}

	public void setFranchiseId(int franchiseId) {
		this.franchiseId = franchiseId;
	}

	public String getFranchiseName() {
		return franchiseName;
	}

	public void setFranchiseName(String franchiseName) {
		this.franchiseName = franchiseName;
	}
		
	public List<Resturant> getListOfResturant() {
		return listOfResturant;
	}
	public void setListOfResturant(List<Resturant> listOfResturant) {
		this.listOfResturant = listOfResturant;
	}
	
	public static JSONObject makeJSONObject(Franchise franchise) {
		JSONObject obj = new JSONObject();
		
		try {
			obj.put("franchiseId", franchise.franchiseId);
			obj.put("franchiseName",franchise.franchiseName);
			obj.put("listOfResturant", franchise.listOfResturant);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	@Override
	public String toString() {
		return "Franchise [franchiseId=" + franchiseId + ", franchiseName=" + franchiseName + ", listOfResturant="
				+ listOfResturant + "]";
	}
	
	
	
	
	
	
	
	
	

}
