package com.editor.shippingdelivery.main.serviceablity.model;

import com.google.gson.annotations.SerializedName;

public class RecommendedBy{

	@SerializedName("id")
	private int id;

	@SerializedName("title")
	private String title;

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	@Override
 	public String toString(){
		return
			"RecommendedBy{" +
			"id = '" + id + '\'' +
			",title = '" + title + '\'' +
			"}";
		}
}