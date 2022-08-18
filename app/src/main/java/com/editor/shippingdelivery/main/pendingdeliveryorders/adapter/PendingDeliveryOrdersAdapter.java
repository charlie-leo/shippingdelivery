package com.editor.shippingdelivery.main.pendingdeliveryorders.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.library.baseAdapters.BR;
import androidx.recyclerview.widget.RecyclerView;

import com.editor.shippingdelivery.R;
import com.editor.shippingdelivery.databinding.ListPendingDeliveryOrdersBinding;
import com.editor.shippingdelivery.main.pendingdeliveryorders.model.PendingOrderHeaderDataModel;
import com.editor.shippingdelivery.main.placeOrder.OrderPlacementActivity;

import java.util.ArrayList;
import java.util.List;

public class PendingDeliveryOrdersAdapter extends RecyclerView.Adapter<PendingDeliveryOrdersAdapter.AdapterViewHolder> {

    Context context;
    List<PendingOrderHeaderDataModel> pendingOrderHeaderDataModelList;

    public PendingDeliveryOrdersAdapter(Context context, List<PendingOrderHeaderDataModel> pendingOrderHeaderDataModelList) {
        this.context = context;
        this.pendingOrderHeaderDataModelList = pendingOrderHeaderDataModelList;
    }

    public PendingDeliveryOrdersAdapter(Context context) {
        this.context = context;
        this.pendingOrderHeaderDataModelList = new ArrayList<>();
    }


    @NonNull
    @Override
    public AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListPendingDeliveryOrdersBinding viewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.list_pending_delivery_orders, parent, false);
        return new AdapterViewHolder(viewDataBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterViewHolder holder, int position) {
        holder.bind(pendingOrderHeaderDataModelList.get(position));
    }

    @Override
    public int getItemCount() {
        return pendingOrderHeaderDataModelList.size();
    }

    public static class AdapterViewHolder extends RecyclerView.ViewHolder {
        private final ListPendingDeliveryOrdersBinding viewDataBinding;

        public AdapterViewHolder(@NonNull ListPendingDeliveryOrdersBinding viewDataBinding) {
            super(viewDataBinding.getRoot());
            this.viewDataBinding = viewDataBinding;
            viewDataBinding.executePendingBindings();
        }

        public void bind(PendingOrderHeaderDataModel pendingOrderHeaderDataModel) {
            viewDataBinding.setVariable(BR.headerModel, pendingOrderHeaderDataModel);
            viewDataBinding.deliveryBase.setOnClickListener( v -> {
                Intent intent = new Intent(v.getContext(), OrderPlacementActivity.class);
                intent.putExtra("orderData", pendingOrderHeaderDataModel);
                v.getContext().startActivity(intent);
            });
        }
    }

    public void setPendingDeliveryOrderList(List<PendingOrderHeaderDataModel> pendingOrderHeaderDataModelList) {
        this.pendingOrderHeaderDataModelList = pendingOrderHeaderDataModelList;
        notifyDataSetChanged();
    }
}
