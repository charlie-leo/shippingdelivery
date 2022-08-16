package com.editor.shippingdelivery.main.pendingdeliveryorders.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.editor.shippingdelivery.R;
import com.editor.shippingdelivery.main.pendingdeliveryorders.PendingDeliveryOrdersActivity;
import com.editor.shippingdelivery.main.pendingdeliveryorders.model.PendingOrderHeaderDataModel;

import java.util.List;

public class PendingDeliveryOrdersAdapter extends RecyclerView.Adapter<PendingDeliveryOrdersAdapter.AdapterViewHolder> {

    Context context;
    List<PendingOrderHeaderDataModel> pendingOrderHeaderDataModelList;
    public PendingDeliveryOrdersAdapter(Context context, List<PendingOrderHeaderDataModel> pendingOrderHeaderDataModelList) {
        this.context = context;
        this.pendingOrderHeaderDataModelList = pendingOrderHeaderDataModelList;
    }

    @NonNull
    @Override
    public AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewDataBinding viewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.list_pending_delivery_orders, parent, false);
        return new AdapterViewHolder(viewDataBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return pendingOrderHeaderDataModelList.size();
    }

    public static class AdapterViewHolder extends RecyclerView.ViewHolder {
        public AdapterViewHolder(@NonNull ViewDataBinding viewDataBinding) {
            super(viewDataBinding.getRoot());
            viewDataBinding.executePendingBindings();
        }
    }
}
