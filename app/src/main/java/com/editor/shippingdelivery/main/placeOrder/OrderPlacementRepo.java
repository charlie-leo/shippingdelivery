package com.editor.shippingdelivery.main.placeOrder;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.editor.shippingdelivery.common.DataInstance;
import com.editor.shippingdelivery.main.placeOrder.model.CreateOrderRequest;
import com.editor.shippingdelivery.main.serviceablity.SelectServiceabilityActivity;
import com.editor.shippingdelivery.services.DisposableManager;
import com.editor.shippingdelivery.services.RetrofitClient;
import com.editor.shippingdelivery.services.RetrofitInterface;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Charles Raj I on 15/08/22.
 *
 * @author Charles Raj I
 */
public class OrderPlacementRepo implements DataInstance {

    private final RetrofitInterface service;
    private final String TAG = "OrderPlacementViewModel";
    public OrderPlacementRepo() {
        service = RetrofitClient.getClient2();
    }

    public void createShippingOrder(Context context, CreateOrderRequest createOrderRequest, OrderPlacementViewModel orderPlacementViewModel){
        try {
            DisposableManager.add(service.createShipOrder(createOrderRequest)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(createOrderResponse -> {
                        if(createOrderResponse.getStatusCode().equals("200")) {
                            Intent intent = new Intent(context, SelectServiceabilityActivity.class);
                            intent.putExtra("orderDetails", createOrderResponse);
                            context.startActivity(intent);
                        } else {
                            Log.d(TAG, "createShippingOrder: " + createOrderResponse);
                            orderPlacementViewModel.setErrorMessage(createOrderResponse.getStatus());
                        }
                    }, throwable -> {
                        Log.d(TAG, "createShippingOrder: " + throwable.getMessage());
                    }));
        }catch (Exception e){
            Log.d(TAG, "createShippingOrder: " + e.getMessage());
        }
    }
}
