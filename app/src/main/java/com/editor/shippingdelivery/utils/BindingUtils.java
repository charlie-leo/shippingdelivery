package com.editor.shippingdelivery.utils;

import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.editor.shippingdelivery.main.pendingdeliveryorders.adapter.InfoBottomSheetDetailsAdapter;
import com.editor.shippingdelivery.main.pendingdeliveryorders.adapter.PendingDeliveryOrdersAdapter;
import com.editor.shippingdelivery.main.pendingdeliveryorders.model.InfoBottomSheetDetailsModel;
import com.editor.shippingdelivery.main.pendingdeliveryorders.model.PendingOrderHeaderDataModel;
import com.editor.shippingdelivery.main.placeOrder.model.CreateOrderRequest;
import com.editor.shippingdelivery.main.whatsappdeliverystatus.adapter.WhatappInfoBottomSheetDetailsAdapter;
import com.editor.shippingdelivery.main.whatsappdeliverystatus.adapter.WhatsappDeliveryStatusAdapter;
import com.editor.shippingdelivery.main.whatsappdeliverystatus.model.WhatsappInfoBottomSheetDetailsModel;
import com.editor.shippingdelivery.main.whatsappdeliverystatus.model.WhatsappStatusHeaderDataModel;

import java.text.SimpleDateFormat;
import java.util.List;

public class BindingUtils {
    @BindingAdapter("set_pending_delivery_order_list")
    public static void setPendingDeliveryOrdersList(RecyclerView recyclerView, List<PendingOrderHeaderDataModel> pendingOrderHeaderDataModelList) {
        PendingDeliveryOrdersAdapter pendingDeliveryOrdersAdapter = new PendingDeliveryOrdersAdapter(recyclerView.getContext());
        pendingDeliveryOrdersAdapter.setPendingDeliveryOrderList(pendingOrderHeaderDataModelList);
    }

    @BindingAdapter("set_whatsapp_status_delivery_list")
    public static void setWhatsappDeliveryStatusList(RecyclerView recyclerView, List<WhatsappStatusHeaderDataModel> whatsappStatusHeaderDataModelList) {
        WhatsappDeliveryStatusAdapter whatsappDeliveryStatusAdapter = new WhatsappDeliveryStatusAdapter(recyclerView.getContext());
        whatsappDeliveryStatusAdapter.setWhatsappDeliveryStatusList(whatsappStatusHeaderDataModelList);
    }

    @BindingAdapter("set_info_bottom_sheet_whatsapp")
    public static void setInfoBottomSheetDetailsWhatsapp(RecyclerView recyclerView, List<WhatsappInfoBottomSheetDetailsModel> whatsappInfoBottomSheetDetailsModelList) {
        WhatappInfoBottomSheetDetailsAdapter infoBottomSheetDetailsAdapter = new WhatappInfoBottomSheetDetailsAdapter(recyclerView.getContext());
        infoBottomSheetDetailsAdapter.setPendingDeliveryOrderList(whatsappInfoBottomSheetDetailsModelList);
    }

    @BindingAdapter("set_info_bottom_sheet")
    public static void setInfoBottomSheetDetails(RecyclerView recyclerView, List<InfoBottomSheetDetailsModel> infoBottomSheetDetailsModelList) {
        InfoBottomSheetDetailsAdapter infoBottomSheetDetailsAdapter = new InfoBottomSheetDetailsAdapter(recyclerView.getContext());
        infoBottomSheetDetailsAdapter.setPendingDeliveryOrderList(infoBottomSheetDetailsModelList);
    }

    @BindingAdapter("set_date")
    public static void setTimeStampToDate(TextView textView, String timeStamp) {
        if (timeStamp != null) {
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            String date = format.format(Long.parseLong(timeStamp));
            textView.setText(date);
        }
    }

    @BindingAdapter("set_value_with_symbol")
    public static void setValueWithSymbol(TextView textView, String value) {
        if (value != null) {
            StringBuilder stringBuilder = new StringBuilder("₹");
            stringBuilder.append(String.format("%.02f", (Double.parseDouble(value))));
            textView.setText(stringBuilder.toString());
        }
    }

    @BindingAdapter(value = {"doubleEditConverter"})
    public static void doubleEditConverter(EditText view, CreateOrderRequest value) {
        if (value.getLength() > 0) {
            view.setText(String.valueOf(value));
        }
        if (!TextUtils.isEmpty(view.getText().toString())) {
            value.setLength(Double.parseDouble(view.getText().toString()));
        }
    }

}
