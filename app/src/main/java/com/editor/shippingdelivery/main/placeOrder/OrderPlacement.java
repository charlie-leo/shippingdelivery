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

/**
 * Created by Charles Raj I on 15/08/22.
 *
 * @author Charles Raj I
 */
public class OrderPlacement extends AppCompatActivity implements LifecycleOwner {

    private Activity activity;
    private OrderPlacementViewModel orderPlacementViewModel;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = OrderPlacement.this;
        OrderPlacmentBinding orderPlacmentBinding = DataBindingUtil.setContentView(activity, R.layout.order_placment);
        orderPlacementViewModel = new ViewModelProvider(this).get(OrderPlacementViewModel.class);
        orderPlacementViewModel.getShipToken();
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
