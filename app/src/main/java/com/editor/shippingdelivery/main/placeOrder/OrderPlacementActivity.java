package com.editor.shippingdelivery.main.placeOrder;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;

import com.editor.shippingdelivery.R;
import com.editor.shippingdelivery.databinding.OrderPlacmentBinding;
import com.editor.shippingdelivery.main.placeOrder.model.CreateOrderRequest;

/**
 * Created by Charles Raj I on 15/08/22.
 *
 * @author Charles Raj I
 */
public class OrderPlacementActivity extends AppCompatActivity implements LifecycleOwner {

    private Activity activity;
    private OrderPlacementViewModel orderPlacementViewModel;
    private OrderPlacementListener orderPlacementListener;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = OrderPlacementActivity.this;

        OrderPlacmentBinding orderPlacmentBinding = DataBindingUtil.setContentView(activity, R.layout.order_placment);
        orderPlacementViewModel = new ViewModelProvider(this).get(OrderPlacementViewModel.class);

        orderPlacementListener = new OrderPlacementListener();
        orderPlacementListener.setActivity(activity);
        orderPlacementListener.setFragmentManager(getSupportFragmentManager());
        orderPlacementListener.setCreateOrderRequest(new CreateOrderRequest());
        orderPlacementListener.setOrderPlacementViewModel(orderPlacementViewModel);
        orderPlacmentBinding.setOrderPlacementListener(orderPlacementListener);

        if (getIntent() != null){
            orderPlacementListener.setOrderData(getIntent().getParcelableExtra("orderData"));
        }


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
