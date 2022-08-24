package com.editor.shippingdelivery.main.tracking.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.editor.shippingdelivery.BR;
import com.editor.shippingdelivery.R;
import com.editor.shippingdelivery.databinding.ItemDeliveryOrdersBinding;
import com.editor.shippingdelivery.databinding.ItemTrackingDeliveryOrdersBinding;
import com.editor.shippingdelivery.databinding.ItemTrackingDeliveryOrdersBindingImpl;
import com.editor.shippingdelivery.main.tracking.model.TrackingDeliveryOrdesrHeaderDataModel;

import java.util.ArrayList;
import java.util.List;

public class TrackingDeliveryOrdersListAdapter extends RecyclerView.Adapter<TrackingDeliveryOrdersListAdapter.AdapterViewHolder> {

    private Context context;
    private List<TrackingDeliveryOrdesrHeaderDataModel> deliveryOrdesrHeaderDataModelList;

    public TrackingDeliveryOrdersListAdapter(Context context) {
        this.context = context;
        this.deliveryOrdesrHeaderDataModelList = new ArrayList<>();
    }


    @NonNull
    @Override
    public AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemTrackingDeliveryOrdersBinding viewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_tracking_delivery_orders, parent, false);
        return new AdapterViewHolder(viewDataBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterViewHolder holder, int position) {
        holder.bind(position, deliveryOrdesrHeaderDataModelList.get(position));
    }

    @Override
    public int getItemCount() {
        return deliveryOrdesrHeaderDataModelList.size();
    }

    public static class AdapterViewHolder extends RecyclerView.ViewHolder {
        private final ItemTrackingDeliveryOrdersBinding viewDataBinding;

        public AdapterViewHolder(@NonNull ItemTrackingDeliveryOrdersBinding viewDataBinding) {
            super(viewDataBinding.getRoot());
            this.viewDataBinding = viewDataBinding;
            viewDataBinding.executePendingBindings();
        }

        public void bind(int position, TrackingDeliveryOrdesrHeaderDataModel deliveryOrdesrHeaderDataModel) {
            viewDataBinding.setVariable(BR.headerModel, deliveryOrdesrHeaderDataModel);
            viewDataBinding.deliveryBase.setOnClickListener(v -> {

                // TODO : Need To Change the Comment
          /*      Intent intent = new Intent(v.getContext(), SelectServiceabilityActivity.class);
                intent.putExtra("orderDetails", "248296234");
                v.getContext().startActivity(intent);

                Intent intent = new Intent(v.getContext(), OrderPlacementActivity.class);
                intent.putExtra("orderData", (Parcelable) deliveryOrdesrHeaderDataModel);
                v.getContext().startActivity(intent);*/
            });
        }
    }

    public void setTrackingDeliveryOrdersList(List<TrackingDeliveryOrdesrHeaderDataModel> deliveryOrdesrHeaderDataModelList) {
        this.deliveryOrdesrHeaderDataModelList = deliveryOrdesrHeaderDataModelList;
        notifyDataSetChanged();
    }

}
