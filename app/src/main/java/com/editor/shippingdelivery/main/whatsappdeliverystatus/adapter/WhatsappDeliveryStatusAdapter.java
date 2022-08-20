package com.editor.shippingdelivery.main.whatsappdeliverystatus.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.editor.shippingdelivery.BR;
import com.editor.shippingdelivery.R;
import com.editor.shippingdelivery.databinding.ListWhatsappDeliveryStatusOrdersBinding;
import com.editor.shippingdelivery.main.whatsappdeliverystatus.model.WhatsappStatusHeaderDataModel;

import java.util.ArrayList;
import java.util.List;

public class WhatsappDeliveryStatusAdapter extends RecyclerView.Adapter<WhatsappDeliveryStatusAdapter.AdapterViewHolder> {

    Context context;
    List<WhatsappStatusHeaderDataModel> whatsappStatusHeaderDataModelList;

    public WhatsappDeliveryStatusAdapter(Context context, List<WhatsappStatusHeaderDataModel> whatsappStatusHeaderDataModelList) {
        this.context = context;
        this.whatsappStatusHeaderDataModelList = whatsappStatusHeaderDataModelList;
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
        holder.bind(whatsappStatusHeaderDataModelList.get(position));
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

        public void bind(WhatsappStatusHeaderDataModel whatsappStatusHeaderDataModel) {
            viewDataBinding.setVariable(BR.headerModels, whatsappStatusHeaderDataModel);
            viewDataBinding.deliveryBase.setOnClickListener( v -> {
                /*Intent intent = new Intent(v.getContext(), OrderPlacementActivity.class);
                intent.putExtra("orderData", whatsappStatusHeaderDataModel);
                v.getContext().startActivity(intent);*/
            });
        }
    }

    public void setWhatsappDeliveryStatusList(List<WhatsappStatusHeaderDataModel> whatsappStatusHeaderDataModels) {
        this.whatsappStatusHeaderDataModelList = whatsappStatusHeaderDataModels;
        notifyDataSetChanged();
    }
}
