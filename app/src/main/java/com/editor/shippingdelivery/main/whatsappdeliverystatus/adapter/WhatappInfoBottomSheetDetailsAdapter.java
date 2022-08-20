package com.editor.shippingdelivery.main.whatsappdeliverystatus.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.editor.shippingdelivery.BR;
import com.editor.shippingdelivery.R;
import com.editor.shippingdelivery.databinding.ItemInfoBottomSheetWhatsappDetailsBinding;
import com.editor.shippingdelivery.main.whatsappdeliverystatus.model.WhatsappInfoBottomSheetDetailsModel;

import java.util.ArrayList;
import java.util.List;

public class WhatappInfoBottomSheetDetailsAdapter extends RecyclerView.Adapter<WhatappInfoBottomSheetDetailsAdapter.AdapterViewHolder> {

    private Context context;
    private List<WhatsappInfoBottomSheetDetailsModel> infoBottomSheetDetailsModelList;

    public WhatappInfoBottomSheetDetailsAdapter(Context context, List<WhatsappInfoBottomSheetDetailsModel> infoBottomSheetDetailsModelList) {
        this.context = context;
        this.infoBottomSheetDetailsModelList = infoBottomSheetDetailsModelList;
    }

    public WhatappInfoBottomSheetDetailsAdapter(Context context) {
        this.context = context;
        this.infoBottomSheetDetailsModelList = new ArrayList<>();
    }


    @NonNull
    @Override
    public AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemInfoBottomSheetWhatsappDetailsBinding viewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_info_bottom_sheet_whatsapp_details, parent, false);
        return new AdapterViewHolder(viewDataBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterViewHolder holder, int position) {
        holder.bind(infoBottomSheetDetailsModelList.get(position));
    }

    @Override
    public int getItemCount() {
        return infoBottomSheetDetailsModelList.size();
    }

    public static class AdapterViewHolder extends RecyclerView.ViewHolder {
        private final ItemInfoBottomSheetWhatsappDetailsBinding viewDataBinding;

        public AdapterViewHolder(@NonNull ItemInfoBottomSheetWhatsappDetailsBinding viewDataBinding) {
            super(viewDataBinding.getRoot());
            this.viewDataBinding = viewDataBinding;
            viewDataBinding.executePendingBindings();
        }

        public void bind(WhatsappInfoBottomSheetDetailsModel infoBottomSheetDetailsModelList) {
            viewDataBinding.setVariable(BR.whatsappInfoBottomSheetDetailsModel, infoBottomSheetDetailsModelList);
        }
    }

    public void setPendingDeliveryOrderList(List<WhatsappInfoBottomSheetDetailsModel> infoBottomSheetDetailsModelList) {
        this.infoBottomSheetDetailsModelList = infoBottomSheetDetailsModelList;
        notifyDataSetChanged();
    }
}
