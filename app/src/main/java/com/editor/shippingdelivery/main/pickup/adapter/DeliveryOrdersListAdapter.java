package com.editor.shippingdelivery.main.pickup.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.editor.shippingdelivery.BR;
import com.editor.shippingdelivery.R;
import com.editor.shippingdelivery.databinding.ItemDeliveryOrdersBinding;
import com.editor.shippingdelivery.main.pendingdeliveryorders.listeners.OnListItemClickListener;
import com.editor.shippingdelivery.main.pickup.model.DeliveryOrdesrHeaderDataModel;
import com.editor.shippingdelivery.main.placeOrder.OrderPlacementActivity;

import java.util.ArrayList;
import java.util.List;

public class DeliveryOrdersListAdapter extends RecyclerView.Adapter<DeliveryOrdersListAdapter.AdapterViewHolder> {

    private Context context;
    private List<DeliveryOrdesrHeaderDataModel> deliveryOrdesrHeaderDataModelList;
    private OnClickDeliveryListener clickListener;

    public DeliveryOrdersListAdapter(Context context, OnClickDeliveryListener clickListener) {
        this.context = context;
        this.deliveryOrdesrHeaderDataModelList = new ArrayList<>();
        this.clickListener = clickListener;
    }

    public DeliveryOrdersListAdapter(Context context) {
        this.context = context;
        this.deliveryOrdesrHeaderDataModelList = new ArrayList<>();
    }


    @NonNull
    @Override
    public AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemDeliveryOrdersBinding viewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_delivery_orders, parent, false);
        return new AdapterViewHolder(viewDataBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterViewHolder holder, int position) {
        holder.bind(position, deliveryOrdesrHeaderDataModelList.get(position), clickListener);
    }

    @Override
    public int getItemCount() {
        return deliveryOrdesrHeaderDataModelList.size();
    }

    public static class AdapterViewHolder extends RecyclerView.ViewHolder {
        private final ItemDeliveryOrdersBinding viewDataBinding;

        public AdapterViewHolder(@NonNull ItemDeliveryOrdersBinding viewDataBinding) {
            super(viewDataBinding.getRoot());
            this.viewDataBinding = viewDataBinding;
            viewDataBinding.executePendingBindings();
        }

        public void bind(int position, DeliveryOrdesrHeaderDataModel deliveryOrdesrHeaderDataModel, OnClickDeliveryListener onClickDeliveryListener) {
            viewDataBinding.setVariable(BR.headerModel, deliveryOrdesrHeaderDataModel);
           /* viewDataBinding.deliveryBase.setOnClickListener(v -> {

                // TODO : Need To Change the Comment
  *//*              Intent intent = new Intent(v.getContext(), SelectServiceabilityActivity.class);
                intent.putExtra("orderDetails", "248296234");
                v.getContext().startActivity(intent);*//*

                Intent intent = new Intent(v.getContext(), OrderPlacementActivity.class);
                intent.putExtra("orderData", (Parcelable) deliveryOrdesrHeaderDataModel);
                v.getContext().startActivity(intent);
            });*/
/*            viewDataBinding.tvBillInfo.setOnClickListener(view -> {
                onListItemClickListener.onClickInfo(viewDataBinding.tvBillInfo, "Bill Info", position, deliveryOrdesrHeaderDataModel);
            });

            viewDataBinding.tvCustomerInfo.setOnClickListener(view -> {
                onListItemClickListener.onClickInfo(viewDataBinding.tvCustomerInfo, "Customer Info", position, deliveryOrdesrHeaderDataModel);
            });

            viewDataBinding.tvRouteInfo.setOnClickListener(view -> {
                onListItemClickListener.onClickInfo(viewDataBinding.tvCustomerInfo, "Route Info", position, deliveryOrdesrHeaderDataModel);
            });*/
            viewDataBinding.ivCancelDelivery.setOnClickListener(view -> {
                onClickDeliveryListener.onCancelDeliveryClick(position, deliveryOrdesrHeaderDataModel);
            });

            viewDataBinding.ivPickupDelivery.setOnClickListener(view -> {
                onClickDeliveryListener.onPickUpDeliveryClick(position, deliveryOrdesrHeaderDataModel);
            });
        }
    }

    public void setDeliveryOrdersList(List<DeliveryOrdesrHeaderDataModel> deliveryOrdesrHeaderDataModelList) {
        this.deliveryOrdesrHeaderDataModelList = deliveryOrdesrHeaderDataModelList;
        notifyDataSetChanged();
    }

    public interface OnClickDeliveryListener {

        void onCancelDeliveryClick(int position, DeliveryOrdesrHeaderDataModel deliveryOrdesrHeaderDataModel);

        void onPickUpDeliveryClick(int position, DeliveryOrdesrHeaderDataModel deliveryOrdesrHeaderDataModel);
    }
}
