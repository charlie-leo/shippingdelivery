package com.editor.shippingdelivery.main.pendingdeliveryorders.model;

import com.google.gson.annotations.SerializedName;

public class PendingDeliveryOrdersRequest {
    @SerializedName("cmpCode")
    private String cmpCode="AMUL";

    @SerializedName("distrCode")
    private String distrCode="000163099";

    @SerializedName("startDate")
    private String startDate="2019-07-30";

    @SerializedName("endDate")
    private String endDate="2020-11-19";
}
