package com.editor.shippingdelivery.main.placeOrder.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class CreateOrderResponse implements Parcelable {

	@SerializedName("status_code")
	private String statusCode;

	@SerializedName("shipment_id")
	private String shipmentId;

	@SerializedName("order_id")
	private String orderId;

	@SerializedName("status")
	private String status;

	@SerializedName("invoice_id")
	private String invoiceId;


	protected CreateOrderResponse(Parcel in) {
		statusCode = in.readString();
		shipmentId = in.readString();
		orderId = in.readString();
		status = in.readString();
		invoiceId = in.readString();
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

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getShipmentId() {
		return shipmentId;
	}

	public void setShipmentId(String shipmentId) {
		this.shipmentId = shipmentId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeString(statusCode);
		parcel.writeString(shipmentId);
		parcel.writeString(orderId);
		parcel.writeString(status);
		parcel.writeString(invoiceId);
	}
}