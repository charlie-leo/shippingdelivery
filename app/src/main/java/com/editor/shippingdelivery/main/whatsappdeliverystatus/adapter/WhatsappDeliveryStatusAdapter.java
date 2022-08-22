package com.editor.shippingdelivery.main.whatsappdeliverystatus.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.editor.shippingdelivery.BR;
import com.editor.shippingdelivery.R;
import com.editor.shippingdelivery.databinding.ListWhatsappDeliveryStatusOrdersBinding;
import com.editor.shippingdelivery.main.placeOrder.PlaceOrderModel;
import com.editor.shippingdelivery.main.whatsappdeliverystatus.listeners.OnListItemClickListener;
import com.editor.shippingdelivery.main.whatsappdeliverystatus.model.WhatsappStatusHeaderDataModel;

import java.util.ArrayList;
import java.util.List;

public class WhatsappDeliveryStatusAdapter extends RecyclerView.Adapter<WhatsappDeliveryStatusAdapter.AdapterViewHolder> {

    Context context;
    List<WhatsappStatusHeaderDataModel> whatsappStatusHeaderDataModelList;
    private OnListItemClickListener onListItemClickListener;

    public WhatsappDeliveryStatusAdapter(Context context, OnListItemClickListener onListItemClickListener) {
        this.context = context;
        this.onListItemClickListener = onListItemClickListener;
        this.whatsappStatusHeaderDataModelList = new ArrayList<>();
    }

    public WhatsappDeliveryStatusAdapter(Context context) {
        this.context = context;
        this.whatsappStatusHeaderDataModelList = new ArrayList<>();
    }


    @NonNull
    @Override
    public AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListWhatsappDeliveryStatusOrdersBinding viewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.list_whatsapp_delivery_status_orders, parent, false);
        return new AdapterViewHolder(viewDataBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterViewHolder holder, int position) {
        holder.bind(position, whatsappStatusHeaderDataModelList.get(position), onListItemClickListener);
    }

    @Override
    public int getItemCount() {
        return whatsappStatusHeaderDataModelList.size();
    }

    public static class AdapterViewHolder extends RecyclerView.ViewHolder {
        private final ListWhatsappDeliveryStatusOrdersBinding viewDataBinding;

        public AdapterViewHolder(@NonNull ListWhatsappDeliveryStatusOrdersBinding viewDataBinding) {
            super(viewDataBinding.getRoot());
            this.viewDataBinding = viewDataBinding;
            viewDataBinding.executePendingBindings();
        }

        public void bind(int position, WhatsappStatusHeaderDataModel whatsappStatusHeaderDataModel, OnListItemClickListener onListItemClickListener) {
            viewDataBinding.setVariable(BR.headerModels, whatsappStatusHeaderDataModel);
            viewDataBinding.deliveryBase.setOnClickListener(v -> {
                /*Intent intent = new Intent(v.getContext(), OrderPlacementActivity.class);
                intent.putExtra("orderData", pendingOrderHeaderDataModel);
                v.getContext().startActivity(intent);*/
            });
            viewDataBinding.tvBillInfo.setOnClickListener(view -> {
                onListItemClickListener.onClickInfo(viewDataBinding.tvBillInfo, "Bill Info", position, whatsappStatusHeaderDataModel);
            });

            viewDataBinding.tvCustomerInfo.setOnClickListener(view -> {
                onListItemClickListener.onClickInfo(viewDataBinding.tvCustomerInfo, "Customer Info", position, whatsappStatusHeaderDataModel);
            });

            viewDataBinding.tvRouteInfo.setOnClickListener(view -> {
                onListItemClickListener.onClickInfo(viewDataBinding.tvCustomerInfo, "Route Info", position, whatsappStatusHeaderDataModel);

            });
            viewDataBinding.placeOrderTxt.setOnClickListener(view -> {
                PlaceOrderModel placeOrderModel = new PlaceOrderModel();
                placeOrderModel.setCustomerCode(whatsappStatusHeaderDataModel.getCustomerCode());
                placeOrderModel.setInvoiceNo(whatsappStatusHeaderDataModel.getInvoiceNo());
                placeOrderModel.setMessageId(Double.toString(Math.random()));
                placeOrderModel.setMobileNumber(whatsappStatusHeaderDataModel.getMobileNo());
                placeOrderModel.setMessageContent("");

                onListItemClickListener.onClick(viewDataBinding.placeOrderTxt, position, placeOrderModel);

            });
        }
    }

    public void setWhatsappDeliveryStatusList(List<WhatsappStatusHeaderDataModel> whatsappStatusHeaderDataModels) {
        this.whatsappStatusHeaderDataModelList = whatsappStatusHeaderDataModels;
        notifyDataSetChanged();
    }
}
