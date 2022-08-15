package com.editor.shippingdelivery.main.placeOrder.model;

import com.google.gson.annotations.SerializedName;

public class CreateOrderResponse{

	@SerializedName("status_code")
	private int statusCode;

	@SerializedName("shipment_id")
	private int shipmentId;

	@SerializedName("order_id")
	private int orderId;

	@SerializedName("status")
	private String status;

	public void setStatusCode(int statusCode){
		this.statusCode = statusCode;
	}

	public int getStatusCode(){
		return statusCode;
	}

	public void setShipmentId(int shipmentId){
		this.shipmentId = shipmentId;
	}

	public int getShipmentId(){
		return shipmentId;
	}

	public void setOrderId(int orderId){
		this.orderId = orderId;
	}

	public int getOrderId(){
		return orderId;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}
}