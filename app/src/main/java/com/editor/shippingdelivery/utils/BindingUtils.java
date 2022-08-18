package com.editor.shippingdelivery.utils;

import android.view.View;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.editor.shippingdelivery.main.pendingdeliveryorders.adapter.PendingDeliveryOrdersAdapter;
import com.editor.shippingdelivery.main.pendingdeliveryorders.model.PendingOrderHeaderDataModel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class BindingUtils {
    @BindingAdapter("set_pending_delivery_order_list")
    public static void setPendingDeliveryOrdersList(RecyclerView recyclerView, List<PendingOrderHeaderDataModel> pendingOrderHeaderDataModelList) {
        PendingDeliveryOrdersAdapter pendingDeliveryOrdersAdapter = new PendingDeliveryOrdersAdapter(recyclerView.getContext());
        pendingDeliveryOrdersAdapter.setPendingDeliveryOrderList(pendingOrderHeaderDataModelList);
    }

    @BindingAdapter("date_convert")
    public static void setPendingDeliveryOrdersList(TextView textView, String timeStamp) {
        if (timeStamp != null) {
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            String date = format.format(timeStamp);
            textView.setText(date);
        }
    }
}
