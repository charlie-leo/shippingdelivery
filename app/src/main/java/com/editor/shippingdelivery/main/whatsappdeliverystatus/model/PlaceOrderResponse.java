package com.editor.shippingdelivery.main.whatsappdeliverystatus.model;

import com.google.gson.annotations.SerializedName;
/**
 * Created by A.Balachandar on 22/08/22.
 *
 * @author A.Balachandar
 */
public class PlaceOrderResponse {
    @SerializedName("customerCode")
    private String customerCode;
    @SerializedName("dbStatus")
    private String dbStatus;
    @SerializedName("messageId")
    private String messageId;
    @SerializedName("waMessageId")
    private String waMessageId;
    @SerializedName("waStatus")
    private String waStatus;

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getDbStatus() {
        return dbStatus;
    }

    public void setDbStatus(String dbStatus) {
        this.dbStatus = dbStatus;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getWaMessageId() {
        return waMessageId;
    }

    public void setWaMessageId(String waMessageId) {
        this.waMessageId = waMessageId;
    }

    public String getWaStatus() {
        return waStatus;
    }

    public void setWaStatus(String waStatus) {
        this.waStatus = waStatus;
    }
    /*  "customerCode": "CODE",

            "dbStatus": "SUCCESS",

            "messageId": "mid",

            "waMessageId": "wamid.HBgMOTE5NTAwNTEyODUzFQIAERgSQjlBREQyOTNFQkFDMTcxMUExAA==",

            "waStatus": "SEND"*/
}
