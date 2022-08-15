package com.editor.shippingdelivery;
/*
 * Created by Charles Raj I on 14/08/2022.
 *  @author Charles Raj I
 */
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

import com.editor.shippingdelivery.databinding.ActivityMainBinding;
import com.editor.shippingdelivery.main.placeOrder.OrderPlacement;

public class MainActivity extends AppCompatActivity {

    private Activity activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = MainActivity.this;

        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(activity,R.layout.activity_main);

        activityMainBinding.cvDelivery.setOnClickListener(view -> {
            startActivity(new Intent(activity, OrderPlacement.class));
        });

    }
}