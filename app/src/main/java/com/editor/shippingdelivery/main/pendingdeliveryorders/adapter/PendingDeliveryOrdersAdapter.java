package com.editor.shippingdelivery.main.pendingdeliveryorders.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.library.baseAdapters.BR;
import androidx.recyclerview.widget.RecyclerView;

import com.editor.shippingdelivery.R;
import com.editor.shippingdelivery.databinding.ListPendingDeliveryOrdersBinding;
import com.editor.shippingdelivery.main.pendingdeliveryorders.listeners.OnListItemClickListener;
import com.editor.shippingdelivery.main.pendingdeliveryorders.model.PendingOrderHeaderDataModel;
import com.editor.shippingdelivery.main.placeOrder.OrderPlacementActivity;
import com.editor.shippingdelivery.main.serviceablity.SelectServiceabilityActivity;

import java.util.ArrayList;
import java.util.List;

public class PendingDeliveryOrdersAdapter extends RecyclerView.Adapter<PendingDeliveryOrdersAdapter.AdapterViewHolder> {

    private Context context;
    private List<PendingOrderHeaderDataModel> pendingOrderHeaderDataModelList;
    private OnListItemClickListener onListItemClickListener;

    public PendingDeliveryOrdersAdapter(Context context, OnListItemClickListener onListItemClickListener) {
        this.context = context;
        this.pendingOrderHeaderDataModelList = new ArrayList<>();
        this.onListItemClickListener = onListItemClickListener;
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
        holder.bind(position, pendingOrderHeaderDataModelList.get(position), onListItemClickListener);
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

        public void bind(int position, PendingOrderHeaderDataModel pendingOrderHeaderDataModel, OnListItemClickListener onListItemClickListener) {
            viewDataBinding.setVariable(BR.headerModel, pendingOrderHeaderDataModel);
            viewDataBinding.deliveryBase.setOnClickListener(v -> {

                // TODO : Need To Change the Comment
                Intent intent = new Intent(v.getContext(), SelectServiceabilityActivity.class);
                intent.putExtra("orderDetails", "248296234");
                v.getContext().startActivity(intent);

//                Intent intent = new Intent(v.getContext(), OrderPlacementActivity.class);
//                intent.putExtra("orderData", (Parcelable) pendingOrderHeaderDataModel);
//                v.getContext().startActivity(intent);
            });
            viewDataBinding.tvBillInfo.setOnClickListener(view -> {
                onListItemClickListener.onClickInfo(viewDataBinding.tvBillInfo, "Bill Info", position, pendingOrderHeaderDataModel);
            });

            viewDataBinding.tvCustomerInfo.setOnClickListener(view -> {
                onListItemClickListener.onClickInfo(viewDataBinding.tvCustomerInfo, "Customer Info", position, pendingOrderHeaderDataModel);
            });

            viewDataBinding.tvRouteInfo.setOnClickListener(view -> {
                onListItemClickListener.onClickInfo(viewDataBinding.tvCustomerInfo, "Route Info", position, pendingOrderHeaderDataModel);

            });
        }
    }

    public void setPendingDeliveryOrderList(List<PendingOrderHeaderDataModel> pendingOrderHeaderDataModelList) {
        this.pendingOrderHeaderDataModelList = pendingOrderHeaderDataModelList;
        notifyDataSetChanged();
    }
}
