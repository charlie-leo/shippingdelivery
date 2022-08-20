package com.editor.shippingdelivery.main.serviceablity.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Data{

	@SerializedName("recommended_courier_company_id")
	private int recommendedCourierCompanyId;

	@SerializedName("shiprocket_recommended_courier_id")
	private int shiprocketRecommendedCourierId;

	@SerializedName("recommended_by")
	private RecommendedBy recommendedBy;

	@SerializedName("available_courier_companies")
	private List<AvailableCourierCompaniesItem> availableCourierCompanies;

	@SerializedName("is_recommendation_enabled")
	private int isRecommendationEnabled;

	public void setRecommendedCourierCompanyId(int recommendedCourierCompanyId){
		this.recommendedCourierCompanyId = recommendedCourierCompanyId;
	}

	public int getRecommendedCourierCompanyId(){
		return recommendedCourierCompanyId;
	}

	public void setShiprocketRecommendedCourierId(int shiprocketRecommendedCourierId){
		this.shiprocketRecommendedCourierId = shiprocketRecommendedCourierId;
	}

	public int getShiprocketRecommendedCourierId(){
		return shiprocketRecommendedCourierId;
	}

	public void setRecommendedBy(RecommendedBy recommendedBy){
		this.recommendedBy = recommendedBy;
	}

	public RecommendedBy getRecommendedBy(){
		return recommendedBy;
	}

	public void setAvailableCourierCompanies(List<AvailableCourierCompaniesItem> availableCourierCompanies){
		this.availableCourierCompanies = availableCourierCompanies;
	}

	public List<AvailableCourierCompaniesItem> getAvailableCourierCompanies(){
		return availableCourierCompanies;
	}

	public void setIsRecommendationEnabled(int isRecommendationEnabled){
		this.isRecommendationEnabled = isRecommendationEnabled;
	}

	public int getIsRecommendationEnabled(){
		return isRecommendationEnabled;
	}

	@Override
 	public String toString(){
		return
			"Data{" +
			"recommended_courier_company_id = '" + recommendedCourierCompanyId + '\'' +
			",shiprocket_recommended_courier_id = '" + shiprocketRecommendedCourierId + '\'' +
			",recommended_by = '" + recommendedBy + '\'' +
			",available_courier_companies = '" + availableCourierCompanies + '\'' +
			",is_recommendation_enabled = '" + isRecommendationEnabled + '\'' +
			"}";
		}
}