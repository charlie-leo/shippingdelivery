package com.editor.shippingdelivery.main.serviceablity;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.editor.shippingdelivery.R;
import com.editor.shippingdelivery.databinding.ServicablityActivityBinding;
import com.editor.shippingdelivery.main.placeOrder.model.CreateOrderResponse;

/**
 * Created by Charles Raj I on 18/08/22.
 *
 * @author Charles Raj I
 */
public class SelectServiceabilityActivity extends AppCompatActivity {

    private Activity activity;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = this;

        ServicablityActivityBinding servicablityActivityBinding = DataBindingUtil.setContentView(activity, R.layout.servicablity_activity);

        SelectServiceabilityViewModel selectServiceabilityViewModel = new SelectServiceabilityViewModel();

        servicablityActivityBinding.setServiceabilityData(selectServiceabilityViewModel);

        if (getIntent() != null){
            String orderId = getIntent().getStringExtra("orderDetails");
            selectServiceabilityViewModel.getServiceability(orderId);
        }
    }
}
