package com.editor.shippingdelivery.main.whatsappdeliverystatus.model;

import com.google.gson.annotations.SerializedName;

public class WhatsappDeliveryStatusRequest {
    @SerializedName("cmpCode")
    private String cmpCode="TGBL";

    @SerializedName("distrCode")
    private String distrCode="0000100039";

    @SerializedName("startDate")
    private String startDate="2020-09-25";

    @SerializedName("endDate")
    private String endDate="2020-09-25";
}
