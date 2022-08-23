package com.editor.shippingdelivery.main.pickup.model;

import com.google.gson.annotations.SerializedName;

public class DeliveryOrdersRequest {
    @SerializedName("cmpCode")
    private String cmpCode="TGBL";

    @SerializedName("distrCode")
    private String distrCode="0000100039";

    @SerializedName("startDate")
    private String startDate="2019-07-30";

    @SerializedName("endDate")
    private String endDate="2020-11-19";
}
