package com.editor.shippingdelivery.main.serviceablity.model;

import com.google.gson.annotations.SerializedName;

public class Rate{

	@SerializedName("zone_international_id")
	private int zoneInternationalId;

	@SerializedName("rate")
	private String rate;

	@SerializedName("weight")
	private String weight;

	@SerializedName("id")
	private int id;

	@SerializedName("plan_id")
	private int planId;

	public void setZoneInternationalId(int zoneInternationalId){
		this.zoneInternationalId = zoneInternationalId;
	}

	public int getZoneInternationalId(){
		return zoneInternationalId;
	}

	public void setRate(String rate){
		this.rate = rate;
	}

	public String getRate(){
		return rate;
	}

	public void setWeight(String weight){
		this.weight = weight;
	}

	public String getWeight(){
		return weight;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setPlanId(int planId){
		this.planId = planId;
	}

	public int getPlanId(){
		return planId;
	}

	@Override
 	public String toString(){
		return 
			"Rate{" + 
			"zone_international_id = '" + zoneInternationalId + '\'' + 
			",rate = '" + rate + '\'' + 
			",weight = '" + weight + '\'' + 
			",id = '" + id + '\'' + 
			",plan_id = '" + planId + '\'' + 
			"}";
		}
}