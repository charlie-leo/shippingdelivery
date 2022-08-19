package com.editor.shippingdelivery.main.serviceablity.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Data{

	@SerializedName("child_courier_id")
	private Object childCourierId;

	@SerializedName("recommended_courier_company_id")
	private int recommendedCourierCompanyId;

	@SerializedName("shiprocket_recommended_courier_id")
	private int shiprocketRecommendedCourierId;

	@SerializedName("recommended_by")
	private RecommendedBy recommendedBy;

	@SerializedName("recommendation_advance_rule")
	private Object recommendationAdvanceRule;

	@SerializedName("available_courier_companies")
	private List<AvailableCourierCompaniesItem> availableCourierCompanies;

	@SerializedName("is_recommendation_enabled")
	private int isRecommendationEnabled;

	public void setChildCourierId(Object childCourierId){
		this.childCourierId = childCourierId;
	}

	public Object getChildCourierId(){
		return childCourierId;
	}

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

	public void setRecommendationAdvanceRule(Object recommendationAdvanceRule){
		this.recommendationAdvanceRule = recommendationAdvanceRule;
	}

	public Object getRecommendationAdvanceRule(){
		return recommendationAdvanceRule;
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
			"child_courier_id = '" + childCourierId + '\'' + 
			",recommended_courier_company_id = '" + recommendedCourierCompanyId + '\'' + 
			",shiprocket_recommended_courier_id = '" + shiprocketRecommendedCourierId + '\'' + 
			",recommended_by = '" + recommendedBy + '\'' + 
			",recommendation_advance_rule = '" + recommendationAdvanceRule + '\'' + 
			",available_courier_companies = '" + availableCourierCompanies + '\'' + 
			",is_recommendation_enabled = '" + isRecommendationEnabled + '\'' + 
			"}";
		}
}