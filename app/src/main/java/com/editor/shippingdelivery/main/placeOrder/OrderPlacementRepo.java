package com.editor.shippingdelivery.main.placeOrder;

import android.app.Activity;
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

    private RetrofitInterface service;
    private final String TAG = "OrderPlacementViewModel";
    public OrderPlacementRepo() {
        service = RetrofitClient.getClient2();
    }

    public void createShippingOrder(Activity activity, CreateOrderRequest createOrderRequest){
        try {
            service = RetrofitClient.getClient2();
            DisposableManager.add(service.createShipOrder("application/json","Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOjI5MDQyNTksImlzcyI6Imh0dHBzOi8vYXBpdjIuc2hpcHJvY2tldC5pbi92MS9leHRlcm5hbC9hdXRoL2xvZ2luIiwiaWF0IjoxNjYxMTkzNjI3LCJleHAiOjE2NjIwNTc2MjcsIm5iZiI6MTY2MTE5MzYyNywianRpIjoiTng0OXlwMDZHMXVVUkc3WSJ9._-j3VPKUOlBi96ixAzopXcWr-dF5wtITYipjBMY8h7s",createOrderRequest)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(createOrderResponse -> {
                        if(createOrderResponse.getStatus().equalsIgnoreCase("1"))
                        {
                            Intent intent = new Intent(activity, SelectServiceabilityActivity.class);
                            intent.putExtra("orderDetails", createOrderResponse);
                            activity.startActivity(intent);
                        }

                        Log.d(TAG, "createShippingOrder: " + createOrderResponse);
                    }, throwable -> {
                        Log.d(TAG, "createShippingOrder: " + throwable.getMessage());
                    }));
        }catch (Exception e){
            Log.d(TAG, "createShippingOrder: " + e.getMessage());
        }
    }
}
