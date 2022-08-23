package com.editor.shippingdelivery.main.placeOrder;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LifecycleOwner;

import com.editor.shippingdelivery.R;
import com.editor.shippingdelivery.databinding.ActivityPlaceDeliveryOrderBinding;
import com.editor.shippingdelivery.main.placeOrder.model.CreateOrderRequest;

/**
 * Created by Charles Raj I on 15/08/22.
 *
 * @author Charles Raj I
 */
public class OrderPlacementActivity extends AppCompatActivity implements LifecycleOwner {

    private Activity activity;
    private OrderPlacementViewModel orderPlacementViewModel;

    private ActivityPlaceDeliveryOrderBinding activityPlaceDeliveryOrderBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = OrderPlacementActivity.this;
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);


        activityPlaceDeliveryOrderBinding = DataBindingUtil.setContentView(activity, R.layout.activity_place_delivery_order);

        orderPlacementViewModel = new OrderPlacementViewModel();
        orderPlacementViewModel.setActivity(activity);
        orderPlacementViewModel.setFragmentManager(getSupportFragmentManager());
        orderPlacementViewModel.setCreateOrderRequest(new CreateOrderRequest());
        activityPlaceDeliveryOrderBinding.setOrderPlacementViewModel(orderPlacementViewModel);

        if (getIntent() != null) {
            orderPlacementViewModel.setOrderData(getIntent().getParcelableExtra("orderData"));
        }

    }

    public void backPress(View view) {
        finish();
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
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
