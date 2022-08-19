package com.editor.shippingdelivery.main.pendingdeliveryorders.listeners;

import android.view.View;

import com.editor.shippingdelivery.main.pendingdeliveryorders.model.PendingOrderHeaderDataModel;

public interface OnListItemClickListener {
    public void onClick(View view, int position);

    public void onClickInfo(View view, String viewName, int position, PendingOrderHeaderDataModel pendingOrderHeaderDataModel);
}
