package com.editor.shippingdelivery.main.tracking;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.editor.shippingdelivery.R;
import com.editor.shippingdelivery.databinding.ActivityPickupBinding;
import com.editor.shippingdelivery.databinding.TrackingActivityBinding;
import com.editor.shippingdelivery.main.pickup.DeliveryOrdersRepo;
import com.editor.shippingdelivery.main.pickup.PickUpViewModel;
import com.editor.shippingdelivery.main.pickup.adapter.DeliveryOrdersListAdapter;
import com.editor.shippingdelivery.main.pickup.model.DeliveryOrdesrHeaderDataModel;
import com.editor.shippingdelivery.main.tracking.adapter.TrackingDeliveryOrdersListAdapter;

import java.util.List;

public class TrackingActivity extends AppCompatActivity {
    private Activity activity;

    private TrackingActivityBinding activityTrackingBinding;
    private TrackingDelveryViewModel trackingViewModel;
    private TrackingDeliveryOrdersListAdapter trackingDeliveryOrdersListAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = this;
   /*     TrackingActivityBinding trackingActivityBinding = DataBindingUtil.setContentView(activity, R.layout.tracking_activity);
        TrackingViewModel trackingViewModel = new TrackingViewModel();
        trackingActivityBinding.setTrackingViewModel(trackingViewModel);*/


        initDataBinding();
        initRecyclerView();
        observerFun();
    }

    private void initDataBinding() {
        activityTrackingBinding = DataBindingUtil.setContentView(this, R.layout.tracking_activity);
        trackingViewModel = new ViewModelProvider(this).get(TrackingDelveryViewModel.class);
        activityTrackingBinding.setTrackingVm(trackingViewModel);
    }

    private void initRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        activityTrackingBinding.rvTrackingDeliveryList.setLayoutManager(layoutManager);
        activityTrackingBinding.rvTrackingDeliveryList.setItemAnimator(new DefaultItemAnimator());
        trackingDeliveryOrdersListAdapter = new TrackingDeliveryOrdersListAdapter(this);
        activityTrackingBinding.rvTrackingDeliveryList.setAdapter(trackingDeliveryOrdersListAdapter);
    }

    private void observerFun() {
        trackingViewModel.getPendingDeliveryOrders().observe(this, trackingDeliveryOrdesrHeaderDataModels ->
                trackingDeliveryOrdersListAdapter.setTrackingDeliveryOrdersList(trackingDeliveryOrdesrHeaderDataModels));

        trackingViewModel.isProgress.observe(this, aBoolean -> {
            if (aBoolean) {
                activityTrackingBinding.progressHorizontal.setVisibility(View.VISIBLE);
            } else {
                activityTrackingBinding.progressHorizontal.setVisibility(View.GONE);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
