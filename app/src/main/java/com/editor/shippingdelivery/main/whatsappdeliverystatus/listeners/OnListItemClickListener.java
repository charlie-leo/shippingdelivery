package com.editor.shippingdelivery.main.whatsappdeliverystatus.listeners;

import android.view.View;

import com.editor.shippingdelivery.main.placeOrder.PlaceOrderModel;
import com.editor.shippingdelivery.main.whatsappdeliverystatus.model.WhatsappStatusHeaderDataModel;

public interface OnListItemClickListener {
    void onClick(View view, int position);

    void onClick(View view, int position, PlaceOrderModel placeOrderModel);

    void onClickInfo(View view, String viewName, int position, WhatsappStatusHeaderDataModel whatsappStatusHeaderDataModel);
}
