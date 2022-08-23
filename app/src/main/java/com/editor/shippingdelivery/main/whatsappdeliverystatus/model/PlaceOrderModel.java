package com.editor.shippingdelivery.main.whatsappdeliverystatus.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.library.baseAdapters.BR;

import com.google.gson.annotations.SerializedName;
/**
 * Created by A.Balachandar on 22/08/22.
 *
 * @author A.Balachandar
 */
public class PlaceOrderModel extends BaseObservable {
    @SerializedName("customerCode")
    private String customerCode="code";
    @SerializedName("invoiceNo")
    private String invoiceNo="iv";
    @SerializedName("messageId")
    private String messageId="mid";
    @SerializedName("mobileNumber")
    private String mobileNumber="919500512853";
    @SerializedName("messageContent")
    private String messageContent="message content";
    private PlaceOrderResponse placeOrderResponse;
    private PlaceOrderRepo placeOrderRepo;

    public PlaceOrderModel() {
        placeOrderRepo = new PlaceOrderRepo();
    }
    public void getPlaceOrderViaWhatsApp(){
        placeOrderRepo.placeOrderSendWhatsApp(this);
    }
    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public PlaceOrderResponse getPlaceOrderResponse() {
        return placeOrderResponse;
    }

    public void setPlaceOrderResponse(PlaceOrderResponse placeOrderResponse) {
        this.placeOrderResponse = placeOrderResponse;
       notifyPropertyChanged(BR.serviceabilityResponse);
    }
}
