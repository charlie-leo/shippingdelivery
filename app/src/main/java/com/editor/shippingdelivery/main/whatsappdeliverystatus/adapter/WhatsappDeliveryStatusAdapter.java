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
import com.editor.shippingdelivery.main.whatsappdeliverystatus.model.PlaceOrderModel;
import com.editor.shippingdelivery.main.whatsappdeliverystatus.listeners.OnListItemClickListener;
import com.editor.shippingdelivery.main.whatsappdeliverystatus.model.WhatsappStatusHeaderDataModel;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
                placeOrderModel.setMessageId(UUID.randomUUID().toString());
                placeOrderModel.setMobileNumber("919500512853");
                String totalInvoiceQty =(whatsappStatusHeaderDataModel.getBillPrintDetailList()!=null) ? whatsappStatusHeaderDataModel.getBillPrintDetailList().get(0).getTotalInvoiceQty() : "Not available";
                String messageContent ="Order Details:\nName:"+whatsappStatusHeaderDataModel.getCustomerName()+" "
                        +"\nPurchased Item Count:"+totalInvoiceQty+" "+
                        "\nYour Billing Amount:"+whatsappStatusHeaderDataModel.getTotNetAmt()+" "+
                        "\nCan we place the order?";
                System.out.println("message:"+messageContent);
                placeOrderModel.setMessageContent(messageContent);

                onListItemClickListener.onClick(viewDataBinding.placeOrderTxt, position, placeOrderModel);

            });
        }
    }

    public void setWhatsappDeliveryStatusList(List<WhatsappStatusHeaderDataModel> whatsappStatusHeaderDataModels) {
        this.whatsappStatusHeaderDataModelList = whatsappStatusHeaderDataModels;
        notifyDataSetChanged();
    }

    public List<WhatsappStatusHeaderDataModel> getWhatsappStatusHeaderDataModelList() {
        return whatsappStatusHeaderDataModelList;
    }
}
