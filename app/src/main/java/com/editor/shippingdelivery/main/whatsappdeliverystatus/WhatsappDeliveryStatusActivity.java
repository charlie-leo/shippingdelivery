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
import com.editor.shippingdelivery.main.whatsappdeliverystatus.adapter.WhatsappDeliveryStatusAdapter;
import com.editor.shippingdelivery.main.whatsappdeliverystatus.viewmodels.WhatsappDeliveryStatusViewModel;

public class WhatsappDeliveryStatusActivity extends AppCompatActivity implements LifecycleOwner {

    private ActivityWhatsappDeliveryStatusBinding activityWhatsappDeliveryStatusBinding;
    private WhatsappDeliveryStatusViewModel whatsappDeliveryStatusViewModel;
    private WhatsappDeliveryStatusAdapter whatsappDeliveryStatusAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDataBinding();
        initRecyclerView();
        whatsappDeliveryStatusViewModel.hitApi();
        whatsappDeliveryStatusViewModel.whatsappStatusHeaderDataModel.observe(this, whatsappStatusHeaderDataModels ->
                whatsappDeliveryStatusAdapter.setWhatsappDeliveryStatusList(whatsappStatusHeaderDataModels));

        whatsappDeliveryStatusViewModel.isProgress.observe(this, aBoolean -> {
            if (aBoolean) {
                activityWhatsappDeliveryStatusBinding.progressHorizontal.setVisibility(View.VISIBLE);
            } else {
                activityWhatsappDeliveryStatusBinding.progressHorizontal.setVisibility(View.GONE);
            }
        });
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
        whatsappDeliveryStatusAdapter = new WhatsappDeliveryStatusAdapter(this);
        activityWhatsappDeliveryStatusBinding.rvWhatsappStatusOrders.setAdapter(whatsappDeliveryStatusAdapter);
    }
}