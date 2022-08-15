package com.editor.shippingdelivery.main.placeOrder.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class CreateOrderRequest{

	@SerializedName("shipping_charges")
	private int shippingCharges;

	@SerializedName("billing_last_name")
	private String billingLastName;

	@SerializedName("billing_phone")
	private String billingPhone;

	@SerializedName("giftwrap_charges")
	private int giftwrapCharges;

	@SerializedName("total_discount")
	private int totalDiscount;

	@SerializedName("shipping_state")
	private String shippingState;

	@SerializedName("breadth")
	private int breadth;

	@SerializedName("shipping_city")
	private String shippingCity;

	@SerializedName("shipping_phone")
	private String shippingPhone;

	@SerializedName("billing_customer_name")
	private String billingCustomerName;

	@SerializedName("billing_address")
	private String billingAddress;

	@SerializedName("shipping_address_2")
	private String shippingAddress2;

	@SerializedName("shipping_is_billing")
	private boolean shippingIsBilling;

	@SerializedName("billing_state")
	private String billingState;

	@SerializedName("billing_address_2")
	private String billingAddress2;

	@SerializedName("billing_email")
	private String billingEmail;

	@SerializedName("shipping_address")
	private String shippingAddress;

	@SerializedName("payment_method")
	private String paymentMethod;

	@SerializedName("order_items")
	private List<OrderItemsItem> orderItems;

	@SerializedName("height")
	private int height;

	@SerializedName("pickup_location")
	private String pickupLocation;

	@SerializedName("shipping_customer_name")
	private String shippingCustomerName;

	@SerializedName("billing_country")
	private String billingCountry;

	@SerializedName("length")
	private int length;

	@SerializedName("weight")
	private double weight;

	@SerializedName("order_date")
	private String orderDate;

	@SerializedName("billing_city")
	private String billingCity;

	@SerializedName("shipping_pincode")
	private String shippingPincode;

	@SerializedName("shipping_email")
	private String shippingEmail;

	@SerializedName("billing_pincode")
	private String billingPincode;

	@SerializedName("sub_total")
	private int subTotal;

	@SerializedName("shipping_last_name")
	private String shippingLastName;

	@SerializedName("comment")
	private String comment;

	@SerializedName("order_id")
	private String orderId;

	@SerializedName("channel_id")
	private String channelId;

	@SerializedName("shipping_country")
	private String shippingCountry;

	@SerializedName("transaction_charges")
	private int transactionCharges;

	public void setShippingCharges(int shippingCharges){
		this.shippingCharges = shippingCharges;
	}

	public int getShippingCharges(){
		return shippingCharges;
	}

	public void setBillingLastName(String billingLastName){
		this.billingLastName = billingLastName;
	}

	public String getBillingLastName(){
		return billingLastName;
	}

	public void setBillingPhone(String billingPhone){
		this.billingPhone = billingPhone;
	}

	public String getBillingPhone(){
		return billingPhone;
	}

	public void setGiftwrapCharges(int giftwrapCharges){
		this.giftwrapCharges = giftwrapCharges;
	}

	public int getGiftwrapCharges(){
		return giftwrapCharges;
	}

	public void setTotalDiscount(int totalDiscount){
		this.totalDiscount = totalDiscount;
	}

	public int getTotalDiscount(){
		return totalDiscount;
	}

	public void setShippingState(String shippingState){
		this.shippingState = shippingState;
	}

	public String getShippingState(){
		return shippingState;
	}

	public void setBreadth(int breadth){
		this.breadth = breadth;
	}

	public int getBreadth(){
		return breadth;
	}

	public void setShippingCity(String shippingCity){
		this.shippingCity = shippingCity;
	}

	public String getShippingCity(){
		return shippingCity;
	}

	public void setShippingPhone(String shippingPhone){
		this.shippingPhone = shippingPhone;
	}

	public String getShippingPhone(){
		return shippingPhone;
	}

	public void setBillingCustomerName(String billingCustomerName){
		this.billingCustomerName = billingCustomerName;
	}

	public String getBillingCustomerName(){
		return billingCustomerName;
	}

	public void setBillingAddress(String billingAddress){
		this.billingAddress = billingAddress;
	}

	public String getBillingAddress(){
		return billingAddress;
	}

	public void setShippingAddress2(String shippingAddress2){
		this.shippingAddress2 = shippingAddress2;
	}

	public String getShippingAddress2(){
		return shippingAddress2;
	}

	public void setShippingIsBilling(boolean shippingIsBilling){
		this.shippingIsBilling = shippingIsBilling;
	}

	public boolean isShippingIsBilling(){
		return shippingIsBilling;
	}

	public void setBillingState(String billingState){
		this.billingState = billingState;
	}

	public String getBillingState(){
		return billingState;
	}

	public void setBillingAddress2(String billingAddress2){
		this.billingAddress2 = billingAddress2;
	}

	public String getBillingAddress2(){
		return billingAddress2;
	}

	public void setBillingEmail(String billingEmail){
		this.billingEmail = billingEmail;
	}

	public String getBillingEmail(){
		return billingEmail;
	}

	public void setShippingAddress(String shippingAddress){
		this.shippingAddress = shippingAddress;
	}

	public String getShippingAddress(){
		return shippingAddress;
	}

	public void setPaymentMethod(String paymentMethod){
		this.paymentMethod = paymentMethod;
	}

	public String getPaymentMethod(){
		return paymentMethod;
	}

	public void setOrderItems(List<OrderItemsItem> orderItems){
		this.orderItems = orderItems;
	}

	public List<OrderItemsItem> getOrderItems(){
		return orderItems;
	}

	public void setHeight(int height){
		this.height = height;
	}

	public int getHeight(){
		return height;
	}

	public void setPickupLocation(String pickupLocation){
		this.pickupLocation = pickupLocation;
	}

	public String getPickupLocation(){
		return pickupLocation;
	}

	public void setShippingCustomerName(String shippingCustomerName){
		this.shippingCustomerName = shippingCustomerName;
	}

	public String getShippingCustomerName(){
		return shippingCustomerName;
	}

	public void setBillingCountry(String billingCountry){
		this.billingCountry = billingCountry;
	}

	public String getBillingCountry(){
		return billingCountry;
	}

	public void setLength(int length){
		this.length = length;
	}

	public int getLength(){
		return length;
	}

	public void setWeight(double weight){
		this.weight = weight;
	}

	public double getWeight(){
		return weight;
	}

	public void setOrderDate(String orderDate){
		this.orderDate = orderDate;
	}

	public String getOrderDate(){
		return orderDate;
	}

	public void setBillingCity(String billingCity){
		this.billingCity = billingCity;
	}

	public String getBillingCity(){
		return billingCity;
	}

	public void setShippingPincode(String shippingPincode){
		this.shippingPincode = shippingPincode;
	}

	public String getShippingPincode(){
		return shippingPincode;
	}

	public void setShippingEmail(String shippingEmail){
		this.shippingEmail = shippingEmail;
	}

	public String getShippingEmail(){
		return shippingEmail;
	}

	public void setBillingPincode(String billingPincode){
		this.billingPincode = billingPincode;
	}

	public String getBillingPincode(){
		return billingPincode;
	}

	public void setSubTotal(int subTotal){
		this.subTotal = subTotal;
	}

	public int getSubTotal(){
		return subTotal;
	}

	public void setShippingLastName(String shippingLastName){
		this.shippingLastName = shippingLastName;
	}

	public String getShippingLastName(){
		return shippingLastName;
	}

	public void setComment(String comment){
		this.comment = comment;
	}

	public String getComment(){
		return comment;
	}

	public void setOrderId(String orderId){
		this.orderId = orderId;
	}

	public String getOrderId(){
		return orderId;
	}

	public void setChannelId(String channelId){
		this.channelId = channelId;
	}

	public String getChannelId(){
		return channelId;
	}

	public void setShippingCountry(String shippingCountry){
		this.shippingCountry = shippingCountry;
	}

	public String getShippingCountry(){
		return shippingCountry;
	}

	public void setTransactionCharges(int transactionCharges){
		this.transactionCharges = transactionCharges;
	}

	public int getTransactionCharges(){
		return transactionCharges;
	}
}