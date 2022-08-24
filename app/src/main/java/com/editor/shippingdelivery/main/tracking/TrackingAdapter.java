package com.editor.shippingdelivery.main.tracking;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.editor.shippingdelivery.R;
import com.editor.shippingdelivery.databinding.TrackingAdapterItemBinding;
import com.editor.shippingdelivery.main.pendingdeliveryorders.model.PendingOrderHeaderDataModel;
import com.editor.shippingdelivery.main.serviceablity.model.Data;

import java.util.List;

public class TrackingAdapter extends RecyclerView.Adapter<TrackingAdapter.TrackingViewHolder>{

    private Context context;
    private List<PendingOrderHeaderDataModel> trackingListData;
    public TrackingAdapter(Context context, List<PendingOrderHeaderDataModel> trackingListData) {
        this.context = context;
        this.trackingListData = trackingListData;
    }

    @NonNull
    @Override
    public TrackingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TrackingAdapterItemBinding trackingAdapterItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.tracking_adapter_item,parent,false);
        return new TrackingViewHolder(trackingAdapterItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull TrackingViewHolder holder, int position) {
            PendingOrderHeaderDataModel pendingOrderHeaderDataModel = trackingListData.get(position);
            holder.onBind(pendingOrderHeaderDataModel);
    }

    @Override
    public int getItemCount() {
        return trackingListData.size();
    }

    public static class TrackingViewHolder extends RecyclerView.ViewHolder {
        private TrackingAdapterItemBinding itemView;
        public TrackingViewHolder(@NonNull TrackingAdapterItemBinding itemView) {
            super(itemView.getRoot());
            this.itemView = itemView;
        }

        public void onBind(PendingOrderHeaderDataModel pendingOrderHeaderDataModel){
            itemView.setTrackingData(pendingOrderHeaderDataModel);
        }

    }
}
