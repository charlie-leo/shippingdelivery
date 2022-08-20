package com.editor.shippingdelivery.main.whatsappdeliverystatus;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.editor.shippingdelivery.R;
import com.editor.shippingdelivery.databinding.ActivityWhatsappDeliveryStatusBinding;
import com.editor.shippingdelivery.databinding.BottomSheetBillInfoWhatsappBinding;
import com.editor.shippingdelivery.main.whatsappdeliverystatus.adapter.WhatappInfoBottomSheetDetailsAdapter;
import com.editor.shippingdelivery.main.whatsappdeliverystatus.adapter.WhatsappDeliveryStatusAdapter;
import com.editor.shippingdelivery.main.whatsappdeliverystatus.listeners.OnListItemClickListener;
import com.editor.shippingdelivery.main.whatsappdeliverystatus.model.WhatsappStatusHeaderDataModel;
import com.editor.shippingdelivery.main.whatsappdeliverystatus.viewmodels.WhatsappDeliveryStatusViewModel;
import com.editor.shippingdelivery.main.whatsappdeliverystatus.viewmodels.WhatsappInfoBottomSheetViewModel;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class WhatsappDeliveryStatusActivity extends AppCompatActivity implements LifecycleOwner {

    private ActivityWhatsappDeliveryStatusBinding activityWhatsappDeliveryStatusBinding;
    private WhatsappDeliveryStatusViewModel whatsappDeliveryStatusViewModel;
    private WhatsappDeliveryStatusAdapter whatsappDeliveryStatusAdapter;
    private WhatsappInfoBottomSheetViewModel infoBottomSheetViewModel;
    private BottomSheetBillInfoWhatsappBinding bottomSheetBillInfoBinding;
    private WhatappInfoBottomSheetDetailsAdapter infoBottomSheetDetailsAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDataBinding();
        initRecyclerView();
        observerFun();
    }

    private void initDataBinding() {
        activityWhatsappDeliveryStatusBinding = DataBindingUtil.setContentView(this, R.layout.activity_whatsapp_delivery_status);
        whatsappDeliveryStatusViewModel = new ViewModelProvider(this).get(WhatsappDeliveryStatusViewModel.class);
        activityWhatsappDeliveryStatusBinding.setWhatsappDeliveryStatusViewModel(whatsappDeliveryStatusViewModel);
    }

    private void initRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        activityWhatsappDeliveryStatusBinding.rvWhatsappStatusOrders.setLayoutManager(layoutManager);
        activityWhatsappDeliveryStatusBinding.rvWhatsappStatusOrders.setItemAnimator(new DefaultItemAnimator());
        whatsappDeliveryStatusAdapter = new WhatsappDeliveryStatusAdapter(this, new OnListItemClickListener() {
            @Override
            public void onClick(View view, int position) {

            }

            @Override
            public void onClickInfo(View view, String viewName, int position, WhatsappStatusHeaderDataModel whatsappStatusHeaderDataModel) {
                showInfoBottomSheetDialog(position, viewName, whatsappStatusHeaderDataModel);
            }
        });
        activityWhatsappDeliveryStatusBinding.rvWhatsappStatusOrders.setAdapter(whatsappDeliveryStatusAdapter);
    }

    private void observerFun() {
        whatsappDeliveryStatusViewModel.getWhatsappStatusOrders().observe(this, whatsappStatusHeaderDataModels ->
                whatsappDeliveryStatusAdapter.setWhatsappDeliveryStatusList(whatsappStatusHeaderDataModels));

        whatsappDeliveryStatusViewModel.isProgress.observe(this, aBoolean -> {
            if (aBoolean) {
                activityWhatsappDeliveryStatusBinding.progressHorizontal.setVisibility(View.VISIBLE);
            } else {
                activityWhatsappDeliveryStatusBinding.progressHorizontal.setVisibility(View.GONE);
            }
        });
    }

    private void showInfoBottomSheetDialog(int position, String viewName, WhatsappStatusHeaderDataModel whatsappStatusHeaderDataModel) {
        bottomSheetBillInfoBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.bottom_sheet_bill_info_whatsapp, null, false);
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(bottomSheetBillInfoBinding.getRoot());

        infoBottomSheetViewModel = new ViewModelProvider(this).get(WhatsappInfoBottomSheetViewModel.class);
        bottomSheetBillInfoBinding.setInfoBottomSheetvm(infoBottomSheetViewModel);

        initInfoBottomSheetRecyclerView();

        infoBottomSheetViewModel.setBottomSheetHeader(viewName);

        infoBottomSheetViewModel.getInfoBottomSheetList(viewName, position, whatsappStatusHeaderDataModel).observe(this, whatsappInfoBottomSheetDetailsModelList ->
                infoBottomSheetDetailsAdapter.setPendingDeliveryOrderList(whatsappInfoBottomSheetDetailsModelList));

        bottomSheetDialog.show();
    }

    private void initInfoBottomSheetRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        bottomSheetBillInfoBinding.rvInfoDetails.setLayoutManager(layoutManager);
        bottomSheetBillInfoBinding.rvInfoDetails.setItemAnimator(new DefaultItemAnimator());
        infoBottomSheetDetailsAdapter = new WhatappInfoBottomSheetDetailsAdapter(this);
        bottomSheetBillInfoBinding.rvInfoDetails.setAdapter(infoBottomSheetDetailsAdapter);
    }

    public void back(View view) {
        finish();
    }
}