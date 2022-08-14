package com.editor.shippingdelivery.application;

/*
 * Created by Charles Raj I on 14/08/2022.
 *  @author Charles Raj I
 */


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.editor.shippingdelivery.R;

public class NoNetworkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.no_network_activity);
    }

}
