package com.editor.shippingdelivery.main.serviceablity.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class AvailableCourierCompaniesItem{

	@SerializedName("is_rto_address_available")
	private boolean isRtoAddressAvailable;

	@SerializedName("rating")
	private double rating;

	@SerializedName("air_max_weight")
	private String airMaxWeight;

	@SerializedName("qc_courier")
	private double qcCourier;

	@SerializedName("rto_charges")
	private double rtoCharges;

	@SerializedName("coverage_charges")
	private double coverageCharges;

	@SerializedName("base_weight")
	private String baseWeight;

	@SerializedName("mode")
	private double mode;

	@SerializedName("pickup_performance")
	private double pickupPerformance;

	@SerializedName("realtime_tracking")
	private String realtimeTracking;

	@SerializedName("is_custom_rate")
	private double isCustomRate;

	@SerializedName("pickup_supress_hours")
	private double pickupSupressHours;

	@SerializedName("etd")
	private String etd;

	@SerializedName("rank")
	private String rank;

	@SerializedName("id")
	private double id;

	@SerializedName("state")
	private String state;

	@SerializedName("courier_type")
	private String courierType;

	@SerializedName("edd")
	private String edd;

	@SerializedName("estimated_delivery_days")
	private String estimatedDeliveryDays;

	@SerializedName("postcode")
	private String postcode;

	@SerializedName("is_hyperlocal")
	private boolean isHyperlocal;

	@SerializedName("entry_tax")
	private double entryTax;

	@SerializedName("charge_weight")
	private double chargeWeight;

	@SerializedName("surface_max_weight")
	private String surfaceMaxWeight;

	@SerializedName("delivery_performance")
	private double deliveryPerformance;

	@SerializedName("metro")
	private double metro;

	@SerializedName("pickup_availability")
	private double pickupAvailability;

	@SerializedName("region")
	private double region;

	@SerializedName("weight_cases")
	private double weightCases;

	@SerializedName("cutoff_time")
	private String cutoffTime;

	@SerializedName("city")
	private String city;

	@SerializedName("description")
	private String description;

	@SerializedName("odablock")
	private boolean odablock;

	@SerializedName("suppress_text")
	private String suppressText;

	@SerializedName("call_before_delivery")
	private String callBeforeDelivery;

	@SerializedName("courier_name")
	private String courierName;

	@SerializedName("blocked")
	private double blocked;

	@SerializedName("rate")
	private double rate;

	@SerializedName("assured_amount")
	private double assuredAmount;

	@SerializedName("cod_multiplier")
	private double codMultiplier;

	@SerializedName("other_charges")
	private double otherCharges;

	@SerializedName("cod_charges")
	private double codCharges;

	@SerializedName("min_weight")
	private double minWeight;

	@SerializedName("courier_company_id")
	private int courierCompanyId;

	@SerializedName("cost")
	private String cost;

	@SerializedName("etd_hours")
	private double etdHours;

	@SerializedName("suppress_date")
	private String suppressDate;

//	@SerializedName("suppression_dates")
//	private SuppressionDates suppressionDates;

	@SerializedName("rto_performance")
	private double rtoPerformance;

	@SerializedName("is_surface")
	private boolean isSurface;

	@SerializedName("local_region")
	private double localRegion;

	@SerializedName("pickup_priority")
	private String pickupPriority;

	@SerializedName("freight_charge")
	private double freightCharge;

	@SerializedName("delivery_boy_contact")
	private String deliveryBoyContact;

	@SerializedName("seconds_left_for_pickup")
	private double secondsLeftForPickup;

	@SerializedName("cod")
	private double cod;

	@SerializedName("is_international")
	private double isInternational;

	@SerializedName("pod_available")
	private String podAvailable;

	@SerializedName("tracking_performance")
	private double trackingPerformance;

	@SerializedName("volumetric_max_weight")
	private double volumetricMaxWeight;

	public void setIsRtoAddressAvailable(boolean isRtoAddressAvailable){
		this.isRtoAddressAvailable = isRtoAddressAvailable;
	}

	public boolean isIsRtoAddressAvailable(){
		return isRtoAddressAvailable;
	}

	public void setRating(double rating){
		this.rating = rating;
	}

	public double getRating(){
		return rating;
	}

	public void setAirMaxWeight(String airMaxWeight){
		this.airMaxWeight = airMaxWeight;
	}

	public String getAirMaxWeight(){
		return airMaxWeight;
	}

	public void setQcCourier(double qcCourier){
		this.qcCourier = qcCourier;
	}

	public double getQcCourier(){
		return qcCourier;
	}

	public void setRtoCharges(double rtoCharges){
		this.rtoCharges = rtoCharges;
	}

	public double getRtoCharges(){
		return rtoCharges;
	}

	public void setCoverageCharges(double coverageCharges){
		this.coverageCharges = coverageCharges;
	}

	public double getCoverageCharges(){
		return coverageCharges;
	}

	public void setBaseWeight(String baseWeight){
		this.baseWeight = baseWeight;
	}

	public String getBaseWeight(){
		return baseWeight;
	}

	public void setMode(double mode){
		this.mode = mode;
	}

	public double getMode(){
		return mode;
	}

	public void setPickupPerformance(double pickupPerformance){
		this.pickupPerformance = pickupPerformance;
	}

	public double getPickupPerformance(){
		return pickupPerformance;
	}

	public void setRealtimeTracking(String realtimeTracking){
		this.realtimeTracking = realtimeTracking;
	}

	public String getRealtimeTracking(){
		return realtimeTracking;
	}

	public void setIsCustomRate(double isCustomRate){
		this.isCustomRate = isCustomRate;
	}

	public double getIsCustomRate(){
		return isCustomRate;
	}

	public void setPickupSupressHours(double pickupSupressHours){
		this.pickupSupressHours = pickupSupressHours;
	}

	public double getPickupSupressHours(){
		return pickupSupressHours;
	}

	public void setEtd(String etd){
		this.etd = etd;
	}

	public String getEtd(){
		return etd;
	}

	public void setRank(String rank){
		this.rank = rank;
	}

	public String getRank(){
		return rank;
	}

	public void setId(double id){
		this.id = id;
	}

	public double getId(){
		return id;
	}

	public void setState(String state){
		this.state = state;
	}

	public String getState(){
		return state;
	}

	public void setCourierType(String courierType){
		this.courierType = courierType;
	}

	public String getCourierType(){
		return courierType;
	}

	public void setEdd(String edd){
		this.edd = edd;
	}

	public String getEdd(){
		return edd;
	}

	public void setEstimatedDeliveryDays(String estimatedDeliveryDays){
		this.estimatedDeliveryDays = estimatedDeliveryDays;
	}

	public String getEstimatedDeliveryDays(){
		return estimatedDeliveryDays;
	}

	public void setPostcode(String postcode){
		this.postcode = postcode;
	}

	public String getPostcode(){
		return postcode;
	}

	public void setIsHyperlocal(boolean isHyperlocal){
		this.isHyperlocal = isHyperlocal;
	}

	public boolean isIsHyperlocal(){
		return isHyperlocal;
	}

	public void setEntryTax(double entryTax){
		this.entryTax = entryTax;
	}

	public double getEntryTax(){
		return entryTax;
	}

	public void setChargeWeight(double chargeWeight){
		this.chargeWeight = chargeWeight;
	}

	public double getChargeWeight(){
		return chargeWeight;
	}

	public void setSurfaceMaxWeight(String surfaceMaxWeight){
		this.surfaceMaxWeight = surfaceMaxWeight;
	}

	public String getSurfaceMaxWeight(){
		return surfaceMaxWeight;
	}

	public void setDeliveryPerformance(double deliveryPerformance){
		this.deliveryPerformance = deliveryPerformance;
	}

	public double getDeliveryPerformance(){
		return deliveryPerformance;
	}

	public void setMetro(double metro){
		this.metro = metro;
	}

	public double getMetro(){
		return metro;
	}

	public void setPickupAvailability(double pickupAvailability){
		this.pickupAvailability = pickupAvailability;
	}

	public double getPickupAvailability(){
		return pickupAvailability;
	}

	public void setRegion(double region){
		this.region = region;
	}

	public double getRegion(){
		return region;
	}

	public void setWeightCases(double weightCases){
		this.weightCases = weightCases;
	}

	public double getWeightCases(){
		return weightCases;
	}

	public void setCutoffTime(String cutoffTime){
		this.cutoffTime = cutoffTime;
	}

	public String getCutoffTime(){
		return cutoffTime;
	}

	public void setCity(String city){
		this.city = city;
	}

	public String getCity(){
		return city;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setOdablock(boolean odablock){
		this.odablock = odablock;
	}

	public boolean isOdablock(){
		return odablock;
	}

	public void setSuppressText(String suppressText){
		this.suppressText = suppressText;
	}

	public String getSuppressText(){
		return suppressText;
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

	public void setBlocked(double blocked){
		this.blocked = blocked;
	}

	public double getBlocked(){
		return blocked;
	}

	public void setRate(double rate){
		this.rate = rate;
	}

	public double getRate(){
		return rate;
	}

	public void setAssuredAmount(double assuredAmount){
		this.assuredAmount = assuredAmount;
	}

	public double getAssuredAmount(){
		return assuredAmount;
	}

	public void setCodMultiplier(double codMultiplier){
		this.codMultiplier = codMultiplier;
	}

	public double getCodMultiplier(){
		return codMultiplier;
	}

	public void setOtherCharges(double otherCharges){
		this.otherCharges = otherCharges;
	}

	public double getOtherCharges(){
		return otherCharges;
	}

	public void setCodCharges(double codCharges){
		this.codCharges = codCharges;
	}

	public double getCodCharges(){
		return codCharges;
	}

	public void setMinWeight(double minWeight){
		this.minWeight = minWeight;
	}

	public double getMinWeight(){
		return minWeight;
	}

	public void setCourierCompanyId(int courierCompanyId){
		this.courierCompanyId = courierCompanyId;
	}

	public int getCourierCompanyId(){
		return courierCompanyId;
	}

	public void setCost(String cost){
		this.cost = cost;
	}

	public String getCost(){
		return cost;
	}

	public void setEtdHours(double etdHours){
		this.etdHours = etdHours;
	}

	public double getEtdHours(){
		return etdHours;
	}

	public void setSuppressDate(String suppressDate){
		this.suppressDate = suppressDate;
	}

	public String getSuppressDate(){
		return suppressDate;
	}

//	public void setSuppressionDates(SuppressionDates suppressionDates){
//		this.suppressionDates = suppressionDates;
//	}
//
//	public SuppressionDates getSuppressionDates(){
//		return suppressionDates;
//	}

	public void setRtoPerformance(double rtoPerformance){
		this.rtoPerformance = rtoPerformance;
	}

	public double getRtoPerformance(){
		return rtoPerformance;
	}

	public void setIsSurface(boolean isSurface){
		this.isSurface = isSurface;
	}

	public boolean isIsSurface(){
		return isSurface;
	}

	public void setLocalRegion(double localRegion){
		this.localRegion = localRegion;
	}

	public double getLocalRegion(){
		return localRegion;
	}

	public void setPickupPriority(String pickupPriority){
		this.pickupPriority = pickupPriority;
	}

	public String getPickupPriority(){
		return pickupPriority;
	}

	public void setFreightCharge(double freightCharge){
		this.freightCharge = freightCharge;
	}

	public double getFreightCharge(){
		return freightCharge;
	}

	public void setDeliveryBoyContact(String deliveryBoyContact){
		this.deliveryBoyContact = deliveryBoyContact;
	}

	public String getDeliveryBoyContact(){
		return deliveryBoyContact;
	}

	public void setSecondsLeftForPickup(double secondsLeftForPickup){
		this.secondsLeftForPickup = secondsLeftForPickup;
	}

	public double getSecondsLeftForPickup(){
		return secondsLeftForPickup;
	}

	public void setCod(double cod){
		this.cod = cod;
	}

	public double getCod(){
		return cod;
	}

	public void setIsInternational(double isInternational){
		this.isInternational = isInternational;
	}

	public double getIsInternational(){
		return isInternational;
	}

	public void setPodAvailable(String podAvailable){
		this.podAvailable = podAvailable;
	}

	public String getPodAvailable(){
		return podAvailable;
	}

	public void setTrackingPerformance(double trackingPerformance){
		this.trackingPerformance = trackingPerformance;
	}

	public double getTrackingPerformance(){
		return trackingPerformance;
	}

	public void setVolumetricMaxWeight(double volumetricMaxWeight){
		this.volumetricMaxWeight = volumetricMaxWeight;
	}

	public double getVolumetricMaxWeight(){
		return volumetricMaxWeight;
	}

	@Override
 	public String toString(){
		return 
			"AvailableCourierCompaniesItem{" + 
			"is_rto_address_available = '" + isRtoAddressAvailable + '\'' + 
			",rating = '" + rating + '\'' + 
			",air_max_weight = '" + airMaxWeight + '\'' + 
			",qc_courier = '" + qcCourier + '\'' + 
			",rto_charges = '" + rtoCharges + '\'' + 
			",coverage_charges = '" + coverageCharges + '\'' + 
			",base_weight = '" + baseWeight + '\'' + 
			",mode = '" + mode + '\'' + 
			",pickup_performance = '" + pickupPerformance + '\'' + 
			",realtime_tracking = '" + realtimeTracking + '\'' + 
			",is_custom_rate = '" + isCustomRate + '\'' + 
			",pickup_supress_hours = '" + pickupSupressHours + '\'' + 
			",etd = '" + etd + '\'' + 
			",rank = '" + rank + '\'' + 
			",id = '" + id + '\'' + 
			",state = '" + state + '\'' + 
			",courier_type = '" + courierType + '\'' + 
			",edd = '" + edd + '\'' + 
			",estimated_delivery_days = '" + estimatedDeliveryDays + '\'' + 
			",postcode = '" + postcode + '\'' + 
			",is_hyperlocal = '" + isHyperlocal + '\'' + 
			",entry_tax = '" + entryTax + '\'' + 
			",charge_weight = '" + chargeWeight + '\'' + 
			",surface_max_weight = '" + surfaceMaxWeight + '\'' + 
			",delivery_performance = '" + deliveryPerformance + '\'' + 
			",metro = '" + metro + '\'' + 
			",pickup_availability = '" + pickupAvailability + '\'' + 
			",region = '" + region + '\'' + 
			",weight_cases = '" + weightCases + '\'' + 
			",cutoff_time = '" + cutoffTime + '\'' + 
			",city = '" + city + '\'' + 
			",description = '" + description + '\'' + 
			",odablock = '" + odablock + '\'' + 
			",suppress_text = '" + suppressText + '\'' + 
			",call_before_delivery = '" + callBeforeDelivery + '\'' + 
			",courier_name = '" + courierName + '\'' + 
			",blocked = '" + blocked + '\'' + 
			",rate = '" + rate + '\'' + 
			",assured_amount = '" + assuredAmount + '\'' + 
			",cod_multiplier = '" + codMultiplier + '\'' + 
			",other_charges = '" + otherCharges + '\'' + 
			",cod_charges = '" + codCharges + '\'' + 
			",min_weight = '" + minWeight + '\'' + 
			",courier_company_id = '" + courierCompanyId + '\'' + 
			",cost = '" + cost + '\'' + 
			",etd_hours = '" + etdHours + '\'' + 
			",suppress_date = '" + suppressDate + '\'' + 
//			",suppression_dates = '" + suppressionDates + '\'' +
			",rto_performance = '" + rtoPerformance + '\'' + 
			",is_surface = '" + isSurface + '\'' + 
			",local_region = '" + localRegion + '\'' + 
			",pickup_priority = '" + pickupPriority + '\'' + 
			",freight_charge = '" + freightCharge + '\'' + 
			",delivery_boy_contact = '" + deliveryBoyContact + '\'' + 
			",seconds_left_for_pickup = '" + secondsLeftForPickup + '\'' + 
			",cod = '" + cod + '\'' + 
			",is_international = '" + isInternational + '\'' + 
			",pod_available = '" + podAvailable + '\'' + 
			",tracking_performance = '" + trackingPerformance + '\'' + 
			",volumetric_max_weight = '" + volumetricMaxWeight + '\'' + 
			"}";
		}
}