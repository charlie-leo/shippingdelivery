package com.editor.shippingdelivery.main.pendingdeliveryorders.listeners;

import android.view.View;

import com.editor.shippingdelivery.main.pendingdeliveryorders.model.PendingOrderHeaderDataModel;
import com.editor.shippingdelivery.main.pickup.model.DeliveryOrdesrHeaderDataModel;

public interface OnListItemClickListener {
    public void onClick(View view, int position);

    public void onClickInfo(View view, String viewName, int position, PendingOrderHeaderDataModel pendingOrderHeaderDataModel);

    public void onClickInfo(View view, String viewName, int position, DeliveryOrdesrHeaderDataModel deliveryOrdesrHeaderDataModel);

}
