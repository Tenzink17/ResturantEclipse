package com.resturant;

public class Dish {

	private String foodName;
	
	private float foodPrice;
	
	private float detailCalories;
	
	private String foodServedAt;
	
	
	Dish()
	{
		
	}
	public Dish(String foodName, float foodPrice, float detailCalories, String foodServedAt) {
		super();

		this.foodName = foodName;
		this.foodPrice = foodPrice;
		this.detailCalories = detailCalories;
		this.foodServedAt = foodServedAt;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public float getFoodPrice() {
		return foodPrice;
	}

	public void setFoodPrice(float d) {
		this.foodPrice = d;
	}

	public float getDetailCalories() {
		return detailCalories;
	}

	public void setDetailCalories(float detailCalories) {
		this.detailCalories = detailCalories;
	}

	public String getFoodServedAt() {
		return foodServedAt;
	}

	public void setFoodServedAt(String foodServedAt) {
		this.foodServedAt = foodServedAt;
	}

	@Override
	public String toString() {
		return "Dish [foodName=" + foodName + ", foodPrice=" + foodPrice + ", detailCalories=" + detailCalories
				+ ", foodServedAt=" + foodServedAt + "]";
	}

}
