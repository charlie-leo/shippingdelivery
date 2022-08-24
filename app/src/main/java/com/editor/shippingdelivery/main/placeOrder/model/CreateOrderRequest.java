package com.editor.shippingdelivery.main.placeOrder.model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CreateOrderRequest {
    @SerializedName("order_id")
    private String orderId = "";

    @SerializedName("order_date")
    private String orderDate = "";

    @SerializedName("pickup_location")
    private String pickupLocation = "Primary";

    @SerializedName("channel_id")
    private String channelId = "";

    @SerializedName("comment")
    private String comment = "";

    @SerializedName("billing_customer_name")
    private String billingCustomerName = "";

    @SerializedName("billing_last_name")
    private String billingLastName = "";

    @SerializedName("billing_address")
    private String billingAddress = "";

    @SerializedName("billing_address_2")
    private String billingAddress2 = "";

    @SerializedName("billing_city")
    private String billingCity = "";

    @SerializedName("billing_pincode")
    private String billingPincode = "";

    @SerializedName("billing_state")
    private String billingState = "";

    @SerializedName("billing_country")
    private String billingCountry = "";

    @SerializedName("billing_email")
    private String billingEmail = "";

    @SerializedName("billing_phone")
    private String billingPhone = "";

    @SerializedName("shipping_is_billing")
    private Boolean shippingIsBilling = true;

    @SerializedName("shipping_customer_name")
    private String shippingCustomerName = "";

    @SerializedName("shipping_last_name")
    private String shippingLastName = "";

    @SerializedName("shipping_address")
    private String shippingAddress = "";

    @SerializedName("shipping_address_2")
    private String shippingAddress2 = "";

    @SerializedName("shipping_city")
    private String shippingCity = "";

    @SerializedName("shipping_pincode")
    private String shippingPincode = "";

    @SerializedName("shipping_country")
    private String shippingCountry = "";

    @SerializedName("shipping_state")
    private String shippingState = "";

    @SerializedName("shipping_email")
    private String shippingEmail = "";

    @SerializedName("shipping_phone")
    private String shippingPhone = "";

    @SerializedName("payment_method")
    private String paymentMethod = "";

    @SerializedName("shipping_charges")
    private Integer shippingCharges = 0;

    @SerializedName("giftwrap_charges")
    private Integer giftwrapCharges = 0;

    @SerializedName("transaction_charges")
    private Integer transactionCharges = 0;

    @SerializedName("total_discount")
    private Double totalDiscount = 0.0;

    @SerializedName("sub_total")
    private Double subTotal = 0.0;

    @SerializedName("length")
    private Double length = 0.6;

    @SerializedName("breadth")
    private Double breadth = 0.6;

    @SerializedName("height")
    private Double height = 0.6;

    @SerializedName("weight")
    private Double weight = 0.6;

    @SerializedName("order_items")
    private List<OrderItemsItem> orderItems = new ArrayList<>();

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getBillingCustomerName() {
        return billingCustomerName;
    }

    public void setBillingCustomerName(String billingCustomerName) {
        this.billingCustomerName = billingCustomerName;
    }

    public String getBillingLastName() {
        return billingLastName;
    }

    public void setBillingLastName(String billingLastName) {
        this.billingLastName = billingLastName;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getBillingAddress2() {
        return billingAddress2;
    }

    public void setBillingAddress2(String billingAddress2) {
        this.billingAddress2 = billingAddress2;
    }

    public String getBillingCity() {
        return billingCity;
    }

    public void setBillingCity(String billingCity) {
        this.billingCity = billingCity;
    }

    public String getBillingPincode() {
        return billingPincode;
    }

    public void setBillingPincode(String billingPincode) {
        this.billingPincode = billingPincode;
    }

    public String getBillingState() {
        return billingState;
    }

    public void setBillingState(String billingState) {
        this.billingState = billingState;
    }

    public String getBillingCountry() {
        return billingCountry;
    }

    public void setBillingCountry(String billingCountry) {
        this.billingCountry = billingCountry;
    }

    public String getBillingEmail() {
        return billingEmail;
    }

    public void setBillingEmail(String billingEmail) {
        this.billingEmail = billingEmail;
    }

    public String getBillingPhone() {
        return billingPhone;
    }

    public void setBillingPhone(String billingPhone) {
        this.billingPhone = billingPhone;
    }

    public Boolean getShippingIsBilling() {
        return shippingIsBilling;
    }

    public void setShippingIsBilling(Boolean shippingIsBilling) {
        this.shippingIsBilling = shippingIsBilling;
    }

    public String getShippingCustomerName() {
        return shippingCustomerName;
    }

    public void setShippingCustomerName(String shippingCustomerName) {
        this.shippingCustomerName = shippingCustomerName;
    }

    public String getShippingLastName() {
        return shippingLastName;
    }

    public void setShippingLastName(String shippingLastName) {
        this.shippingLastName = shippingLastName;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getShippingAddress2() {
        return shippingAddress2;
    }

    public void setShippingAddress2(String shippingAddress2) {
        this.shippingAddress2 = shippingAddress2;
    }

    public String getShippingCity() {
        return shippingCity;
    }

    public void setShippingCity(String shippingCity) {
        this.shippingCity = shippingCity;
    }

    public String getShippingPincode() {
        return shippingPincode;
    }

    public void setShippingPincode(String shippingPincode) {
        this.shippingPincode = shippingPincode;
    }

    public String getShippingCountry() {
        return shippingCountry;
    }

    public void setShippingCountry(String shippingCountry) {
        this.shippingCountry = shippingCountry;
    }

    public String getShippingState() {
        return shippingState;
    }

    public void setShippingState(String shippingState) {
        this.shippingState = shippingState;
    }

    public String getShippingEmail() {
        return shippingEmail;
    }

    public void setShippingEmail(String shippingEmail) {
        this.shippingEmail = shippingEmail;
    }

    public String getShippingPhone() {
        return shippingPhone;
    }

    public void setShippingPhone(String shippingPhone) {
        this.shippingPhone = shippingPhone;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Integer getShippingCharges() {
        return shippingCharges;
    }

    public void setShippingCharges(Integer shippingCharges) {
        this.shippingCharges = shippingCharges;
    }

    public Integer getGiftwrapCharges() {
        return giftwrapCharges;
    }

    public void setGiftwrapCharges(Integer giftwrapCharges) {
        this.giftwrapCharges = giftwrapCharges;
    }

    public Integer getTransactionCharges() {
        return transactionCharges;
    }

    public void setTransactionCharges(Integer transactionCharges) {
        this.transactionCharges = transactionCharges;
    }

    public Double getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(double totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getBreadth() {
        return breadth;
    }

    public void setBreadth(Double breadth) {
        this.breadth = breadth;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public List<OrderItemsItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemsItem> orderItems) {
        this.orderItems = orderItems;
    }
}