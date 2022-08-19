package com.editor.shippingdelivery.main.serviceablity.model;

import com.google.gson.annotations.SerializedName;

public class AvailableCourierCompaniesItem{

	@SerializedName("courier_company_id")
	private int courierCompanyId;

	@SerializedName("estimated_delivery_days")
	private String estimatedDeliveryDays;

	@SerializedName("etd_hours")
	private int etdHours;

	@SerializedName("rating")
	private int rating;

	@SerializedName("description")
	private String description;

	@SerializedName("first_mile_courier_option")
	private Object firstMileCourierOption;

	@SerializedName("rto_performance")
	private int rtoPerformance;

	@SerializedName("mode")
	private int mode;

	@SerializedName("realtime_tracking")
	private String realtimeTracking;

	@SerializedName("pickup_performance")
	private int pickupPerformance;

	@SerializedName("call_before_delivery")
	private String callBeforeDelivery;

	@SerializedName("courier_name")
	private String courierName;

	@SerializedName("delivery_performance")
	private int deliveryPerformance;

	@SerializedName("delivery_boy_contact")
	private String deliveryBoyContact;

	@SerializedName("blocked")
	private int blocked;

	@SerializedName("etd")
	private String etd;

	@SerializedName("rate")
	private Rate rate;

	@SerializedName("base_courier_id")
	private Object baseCourierId;

	@SerializedName("min_weight")
	private double minWeight;

	@SerializedName("weight_cases")
	private int weightCases;

	@SerializedName("is_international")
	private int isInternational;

	@SerializedName("pod_available")
	private String podAvailable;

	public void setCourierCompanyId(int courierCompanyId){
		this.courierCompanyId = courierCompanyId;
	}

	public int getCourierCompanyId(){
		return courierCompanyId;
	}

	public void setEstimatedDeliveryDays(String estimatedDeliveryDays){
		this.estimatedDeliveryDays = estimatedDeliveryDays;
	}

	public String getEstimatedDeliveryDays(){
		return estimatedDeliveryDays;
	}

	public void setEtdHours(int etdHours){
		this.etdHours = etdHours;
	}

	public int getEtdHours(){
		return etdHours;
	}

	public void setRating(int rating){
		this.rating = rating;
	}

	public int getRating(){
		return rating;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setFirstMileCourierOption(Object firstMileCourierOption){
		this.firstMileCourierOption = firstMileCourierOption;
	}

	public Object getFirstMileCourierOption(){
		return firstMileCourierOption;
	}

	public void setRtoPerformance(int rtoPerformance){
		this.rtoPerformance = rtoPerformance;
	}

	public int getRtoPerformance(){
		return rtoPerformance;
	}

	public void setMode(int mode){
		this.mode = mode;
	}

	public int getMode(){
		return mode;
	}

	public void setRealtimeTracking(String realtimeTracking){
		this.realtimeTracking = realtimeTracking;
	}

	public String getRealtimeTracking(){
		return realtimeTracking;
	}

	public void setPickupPerformance(int pickupPerformance){
		this.pickupPerformance = pickupPerformance;
	}

	public int getPickupPerformance(){
		return pickupPerformance;
	}

	public void setCallBeforeDelivery(String callBeforeDelivery){
		this.callBeforeDelivery = callBeforeDelivery;
	}

	public String getCallBeforeDelivery(){
		return callBeforeDelivery;
	}

	public void setCourierName(String courierName){
		this.courierName = courierName;
	}

	public String getCourierName(){
		return courierName;
	}

	public void setDeliveryPerformance(int deliveryPerformance){
		this.deliveryPerformance = deliveryPerformance;
	}

	public int getDeliveryPerformance(){
		return deliveryPerformance;
	}

	public void setDeliveryBoyContact(String deliveryBoyContact){
		this.deliveryBoyContact = deliveryBoyContact;
	}

	public String getDeliveryBoyContact(){
		return deliveryBoyContact;
	}

	public void setBlocked(int blocked){
		this.blocked = blocked;
	}

	public int getBlocked(){
		return blocked;
	}

	public void setEtd(String etd){
		this.etd = etd;
	}

	public String getEtd(){
		return etd;
	}

	public void setRate(Rate rate){
		this.rate = rate;
	}

	public Rate getRate(){
		return rate;
	}

	public void setBaseCourierId(Object baseCourierId){
		this.baseCourierId = baseCourierId;
	}

	public Object getBaseCourierId(){
		return baseCourierId;
	}

	public void setMinWeight(double minWeight){
		this.minWeight = minWeight;
	}

	public double getMinWeight(){
		return minWeight;
	}

	public void setWeightCases(int weightCases){
		this.weightCases = weightCases;
	}

	public int getWeightCases(){
		return weightCases;
	}

	public void setIsInternational(int isInternational){
		this.isInternational = isInternational;
	}

	public int getIsInternational(){
		return isInternational;
	}

	public void setPodAvailable(String podAvailable){
		this.podAvailable = podAvailable;
	}

	public String getPodAvailable(){
		return podAvailable;
	}

	@Override
 	public String toString(){
		return 
			"AvailableCourierCompaniesItem{" + 
			"courier_company_id = '" + courierCompanyId + '\'' + 
			",estimated_delivery_days = '" + estimatedDeliveryDays + '\'' + 
			",etd_hours = '" + etdHours + '\'' + 
			",rating = '" + rating + '\'' + 
			",description = '" + description + '\'' + 
			",first_mile_courier_option = '" + firstMileCourierOption + '\'' + 
			",rto_performance = '" + rtoPerformance + '\'' + 
			",mode = '" + mode + '\'' + 
			",realtime_tracking = '" + realtimeTracking + '\'' + 
			",pickup_performance = '" + pickupPerformance + '\'' + 
			",call_before_delivery = '" + callBeforeDelivery + '\'' + 
			",courier_name = '" + courierName + '\'' + 
			",delivery_performance = '" + deliveryPerformance + '\'' + 
			",delivery_boy_contact = '" + deliveryBoyContact + '\'' + 
			",blocked = '" + blocked + '\'' + 
			",etd = '" + etd + '\'' + 
			",rate = '" + rate + '\'' + 
			",base_courier_id = '" + baseCourierId + '\'' + 
			",min_weight = '" + minWeight + '\'' + 
			",weight_cases = '" + weightCases + '\'' + 
			",is_international = '" + isInternational + '\'' + 
			",pod_available = '" + podAvailable + '\'' + 
			"}";
		}
}