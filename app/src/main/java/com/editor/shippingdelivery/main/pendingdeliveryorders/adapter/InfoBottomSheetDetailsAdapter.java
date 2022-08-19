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
import com.editor.shippingdelivery.databinding.ItemInfoBottomSheetDetailsBinding;
import com.editor.shippingdelivery.databinding.ListPendingDeliveryOrdersBinding;
import com.editor.shippingdelivery.main.pendingdeliveryorders.model.InfoBottomSheetDetailsModel;
import com.editor.shippingdelivery.main.pendingdeliveryorders.model.PendingOrderHeaderDataModel;
import com.editor.shippingdelivery.main.placeOrder.OrderPlacementActivity;

import java.util.ArrayList;
import java.util.List;

public class InfoBottomSheetDetailsAdapter extends RecyclerView.Adapter<InfoBottomSheetDetailsAdapter.AdapterViewHolder> {

    private Context context;
    private List<InfoBottomSheetDetailsModel> infoBottomSheetDetailsModelList;

    public InfoBottomSheetDetailsAdapter(Context context, List<InfoBottomSheetDetailsModel> infoBottomSheetDetailsModelList) {
        this.context = context;
        this.infoBottomSheetDetailsModelList = infoBottomSheetDetailsModelList;
    }

    public InfoBottomSheetDetailsAdapter(Context context) {
        this.context = context;
        this.infoBottomSheetDetailsModelList = new ArrayList<>();
    }


    @NonNull
    @Override
    public AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemInfoBottomSheetDetailsBinding viewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_info_bottom_sheet_details, parent, false);
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
        private final ItemInfoBottomSheetDetailsBinding viewDataBinding;

        public AdapterViewHolder(@NonNull ItemInfoBottomSheetDetailsBinding viewDataBinding) {
            super(viewDataBinding.getRoot());
            this.viewDataBinding = viewDataBinding;
            viewDataBinding.executePendingBindings();
        }

        public void bind(InfoBottomSheetDetailsModel infoBottomSheetDetailsModelList) {
            viewDataBinding.setVariable(BR.infoBottomSheetDetailsModel, infoBottomSheetDetailsModelList);
        }
    }

    public void setPendingDeliveryOrderList(List<InfoBottomSheetDetailsModel> infoBottomSheetDetailsModelList) {
        this.infoBottomSheetDetailsModelList = infoBottomSheetDetailsModelList;
        notifyDataSetChanged();
    }
}
