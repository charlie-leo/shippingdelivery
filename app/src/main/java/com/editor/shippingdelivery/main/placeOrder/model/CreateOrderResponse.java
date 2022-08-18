package com.editor.shippingdelivery.main.placeOrder.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class CreateOrderResponse implements Parcelable {

	@SerializedName("status_code")
	private int statusCode;

	@SerializedName("shipment_id")
	private int shipmentId;

	@SerializedName("order_id")
	private int orderId;

	@SerializedName("status")
	private String status;

	protected CreateOrderResponse(Parcel in) {
		statusCode = in.readInt();
		shipmentId = in.readInt();
		orderId = in.readInt();
		status = in.readString();
	}

	public static final Creator<CreateOrderResponse> CREATOR = new Creator<CreateOrderResponse>() {
		@Override
		public CreateOrderResponse createFromParcel(Parcel in) {
			return new CreateOrderResponse(in);
		}

		@Override
		public CreateOrderResponse[] newArray(int size) {
			return new CreateOrderResponse[size];
		}
	};

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

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeInt(statusCode);
		parcel.writeInt(shipmentId);
		parcel.writeInt(orderId);
		parcel.writeString(status);
	}
}