package com.editor.shippingdelivery.main.placeOrder;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.editor.shippingdelivery.common.DataInstance;
import com.editor.shippingdelivery.main.placeOrder.model.CreateOrderRequest;
import com.editor.shippingdelivery.main.serviceablity.SelectServiceableActivity;
import com.editor.shippingdelivery.services.DisposableManager;
import com.editor.shippingdelivery.services.RetrofitClient;
import com.editor.shippingdelivery.services.RetrofitInterface;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.gson.JsonObject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Charles Raj I on 15/08/22.
 *
 * @author Charles Raj I
 */
public class OrderPlacementViewModel extends AndroidViewModel implements DataInstance {

    private final Application application;
    private RetrofitInterface service;
    private final String TAG = "OrderPlacementViewModel";
    public OrderPlacementViewModel(@NonNull Application application) {
        super(application);
        this.application = application;
        service = RetrofitClient.getClient();
    }
    // TODO : Need to remove the function
    public void getShipToken(){

        try {
            ShipLoginModel shipLoginModel = new ShipLoginModel();
            DisposableManager.add(service.getShipRocketToken(shipLoginModel)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(responseBodyResponse -> {
                        if ( responseBodyResponse != null) {
                            String token = responseBodyResponse.toString();
                            Log.d(TAG, "getShipToken: Response" + token);
                            setApplicationData("token", responseBodyResponse.get("token").toString());
                            setApplicationData("company_id", responseBodyResponse.get("company_id").toString());
                        }
                    }, throwable -> {
                        Log.d(TAG, "getShipToken: Error  " + throwable.getMessage());
                    }));
        }catch (Exception e){
            Log.d(TAG, "getShipToken: exception  " + e.getMessage() );
        }
    }

    public void createShippingOrder(Activity activity, CreateOrderRequest createOrderRequest){
        try {
            DisposableManager.add(service.createShipOrder(createOrderRequest)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(createOrderResponse -> {
                        Intent intent = new Intent(activity, SelectServiceableActivity.class);
                        intent.putExtra("orderDetails", createOrderResponse);
                        activity.startActivity(intent);
                        Log.d(TAG, "createShippingOrder: " + createOrderResponse.getStatus());
                    }, throwable -> {
                        Log.d(TAG, "createShippingOrder: " + throwable.getMessage());
                    }));
        }catch (Exception e){
            Log.d(TAG, "createShippingOrder: " + e.getMessage());
        }
    }
}
