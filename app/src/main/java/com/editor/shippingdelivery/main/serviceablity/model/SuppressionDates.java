package com.editor.shippingdelivery.main.serviceablity.model;

import com.google.gson.annotations.SerializedName;

public class SuppressionDates{

	@SerializedName("delivery_delay_to")
	private String deliveryDelayTo;

	@SerializedName("pickup_delay_from")
	private String pickupDelayFrom;

	@SerializedName("delivery_delay_days")
	private String deliveryDelayDays;

	@SerializedName("pickup_delay_by")
	private int pickupDelayBy;

	@SerializedName("action_on")
	private String actionOn;

	@SerializedName("pickup_delay_to")
	private String pickupDelayTo;

	@SerializedName("pickup_delay_days")
	private String pickupDelayDays;

	@SerializedName("delay_remark")
	private String delayRemark;

	@SerializedName("delivery_delay_by")
	private int deliveryDelayBy;

	@SerializedName("delivery_delay_from")
	private String deliveryDelayFrom;

	public void setDeliveryDelayTo(String deliveryDelayTo){
		this.deliveryDelayTo = deliveryDelayTo;
	}

	public String getDeliveryDelayTo(){
		return deliveryDelayTo;
	}

	public void setPickupDelayFrom(String pickupDelayFrom){
		this.pickupDelayFrom = pickupDelayFrom;
	}

	public String getPickupDelayFrom(){
		return pickupDelayFrom;
	}

	public void setDeliveryDelayDays(String deliveryDelayDays){
		this.deliveryDelayDays = deliveryDelayDays;
	}

	public String getDeliveryDelayDays(){
		return deliveryDelayDays;
	}

	public void setPickupDelayBy(int pickupDelayBy){
		this.pickupDelayBy = pickupDelayBy;
	}

	public int getPickupDelayBy(){
		return pickupDelayBy;
	}

	public void setActionOn(String actionOn){
		this.actionOn = actionOn;
	}

	public String getActionOn(){
		return actionOn;
	}

	public void setPickupDelayTo(String pickupDelayTo){
		this.pickupDelayTo = pickupDelayTo;
	}

	public String getPickupDelayTo(){
		return pickupDelayTo;
	}

	public void setPickupDelayDays(String pickupDelayDays){
		this.pickupDelayDays = pickupDelayDays;
	}

	public String getPickupDelayDays(){
		return pickupDelayDays;
	}

	public void setDelayRemark(String delayRemark){
		this.delayRemark = delayRemark;
	}

	public String getDelayRemark(){
		return delayRemark;
	}

	public void setDeliveryDelayBy(int deliveryDelayBy){
		this.deliveryDelayBy = deliveryDelayBy;
	}

	public int getDeliveryDelayBy(){
		return deliveryDelayBy;
	}

	public void setDeliveryDelayFrom(String deliveryDelayFrom){
		this.deliveryDelayFrom = deliveryDelayFrom;
	}

	public String getDeliveryDelayFrom(){
		return deliveryDelayFrom;
	}

	@Override
 	public String toString(){
		return 
			"SuppressionDates{" + 
			"delivery_delay_to = '" + deliveryDelayTo + '\'' + 
			",pickup_delay_from = '" + pickupDelayFrom + '\'' + 
			",delivery_delay_days = '" + deliveryDelayDays + '\'' + 
			",pickup_delay_by = '" + pickupDelayBy + '\'' + 
			",action_on = '" + actionOn + '\'' + 
			",pickup_delay_to = '" + pickupDelayTo + '\'' + 
			",pickup_delay_days = '" + pickupDelayDays + '\'' + 
			",delay_remark = '" + delayRemark + '\'' + 
			",delivery_delay_by = '" + deliveryDelayBy + '\'' + 
			",delivery_delay_from = '" + deliveryDelayFrom + '\'' + 
			"}";
		}
}