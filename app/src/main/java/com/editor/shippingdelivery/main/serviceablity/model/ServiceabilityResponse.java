package com.editor.shippingdelivery.main.serviceablity.model;

import com.google.gson.annotations.SerializedName;

public class ServiceabilityResponse{

	@SerializedName("data")
	private Data data;

	@SerializedName("covid_zones")
	private CovidZones covidZones;

	@SerializedName("seller_address")
	private SellerAddress sellerAddress;

	@SerializedName("user_insurance_manadatory")
	private boolean userInsuranceManadatory;

	@SerializedName("is_latlong")
	private int isLatlong;

	@SerializedName("dg_courier")
	private int dgCourier;

	@SerializedName("eligible_for_insurance")
	private int eligibleForInsurance;

	@SerializedName("insurace_opted_at_order_creation")
	private boolean insuraceOptedAtOrderCreation;

	@SerializedName("label_generate_type")
	private int labelGenerateType;

	@SerializedName("currency")
	private String currency;

	@SerializedName("company_auto_shipment_insurance_setting")
	private boolean companyAutoShipmentInsuranceSetting;

	@SerializedName("is_allow_templatized_pricing")
	private boolean isAllowTemplatizedPricing;

	@SerializedName("status")
	private int status;

	public void setData(Data data){
		this.data = data;
	}

	public Data getData(){
		return data;
	}

	public void setCovidZones(CovidZones covidZones){
		this.covidZones = covidZones;
	}

	public CovidZones getCovidZones(){
		return covidZones;
	}

	public void setSellerAddress(SellerAddress sellerAddress){
		this.sellerAddress = sellerAddress;
	}

	public SellerAddress getSellerAddress(){
		return sellerAddress;
	}

	public void setUserInsuranceManadatory(boolean userInsuranceManadatory){
		this.userInsuranceManadatory = userInsuranceManadatory;
	}

	public boolean isUserInsuranceManadatory(){
		return userInsuranceManadatory;
	}

	public void setIsLatlong(int isLatlong){
		this.isLatlong = isLatlong;
	}

	public int getIsLatlong(){
		return isLatlong;
	}

	public void setDgCourier(int dgCourier){
		this.dgCourier = dgCourier;
	}

	public int getDgCourier(){
		return dgCourier;
	}

	public void setEligibleForInsurance(int eligibleForInsurance){
		this.eligibleForInsurance = eligibleForInsurance;
	}

	public int getEligibleForInsurance(){
		return eligibleForInsurance;
	}

	public void setInsuraceOptedAtOrderCreation(boolean insuraceOptedAtOrderCreation){
		this.insuraceOptedAtOrderCreation = insuraceOptedAtOrderCreation;
	}

	public boolean isInsuraceOptedAtOrderCreation(){
		return insuraceOptedAtOrderCreation;
	}

	public void setLabelGenerateType(int labelGenerateType){
		this.labelGenerateType = labelGenerateType;
	}

	public int getLabelGenerateType(){
		return labelGenerateType;
	}

	public void setCurrency(String currency){
		this.currency = currency;
	}

	public String getCurrency(){
		return currency;
	}

	public void setCompanyAutoShipmentInsuranceSetting(boolean companyAutoShipmentInsuranceSetting){
		this.companyAutoShipmentInsuranceSetting = companyAutoShipmentInsuranceSetting;
	}

	public boolean isCompanyAutoShipmentInsuranceSetting(){
		return companyAutoShipmentInsuranceSetting;
	}

	public void setIsAllowTemplatizedPricing(boolean isAllowTemplatizedPricing){
		this.isAllowTemplatizedPricing = isAllowTemplatizedPricing;
	}

	public boolean isIsAllowTemplatizedPricing(){
		return isAllowTemplatizedPricing;
	}

	public void setStatus(int status){
		this.status = status;
	}

	public int getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return
			"ServiceabilityResponse{" +
			"data = '" + data + '\'' +
			",covid_zones = '" + covidZones + '\'' +
			",seller_address = '" + sellerAddress + '\'' +
			",user_insurance_manadatory = '" + userInsuranceManadatory + '\'' +
			",is_latlong = '" + isLatlong + '\'' +
			",dg_courier = '" + dgCourier + '\'' +
			",eligible_for_insurance = '" + eligibleForInsurance + '\'' +
			",insurace_opted_at_order_creation = '" + insuraceOptedAtOrderCreation + '\'' +
			",label_generate_type = '" + labelGenerateType + '\'' +
			",currency = '" + currency + '\'' +
			",company_auto_shipment_insurance_setting = '" + companyAutoShipmentInsuranceSetting + '\'' +
			",is_allow_templatized_pricing = '" + isAllowTemplatizedPricing + '\'' +
			",status = '" + status + '\'' +
			"}";
		}
}