package com.editor.shippingdelivery.main.whatsappdeliverystatus.listeners;

import android.view.View;

import com.editor.shippingdelivery.main.whatsappdeliverystatus.model.WhatsappStatusHeaderDataModel;

public interface OnListItemClickListener {
    public void onClick(View view, int position);

    public void onClickInfo(View view, String viewName, int position, WhatsappStatusHeaderDataModel whatsappStatusHeaderDataModel);
}
