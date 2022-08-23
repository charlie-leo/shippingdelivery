package com.editor.shippingdelivery;
/*
 * Created by Charles Raj I on 14/08/2022.
 *  @author Charles Raj I
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.editor.shippingdelivery.databinding.ActivityMainBinding;
import com.editor.shippingdelivery.main.pendingdeliveryorders.PendingDeliveryOrdersActivity;
import com.editor.shippingdelivery.main.pendingdeliveryorders.model.PendingOrderHeaderDataModel;
import com.editor.shippingdelivery.main.placeOrder.OrderPlacementActivity;
import com.editor.shippingdelivery.main.whatsappdeliverystatus.WhatsappDeliveryStatusActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = MainActivity.this;

        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(activity, R.layout.activity_main);

        activityMainBinding.cvDelivery.setOnClickListener(view -> {
            startActivity(new Intent(activity, PendingDeliveryOrdersActivity.class));
            /*Intent intent = new Intent(this, OrderPlacementActivity.class);
            startActivity(intent);*/
        });
        activityMainBinding.cvWatsapp.setOnClickListener(view -> {
            startActivity(new Intent(activity, WhatsappDeliveryStatusActivity.class));
        });

    }
}