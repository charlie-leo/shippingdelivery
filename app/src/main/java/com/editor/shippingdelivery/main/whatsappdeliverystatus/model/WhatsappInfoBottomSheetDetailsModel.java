package com.editor.shippingdelivery.main.whatsappdeliverystatus.model;

public class WhatsappInfoBottomSheetDetailsModel {
    private String name;
    private String value;

    public WhatsappInfoBottomSheetDetailsModel(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}