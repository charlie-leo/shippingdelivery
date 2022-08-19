package com.editor.shippingdelivery.main.serviceablity.model;

import com.google.gson.annotations.SerializedName;

public class ServiceabilityResponse{

	@SerializedName("data")
	private Data data;

	@SerializedName("currency")
	private String currency;

	@SerializedName("status")
	private int status;

	public void setData(Data data){
		this.data = data;
	}

	public Data getData(){
		return data;
	}

	public void setCurrency(String currency){
		this.currency = currency;
	}

	public String getCurrency(){
		return currency;
	}

	public void setStatus(int status){
		this.status = status;
	}

	public int getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"ServiceabilityResponse{" + 
			"data = '" + data + '\'' + 
			",currency = '" + currency + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}