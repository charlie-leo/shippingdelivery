package com.editor.shippingdelivery.main.tracking;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.editor.shippingdelivery.R;
import com.editor.shippingdelivery.databinding.TrackingActivityBinding;

public class TrackingActivity extends AppCompatActivity {


    private Activity activity;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = this;
        TrackingActivityBinding trackingActivityBinding = DataBindingUtil.setContentView(activity, R.layout.tracking_activity);
        TrackingViewModel trackingViewModel = new TrackingViewModel();
        trackingActivityBinding.setTrackingViewModel(trackingViewModel);
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
