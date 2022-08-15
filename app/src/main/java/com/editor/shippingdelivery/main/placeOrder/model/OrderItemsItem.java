package com.editor.shippingdelivery.main.placeOrder.model;

import com.google.gson.annotations.SerializedName;

public class OrderItemsItem{

	@SerializedName("selling_price")
	private String sellingPrice;

	@SerializedName("hsn")
	private int hsn;

	@SerializedName("name")
	private String name;

	@SerializedName("discount")
	private String discount;

	@SerializedName("tax")
	private String tax;

	@SerializedName("units")
	private int units;

	@SerializedName("sku")
	private String sku;

	public void setSellingPrice(String sellingPrice){
		this.sellingPrice = sellingPrice;
	}

	public String getSellingPrice(){
		return sellingPrice;
	}

	public void setHsn(int hsn){
		this.hsn = hsn;
	}

	public int getHsn(){
		return hsn;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setDiscount(String discount){
		this.discount = discount;
	}

	public String getDiscount(){
		return discount;
	}

	public void setTax(String tax){
		this.tax = tax;
	}

	public String getTax(){
		return tax;
	}

	public void setUnits(int units){
		this.units = units;
	}

	public int getUnits(){
		return units;
	}

	public void setSku(String sku){
		this.sku = sku;
	}

	public String getSku(){
		return sku;
	}
}