package com.editor.shippingdelivery.main.pendingdeliveryorders;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.editor.shippingdelivery.R;
import com.editor.shippingdelivery.databinding.ActivityPendingDeliveryOrdersBinding;
import com.editor.shippingdelivery.main.pendingdeliveryorders.adapter.PendingDeliveryOrdersAdapter;
import com.editor.shippingdelivery.main.pendingdeliveryorders.viewmodels.PendingDeliveryOrdersViewModel;

public class PendingDeliveryOrdersActivity extends AppCompatActivity implements LifecycleOwner {

    private ActivityPendingDeliveryOrdersBinding activityPendingDeliveryOrdersBinding;
    private PendingDeliveryOrdersViewModel pendingDeliveryOrdersViewModel;
    private PendingDeliveryOrdersAdapter pendingDeliveryOrdersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDataBinding();
        initRecyclerView();
        pendingDeliveryOrdersViewModel.hitApi();
        pendingDeliveryOrdersViewModel.pendingOrderHeaderDataModel.observe(this, pendingOrderHeaderDataModels ->
                pendingDeliveryOrdersAdapter.setPendingDeliveryOrderList(pendingOrderHeaderDataModels));
    }

    private void initDataBinding() {
        activityPendingDeliveryOrdersBinding = DataBindingUtil.setContentView(this, R.layout.activity_pending_delivery_orders);
        pendingDeliveryOrdersViewModel = new ViewModelProvider(this).get(PendingDeliveryOrdersViewModel.class);
        activityPendingDeliveryOrdersBinding.setPendingDeliveryOrdersViewModel(pendingDeliveryOrdersViewModel);
    }

    private void initRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        activityPendingDeliveryOrdersBinding.rvPendingDeliveryOrders.setLayoutManager(layoutManager);
        activityPendingDeliveryOrdersBinding.rvPendingDeliveryOrders.setItemAnimator(new DefaultItemAnimator());
        pendingDeliveryOrdersAdapter = new PendingDeliveryOrdersAdapter(this);
        activityPendingDeliveryOrdersBinding.rvPendingDeliveryOrders.setAdapter(pendingDeliveryOrdersAdapter);
    }
}